package lb.rest.user.db.dao;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.rest.user.db.entity.Blacklist;
import lb.rest.user.db.entity.BlacklistExample;
import lb.rest.user.db.entity.BlacklistExample.Criteria;
import lb.rest.user.db.entity.BlacklistKey;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

import lb.rest.user.db.mapper.BlacklistMapper;

@Repository
public class BlacklistDao implements StaticTableDaoSupport<Blacklist, BlacklistExample, BlacklistKey>{

	@Resource
	private BlacklistMapper mapper;
	
	
	@Override
	public int countByExample(BlacklistExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BlacklistExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BlacklistKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(Blacklist record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Blacklist record)  {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<Blacklist> records)
			 {
		for(Blacklist record : records){
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<Blacklist> records)
			 {
		for(Blacklist record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<Blacklist> records)
			 {
		for(Blacklist record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<Blacklist> selectByExample(BlacklistExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public Blacklist selectByPrimaryKey(BlacklistKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<Blacklist> findAll(List<Blacklist> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BlacklistExample());
		}
		List<Blacklist> list = new ArrayList<>();
		for(Blacklist record : records){
			Blacklist result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(Blacklist record, BlacklistExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Blacklist record, BlacklistExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Blacklist record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Blacklist record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BlacklistExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new BlacklistExample());
	}

	@Override
	public BlacklistExample getExample(Blacklist record) {
		BlacklistExample example = new BlacklistExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getPhone()!=null){
				criteria.andPhoneEqualTo(record.getPhone());
				}
				if(record.getName()!=null){
				criteria.andNameEqualTo(record.getName());
				}
				if(record.getCreatetime()!=null){
				criteria.andCreatetimeEqualTo(record.getCreatetime());
				}
				if(record.getUpdatetime()!=null){
				criteria.andUpdatetimeEqualTo(record.getUpdatetime());
				}
				if(record.getState()!=null){
				criteria.andStateEqualTo(record.getState());
				}
				if(record.getNum()!=null){
				criteria.andNumEqualTo(record.getNum());
				}
				if(record.getCreateuserid()!=null){
				criteria.andCreateuseridEqualTo(record.getCreateuserid());
				}
				if(record.getCreateusername()!=null){
				criteria.andCreateusernameEqualTo(record.getCreateusername());
				}
				if(record.getUpdateuserid()!=null){
				criteria.andUpdateuseridEqualTo(record.getUpdateuserid());
				}
				if(record.getUpdateusername()!=null){
				criteria.andUpdateusernameEqualTo(record.getUpdateusername());
				}
				if(record.getMlbuserboid()!=null){
				criteria.andMlbuserboidEqualTo(record.getMlbuserboid());
				}
				if(record.getRemarks()!=null){
				criteria.andRemarksEqualTo(record.getRemarks());
				}
				if(record.getSource()!=null){
				criteria.andSourceEqualTo(record.getSource());
				}
				if(record.getOwnedcompany()!=null){
				criteria.andOwnedcompanyEqualTo(record.getOwnedcompany());
				}
				if(record.getCorporatename()!=null){
				criteria.andCorporatenameEqualTo(record.getCorporatename());
				}
				if(record.getLocation()!=null){
				criteria.andLocationEqualTo(record.getLocation());
				}
				if(record.getAddress()!=null){
				criteria.andAddressEqualTo(record.getAddress());
				}
				if(record.getLocationdesc()!=null){
				criteria.andLocationdescEqualTo(record.getLocationdesc());
				}
				if(record.getTraderName()!=null){
				criteria.andTraderNameEqualTo(record.getTraderName());
				}

		}
		return example;
	}
}
