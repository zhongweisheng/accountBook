package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lb.rest.user.db.entity.Image;
import lb.rest.user.db.entity.ImageExample;
import lb.rest.user.db.entity.ImageExample.Criteria;
import lb.rest.user.db.entity.ImageKey;
import lb.rest.user.db.mapper.ImageMapper;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

@Repository
public class ImageDao implements StaticTableDaoSupport<Image, ImageExample, ImageKey> {

	@Resource
	private ImageMapper mapper;

	// 更新图片 外键
	public void updateFkey(String imageIds, int fKey) {
		// 更新图片对应关系
		String[] iid = StringUtils.trimToEmpty(imageIds).split(",", -1);
		for (int i = 0; i < iid.length; i++) {
			if (iid[i].length() > 0) {
				ImageKey key2 = new ImageKey();
				key2.setId(NumberUtils.toInt(iid[i]));
				Image image = mapper.selectByPrimaryKey(key2);
				if (image != null && fKey > 0) {
					image.setForeignkey(fKey);
					mapper.updateByPrimaryKey(image);
					// image = ImageService.saveImageBO(image);
				}
			}
		}
	}

	@Override
	public int countByExample(ImageExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ImageExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(ImageKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(Image record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Image record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<Image> records) {
		for (Image record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<Image> records) {
		for (Image record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<Image> records) {
		for (Image record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<Image> selectByExample(ImageExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public Image selectByPrimaryKey(ImageKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<Image> findAll(List<Image> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new ImageExample());
		}
		List<Image> list = new ArrayList<>();
		for (Image record : records) {
			Image result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(Image record, ImageExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Image record, ImageExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Image record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Image record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(ImageExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new ImageExample());
	}

	@Override
	public ImageExample getExample(Image record) {
		ImageExample example = new ImageExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}
			if (record.getImagename() != null) {
				criteria.andImagenameEqualTo(record.getImagename());
			}
			if (record.getImagepath() != null) {
				criteria.andImagepathEqualTo(record.getImagepath());
			}
			if (record.getStatus() != null) {
				criteria.andStatusEqualTo(record.getStatus());
			}
			if (record.getImagetype() != null) {
				criteria.andImagetypeEqualTo(record.getImagetype());
			}
			if (record.getForeignkey() != null) {
				criteria.andForeignkeyEqualTo(record.getForeignkey());
			}

		}
		return example;
	}
}
