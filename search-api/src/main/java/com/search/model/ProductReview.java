package com.search.model;

public class ProductReview implements Comparable<ProductReview> {
	private String productId;
	private String userId;
	private String profileName;
	private String helpfulness;
	private Double score;
	private Long time;
	private String summary;
	private String reviewText;
	private double actualScore = 0d;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getHelpfulness() {
		return helpfulness;
	}

	public void setHelpfulness(String helpfulness) {
		this.helpfulness = helpfulness;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public double getActualScore() {
		return actualScore;
	}

	public void setActualScore(double actualScore) {
		this.actualScore = actualScore;
	}

	@Override
	public int compareTo(ProductReview arg0) {
		if (this.getActualScore() > arg0.getActualScore())
			return -1;
		else if (this.getActualScore() < arg0.getActualScore())
			return 1;
		else
			return 0;

	}
}
