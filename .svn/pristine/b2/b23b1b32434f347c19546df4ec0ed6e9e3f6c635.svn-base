package com.mlb.bo;

import com.mlb.util.TDateTimeUnits;

public class OfferPriceMatchBO {
	private int id;
	private double offerPrice;
	private double orderPrice;
	private double priceWeight;

	private double origLat;
	private double origLng;
	private double destLat;
	private double destLng;
	private double distance;
	private double distanceExpense;
	private double distanceWeight;

	private double maxDistance;

	private int origLocation;
	private int destLocation;

	private double offerAmount;
	private double orderAmount;
	private double amountWeight;

	private String offerDate;
	private String orderDate;
	private double dateWeight;

	private double priceMatch;
	private double distanceMatch;
	private double amountMatch;
	private double dateMatch;
	private double qualityMatch;

	private double match;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public double getPriceWeight() {
		return priceWeight;
	}

	public void setPriceWeight(double priceWeight) {
		this.priceWeight = priceWeight;
	}

	public double getOrigLat() {
		return origLat;
	}

	public void setOrigLat(double origLat) {
		this.origLat = origLat;
	}

	public double getOrigLng() {
		return origLng;
	}

	public void setOrigLng(double origLng) {
		this.origLng = origLng;
	}

	public double getDestLat() {
		return destLat;
	}

	public void setDestLat(double desLat) {
		this.destLat = desLat;
	}

	public double getDestLng() {
		return destLng;
	}

	public void setDestLng(double desLng) {
		this.destLng = desLng;
	}

	public double getOrigLocation() {
		return origLocation;
	}

	public void setOrigLocation(int origLocation) {
		this.origLocation = origLocation;
	}

	public double getDestLocation() {
		return destLocation;
	}

	public void setDestLocation(int destLocation) {
		this.destLocation = destLocation;
	}

	public double getDistanceWeight() {
		return distanceWeight;
	}

	public void setDistanceWeight(double distanceWeight) {
		this.distanceWeight = distanceWeight;
	}

