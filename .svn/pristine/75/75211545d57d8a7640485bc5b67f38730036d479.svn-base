package lb.rest.user.db.dao;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.rest.user.db.entity.HtUser;
import lb.rest.user.db.entity.HtUserExample;
import lb.rest.user.db.entity.HtUserExample.Criteria;
import lb.rest.user.db.entity.HtUserKey;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

import lb.rest.user.db.mapper.HtUserMapper;

@Repository
public class HtUserDao implements StaticTableDaoSupport<HtUser, HtUserExample, HtUserKey>{

	@Resource
	private HtUserMapper mapper;
	
	
	@Override
	public int countByExample(HtUserExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(HtUserExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(HtUserKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(HtUser record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(HtUser record)  {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<HtUser> records)
			 {
		for(HtUser record : records){
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<HtUser> records)
			 {
		for(HtUser record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<HtUser> records)
			 {
		for(HtUser record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<HtUser> selectByExample(HtUserExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public HtUser selectByPrimaryKey(HtUserKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<HtUser> findAll(List<HtUser> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new HtUserExample());
		}
		List<HtUser> list = new ArrayList<>();
		for(HtUser record : records){
			HtUser result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(HtUser record, HtUserExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(HtUser record, HtUserExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(HtUser record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(HtUser record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(HtUserExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new HtUserExample());
	}

	@Override
	public HtUserExample getExample(HtUser record) {
		HtUserExample example = new HtUserExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUserid()!=null){
				criteria.andUseridEqualTo(record.getUserid());
				}
				if(record.getUsername()!=null){
				criteria.andUsernameEqualTo(record.getUsername());
				}
				if(record.getUserpwd()!=null){
				criteria.andUserpwdEqualTo(record.getUserpwd());
				}
				if(record.getUsertype()!=null){
				criteria.andUsertypeEqualTo(record.getUsertype());
				}
				if(record.getRealname()!=null){
				criteria.andRealnameEqualTo(record.getRealname());
				}
				if(record.getDepartmentid()!=null){
				criteria.andDepartmentidEqualTo(record.getDepartmentid());
				}
				if(record.getIsavailable()!=null){
				criteria.andIsavailableEqualTo(record.getIsavailable());
				}
				if(record.getCellphone()!=null){
				criteria.andCellphoneEqualTo(record.getCellphone());
				}
				if(record.getEmail()!=null){
				criteria.andEmailEqualTo(record.getEmail());
				}
				if(record.getCreator()!=null){
				criteria.andCreatorEqualTo(record.getCreator());
				}
				if(record.getCreatetime()!=null){
				criteria.andCreatetimeEqualTo(record.getCreatetime());
				}
				if(record.getOpenid()!=null){
				criteria.andOpenidEqualTo(record.getOpenid());
				}
				if(record.getQyUserId()!=null){
				criteria.andQyUserIdEqualTo(record.getQyUserId());
				}

		}
		return example;
	}
}
