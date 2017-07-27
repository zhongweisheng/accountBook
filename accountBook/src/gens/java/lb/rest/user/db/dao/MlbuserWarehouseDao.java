package lb.rest.user.db.dao;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.rest.user.db.entity.MlbuserWarehouse;
import lb.rest.user.db.entity.MlbuserWarehouseExample;
import lb.rest.user.db.entity.MlbuserWarehouseExample.Criteria;
import lb.rest.user.db.entity.MlbuserWarehouseKey;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

import lb.rest.user.db.mapper.MlbuserWarehouseMapper;

@Repository
public class MlbuserWarehouseDao implements StaticTableDaoSupport<MlbuserWarehouse, MlbuserWarehouseExample, MlbuserWarehouseKey>{

	@Resource
	private MlbuserWarehouseMapper mapper;
	
	
	@Override
	public int countByExample(MlbuserWarehouseExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MlbuserWarehouseExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(MlbuserWarehouseKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(MlbuserWarehouse record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(MlbuserWarehouse record)  {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<MlbuserWarehouse> records)
			 {
		for(MlbuserWarehouse record : records){
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<MlbuserWarehouse> records)
			 {
		for(MlbuserWarehouse record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<MlbuserWarehouse> records)
			 {
		for(MlbuserWarehouse record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<MlbuserWarehouse> selectByExample(MlbuserWarehouseExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public MlbuserWarehouse selectByPrimaryKey(MlbuserWarehouseKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<MlbuserWarehouse> findAll(List<MlbuserWarehouse> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new MlbuserWarehouseExample());
		}
		List<MlbuserWarehouse> list = new ArrayList<>();
		for(MlbuserWarehouse record : records){
			MlbuserWarehouse result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(MlbuserWarehouse record, MlbuserWarehouseExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(MlbuserWarehouse record, MlbuserWarehouseExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(MlbuserWarehouse record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MlbuserWarehouse record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(MlbuserWarehouseExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new MlbuserWarehouseExample());
	}

	@Override
	public MlbuserWarehouseExample getExample(MlbuserWarehouse record) {
		MlbuserWarehouseExample example = new MlbuserWarehouseExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getWarename()!=null){
				criteria.andWarenameEqualTo(record.getWarename());
				}
				if(record.getWareaddress()!=null){
				criteria.andWareaddressEqualTo(record.getWareaddress());
				}
				if(record.getWarelocation()!=null){
				criteria.andWarelocationEqualTo(record.getWarelocation());
				}
				if(record.getWarelocationdesc()!=null){
				criteria.andWarelocationdescEqualTo(record.getWarelocationdesc());
				}
				if(record.getHasInvoice()!=null){
				criteria.andHasInvoiceEqualTo(record.getHasInvoice());
				}
				if(record.getHasTower()!=null){
				criteria.andHasTowerEqualTo(record.getHasTower());
				}
				if(record.getOutPutNum()!=null){
				criteria.andOutPutNumEqualTo(record.getOutPutNum());
				}
				if(record.getFieldScale()!=null){
				criteria.andFieldScaleEqualTo(record.getFieldScale());
				}
				if(record.getYearTurnover()!=null){
				criteria.andYearTurnoverEqualTo(record.getYearTurnover());
				}
				if(record.getMainFlowDirection()!=null){
				criteria.andMainFlowDirectionEqualTo(record.getMainFlowDirection());
				}
				if(record.getOperateYearLimit()!=null){
				criteria.andOperateYearLimitEqualTo(record.getOperateYearLimit());
				}
				if(record.getPropertyRight()!=null){
				criteria.andPropertyRightEqualTo(record.getPropertyRight());
				}
				if(record.getIsstorage()!=null){
				criteria.andIsstorageEqualTo(record.getIsstorage());
				}

		}
		return example;
	}
}
