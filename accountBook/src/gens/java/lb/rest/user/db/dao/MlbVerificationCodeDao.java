package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.MlbVerificationCode;
import lb.rest.user.db.entity.MlbVerificationCodeExample;
import lb.rest.user.db.entity.MlbVerificationCodeExample.Criteria;
import lb.rest.user.db.entity.MlbVerificationCodeKey;
import lb.rest.user.db.mapper.MlbVerificationCodeMapper;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class MlbVerificationCodeDao implements
		StaticTableDaoSupport<MlbVerificationCode, MlbVerificationCodeExample, MlbVerificationCodeKey> {

	@Resource
	private MlbVerificationCodeMapper mapper;

	@Override
	public int countByExample(MlbVerificationCodeExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MlbVerificationCodeExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(MlbVerificationCodeKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(MlbVerificationCode record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(MlbVerificationCode record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<MlbVerificationCode> records) {
		for (MlbVerificationCode record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<MlbVerificationCode> records) {
		for (MlbVerificationCode record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<MlbVerificationCode> records) {
		for (MlbVerificationCode record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<MlbVerificationCode> selectByExample(MlbVerificationCodeExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public MlbVerificationCode selectByPrimaryKey(MlbVerificationCodeKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<MlbVerificationCode> findAll(List<MlbVerificationCode> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new MlbVerificationCodeExample());
		}
		List<MlbVerificationCode> list = new ArrayList<>();
		for (MlbVerificationCode record : records) {
			MlbVerificationCode result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(MlbVerificationCode record, MlbVerificationCodeExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(MlbVerificationCode record, MlbVerificationCodeExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(MlbVerificationCode record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MlbVerificationCode record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(MlbVerificationCodeExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new MlbVerificationCodeExample());
	}

	@Override
	public MlbVerificationCodeExample getExample(MlbVerificationCode record) {
		MlbVerificationCodeExample example = new MlbVerificationCodeExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}
			if (record.getPhone() != null) {
				criteria.andPhoneEqualTo(record.getPhone());
			}
			if (record.getStartdate() != null) {
				criteria.andStartdateEqualTo(record.getStartdate());
			}
			if (record.getNum() != null) {
				criteria.andNumEqualTo(record.getNum());
			}
			if (record.getStatus() != null) {
				criteria.andStatusEqualTo(record.getStatus());
			}

		}
		return example;
	}
}
