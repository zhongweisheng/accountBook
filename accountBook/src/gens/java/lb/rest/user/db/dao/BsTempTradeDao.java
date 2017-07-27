package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsTempTrade;
import lb.rest.user.db.entity.BsTempTradeExample;
import lb.rest.user.db.entity.BsTempTradeExample.Criteria;
import lb.rest.user.db.entity.BsTempTradeKey;
import lb.rest.user.db.mapper.BsTempTradeMapper;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class BsTempTradeDao implements StaticTableDaoSupport<BsTempTrade, BsTempTradeExample, BsTempTradeKey> {

	@Resource
	private BsTempTradeMapper mapper;

	public static Map<Integer, BsTempTrade> tempMap = new HashMap<Integer, BsTempTrade>();

	public Map<Integer, BsTempTrade> getTradeMap(int update) {
		Map<Integer, BsTempTrade> map = new HashMap<Integer, BsTempTrade>();
		BsTempTradeExample example = new BsTempTradeExample();
		if (tempMap != null && tempMap.size() > 1 && update != 1) {
			return tempMap;
		} else {
			List<BsTempTrade> list = mapper.selectByExample(example);
			if (list != null && list.size() > 0) {
				for (BsTempTrade item : list) {
					map.put(item.getBuyId(), item);
				}
			}
			tempMap = map;
		}
		return map;
	}

	@Override
	public int countByExample(BsTempTradeExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsTempTradeExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsTempTradeKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsTempTrade record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsTempTrade record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsTempTrade> records) {
		for (BsTempTrade record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsTempTrade> records) {
		for (BsTempTrade record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsTempTrade> records) {
		for (BsTempTrade record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsTempTrade> selectByExample(BsTempTradeExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public BsTempTrade selectByPrimaryKey(BsTempTradeKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsTempTrade> findAll(List<BsTempTrade> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsTempTradeExample());
		}
		List<BsTempTrade> list = new ArrayList<>();
		for (BsTempTrade record : records) {
			BsTempTrade result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsTempTrade record, BsTempTradeExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsTempTrade record, BsTempTradeExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsTempTrade record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsTempTrade record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsTempTradeExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsTempTradeExample());
	}

	@Override
	public BsTempTradeExample getExample(BsTempTrade record) {
		BsTempTradeExample example = new BsTempTradeExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}

		}
		return example;
	}
}
