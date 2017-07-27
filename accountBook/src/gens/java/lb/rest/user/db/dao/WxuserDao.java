package lb.rest.user.db.dao;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.rest.user.db.entity.Wxuser;
import lb.rest.user.db.entity.WxuserExample;
import lb.rest.user.db.entity.WxuserExample.Criteria;
import lb.rest.user.db.entity.WxuserKey;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

import lb.rest.user.db.mapper.WxuserMapper;

@Repository
public class WxuserDao implements StaticTableDaoSupport<Wxuser, WxuserExample, WxuserKey>{

	@Resource
	private WxuserMapper mapper;
	
	
	@Override
	public int countByExample(WxuserExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(WxuserExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(WxuserKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(Wxuser record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Wxuser record)  {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<Wxuser> records)
			 {
		for(Wxuser record : records){
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<Wxuser> records)
			 {
		for(Wxuser record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<Wxuser> records)
			 {
		for(Wxuser record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<Wxuser> selectByExample(WxuserExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public Wxuser selectByPrimaryKey(WxuserKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<Wxuser> findAll(List<Wxuser> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new WxuserExample());
		}
		List<Wxuser> list = new ArrayList<>();
		for(Wxuser record : records){
			Wxuser result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(Wxuser record, WxuserExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Wxuser record, WxuserExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Wxuser record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Wxuser record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(WxuserExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new WxuserExample());
	}

	@Override
	public WxuserExample getExample(Wxuser record) {
		WxuserExample example = new WxuserExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUserid()!=null){
				criteria.andUseridEqualTo(record.getUserid());
				}
				if(record.getOpenid()!=null){
				criteria.andOpenidEqualTo(record.getOpenid());
				}
				if(record.getNickname()!=null){
				criteria.andNicknameEqualTo(record.getNickname());
				}
				if(record.getUserimage()!=null){
				criteria.andUserimageEqualTo(record.getUserimage());
				}

		}
		return example;
	}
}
