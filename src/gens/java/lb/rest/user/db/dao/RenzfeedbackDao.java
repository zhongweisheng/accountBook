package lb.rest.user.db.dao;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.rest.user.db.entity.Renzfeedback;
import lb.rest.user.db.entity.RenzfeedbackExample;
import lb.rest.user.db.entity.RenzfeedbackExample.Criteria;
import lb.rest.user.db.entity.RenzfeedbackKey;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

import lb.rest.user.db.mapper.RenzfeedbackMapper;

@Repository
public class RenzfeedbackDao implements StaticTableDaoSupport<Renzfeedback, RenzfeedbackExample, RenzfeedbackKey>{

	@Resource
	private RenzfeedbackMapper mapper;
	
	
	@Override
	public int countByExample(RenzfeedbackExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RenzfeedbackExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(RenzfeedbackKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(Renzfeedback record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Renzfeedback record)  {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<Renzfeedback> records)
			 {
		for(Renzfeedback record : records){
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<Renzfeedback> records)
			 {
		for(Renzfeedback record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<Renzfeedback> records)
			 {
		for(Renzfeedback record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<Renzfeedback> selectByExample(RenzfeedbackExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public Renzfeedback selectByPrimaryKey(RenzfeedbackKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<Renzfeedback> findAll(List<Renzfeedback> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new RenzfeedbackExample());
		}
		List<Renzfeedback> list = new ArrayList<>();
		for(Renzfeedback record : records){
			Renzfeedback result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(Renzfeedback record, RenzfeedbackExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Renzfeedback record, RenzfeedbackExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Renzfeedback record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Renzfeedback record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(RenzfeedbackExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new RenzfeedbackExample());
	}

	@Override
	public RenzfeedbackExample getExample(Renzfeedback record) {
		RenzfeedbackExample example = new RenzfeedbackExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getCreateuserid()!=null){
				criteria.andCreateuseridEqualTo(record.getCreateuserid());
				}
				if(record.getCreateusername()!=null){
				criteria.andCreateusernameEqualTo(record.getCreateusername());
				}
				if(record.getCreatetime()!=null){
				criteria.andCreatetimeEqualTo(record.getCreatetime());
				}
				if(record.getMlbuserid()!=null){
				criteria.andMlbuseridEqualTo(record.getMlbuserid());
				}
				if(record.getMlbusername()!=null){
				criteria.andMlbusernameEqualTo(record.getMlbusername());
				}
				if(record.getNote()!=null){
				criteria.andNoteEqualTo(record.getNote());
				}

		}
		return example;
	}
}
