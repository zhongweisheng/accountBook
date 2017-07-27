package com.mlb.util;

/*
 * Copyright BeiJing Xintuoyida(c) Software Co.,Ltd 2013.
 *
 *          http://www.xintuoyida.com
 *
 * Author          Spance Wong ,Email: huangsy@xintuoyida.com
 * Project         dwxj
 * Module          dwxj
 * File            com.xtyd.core.commons.TGeographyUtils
 * LastModified    13-8-10 下午6:59
 * Version         _major.minor.rev_
 * Description
 */

import java.text.NumberFormat;

/**
 * Created with IntelliJ IDEA. User: spance Date: 13-8-10 Time: 下午6:59 To change
 * this template use File | Settings | File Templates.
 */
public class TGeographyUtils {

	public enum GaussSphere {
		Beijing54, Xian80, WGS84,
	}

	public Float parseLatLng(String latLng) {
		NumberFormat nFormat = NumberFormat.getNumberInstance();
		// nFormat.setMinimumIntegerDigits(3);
		nFormat.setMaximumFractionDigits(6);
		Float raw = Float.parseFloat(latLng);
		return raw;
	}

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 单位Km
	 *
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * 6378.137;
		return s;
	}

	public static void main(String[] args) {
		//System.out.println(getDistance(1, 1, 27, 112));
	}
}
