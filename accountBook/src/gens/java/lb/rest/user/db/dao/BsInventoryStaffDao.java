package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsInventoryRecord;
import lb.rest.user.db.entity.BsInventoryRecordExample;
import lb.rest.user.db.entity.BsInventoryStaff;
import lb.rest.user.db.entity.BsInventoryStaffExample;
import lb.rest.user.db.entity.BsInventoryStaffExample.Criteria;
import lb.rest.user.db.entity.BsInventoryStaffKey;
import lb.rest.user.db.mapper.BsInventoryRecordMapper;
import lb.rest.user.db.mapper.BsInventoryStaffMapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class BsInventoryStaffDao implements
		StaticTableDaoSupport<BsInventoryStaff, BsInventoryStaffExample, BsInventoryStaffKey> {

	@Resource
	private BsInventoryStaffMapper mapper;

	@Resource
	private BsInventoryRecordMapper bsInventoryRecordMapper;

	// 更新 出入库记录中的送粮人或买两人或司机。
	public int updateRecord(BsInventoryStaff staff) {
		int staffId = staff.getId();
		int staffType = staff.getStaffType();
		String staffName = staff.getTrueName();
		String phone = staff.getPhone();
		if (staffId > 0 && StringUtils.isNotEmpty(staffName) && StringUtils.isNotEmpty(phone)) {
			BsInventoryRecordExample example = new BsInventoryRecordExample();
			lb.rest.user.db.entity.BsInventoryRecordExample.Criteria criteria = example.createCriteria();
			BsInventoryRecord record = new BsInventoryRecord();
			if (staffType == 3) {
				criteria.andDriverIdEqualTo(staffId);
				record.setDriverName(staffName);
				record.setDriverPhone(phone);
			} else {
				criteria.andStaffIdEqualTo(staffId);
				record.setStaffName(staffName);
				record.setStaffPhone(phone);
			}
			return bsInventoryRecordMapper.updateByExample(record, example);
		} else {
			return 0;
		}
	}

	public boolean isExist(int userId, int staffType, String phone, int selfId) {
		boolean isExist = false;
		BsInventoryStaffExample example = new BsInventoryStaffExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andStaffTypeEqualTo(staffType);
		criteria.andPhoneEqualTo(phone);
		// 不等于自己的ID
		criteria.andIdNotEqualTo(selfId);
		List<BsInventoryStaff> list = mapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public int countByExample(BsInventoryStaffExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsInventoryStaffExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsInventoryStaffKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsInventoryStaff record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsInventoryStaff record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsInventoryStaff> records) {
		for (BsInventoryStaff record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsInventoryStaff> records) {
		for (BsInventoryStaff record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsInventoryStaff> records) {
		for (BsInventoryStaff record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsInventoryStaff> selectByExample(BsInventoryStaffExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public BsInventoryStaff selectByPrimaryKey(BsInventoryStaffKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsInventoryStaff> findAll(List<BsInventoryStaff> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsInventoryStaffExample());
		}
		List<BsInventoryStaff> list = new ArrayList<>();
		for (BsInventoryStaff record : records) {
			BsInventoryStaff result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsInventoryStaff record, BsInventoryStaffExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsInventoryStaff record, BsInventoryStaffExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsInventoryStaff record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsInventoryStaff record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsInventoryStaffExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsInventoryStaffExample());
	}

	@Override
	public BsInventoryStaffExample getExample(BsInventoryStaff record) {
		BsInventoryStaffExample example = new BsInventoryStaffExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}
			if (record.getPhone() != null) {
				criteria.andPhoneEqualTo(record.getPhone());
			}
			if (record.getStaffType() != null) {
				criteria.andStaffTypeEqualTo(record.getStaffType());
			}
		}
		return example;
	}
}
