package lb.rest.user.db.dao;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.rest.user.db.entity.MlbuserAddition;
import lb.rest.user.db.entity.MlbuserAdditionExample;
import lb.rest.user.db.entity.MlbuserAdditionExample.Criteria;
import lb.rest.user.db.entity.MlbuserAdditionKey;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

import lb.rest.user.db.mapper.MlbuserAdditionMapper;

@Repository
public class MlbuserAdditionDao implements StaticTableDaoSupport<MlbuserAddition, MlbuserAdditionExample, MlbuserAdditionKey>{

	@Resource
	private MlbuserAdditionMapper mapper;
	
	
	@Override
	public int countByExample(MlbuserAdditionExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MlbuserAdditionExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(MlbuserAdditionKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(MlbuserAddition record)  {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(MlbuserAddition record)  {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<MlbuserAddition> records)
			 {
		for(MlbuserAddition record : records){
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<MlbuserAddition> records)
			 {
		for(MlbuserAddition record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<MlbuserAddition> records)
			 {
		for(MlbuserAddition record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<MlbuserAddition> selectByExample(MlbuserAdditionExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public MlbuserAddition selectByPrimaryKey(MlbuserAdditionKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<MlbuserAddition> findAll(List<MlbuserAddition> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new MlbuserAdditionExample());
		}
		List<MlbuserAddition> list = new ArrayList<>();
		for(MlbuserAddition record : records){
			MlbuserAddition result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(MlbuserAddition record, MlbuserAdditionExample example)  {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(MlbuserAddition record, MlbuserAdditionExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(MlbuserAddition record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MlbuserAddition record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(MlbuserAdditionExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  {
		mapper.deleteByExample(new MlbuserAdditionExample());
	}

	@Override
	public MlbuserAdditionExample getExample(MlbuserAddition record) {
		MlbuserAdditionExample example = new MlbuserAdditionExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getUserCategory()!=null){
				criteria.andUserCategoryEqualTo(record.getUserCategory());
				}
				if(record.getHasInvoice()!=null){
				criteria.andHasInvoiceEqualTo(record.getHasInvoice());
				}
				if(record.getHasWarehouse()!=null){
				criteria.andHasWarehouseEqualTo(record.getHasWarehouse());
				}
				if(record.getCompanyName()!=null){
				criteria.andCompanyNameEqualTo(record.getCompanyName());
				}
				if(record.getLegalPerson()!=null){
				criteria.andLegalPersonEqualTo(record.getLegalPerson());
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
				if(record.getOperateYearLimit()!=null){
				criteria.andOperateYearLimitEqualTo(record.getOperateYearLimit());
				}
				if(record.getMonthTurnover()!=null){
				criteria.andMonthTurnoverEqualTo(record.getMonthTurnover());
				}
				if(record.getSaleArea()!=null){
				criteria.andSaleAreaEqualTo(record.getSaleArea());
				}
				if(record.getHasTower()!=null){
				criteria.andHasTowerEqualTo(record.getHasTower());
				}
				if(record.getPayOnDelivery()!=null){
				criteria.andPayOnDeliveryEqualTo(record.getPayOnDelivery());
				}
				if(record.getGrainType()!=null){
				criteria.andGrainTypeEqualTo(record.getGrainType());
				}
				if(record.getBuyAddress()!=null){
				criteria.andBuyAddressEqualTo(record.getBuyAddress());
				}
				if(record.getMonthlyRequire()!=null){
				criteria.andMonthlyRequireEqualTo(record.getMonthlyRequire());
				}
				if(record.getIndustry()!=null){
				criteria.andIndustryEqualTo(record.getIndustry());
				}
				if(record.getAccountPeriod()!=null){
				criteria.andAccountPeriodEqualTo(record.getAccountPeriod());
				}
				if(record.getBankName()!=null){
				criteria.andBankNameEqualTo(record.getBankName());
				}
				if(record.getBankUserName()!=null){
				criteria.andBankUserNameEqualTo(record.getBankUserName());
				}
				if(record.getBankAccountNumber()!=null){
				criteria.andBankAccountNumberEqualTo(record.getBankAccountNumber());
				}
				if(record.getMembershipGroup()!=null){
				criteria.andMembershipGroupEqualTo(record.getMembershipGroup());
				}
				if(record.getMainUsage()!=null){
				criteria.andMainUsageEqualTo(record.getMainUsage());
				}
				if(record.getPaymentFlow()!=null){
				criteria.andPaymentFlowEqualTo(record.getPaymentFlow());
				}
				if(record.getQuotationMode()!=null){
				criteria.andQuotationModeEqualTo(record.getQuotationMode());
				}
				if(record.getCompanyLocation()!=null){
				criteria.andCompanyLocationEqualTo(record.getCompanyLocation());
				}
				if(record.getCompanyLocationdesc()!=null){
				criteria.andCompanyLocationdescEqualTo(record.getCompanyLocationdesc());
				}
				if(record.getCompanyAddress()!=null){
				criteria.andCompanyAddressEqualTo(record.getCompanyAddress());
				}

		}
		return example;
	}
}
