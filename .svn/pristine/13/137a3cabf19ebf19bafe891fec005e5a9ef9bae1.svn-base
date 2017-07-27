package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsInventoryDelete;
import lb.rest.user.db.entity.BsInventoryDeleteExample;
import lb.rest.user.db.entity.BsInventoryDeleteExample.Criteria;
import lb.rest.user.db.entity.BsInventoryDeleteKey;
import lb.rest.user.db.mapper.BsInventoryDeleteMapper;

import org.springframework.stereotype.Repository;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class BsInventoryDeleteDao implements
		StaticTableDaoSupport<BsInventoryDelete, BsInventoryDeleteExample, BsInventoryDeleteKey> {
	@Resource
	private BsInventoryDeleteMapper mapper;

	@Override
	public int countByExample(BsInventoryDeleteExample paramD) {
		return mapper.countByExample(paramD);
	}

	@Override
	public int deleteByExample(BsInventoryDeleteExample paramD) {
		return mapper.deleteByExample(paramD);
	}

	@Override
	public int deleteByPrimaryKey(BsInventoryDeleteKey paramK) {
		return mapper.deleteByPrimaryKey(paramK);
	}

	@Override
	public int insert(BsInventoryDelete paramT) {
		return mapper.insert(paramT);
	}

	@Override
	public int insertSelective(BsInventoryDelete paramT) {
		return mapper.insertSelective(paramT);
	}

	@Override
	public int batchInsert(List<BsInventoryDelete> paramList) {
		for (BsInventoryDelete bsInventoryDelete : paramList) {
			mapper.insert(bsInventoryDelete);
		}
		return paramList.size();
	}

	@Override
	public int batchUpdate(List<BsInventoryDelete> paramList) {
		for (BsInventoryDelete bsInventoryDelete : paramList) {
			mapper.updateByPrimaryKeySelective(bsInventoryDelete);
		}
		return paramList.size();
	}

	@Override
	public int batchDelete(List<BsInventoryDelete> paramList) {
		for (BsInventoryDelete bsInventoryDelete : paramList) {
			mapper.deleteByPrimaryKey(bsInventoryDelete);
		}
		return 0;
	}

	@Override
	public List<BsInventoryDelete> selectByExample(BsInventoryDeleteExample paramD) {
		return mapper.selectByExample(paramD);
	}

	@Override
	public BsInventoryDelete selectByPrimaryKey(BsInventoryDeleteKey paramK) {
		return mapper.selectByPrimaryKey(paramK);
	}

	@Override
	public List<BsInventoryDelete> findAll(List<BsInventoryDelete> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsInventoryDeleteExample());
		}
		List<BsInventoryDelete> list = new ArrayList<>();
		for (BsInventoryDelete record : records) {
			BsInventoryDelete result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsInventoryDelete paramT, BsInventoryDeleteExample paramD) {
		return mapper.updateByExampleSelective(paramT, paramD);
	}

	@Override
	public int updateByExample(BsInventoryDelete paramT, BsInventoryDeleteExample paramD) {
		return mapper.updateByExample(paramT, paramD);
	}

	@Override
	public int updateByPrimaryKeySelective(BsInventoryDelete paramT) {
		return mapper.updateByPrimaryKey(paramT);
	}

	@Override
	public int updateByPrimaryKey(BsInventoryDelete paramT) {
		return mapper.updateByPrimaryKey(paramT);
	}

	@Override
	public int sumByExample(BsInventoryDeleteExample paramD) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsInventoryDeleteExample());
	}

	@Override
	public BsInventoryDeleteExample getExample(BsInventoryDelete record) {
		BsInventoryDeleteExample example = new BsInventoryDeleteExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}
			if (record.getUserId() != null) {
				criteria.andUserIdEqualTo(record.getUserId());
			}
		}
		return example;
	}

}
