package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import lb.rest.user.db.entity.Mlbuser;
import lb.rest.user.db.entity.MlbuserExample;
import lb.rest.user.db.entity.MlbuserExample.Criteria;
import lb.rest.user.db.entity.MlbuserKey;
import lb.rest.user.db.mapper.MlbuserMapper;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;
import fc.wpf.rest.utils.BeanFactory;

@Repository
public class MlbuserDao implements StaticTableDaoSupport<Mlbuser, MlbuserExample, MlbuserKey> {

	@Resource
	private MlbuserMapper mapper;

	private static BsUnionUserDao bsUnionUserDao = (BsUnionUserDao) BeanFactory.getBean("bsUnionUserDao");

	@Override
	public int countByExample(MlbuserExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MlbuserExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(MlbuserKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(Mlbuser record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Mlbuser record) {
		bsUnionUserDao.saveByMlb(record);
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<Mlbuser> records) {
		for (Mlbuser record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<Mlbuser> records) {
		for (Mlbuser record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<Mlbuser> records) {
		for (Mlbuser record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<Mlbuser> selectByExample(MlbuserExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public Mlbuser selectByPrimaryKey(MlbuserKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<Mlbuser> findAll(List<Mlbuser> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new MlbuserExample());
		}
		List<Mlbuser> list = new ArrayList<>();
		for (Mlbuser record : records) {
			Mlbuser result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(Mlbuser record, MlbuserExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Mlbuser record, MlbuserExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Mlbuser record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Mlbuser record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(MlbuserExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new MlbuserExample());
	}

	@Override
	public MlbuserExample getExample(Mlbuser record) {
		MlbuserExample example = new MlbuserExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getUserid() != null) {
				criteria.andUseridEqualTo(record.getUserid());
			}
			if (record.getRegisterstatus() != null) {
				criteria.andRegisterstatusEqualTo(record.getRegisterstatus());
			}
			if (record.getTruename() != null) {
				criteria.andTruenameEqualTo(record.getTruename());
			}
			if (record.getPhone() != null) {
				criteria.andPhoneEqualTo(record.getPhone());
			}
			if (record.getLoginname() != null) {
				criteria.andLoginnameEqualTo(record.getLoginname());
			}
			if (record.getPassword() != null) {
				criteria.andPasswordEqualTo(record.getPassword());
			}
			if (record.getStatus() != null) {
				criteria.andStatusEqualTo(record.getStatus());
			}
			if (record.getUsertype() != null) {
				criteria.andUsertypeEqualTo(record.getUsertype());
			}
			if (record.getLocation() != null) {
				criteria.andLocationEqualTo(record.getLocation());
			}
			if (record.getAddress() != null) {
				criteria.andAddressEqualTo(record.getAddress());
			}
			if (record.getPreferuserid() != null) {
				criteria.andPreferuseridEqualTo(record.getPreferuserid());
			}
			if (record.getOpenid() != null) {
				criteria.andOpenidEqualTo(record.getOpenid());
			}
			if (record.getNickname() != null) {
				criteria.andNicknameEqualTo(record.getNickname());
			}
			if (record.getUserimage() != null) {
				criteria.andUserimageEqualTo(record.getUserimage());
			}
			if (record.getLocationdesc() != null) {
				criteria.andLocationdescEqualTo(record.getLocationdesc());
			}
			if (record.getInvitecode() != null) {
				criteria.andInvitecodeEqualTo(record.getInvitecode());
			}
			if (record.getRegtime() != null) {
				criteria.andRegtimeEqualTo(record.getRegtime());
			}
			if (record.getCompanyname() != null) {
				criteria.andCompanynameEqualTo(record.getCompanyname());
			}
			if (record.getFromtype() != null) {
				criteria.andFromtypeEqualTo(record.getFromtype());
			}
			if (record.getCreateuserid() != null) {
				criteria.andCreateuseridEqualTo(record.getCreateuserid());
			}
			if (record.getLevel() != null) {
				criteria.andLevelEqualTo(record.getLevel());
			}
			if (record.getUpdatetime() != null) {
				criteria.andUpdatetimeEqualTo(record.getUpdatetime());
			}
			if (record.getIsManage() != null) {
				criteria.andIsManageEqualTo(record.getIsManage());
			}
			if (record.getManagerId() != null) {
				criteria.andManagerIdEqualTo(record.getManagerId());
			}
			if (record.getHasAgree() != null) {
				criteria.andHasAgreeEqualTo(record.getHasAgree());
			}
			if (record.getBlacklist() != null) {
				criteria.andBlacklistEqualTo(record.getBlacklist());
			}
			if (record.getAuthentication() != null) {
				criteria.andAuthenticationEqualTo(record.getAuthentication());
			}
			if (record.getProcesscode() != null) {
				criteria.andProcesscodeEqualTo(record.getProcesscode());
			}
			if (record.getTraderuserid() != null) {
				criteria.andTraderuseridEqualTo(record.getTraderuserid());
			}
			if (record.getTradername() != null) {
				criteria.andTradernameEqualTo(record.getTradername());
			}
			if (record.getClientName() != null) {
				criteria.andClientNameEqualTo(record.getClientName());
			}
			if (record.getCustomername() != null) {
				criteria.andCustomernameEqualTo(record.getCustomername());
			}
			if (record.getRemark() != null) {
				criteria.andRemarkEqualTo(record.getRemark());
			}
			if (record.getAssignsStatus() != null) {
				criteria.andAssignsStatusEqualTo(record.getAssignsStatus());
			}
			if (record.getApplyUserStatus() != null) {
				criteria.andApplyUserStatusEqualTo(record.getApplyUserStatus());
			}
			if (record.getApplyUserTime() != null) {
				criteria.andApplyUserTimeEqualTo(record.getApplyUserTime());
			}
			if (record.getBuyType() != null) {
				criteria.andBuyTypeEqualTo(record.getBuyType());
			}
			if (record.getMaintainer() != null) {
				criteria.andMaintainerEqualTo(record.getMaintainer());
			}
			if (record.getShineuser() != null) {
				criteria.andShineuserEqualTo(record.getShineuser());
			}
			if (record.getIdCard() != null) {
				criteria.andIdCardEqualTo(record.getIdCard());
			}
			if (record.getEmail() != null) {
				criteria.andEmailEqualTo(record.getEmail());
			}
			if (record.getPhone2() != null) {
				criteria.andPhone2EqualTo(record.getPhone2());
			}
			if (record.getAuthTime() != null) {
				criteria.andAuthTimeEqualTo(record.getAuthTime());
			}
			if (record.getCompanyAuth() != null) {
				criteria.andCompanyAuthEqualTo(record.getCompanyAuth());
			}
			if (record.getPersonalAuth() != null) {
				criteria.andPersonalAuthEqualTo(record.getPersonalAuth());
			}

		}
		return example;
	}
}
