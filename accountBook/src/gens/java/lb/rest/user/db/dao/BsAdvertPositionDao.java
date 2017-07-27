package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsAdvertPosition;
import lb.rest.user.db.entity.BsAdvertPositionExample;
import lb.rest.user.db.entity.BsAdvertPositionExample.Criteria;
import lb.rest.user.db.entity.BsAdvertPositionKey;
import lb.rest.user.db.mapper.BsAdvertPositionMapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class BsAdvertPositionDao implements
		StaticTableDaoSupport<BsAdvertPosition, BsAdvertPositionExample, BsAdvertPositionKey> {

	@Resource
	private BsAdvertPositionMapper mapper;

	// status 状态{1已读 2 未读 3 取消}
	public BsAdvertPosition getAttention(int subUserId, int objUserId) {
		BsAdvertPositionExample example = new BsAdvertPositionExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(subUserId).andUserIdEqualTo(objUserId);
		List<BsAdvertPosition> list = mapper.selectByExample(example);
		BsAdvertPosition attention = null;
		if (list != null && list.size() > 0) {
			attention = list.get(0);
		}
		return attention;
	}

	public String getIds(int userId) {
		String ids = "0,";
		List<BsAdvertPosition> list = getObjectList(userId);
		if (list != null && list.size() > 0) {
			for (BsAdvertPosition item : list) {
				ids += item.getId() + ",";
			}
		}
		ids = StringUtils.removeEnd(ids, ",");
		return ids;
	}

	public List<Integer> getIdList(int userId) {
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(0);
		List<BsAdvertPosition> list = getObjectList(userId);
		if (list != null && list.size() > 0) {
			for (BsAdvertPosition item : list) {
				idList.add(item.getId());
			}
		}
		return idList;
	}

	public List<BsAdvertPosition> getSubjectList(int userId) {
		BsAdvertPositionExample example = new BsAdvertPositionExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId).andStatusNotEqualTo(3);
		example.setOrderByClause(" update_time desc ");
		List<BsAdvertPosition> list = mapper.selectByExample(example);
		return list;
	}

	public List<BsAdvertPosition> getObjectList(int userId) {
		BsAdvertPositionExample example = new BsAdvertPositionExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId).andStatusNotEqualTo(3);
		example.setOrderByClause(" update_time desc ");
		List<BsAdvertPosition> list = mapper.selectByExample(example);
		return list;
	}

	public List<BsAdvertPosition> getStatusList(int type, int status) {
		BsAdvertPositionExample example = new BsAdvertPositionExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(status).andUserIdIsNotNull().andContentIsNotNull();
		if (type > 0) {
			criteria.andAdvertTypeEqualTo(type);
		}
		example.setOrderByClause(" rank  , update_time desc ");
		List<BsAdvertPosition> list = mapper.selectByExample(example);
		return list;
	}

	@Override
	public int countByExample(BsAdvertPositionExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsAdvertPositionExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsAdvertPositionKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsAdvertPosition record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsAdvertPosition record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsAdvertPosition> records) {
		for (BsAdvertPosition record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsAdvertPosition> records) {
		for (BsAdvertPosition record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsAdvertPosition> records) {
		for (BsAdvertPosition record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsAdvertPosition> selectByExample(BsAdvertPositionExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public BsAdvertPosition selectByPrimaryKey(BsAdvertPositionKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsAdvertPosition> findAll(List<BsAdvertPosition> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsAdvertPositionExample());
		}
		List<BsAdvertPosition> list = new ArrayList<>();
		for (BsAdvertPosition record : records) {
			BsAdvertPosition result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsAdvertPosition record, BsAdvertPositionExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsAdvertPosition record, BsAdvertPositionExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsAdvertPosition record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsAdvertPosition record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsAdvertPositionExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsAdvertPositionExample());
	}

	@Override
	public BsAdvertPositionExample getExample(BsAdvertPosition record) {
		BsAdvertPositionExample example = new BsAdvertPositionExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}
		}
		return example;
	}
}
