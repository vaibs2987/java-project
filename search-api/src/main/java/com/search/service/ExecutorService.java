package com.search.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.search.model.ProductReview;

public class ExecutorService implements Runnable {

	private Set<String> queries;
	private ProductReview productReview;

	public ExecutorService() {

	}

	public ExecutorService(Set<String> queries, ProductReview productReview) {
		this.queries = queries;
		this.productReview = productReview;
	}

	public void setActualScore(Set<String> queries, String text,
			ProductReview productReview) {
		int size = queries.size();
		String[] array = text.split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : array) {
			for (String query : queries) {
				if (query.equalsIgnoreCase(str) && map.get(query) == null) {
					map.put(query, 1);

				}
			}
		}

		productReview.setActualScore(map.size() / size);
	}

	@Override
	public void run() {
		setActualScore(queries, productReview.getReviewText(), productReview);
	}


}

