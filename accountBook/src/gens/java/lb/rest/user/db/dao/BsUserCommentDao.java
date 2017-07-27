package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsUserComment;
import lb.rest.user.db.entity.BsUserCommentExample;
import lb.rest.user.db.entity.BsUserCommentExample.Criteria;
import lb.rest.user.db.entity.BsUserCommentKey;
import lb.rest.user.db.mapper.BsUserCommentMapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class BsUserCommentDao implements StaticTableDaoSupport<BsUserComment, BsUserCommentExample, BsUserCommentKey> {

	@Resource
	private BsUserCommentMapper mapper;

	public String getIds(int userId) {
		String ids = "0,";
		List<BsUserComment> list = getList(userId);
		if (list != null && list.size() > 0) {
			for (BsUserComment item : list) {
				ids += item.getId() + ",";
			}
		}
		ids = StringUtils.removeEnd(ids, ",");
		return ids;
	}

	public List<Integer> getIdList(int userId) {
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(0);
		List<BsUserComment> list = getList(userId);
		if (list != null && list.size() > 0) {
			for (BsUserComment item : list) {
				idList.add(item.getId());
			}
		}
		return idList;
	}

	public List<BsUserComment> getList(int userId) {
		BsUserCommentExample example = new BsUserCommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		example.setOrderByClause("comment_time desc ");
		List<BsUserComment> list = mapper.selectByExample(example);
		return list;
	}

	@Override
	public int countByExample(BsUserCommentExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsUserCommentExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsUserCommentKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsUserComment record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsUserComment record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsUserComment> records) {
		for (BsUserComment record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsUserComment> records) {
		for (BsUserComment record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsUserComment> records) {
		for (BsUserComment record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsUserComment> selectByExample(BsUserCommentExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public BsUserComment selectByPrimaryKey(BsUserCommentKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsUserComment> findAll(List<BsUserComment> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsUserCommentExample());
		}
		List<BsUserComment> list = new ArrayList<>();
		for (BsUserComment record : records) {
			BsUserComment result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsUserComment record, BsUserCommentExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsUserComment record, BsUserCommentExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsUserComment record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsUserComment record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsUserCommentExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsUserCommentExample());
	}

	@Override
	public BsUserCommentExample getExample(BsUserComment record) {
		BsUserCommentExample example = new BsUserCommentExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}
		}
		return example;
	}
}
