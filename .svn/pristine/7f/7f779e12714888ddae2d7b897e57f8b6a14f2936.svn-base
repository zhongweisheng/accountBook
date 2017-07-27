package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsInventoryOperate;
import lb.rest.user.db.entity.BsInventoryOperateExample;
import lb.rest.user.db.entity.BsInventoryOperateExample.Criteria;
import lb.rest.user.db.entity.BsInventoryOperateKey;
import lb.rest.user.db.mapper.BsInventoryOperateMapper;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class BsInventoryOperateDao implements
		StaticTableDaoSupport<BsInventoryOperate, BsInventoryOperateExample, BsInventoryOperateKey> {

	@Resource
	private BsInventoryOperateMapper mapper;

	@Override
	public int countByExample(BsInventoryOperateExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsInventoryOperateExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsInventoryOperateKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsInventoryOperate record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsInventoryOperate record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsInventoryOperate> records) {
		for (BsInventoryOperate record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsInventoryOperate> records) {
		for (BsInventoryOperate record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsInventoryOperate> records) {
		for (BsInventoryOperate record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsInventoryOperate> selectByExample(BsInventoryOperateExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public BsInventoryOperate selectByPrimaryKey(BsInventoryOperateKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsInventoryOperate> findAll(List<BsInventoryOperate> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsInventoryOperateExample());
		}
		List<BsInventoryOperate> list = new ArrayList<>();
		for (BsInventoryOperate record : records) {
			BsInventoryOperate result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsInventoryOperate record, BsInventoryOperateExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsInventoryOperate record, BsInventoryOperateExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsInventoryOperate record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsInventoryOperate record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsInventoryOperateExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsInventoryOperateExample());
	}

	@Override
	public BsInventoryOperateExample getExample(BsInventoryOperate record) {
		BsInventoryOperateExample example = new BsInventoryOperateExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}

		}
		return example;
	}
}
