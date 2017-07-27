package com.mlb.bo;

public class LocationBO {

	private int location;

	private double lat;
	private double lng;
	private String bdlng;
	private String bdlat;
	private String name;

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBdlng() {
		return bdlng;
	}

	public void setBdlng(String bdlng) {
		this.bdlng = bdlng;
	}

	public String getBdlat() {
		return bdlat;
	}

	public void setBdlat(String bdlat) {
		this.bdlat = bdlat;
	}

}
