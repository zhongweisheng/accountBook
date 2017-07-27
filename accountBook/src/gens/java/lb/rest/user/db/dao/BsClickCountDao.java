package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsClickCount;
import lb.rest.user.db.entity.BsClickCountExample;
import lb.rest.user.db.entity.BsClickCountExample.Criteria;
import lb.rest.user.db.entity.BsClickCountKey;
import lb.rest.user.db.mapper.BsClickCountMapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class BsClickCountDao implements StaticTableDaoSupport<BsClickCount, BsClickCountExample, BsClickCountKey> {

	@Resource
	private BsClickCountMapper mapper;

	public String getIds(int userId) {
		String ids = "0,";
		List<BsClickCount> list = getList(userId);
		if (list != null && list.size() > 0) {
			for (BsClickCount item : list) {
				ids += item.getId() + ",";
			}
		}
		ids = StringUtils.removeEnd(ids, ",");
		return ids;
	}

	public List<Integer> getIdList(int userId) {
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(0);
		List<BsClickCount> list = getList(userId);
		if (list != null && list.size() > 0) {
			for (BsClickCount item : list) {
				idList.add(item.getId());
			}
		}
		return idList;
	}

	public List<BsClickCount> getList(int userId) {
		BsClickCountExample example = new BsClickCountExample();
		Criteria criteria = example.createCriteria();
		criteria.andTargetIdEqualTo(userId);
		List<BsClickCount> list = mapper.selectByExample(example);
		return list;
	}

	@Override
	public int countByExample(BsClickCountExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsClickCountExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsClickCountKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsClickCount record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsClickCount record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsClickCount> records) {
		for (BsClickCount record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsClickCount> records) {
		for (BsClickCount record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsClickCount> records) {
		for (BsClickCount record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsClickCount> selectByExample(BsClickCountExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public BsClickCount selectByPrimaryKey(BsClickCountKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsClickCount> findAll(List<BsClickCount> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsClickCountExample());
		}
		List<BsClickCount> list = new ArrayList<>();
		for (BsClickCount record : records) {
			BsClickCount result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsClickCount record, BsClickCountExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsClickCount record, BsClickCountExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsClickCount record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsClickCount record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsClickCountExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsClickCountExample());
	}

	@Override
	public BsClickCountExample getExample(BsClickCount record) {
		BsClickCountExample example = new BsClickCountExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}
		}
		return example;
	}
}