	public double getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}

	public double getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public double getAmountWeight() {
		return amountWeight;
	}

	public void setAmountWeight(double amountWeight) {
		this.amountWeight = amountWeight;
	}

	public void setOfferDate(String offerDate) {
		this.offerDate = offerDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOfferDate() {
		return offerDate;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public double getDistanceExpense() {
		return distanceExpense;
	}

	public void setDistanceExpense(double distanceExpense) {
		this.distanceExpense = distanceExpense;
	}

	public double getDateWeight() {
		return dateWeight;
	}

	public void setDateWeight(double dateWeight) {
		this.dateWeight = dateWeight;
	}

	public double getPriceMatch() {
		// (1+(订单收购价-报价)/订单收购价)*价格权重
		if (offerPrice >= 2 * orderPrice || offerPrice == 0) {
			priceMatch = 0;
		} else if (offerPrice <= orderPrice / 2) {
			priceMatch = 1 * priceWeight;
		} else {
			if (orderPrice - offerPrice >= 0) {
				// priceMatch = (0.6 + (orderPrice - offerPrice) / orderPrice *
				// 0.4) * priceWeight;
				priceMatch = 1 * priceWeight;
			} else {
				priceMatch = (1 - (offerPrice - orderPrice) / offerPrice * 0.5) * priceWeight;
			}
		}
		if (priceMatch <= 0) {
			priceMatch = 0;
		}

		return priceMatch;
	}

	public double getPriceMatchNew() {
		if (priceWeight > 0) {
			double offerPriceTemp = offerPrice + getDistanceExpense();
			// (1+(订单收购价-报价)/订单收购价)*价格权重
			if (offerPriceTemp >= 2 * orderPrice || offerPriceTemp == 0) {
				priceMatch = 0;
			} else if (offerPriceTemp <= orderPrice / 2) {
				priceMatch = 1 * priceWeight;
			} else {
				if (orderPrice - offerPriceTemp >= 0) {
					// priceMatch = (0.6 + (orderPrice - offerPrice) /
					// orderPrice *
					// 0.4) * priceWeight;
					priceMatch = 1 * priceWeight;
				} else {
					priceMatch = (1 - (offerPriceTemp - orderPrice) / offerPriceTemp * 0.5) * priceWeight;
				}
			}
		}
		if (priceMatch < 0) {
			priceMatch = 0;
		}
		return priceMatch;
	}

	// 价格大的在前面
	public double getPriceMatchHight() {
		if (priceWeight > 0) {
			double offerPriceTemp = orderPrice + getDistanceExpense();
			// (1+(订单收购价-报价)/订单收购价)*价格权重
			if (offerPriceTemp >= 2 * offerPrice || offerPriceTemp == 0) {
				priceMatch = 0;
			} else if (offerPriceTemp <= offerPrice / 2) {
				priceMatch = 1 * priceWeight;
			} else {
				if (offerPrice - offerPriceTemp >= 0) {
					priceMatch = (0.6 + (offerPrice - offerPriceTemp) / offerPriceTemp * 0.4) * priceWeight;
				} else {
					priceMatch = (0.6 - (offerPriceTemp - orderPrice) / offerPriceTemp * 0.5) * priceWeight;
				}
			}
		}
		if (priceMatch < 0) {
			priceMatch = 0;
		}
		return priceMatch;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getDistance() {
		return distance;
	}

	public double getDistanceMatch() {
		double distance = getDistance();
		if (distance >= 0 && distanceWeight > 0) {
			if (distance > maxDistance) {
				distance = maxDistance;
			}
			distanceMatch = (1 - distance / maxDistance) * distanceWeight;
		} else {
			distanceMatch = 0;
		}
		return distanceMatch;
	}

	public double getAmountMatch() {
		// (报价可供量>收购量？1:0)*40
		if (amountWeight == 0 || orderAmount == 0 || offerAmount == 0) {
			amountMatch = 0;
		} else {
			amountMatch = (offerAmount >= orderAmount ? 1 : (offerAmount / orderAmount)) * amountWeight;
		}
		return amountMatch;
	}

	public double getDateMatch() {
		try {
			if (dateWeight > 0) {
				int maxDays = 60;
				// 越接近当前时间，分数越高
				long diffTime = TDateTimeUnits.getDiffTime(TDateTimeUnits.currentTimeString(), offerDate);
				long days = Math.abs(diffTime / (60 * 60 * 24));
				if (maxDays > days && days >= 0) {
					dateMatch = dateWeight * ((maxDays - days) / (double) maxDays);
				} else {
					dateMatch = 0;
				}
			} else {
				dateMatch = 0;
			}
		} catch (Exception e) {
		}
		return dateMatch;
	}

	public double getQualityMatch() {
		return qualityMatch;
	}

	public void setQualityMatch(double qualityMatch) {
		this.qualityMatch = qualityMatch;
	}

	public double getMatch() {
		match = getPriceMatch() + getDistanceMatch() + getAmountMatch() + getDateMatch() + getQualityMatch();
		return match;
	}

	public double getMatchNew() {
		// 价格是价格加上运费 , 不再有距离权重
		match = getPriceMatchNew() + getAmountMatch() + getDateMatch() + getQualityMatch();
		return match;
	}

	public double getMatchCommon() {
		// 价格是价格加上运费 , 不再有距离权重
		match = getPriceMatchNew() + getDistanceMatch() + getAmountMatch() + getDateMatch() + getQualityMatch();
		return match;
	}

	public double getMatchPriceHight() {
		// 价格是价格加上运费 , 不再有距离权重
		match = getPriceMatchHight() + getDistanceMatch() + getAmountMatch() + getDateMatch() + getQualityMatch();
		return match;
	}

}
