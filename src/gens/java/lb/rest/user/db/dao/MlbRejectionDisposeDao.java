package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.MlbRejectionDispose;
import lb.rest.user.db.entity.MlbRejectionDisposeExample;
import lb.rest.user.db.entity.MlbRejectionDisposeExample.Criteria;
import lb.rest.user.db.entity.MlbRejectionDisposeKey;
import lb.rest.user.db.mapper.MlbRejectionDisposeMapper;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class MlbRejectionDisposeDao implements
		StaticTableDaoSupport<MlbRejectionDispose, MlbRejectionDisposeExample, MlbRejectionDisposeKey> {

	@Resource
	private MlbRejectionDisposeMapper mapper;

	@Override
	public int countByExample(MlbRejectionDisposeExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MlbRejectionDisposeExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(MlbRejectionDisposeKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(MlbRejectionDispose record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(MlbRejectionDispose record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<MlbRejectionDispose> records) {
		for (MlbRejectionDispose record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<MlbRejectionDispose> records) {
		for (MlbRejectionDispose record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<MlbRejectionDispose> records) {
		for (MlbRejectionDispose record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<MlbRejectionDispose> selectByExample(MlbRejectionDisposeExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public MlbRejectionDispose selectByPrimaryKey(MlbRejectionDisposeKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<MlbRejectionDispose> findAll(List<MlbRejectionDispose> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new MlbRejectionDisposeExample());
		}
		List<MlbRejectionDispose> list = new ArrayList<>();
		for (MlbRejectionDispose record : records) {
			MlbRejectionDispose result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(MlbRejectionDispose record, MlbRejectionDisposeExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(MlbRejectionDispose record, MlbRejectionDisposeExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(MlbRejectionDispose record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MlbRejectionDispose record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(MlbRejectionDisposeExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new MlbRejectionDisposeExample());
	}

	@Override
	public MlbRejectionDisposeExample getExample(MlbRejectionDispose record) {
		MlbRejectionDisposeExample example = new MlbRejectionDisposeExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}
			if (record.getUserId() != null) {
				criteria.andUserIdEqualTo(record.getUserId());
			}
			if (record.getUserName() != null) {
				criteria.andUserNameEqualTo(record.getUserName());
			}
			if (record.getUserPhone() != null) {
				criteria.andUserPhoneEqualTo(record.getUserPhone());
			}
			if (record.getApplyTime() != null) {
				criteria.andApplyTimeEqualTo(record.getApplyTime());
			}
			if (record.getOperationTime() != null) {
				criteria.andOperationTimeEqualTo(record.getOperationTime());
			}
			if (record.getOperationUserId() != null) {
				criteria.andOperationUserIdEqualTo(record.getOperationUserId());
			}
			if (record.getOperationUserName() != null) {
				criteria.andOperationUserNameEqualTo(record.getOperationUserName());
			}
			if (record.getLocation() != null) {
				criteria.andLocationEqualTo(record.getLocation());
			}
			if (record.getLocationDesc() != null) {
				criteria.andLocationDescEqualTo(record.getLocationDesc());
			}
			if (record.getAddress() != null) {
				criteria.andAddressEqualTo(record.getAddress());
			}
			if (record.getGrainType() != null) {
				criteria.andGrainTypeEqualTo(record.getGrainType());
			}
			if (record.getGrainLevel() != null) {
				criteria.andGrainLevelEqualTo(record.getGrainLevel());
			}
			if (record.getQualityDesc() != null) {
				criteria.andQualityDescEqualTo(record.getQualityDesc());
			}
			if (record.getPrice() != null) {
				criteria.andPriceEqualTo(record.getPrice());
			}
			if (record.getAmount() != null) {
				criteria.andAmountEqualTo(record.getAmount());
			}
			if (record.getHasInvoice() != null) {
				criteria.andHasInvoiceEqualTo(record.getHasInvoice());
			}
			if (record.getRemark() != null) {
				criteria.andRemarkEqualTo(record.getRemark());
			}
			if (record.getStrColumnBak1() != null) {
				criteria.andStrColumnBak1EqualTo(record.getStrColumnBak1());
			}
			if (record.getIntColumnBak1() != null) {
				criteria.andIntColumnBak1EqualTo(record.getIntColumnBak1());
			}
			if (record.getStatus() != null) {
				criteria.andStatusEqualTo(record.getStatus());
			}

		}
		return example;
	}
}
