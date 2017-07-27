package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsNumber;
import lb.rest.user.db.entity.BsNumberExample;
import lb.rest.user.db.entity.BsNumberExample.Criteria;
import lb.rest.user.db.entity.BsNumberKey;
import lb.rest.user.db.mapper.BsNumberMapper;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Repository;

import com.mlb.enums.InviteCodeEnum;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class BsNumberDao implements StaticTableDaoSupport<BsNumber, BsNumberExample, BsNumberKey> {

	@Resource
	private BsNumberMapper mapper;

	public List<BsNumber> selectListByExample(String inviteCode) {
		BsNumberExample example = new BsNumberExample();
		// 验证码在 时间 范围内，并且未被使用；
		Criteria criteria = example.createCriteria();
		criteria.andEndtimeGreaterThanOrEqualTo(new Date());
		criteria.andStrtimeLessThanOrEqualTo(new Date());
		criteria.andNumberEqualTo(NumberUtils.toInt(inviteCode));
		criteria.andStatusEqualTo(InviteCodeEnum.可用.getCode());
		return mapper.selectByExample(example);
	}

	@Override
	public int countByExample(BsNumberExample paramD) {
		return mapper.countByExample(paramD);
	}

	@Override
	public int deleteByExample(BsNumberExample paramD) {
		return mapper.deleteByExample(paramD);
	}

	@Override
	public int deleteByPrimaryKey(BsNumberKey paramK) {
		return mapper.deleteByPrimaryKey(paramK);
	}

	@Override
	public int insert(BsNumber paramT) {
		return mapper.insert(paramT);
	}

	@Override
	public int insertSelective(BsNumber paramT) {
		return mapper.insertSelective(paramT);
	}

	@Override
	public int batchInsert(List<BsNumber> paramList) {
		for (BsNumber BsNumber : paramList) {
			mapper.insert(BsNumber);
		}
		return paramList.size();
	}

	@Override
	public int batchUpdate(List<BsNumber> paramList) {
		for (BsNumber BsNumber : paramList) {
			mapper.updateByPrimaryKeySelective(BsNumber);
		}
		return paramList.size();
	}

	@Override
	public int batchDelete(List<BsNumber> paramList) {
		for (BsNumber BsNumber : paramList) {
			mapper.deleteByPrimaryKey(BsNumber);
		}
		return 0;
	}

	@Override
	public List<BsNumber> selectByExample(BsNumberExample paramD) {
		return mapper.selectByExample(paramD);
	}

	@Override
	public BsNumber selectByPrimaryKey(BsNumberKey paramK) {
		return mapper.selectByPrimaryKey(paramK);
	}

	@Override
	public List<BsNumber> findAll(List<BsNumber> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsNumberExample());
		}
		List<BsNumber> list = new ArrayList<>();
		for (BsNumber record : records) {
			BsNumber result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsNumber paramT, BsNumberExample paramD) {
		return mapper.updateByExampleSelective(paramT, paramD);
	}

	@Override
	public int updateByExample(BsNumber paramT, BsNumberExample paramD) {
		return mapper.updateByExample(paramT, paramD);
	}

	@Override
	public int updateByPrimaryKeySelective(BsNumber paramT) {
		return mapper.updateByPrimaryKey(paramT);
	}

	@Override
	public int updateByPrimaryKey(BsNumber paramT) {
		return mapper.updateByPrimaryKey(paramT);
	}

	@Override
	public int sumByExample(BsNumberExample paramD) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsNumberExample());
	}

	@Override
	public BsNumberExample getExample(BsNumber record) {
		BsNumberExample example = new BsNumberExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}
		}
		return example;
	}

}
