package lb.rest.user.db.dao;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.rest.user.db.entity.MlbWinners;
import lb.rest.user.db.entity.MlbWinnersExample;
import lb.rest.user.db.entity.MlbWinnersExample.Criteria;
import lb.rest.user.db.entity.MlbWinnersKey;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

import lb.rest.user.db.mapper.MlbWinnersMapper;

@Repository
public class MlbWinnersDao implements StaticTableDaoSupport<MlbWinners, MlbWinnersExample, MlbWinnersKey>{

	@Resource
	private MlbWinnersMapper mapper;
	
	
	@Override
	public int countByExample(MlbWinnersExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MlbWinnersExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(MlbWinnersKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(MlbWinners record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(MlbWinners record)  {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<MlbWinners> records)
			 {
		for(MlbWinners record : records){
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<MlbWinners> records)
			 {
		for(MlbWinners record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<MlbWinners> records)
			 {
		for(MlbWinners record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<MlbWinners> selectByExample(MlbWinnersExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public MlbWinners selectByPrimaryKey(MlbWinnersKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<MlbWinners> findAll(List<MlbWinners> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new MlbWinnersExample());
		}
		List<MlbWinners> list = new ArrayList<>();
		for(MlbWinners record : records){
			MlbWinners result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(MlbWinners record, MlbWinnersExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(MlbWinners record, MlbWinnersExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(MlbWinners record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MlbWinners record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(MlbWinnersExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new MlbWinnersExample());
	}

	@Override
	public MlbWinnersExample getExample(MlbWinners record) {
		MlbWinnersExample example = new MlbWinnersExample();
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
				if(record.getWinnersTime()!=null){
				criteria.andWinnersTimeEqualTo(record.getWinnersTime());
				}
				if(record.getRemark()!=null){
				criteria.andRemarkEqualTo(record.getRemark());
				}
				if(record.getIsget()!=null){
				criteria.andIsgetEqualTo(record.getIsget());
				}

		}
		return example;
	}
}
