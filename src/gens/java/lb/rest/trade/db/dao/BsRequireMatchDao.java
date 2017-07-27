package lb.rest.trade.db.dao;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.rest.trade.db.entity.BsRequireMatch;
import lb.rest.trade.db.entity.BsRequireMatchExample;
import lb.rest.trade.db.entity.BsRequireMatchExample.Criteria;
import lb.rest.trade.db.entity.BsRequireMatchKey;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

import lb.rest.trade.db.mapper.BsRequireMatchMapper;

@Repository
public class BsRequireMatchDao implements StaticTableDaoSupport<BsRequireMatch, BsRequireMatchExample, BsRequireMatchKey>{

	@Resource
	private BsRequireMatchMapper mapper;
	
	
	@Override
	public int countByExample(BsRequireMatchExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsRequireMatchExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsRequireMatchKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsRequireMatch record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsRequireMatch record)  {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsRequireMatch> records)
			 {
		for(BsRequireMatch record : records){
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsRequireMatch> records)
			 {
		for(BsRequireMatch record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsRequireMatch> records)
			 {
		for(BsRequireMatch record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsRequireMatch> selectByExample(BsRequireMatchExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BsRequireMatch selectByPrimaryKey(BsRequireMatchKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsRequireMatch> findAll(List<BsRequireMatch> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BsRequireMatchExample());
		}
		List<BsRequireMatch> list = new ArrayList<>();
		for(BsRequireMatch record : records){
			BsRequireMatch result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsRequireMatch record, BsRequireMatchExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsRequireMatch record, BsRequireMatchExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsRequireMatch record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsRequireMatch record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsRequireMatchExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new BsRequireMatchExample());
	}

	@Override
	public BsRequireMatchExample getExample(BsRequireMatch record) {
		BsRequireMatchExample example = new BsRequireMatchExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getKeyId()!=null){
				criteria.andKeyIdEqualTo(record.getKeyId());
				}
				if(record.getRequireType()!=null){
				criteria.andRequireTypeEqualTo(record.getRequireType());
				}
				if(record.getRequireId()!=null){
				criteria.andRequireIdEqualTo(record.getRequireId());
				}
				if(record.getMatchId()!=null){
				criteria.andMatchIdEqualTo(record.getMatchId());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}
				if(record.getOperateUserId()!=null){
				criteria.andOperateUserIdEqualTo(record.getOperateUserId());
				}
				if(record.getOpearateUserName()!=null){
				criteria.andOpearateUserNameEqualTo(record.getOpearateUserName());
				}
				if(record.getCreateTime()!=null){
				criteria.andCreateTimeEqualTo(record.getCreateTime());
				}

		}
		return example;
	}
}
