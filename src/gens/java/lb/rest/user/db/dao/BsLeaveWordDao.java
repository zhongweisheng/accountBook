package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsLeaveWord;
import lb.rest.user.db.entity.BsLeaveWordExample;
import lb.rest.user.db.entity.BsLeaveWordExample.Criteria;
import lb.rest.user.db.entity.BsLeaveWordKey;
import lb.rest.user.db.mapper.BsLeaveWordMapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class BsLeaveWordDao implements StaticTableDaoSupport<BsLeaveWord, BsLeaveWordExample, BsLeaveWordKey> {

	@Resource
	private BsLeaveWordMapper mapper;

	public String getIds(int userId) {
		String ids = "0,";
		List<BsLeaveWord> list = getObjectList(userId);
		if (list != null && list.size() > 0) {
			for (BsLeaveWord item : list) {
				ids += item.getId() + ",";
			}
		}
		ids = StringUtils.removeEnd(ids, ",");
		return ids;
	}

	public List<Integer> getIdList(int userId) {
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(0);
		List<BsLeaveWord> list = getObjectList(userId);
		if (list != null && list.size() > 0) {
			for (BsLeaveWord item : list) {
				idList.add(item.getId());
			}
		}
		return idList;
	}

	public List<BsLeaveWord> getSubjectList(int userId) {
		BsLeaveWordExample example = new BsLeaveWordExample();
		Criteria criteria = example.createCriteria();
		criteria.andSubjectUserIdEqualTo(userId);
		example.setOrderByClause(" id desc ");
		List<BsLeaveWord> list = mapper.selectByExample(example);
		return list;
	}

	public List<BsLeaveWord> getObjectList(int userId) {
		BsLeaveWordExample example = new BsLeaveWordExample();
		Criteria criteria = example.createCriteria();
		criteria.andObjectUserIdEqualTo(userId);
		example.setOrderByClause(" id desc ");
		List<BsLeaveWord> list = mapper.selectByExample(example);
		return list;
	}

	@Override
	public int countByExample(BsLeaveWordExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsLeaveWordExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsLeaveWordKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsLeaveWord record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsLeaveWord record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsLeaveWord> records) {
		for (BsLeaveWord record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsLeaveWord> records) {
		for (BsLeaveWord record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsLeaveWord> records) {
		for (BsLeaveWord record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsLeaveWord> selectByExample(BsLeaveWordExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public BsLeaveWord selectByPrimaryKey(BsLeaveWordKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsLeaveWord> findAll(List<BsLeaveWord> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsLeaveWordExample());
		}
		List<BsLeaveWord> list = new ArrayList<>();
		for (BsLeaveWord record : records) {
			BsLeaveWord result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsLeaveWord record, BsLeaveWordExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsLeaveWord record, BsLeaveWordExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsLeaveWord record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsLeaveWord record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsLeaveWordExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsLeaveWordExample());
	}

	@Override
	public BsLeaveWordExample getExample(BsLeaveWord record) {
		BsLeaveWordExample example = new BsLeaveWordExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}
		}
		return example;
	}
}
