package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsInventoryUser;
import lb.rest.user.db.entity.BsUnionUser;
import lb.rest.user.db.entity.BsUnionUserExample;
import lb.rest.user.db.entity.BsUnionUserExample.Criteria;
import lb.rest.user.db.entity.BsUnionUserKey;
import lb.rest.user.db.entity.Mlbuser;
import lb.rest.user.db.mapper.BsInventoryUserMapper;
import lb.rest.user.db.mapper.BsUnionUserMapper;
import lb.rest.user.db.mapper.MlbuserMapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mlb.util.Md5;
import com.mlb.util.SequenceUtil;
import com.mlb.util.ThreeDes;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;
import fc.wpf.rest.utils.BeanFactory;

@Repository
public class BsUnionUserDao implements StaticTableDaoSupport<BsUnionUser, BsUnionUserExample, BsUnionUserKey> {

	@Resource
	private BsUnionUserMapper mapper;
	private static MlbuserMapper mlbuserMapper = (MlbuserMapper) BeanFactory.getBean("mlbuserMapper");
	private static BsInventoryUserMapper bsInventoryUserMapper = (BsInventoryUserMapper) BeanFactory
			.getBean("bsInventoryUserMapper");

	// 通过 保存 mlbuser 来保存 统一的用户； 如果有则只修改密码和卖粮宝用户ID,如果没有则插入一条新的记录
	public int saveByMlb(Mlbuser record) {
		int result = 0;
		String phone = record.getPhone();
		// String phoneDe = ThreeDes.decryptPhone("", phone);
		List<BsUnionUser> userList = null;
		BsUnionUserExample example = new BsUnionUserExample();

		if (StringUtils.isEmpty(phone)) {
			int userId = record.getUserid();
			example.createCriteria().andMlbUserIdEqualTo(userId);
			userList = mapper.selectByExample(example);
		} else {
			example.createCriteria().andPhoneEqualTo(phone);
			userList = mapper.selectByExample(example);
		}

		if (userList != null && userList.size() > 0) {
			BsUnionUser user = new BsUnionUser();
			user.setMlbUserId(record.getUserid());
			if (record.getPassword() != null) {
				String passwordEn = Md5.getInstance().encode(record.getPassword());
				user.setPassWord(passwordEn);
			}
			result = mapper.updateByExampleSelective(user, example);
		} else {
			int id = record.getUserid();
			try {
				if (id <= 0) {
					id = SequenceUtil.getInstance().nextValue("user");
				}
				String passwordEn = Md5.getInstance().encode(record.getPassword());
				// 为 空则 插入
				BsUnionUser user = new BsUnionUser();

				user.setUserId(id);

				user.setMlbUserId(record.getUserid());
				user.setLzbUserId(0);
				user.setTrueName(record.getTruename());
				user.setLoginName(record.getLoginname());
				user.setPhone(record.getPhone());
				user.setPassWord(passwordEn);
				user.setOpenId(record.getOpenid());
				user.setCreateTime(new Date());
				result = mapper.insertSelective(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 初始化 等于false， 则使用粮账本的用户ID，作为统一用户的ID。
	public int saveByLzb(BsInventoryUser record) {
		int result = saveByLzb(record, false);
		return result;
	}

	public int saveByLzb(BsInventoryUser record, boolean isInit) {
		int result = 0;

		String phone = record.getPhone();
		String phoneDe = ThreeDes.decryptPhone("", phone);
		String loginNameDe = ThreeDes.decryptPhone("", record.getLoginName());
		List<BsUnionUser> userList = null;
		BsUnionUserExample example = new BsUnionUserExample();

		if (StringUtils.isEmpty(phone)) {
			int userId = record.getUserId();
			example.createCriteria().andLzbUserIdEqualTo(userId);
			userList = mapper.selectByExample(example);
		} else {
			example.createCriteria().andPhoneEqualTo(phoneDe);
			userList = mapper.selectByExample(example);
		}

		if (userList != null && userList.size() > 0) {
			BsUnionUser user = new BsUnionUser();
			user.setLzbUserId(record.getUserId());
			if (record.getPassWord() != null) {
				user.setPassWord(record.getPassWord());
			}
			result = mapper.updateByExampleSelective(user, example);
		} else {
			int id = record.getUserId();
			try {
				if (isInit || id <= 0) {
					id = SequenceUtil.getInstance().nextValue("user");
				}
				// 为 空则 插入
				BsUnionUser user = new BsUnionUser();
				user.setUserId(id);
				user.setMlbUserId(0);
				user.setLzbUserId(record.getUserId());
				user.setTrueName(record.getTrueName());
				user.setLoginName(loginNameDe);
				user.setPhone(phoneDe);
				user.setPassWord(record.getPassWord());
				user.setOpenId(record.getOpenid());
				user.setCreateTime(new Date());
				result = mapper.insertSelective(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int countByExample(BsUnionUserExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsUnionUserExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsUnionUserKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsUnionUser record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsUnionUser record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsUnionUser> records) {
		for (BsUnionUser record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsUnionUser> records) {
		for (BsUnionUser record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsUnionUser> records) {
		for (BsUnionUser record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsUnionUser> selectByExample(BsUnionUserExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public BsUnionUser selectByPrimaryKey(BsUnionUserKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsUnionUser> findAll(List<BsUnionUser> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsUnionUserExample());
		}
		List<BsUnionUser> list = new ArrayList<>();
		for (BsUnionUser record : records) {
			BsUnionUser result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsUnionUser record, BsUnionUserExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsUnionUser record, BsUnionUserExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsUnionUser record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsUnionUser record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsUnionUserExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsUnionUserExample());
	}

	@Override
	public BsUnionUserExample getExample(BsUnionUser record) {
		BsUnionUserExample example = new BsUnionUserExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getUserId() != null) {
				criteria.andUserIdEqualTo(record.getUserId());
			}
		}
		return example;
	}
}
