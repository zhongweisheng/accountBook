package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsInventoryDepot;
import lb.rest.user.db.entity.BsInventoryDepotExample;
import lb.rest.user.db.entity.BsInventoryDepotExample.Criteria;
import lb.rest.user.db.entity.BsInventoryDepotKey;
import lb.rest.user.db.entity.BsInventoryUserDepot;
import lb.rest.user.db.entity.BsInventoryUserDepotExample;
import lb.rest.user.db.mapper.BsInventoryDepotMapper;
import lb.rest.user.db.mapper.BsInventoryUserDepotMapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class BsInventoryDepotDao implements
		StaticTableDaoSupport<BsInventoryDepot, BsInventoryDepotExample, BsInventoryDepotKey> {

	@Resource
	private BsInventoryDepotMapper mapper;
	@Resource
	private BsInventoryUserDepotMapper userDepotMapper;

	public String getIds(int userId) {
		String ids = "0,";
		List<BsInventoryDepot> list = getList(userId);
		if (list != null && list.size() > 0) {
			for (BsInventoryDepot userDepot : list) {
				ids += userDepot.getId() + ",";
			}
		}
		ids = StringUtils.removeEnd(ids, ",");
		return ids;
	}

	public List<Integer> getIdList(int userId) {
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(0);
		List<BsInventoryDepot> list = getList(userId);
		if (list != null && list.size() > 0) {
			for (BsInventoryDepot userDepot : list) {
				idList.add(userDepot.getId());
			}
		}
		return idList;
	}

	public List<BsInventoryDepot> getList(int userId) {
		BsInventoryDepotExample example = new BsInventoryDepotExample();
		// 粮库主 所有者 的 粮库
		Criteria criteria = example.createCriteria();
		criteria.andOwnerIdEqualTo(userId);
		List<BsInventoryDepot> depotList = mapper.selectByExample(example);

		if (depotList == null || depotList.size() == 0) {
			// 员工能看到的粮库
			BsInventoryDepotExample exampleView = new BsInventoryDepotExample();
			Criteria criteriaOr = exampleView.createCriteria();

			BsInventoryUserDepotExample exampleUser = new BsInventoryUserDepotExample();
			lb.rest.user.db.entity.BsInventoryUserDepotExample.Criteria criteriaUser = exampleUser.createCriteria();
			criteriaUser.andUserIdEqualTo(userId);

			List<BsInventoryUserDepot> userDepotList = userDepotMapper.selectByExample(exampleUser);
			if (userDepotList != null && userDepotList.size() > 0) {
				List<Integer> values = new ArrayList<Integer>();
				for (BsInventoryUserDepot userDepot : userDepotList) {
					values.add(userDepot.getDepotId());
				}
				criteriaOr.andIdIn(values);
				List<BsInventoryDepot> depotListView = mapper.selectByExample(exampleView);
				depotList = depotListView;
				// if (depotListView != null && depotListView.size() > 0) {
				// for (BsInventoryDepot d : depotListView) {
				// if (!depotList.contains(d)) {
				// depotList.add(d);
				// }
				// }
				// }
			}
		}
		return depotList;
	}

	@Override
	public int countByExample(BsInventoryDepotExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsInventoryDepotExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsInventoryDepotKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsInventoryDepot record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsInventoryDepot record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsInventoryDepot> records) {
		for (BsInventoryDepot record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsInventoryDepot> records) {
		for (BsInventoryDepot record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsInventoryDepot> records) {
		for (BsInventoryDepot record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsInventoryDepot> selectByExample(BsInventoryDepotExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public BsInventoryDepot selectByPrimaryKey(BsInventoryDepotKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsInventoryDepot> findAll(List<BsInventoryDepot> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsInventoryDepotExample());
		}
		List<BsInventoryDepot> list = new ArrayList<>();
		for (BsInventoryDepot record : records) {
			BsInventoryDepot result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsInventoryDepot record, BsInventoryDepotExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsInventoryDepot record, BsInventoryDepotExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsInventoryDepot record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsInventoryDepot record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsInventoryDepotExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsInventoryDepotExample());
	}

	@Override
	public BsInventoryDepotExample getExample(BsInventoryDepot record) {
		BsInventoryDepotExample example = new BsInventoryDepotExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}
		}
		return example;
	}
}
