package lb.rest.user.db.dao;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.rest.user.db.entity.MlbSuggestion;
import lb.rest.user.db.entity.MlbSuggestionExample;
import lb.rest.user.db.entity.MlbSuggestionExample.Criteria;
import lb.rest.user.db.entity.MlbSuggestionKey;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

import lb.rest.user.db.mapper.MlbSuggestionMapper;

@Repository
public class MlbSuggestionDao implements StaticTableDaoSupport<MlbSuggestion, MlbSuggestionExample, MlbSuggestionKey>{

	@Resource
	private MlbSuggestionMapper mapper;
	
	
	@Override
	public int countByExample(MlbSuggestionExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MlbSuggestionExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(MlbSuggestionKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(MlbSuggestion record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(MlbSuggestion record)  {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<MlbSuggestion> records)
			 {
		for(MlbSuggestion record : records){
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<MlbSuggestion> records)
			 {
		for(MlbSuggestion record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<MlbSuggestion> records)
			 {
		for(MlbSuggestion record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<MlbSuggestion> selectByExample(MlbSuggestionExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public MlbSuggestion selectByPrimaryKey(MlbSuggestionKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<MlbSuggestion> findAll(List<MlbSuggestion> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new MlbSuggestionExample());
		}
		List<MlbSuggestion> list = new ArrayList<>();
		for(MlbSuggestion record : records){
			MlbSuggestion result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(MlbSuggestion record, MlbSuggestionExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(MlbSuggestion record, MlbSuggestionExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(MlbSuggestion record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MlbSuggestion record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(MlbSuggestionExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new MlbSuggestionExample());
	}

	@Override
	public MlbSuggestionExample getExample(MlbSuggestion record) {
		MlbSuggestionExample example = new MlbSuggestionExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getMlbuserid()!=null){
				criteria.andMlbuseridEqualTo(record.getMlbuserid());
				}
				if(record.getMlbusername()!=null){
				criteria.andMlbusernameEqualTo(record.getMlbusername());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}
				if(record.getSuggestionTime()!=null){
				criteria.andSuggestionTimeEqualTo(record.getSuggestionTime());
				}
				if(record.getRemark()!=null){
				criteria.andRemarkEqualTo(record.getRemark());
				}
				if(record.getDealTime()!=null){
				criteria.andDealTimeEqualTo(record.getDealTime());
				}
				if(record.getDealUser()!=null){
				criteria.andDealUserEqualTo(record.getDealUser());
				}
				if(record.getReplyMsg()!=null){
				criteria.andReplyMsgEqualTo(record.getReplyMsg());
				}

		}
		return example;
	}
}
