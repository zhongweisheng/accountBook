package lb.rest.user.db.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lb.rest.user.db.entity.BsNews;
import lb.rest.user.db.entity.BsNewsExample;
import lb.rest.user.db.entity.Image;
import lb.rest.user.db.entity.ImageExample;
import lb.rest.user.db.mapper.BsNewsMapper;

import org.springframework.stereotype.Repository;

import fc.wpf.rest.utils.BeanFactory;
import fc.wpf.rest.utils.DateStyle;
import fc.wpf.rest.utils.DateUtil;


@Repository
public class BsNewsServiceDao {

	private  BsNewsMapper bsNewsMapper = (BsNewsMapper)BeanFactory.getBean("bsNewsMapper");
	private  ImageDao imageDao = (ImageDao)BeanFactory.getBean("imageDao");
	/**
	 * 查询
	 * @param @param grainType
	 * @param @return   
	 * @return BsInventoryRecord  
	 * @throws
	 * @date 2017年3月28日上午11:01:53
	 */
	public Map<String, Object> getBsNewsList(Map<String, Object> mapPage){
		Map<String, Object> map = null;
		Map<String, Object> mp = null;
		List<Map<String, Object>> maplist = new ArrayList<Map<String,Object>>();
		BsNewsExample recordExample = new BsNewsExample();
		recordExample.setOrderByClause("id desc");
		
		if (mapPage.get("page") != null && !"".equals(mapPage.get("page")) && mapPage.get("number") != null && !"".equals(mapPage.get("number"))) {
			int page = Integer.parseInt(mapPage.get("page").toString());
			int number = Integer.parseInt(mapPage.get("number").toString());
			page = page * number;
			recordExample.setOffset(page);
			recordExample.setLimit(number);
		}
		List<BsNews> ckxm = bsNewsMapper.selectByExample(recordExample);
		if(ckxm != null && ckxm.size() > 0){
			map = new HashMap<String, Object>();
			for (BsNews bsNews : ckxm) {
				mp = new HashMap<String, Object>();
				mp.put("id", bsNews.getId());
				mp.put("title", bsNews.getTitle());
				mp.put("node", bsNews.getNote());
				mp.put("dateTime", DateUtil.format(bsNews.getCreatetime(), DateStyle.YYYY_MM_DD));
				ImageExample example = new ImageExample();
				example.createCriteria().andForeignkeyEqualTo(bsNews.getId()).andImagetypeEqualTo("NEWS_IMAGE");
				example.setOrderByClause("id desc");
				List<Image> imalist = imageDao.selectByExample(example);
				if(imalist != null && imalist.size() > 0){
					mp.put("imagepath", imalist.get(0).getId());
				}
				maplist.add(mp);
			}
		}
		map.put("dataList", maplist);
		return map;
	}
	/**
	 * 两个Double数相除，并保留scale位小数
	 * @param @param v1
	 * @param @param v2
	 * @param @param scale
	 * @param @return   
	 * @return double  
	 * @throws
	 * @date 2017年3月28日下午7:00:30
	 */
	public double Doublediv(Double v1,Double v2,int scale){
		if(scale<0){
			throw new IllegalArgumentException("Thescalemustbeapositiveintegerorzero");
		}
		BigDecimal b1=new BigDecimal(v1.toString());
		BigDecimal b2=new BigDecimal(v2.toString());
		return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
