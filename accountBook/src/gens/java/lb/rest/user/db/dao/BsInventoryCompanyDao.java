package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsInventoryCompany;
import lb.rest.user.db.entity.BsInventoryCompanyExample;
import lb.rest.user.db.entity.BsInventoryCompanyExample.Criteria;
import lb.rest.user.db.entity.BsInventoryCompanyKey;
import lb.rest.user.db.mapper.BsInventoryCompanyMapper;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mlb.util.SequenceUtil;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class BsInventoryCompanyDao implements
		StaticTableDaoSupport<BsInventoryCompany, BsInventoryCompanyExample, BsInventoryCompanyKey> {

	@Resource
	private BsInventoryCompanyMapper mapper;

	// 所有者下 有无 公司
	public BsInventoryCompany getCompanyByOwnerId(int ownerId) {
		BsInventoryCompany company = null;
		BsInventoryCompanyExample exampleCompany = new BsInventoryCompanyExample();
		exampleCompany.createCriteria().andOwnerIdEqualTo(ownerId);
		List<BsInventoryCompany> companyList = mapper.selectByExample(exampleCompany);
		if (companyList != null && companyList.size() > 0) {
			company = companyList.get(0);
		} else {
			company = new BsInventoryCompany();
			int id = 0;
			try {
				id = SequenceUtil.getInstance().nextValue("bs_inventory_company");
				company.setId(id);
				company.setCompanyName("");
				company.setAddress("");
				company.setPhone("");
				company.setCreateTime(new Date());
				company.setUpdateTime(new Date());
				company.setOwnerId(ownerId);
				mapper.insert(company);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return company;
	}

	@Override
	public int countByExample(BsInventoryCompanyExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsInventoryCompanyExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsInventoryCompanyKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsInventoryCompany record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsInventoryCompany record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsInventoryCompany> records) {
		for (BsInventoryCompany record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsInventoryCompany> records) {
		for (BsInventoryCompany record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsInventoryCompany> records) {
		for (BsInventoryCompany record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsInventoryCompany> selectByExample(BsInventoryCompanyExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public BsInventoryCompany selectByPrimaryKey(BsInventoryCompanyKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsInventoryCompany> findAll(List<BsInventoryCompany> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsInventoryCompanyExample());
		}
		List<BsInventoryCompany> list = new ArrayList<>();
		for (BsInventoryCompany record : records) {
			BsInventoryCompany result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsInventoryCompany record, BsInventoryCompanyExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsInventoryCompany record, BsInventoryCompanyExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsInventoryCompany record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsInventoryCompany record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsInventoryCompanyExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsInventoryCompanyExample());
	}

	@Override
	public BsInventoryCompanyExample getExample(BsInventoryCompany record) {
		BsInventoryCompanyExample example = new BsInventoryCompanyExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}

		}
		return example;
	}
}
