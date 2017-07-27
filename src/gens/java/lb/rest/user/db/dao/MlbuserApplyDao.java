package lb.rest.user.db.dao;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.rest.user.db.entity.MlbuserApply;
import lb.rest.user.db.entity.MlbuserApplyExample;
import lb.rest.user.db.entity.MlbuserApplyExample.Criteria;
import lb.rest.user.db.entity.MlbuserApplyKey;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

import lb.rest.user.db.mapper.MlbuserApplyMapper;

@Repository
public class MlbuserApplyDao implements StaticTableDaoSupport<MlbuserApply, MlbuserApplyExample, MlbuserApplyKey>{

	@Resource
	private MlbuserApplyMapper mapper;
	
	
	@Override
	public int countByExample(MlbuserApplyExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MlbuserApplyExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(MlbuserApplyKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(MlbuserApply record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(MlbuserApply record)  {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<MlbuserApply> records)
			 {
		for(MlbuserApply record : records){
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<MlbuserApply> records)
			 {
		for(MlbuserApply record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<MlbuserApply> records)
			 {
		for(MlbuserApply record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<MlbuserApply> selectByExample(MlbuserApplyExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public MlbuserApply selectByPrimaryKey(MlbuserApplyKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<MlbuserApply> findAll(List<MlbuserApply> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new MlbuserApplyExample());
		}
		List<MlbuserApply> list = new ArrayList<>();
		for(MlbuserApply record : records){
			MlbuserApply result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(MlbuserApply record, MlbuserApplyExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(MlbuserApply record, MlbuserApplyExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(MlbuserApply record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MlbuserApply record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(MlbuserApplyExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new MlbuserApplyExample());
	}

	@Override
	public MlbuserApplyExample getExample(MlbuserApply record) {
		MlbuserApplyExample example = new MlbuserApplyExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getMlbuserId()!=null){
				criteria.andMlbuserIdEqualTo(record.getMlbuserId());
				}
				if(record.getMlbuserName()!=null){
				criteria.andMlbuserNameEqualTo(record.getMlbuserName());
				}
				if(record.getHtUserId()!=null){
				criteria.andHtUserIdEqualTo(record.getHtUserId());
				}
				if(record.getHtUserName()!=null){
				criteria.andHtUserNameEqualTo(record.getHtUserName());
				}

		}
		return example;
	}
}
