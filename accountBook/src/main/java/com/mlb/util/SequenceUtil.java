package com.mlb.util;

import java.util.List;

import lb.rest.user.db.entity.SequenceExample;
import lb.rest.user.db.mapper.SequenceMapper;

import org.springframework.stereotype.Repository;

import fc.wpf.rest.utils.BeanFactory;

@Repository
public class SequenceUtil {
	private static SequenceMapper sequenceMapper = (SequenceMapper) BeanFactory
			.getBean("sequenceMapper");

	/**
	 * 修改为完美单例持有，保证并发一致和线程安全！
	 *
	 */

	private SequenceUtil() {
	}

	private static class SequenceHolder {

		private static final SequenceUtil INSTANCE = new SequenceUtil();
	}

	public static SequenceUtil getInstance() {
		return SequenceHolder.INSTANCE;
	}

	/**
	 * 得到某一项序列号的下一个可用值。
	 *
	 * 同步锁定，保证并发一致！
	 *
	 * @param seqName
	 *            要得到的序列名
	 * @return 可用的序列号
	 * @throws Exception
	 */
	public synchronized int nextValue(String seqName) throws Exception {
		if ((seqName == null) || (seqName.equals(""))) {
			throw new Exception("获取下一个可用序列号：序列号名不能为空");
		}

		int nextVal = 9999;
		SequenceExample example = new SequenceExample();
		example.createCriteria().andNameEqualTo(seqName);
		List<lb.rest.user.db.entity.Sequence> sequenceList = sequenceMapper
				.selectByExample(example);

		if (sequenceList != null && sequenceList.size() > 0) {
			lb.rest.user.db.entity.Sequence firstItem = sequenceList.get(0);
			nextVal = firstItem.getId();
			firstItem.setId(nextVal + 1);
			sequenceMapper.updateByPrimaryKey(firstItem);
		} else {
			lb.rest.user.db.entity.Sequence record = new lb.rest.user.db.entity.Sequence();
			record.setName(seqName);
			record.setId(nextVal + 1);
			sequenceMapper.insertSelective(record);
		}

		/*
		 * BasicJDBC thisDao = null; int nextVal = 9999; try { thisDao =
		 * DBAccess.executeQuery(" select id from sequence where name = '" +
		 * seqName + "'"); if (thisDao.rs.next()) { nextVal =
		 * thisDao.rs.getInt("id"); thisDao.destroyMe();
		 * DBAccess.executeUpdate("update sequence set id = " + (nextVal + 1) +
		 * " where name = '" + seqName + "'"); } else {
		 * DBAccess.executeUpdate("insert into sequence values('" + seqName +
		 * "'," + (nextVal + 1) + ")"); } } catch (Exception ex) {
		 * ex.printStackTrace(); throw new Exception("取序列号发生错误！"); } finally {
		 * if (thisDao != null) { thisDao.destroyMe(); } }
		 */return nextVal;
	}
}
