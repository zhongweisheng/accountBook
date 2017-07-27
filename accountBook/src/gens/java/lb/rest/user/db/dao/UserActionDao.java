package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.UserAction;
import lb.rest.user.db.entity.UserActionExample;
import lb.rest.user.db.entity.UserActionExample.Criteria;
import lb.rest.user.db.entity.UserActionKey;
import lb.rest.user.db.mapper.UserActionMapper;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mlb.enums.UserActionEnum;
import com.mlb.util.SequenceUtil;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class UserActionDao implements StaticTableDaoSupport<UserAction, UserActionExample, UserActionKey> {

	@Resource
	private UserActionMapper mapper;

	/***
	 * 参数 用户名
	 * 
	 * @param record
	 * @return
	 */
	public int saveAuthTime(int actionType, int userId, String userName) {
		// 组装 对象
		UserAction record = new UserAction();
		int id = 0;
		try {
			id = SequenceUtil.getInstance().nextValue("user_action");
			record.setId(id);
			record.setActiontype(actionType);
			record.setActionname(UserActionEnum.getName(actionType));
			record.setUserid(userId);
			record.setUsername(userName);
			record.setActiontime(new Date());

			UserActionExample example = new UserActionExample();
			example.createCriteria().andActiontypeEqualTo(actionType).andUseridEqualTo(userId);
			List<UserAction> list = mapper.selectByExample(example);

			if (list != null && list.size() > 0) {
				return mapper.updateByExample(record, example);
			} else {
				return mapper.insertSelective(record);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public int countByExample(UserActionExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(UserActionExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(UserActionKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(UserAction record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(UserAction record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<UserAction> records) {
		for (UserAction record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<UserAction> records) {
		for (UserAction record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<UserAction> records) {
		for (UserAction record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<UserAction> selectByExample(UserActionExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public UserAction selectByPrimaryKey(UserActionKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<UserAction> findAll(List<UserAction> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new UserActionExample());
		}
		List<UserAction> list = new ArrayList<>();
		for (UserAction record : records) {
			UserAction result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(UserAction record, UserActionExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(UserAction record, UserActionExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(UserAction record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserAction record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(UserActionExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new UserActionExample());
	}

	@Override
	public UserActionExample getExample(UserAction record) {
		UserActionExample example = new UserActionExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}
			if (record.getActiontype() != null) {
				criteria.andActiontypeEqualTo(record.getActiontype());
			}
			if (record.getActionname() != null) {
				criteria.andActionnameEqualTo(record.getActionname());
			}
			if (record.getActiontime() != null) {
				criteria.andActiontimeEqualTo(record.getActiontime());
			}
			if (record.getUserid() != null) {
				criteria.andUseridEqualTo(record.getUserid());
			}
			if (record.getUsername() != null) {
				criteria.andUsernameEqualTo(record.getUsername());
			}
			if (record.getUseropenid() != null) {
				criteria.andUseropenidEqualTo(record.getUseropenid());
			}
			if (record.getNote() != null) {
				criteria.andNoteEqualTo(record.getNote());
			}
			if (record.getOfferpricetype() != null) {
				criteria.andOfferpricetypeEqualTo(record.getOfferpricetype());
			}
			if (record.getGraintype() != null) {
				criteria.andGraintypeEqualTo(record.getGraintype());
			}
			if (record.getOfferpriceid() != null) {
				criteria.andOfferpriceidEqualTo(record.getOfferpriceid());
			}
			if (record.getOrderid() != null) {
				criteria.andOrderidEqualTo(record.getOrderid());
			}
			if (record.getPhone() != null) {
				criteria.andPhoneEqualTo(record.getPhone());
			}
			if (record.getMessageid() != null) {
				criteria.andMessageidEqualTo(record.getMessageid());
			}
			if (record.getMenuname() != null) {
				criteria.andMenunameEqualTo(record.getMenuname());
			}
			if (record.getFromtype() != null) {
				criteria.andFromtypeEqualTo(record.getFromtype());
			}
			if (record.getIsshow() != null) {
				criteria.andIsshowEqualTo(record.getIsshow());
			}

		}
		return example;
	}
}
