package lb.rest.trade.db.dao;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.rest.trade.db.entity.BsUserRequireMatch;
import lb.rest.trade.db.entity.BsUserRequireMatchExample;
import lb.rest.trade.db.entity.BsUserRequireMatchExample.Criteria;
import lb.rest.trade.db.entity.BsUserRequireMatchKey;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

import lb.rest.trade.db.mapper.BsUserRequireMatchMapper;

@Repository
public class BsUserRequireMatchDao implements StaticTableDaoSupport<BsUserRequireMatch, BsUserRequireMatchExample, BsUserRequireMatchKey>{

	@Resource
	private BsUserRequireMatchMapper mapper;
	
	
	@Override
	public int countByExample(BsUserRequireMatchExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsUserRequireMatchExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsUserRequireMatchKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsUserRequireMatch record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsUserRequireMatch record)  {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsUserRequireMatch> records)
			 {
		for(BsUserRequireMatch record : records){
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsUserRequireMatch> records)
			 {
		for(BsUserRequireMatch record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsUserRequireMatch> records)
			 {
		for(BsUserRequireMatch record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsUserRequireMatch> selectByExample(BsUserRequireMatchExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BsUserRequireMatch selectByPrimaryKey(BsUserRequireMatchKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsUserRequireMatch> findAll(List<BsUserRequireMatch> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BsUserRequireMatchExample());
		}
		List<BsUserRequireMatch> list = new ArrayList<>();
		for(BsUserRequireMatch record : records){
			BsUserRequireMatch result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsUserRequireMatch record, BsUserRequireMatchExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsUserRequireMatch record, BsUserRequireMatchExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsUserRequireMatch record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsUserRequireMatch record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsUserRequireMatchExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new BsUserRequireMatchExample());
	}

	@Override
	public BsUserRequireMatchExample getExample(BsUserRequireMatch record) {
		BsUserRequireMatchExample example = new BsUserRequireMatchExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getProcessStatus()!=null){
				criteria.andProcessStatusEqualTo(record.getProcessStatus());
				}
				if(record.getRequireId()!=null){
				criteria.andRequireIdEqualTo(record.getRequireId());
				}
				if(record.getMatchGoodsId()!=null){
				criteria.andMatchGoodsIdEqualTo(record.getMatchGoodsId());
				}
				if(record.getRealityBuyPriceType()!=null){
				criteria.andRealityBuyPriceTypeEqualTo(record.getRealityBuyPriceType());
				}
				if(record.getRealitySellPriceType()!=null){
				criteria.andRealitySellPriceTypeEqualTo(record.getRealitySellPriceType());
				}
				if(record.getRealityBuyPrice()!=null){
				criteria.andRealityBuyPriceEqualTo(record.getRealityBuyPrice());
				}
				if(record.getRealitySellPrice()!=null){
				criteria.andRealitySellPriceEqualTo(record.getRealitySellPrice());
				}
				if(record.getRealityBuyPayMethod()!=null){
				criteria.andRealityBuyPayMethodEqualTo(record.getRealityBuyPayMethod());
				}
				if(record.getRealitySellPayMethod()!=null){
				criteria.andRealitySellPayMethodEqualTo(record.getRealitySellPayMethod());
				}
				if(record.getRealityBuyRequire()!=null){
				criteria.andRealityBuyRequireEqualTo(record.getRealityBuyRequire());
				}
				if(record.getRealitySellRequire()!=null){
				criteria.andRealitySellRequireEqualTo(record.getRealitySellRequire());
				}
				if(record.getRealityLogisticsInfo()!=null){
				criteria.andRealityLogisticsInfoEqualTo(record.getRealityLogisticsInfo());
				}
				if(record.getAbandonReasonCode()!=null){
				criteria.andAbandonReasonCodeEqualTo(record.getAbandonReasonCode());
				}
				if(record.getAbandonReason()!=null){
				criteria.andAbandonReasonEqualTo(record.getAbandonReason());
				}
				if(record.getModifyTime()!=null){
				criteria.andModifyTimeEqualTo(record.getModifyTime());
				}
				if(record.getCompleteTime()!=null){
				criteria.andCompleteTimeEqualTo(record.getCompleteTime());
				}

		}
		return example;
	}
}
