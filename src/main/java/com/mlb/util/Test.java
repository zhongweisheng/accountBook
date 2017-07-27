package com.mlb.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lb.rest.trade.db.entity.BsGoodsInfo;

public class Test {

	public static void main(String[] args) {
		BsGoodsInfo info1 = new BsGoodsInfo();
		info1.setViewCount(1);
		BsGoodsInfo info2 = new BsGoodsInfo();
		info2.setViewCount(3);
		BsGoodsInfo info3 = new BsGoodsInfo();
		info2.setViewCount(6);

		List<BsGoodsInfo> list = new ArrayList<BsGoodsInfo>();
		list.add(info2);
		list.add(info1);
		list.add(info3);
		Collections.sort(list, goodsLevelDesc);

		for (BsGoodsInfo item : list) {
			System.out.println(item.getViewCount());
		}

	}

	public static final Comparator<BsGoodsInfo> goodsLevelDesc = new Comparator<BsGoodsInfo>() {
		public int compare(BsGoodsInfo o1, BsGoodsInfo o2) {
			if (o1 == null || o2 == null) {
				return 0;
			} else {
				int result1 = o1.getViewCount();
				int result2 = o2.getViewCount();
				// 降序 排列
				if (result1 < result2) {
					return 1;
				} else if (result1 > result2) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	};
}
