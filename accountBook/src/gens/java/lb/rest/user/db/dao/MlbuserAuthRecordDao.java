package lb.rest.user.db.dao;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.rest.user.db.entity.MlbuserAuthRecord;
import lb.rest.user.db.entity.MlbuserAuthRecordExample;
import lb.rest.user.db.entity.MlbuserAuthRecordExample.Criteria;
import lb.rest.user.db.entity.MlbuserAuthRecordKey;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

import lb.rest.user.db.mapper.MlbuserAuthRecordMapper;

@Repository
public class MlbuserAuthRecordDao implements StaticTableDaoSupport<MlbuserAuthRecord, MlbuserAuthRecordExample, MlbuserAuthRecordKey>{

	@Resource
	private MlbuserAuthRecordMapper mapper;
	
	
	@Override
	public int countByExample(MlbuserAuthRecordExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MlbuserAuthRecordExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(MlbuserAuthRecordKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(MlbuserAuthRecord record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(MlbuserAuthRecord record)  {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<MlbuserAuthRecord> records)
			 {
		for(MlbuserAuthRecord record : records){
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<MlbuserAuthRecord> records)
			 {
		for(MlbuserAuthRecord record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<MlbuserAuthRecord> records)
			 {
		for(MlbuserAuthRecord record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<MlbuserAuthRecord> selectByExample(MlbuserAuthRecordExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public MlbuserAuthRecord selectByPrimaryKey(MlbuserAuthRecordKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<MlbuserAuthRecord> findAll(List<MlbuserAuthRecord> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new MlbuserAuthRecordExample());
		}
		List<MlbuserAuthRecord> list = new ArrayList<>();
		for(MlbuserAuthRecord record : records){
			MlbuserAuthRecord result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(MlbuserAuthRecord record, MlbuserAuthRecordExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(MlbuserAuthRecord record, MlbuserAuthRecordExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(MlbuserAuthRecord record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MlbuserAuthRecord record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(MlbuserAuthRecordExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new MlbuserAuthRecordExample());
	}

	@Override
	public MlbuserAuthRecordExample getExample(MlbuserAuthRecord record) {
		MlbuserAuthRecordExample example = new MlbuserAuthRecordExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getUserName()!=null){
				criteria.andUserNameEqualTo(record.getUserName());
				}
				if(record.getTradeManagerId()!=null){
				criteria.andTradeManagerIdEqualTo(record.getTradeManagerId());
				}
				if(record.getTradeManagerName()!=null){
				criteria.andTradeManagerNameEqualTo(record.getTradeManagerName());
				}
				if(record.getTradePersonId()!=null){
				criteria.andTradePersonIdEqualTo(record.getTradePersonId());
				}
				if(record.getTradePersonName()!=null){
				criteria.andTradePersonNameEqualTo(record.getTradePersonName());
				}
				if(record.getClientId()!=null){
				criteria.andClientIdEqualTo(record.getClientId());
				}
				if(record.getClientName()!=null){
				criteria.andClientNameEqualTo(record.getClientName());
				}
				if(record.getRemark()!=null){
				criteria.andRemarkEqualTo(record.getRemark());
				}
				if(record.getCreateTime()!=null){
				criteria.andCreateTimeEqualTo(record.getCreateTime());
				}
				if(record.getModifyTime()!=null){
				criteria.andModifyTimeEqualTo(record.getModifyTime());
				}

		}
		return example;
	}
}
