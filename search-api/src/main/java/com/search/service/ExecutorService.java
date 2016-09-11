package com.search.service;

import java.util.Set;

import com.search.model.ProductReview;

public class ExecutorService implements Runnable {

	private String str;
	private Set<String> queries;
	private ProductReview productReview;

	public ExecutorService() {

	}

	public ExecutorService(Set<String> queries, String str,
			ProductReview productReview) {
		this.queries = queries;
		this.str = str;
		this.productReview = productReview;
	}

	public void setActualScore(Set<String> queries, String str,
			ProductReview productReview) {
		double score = 0d;
		for (String string : queries) {
			if (findMatch(str, string)) {
				score++;
			}
		}
		productReview.setActualScore(score / queries.size());
	}

	@Override
	public void run() {
		setActualScore(queries, str, productReview);
	}

	private boolean findMatch(String text, String query) {
		String[] array = text.split(" ");
		for (String str : array) {
			if (str.equalsIgnoreCase(query)) {
				return true;
			}
		}
		return false;
	}

}
