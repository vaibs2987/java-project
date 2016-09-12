package com.search.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.search.model.ProductReview;

@Service
public class ReadingFile {

	@Autowired
	private HelperService helperService;

	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	@Autowired
	private ConfigurationService configurationService;

	public List<ProductReview> getAllProducts(Set<String> queries) {
		List<ProductReview> productReviews = new ArrayList<ProductReview>();
		LineIterator it = null;
		try {
			it = FileUtils.lineIterator(
					new File(configurationService.getFilePath()),
					configurationService.getFormat());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ProductReview productReview = null;
			while (it.hasNext()) {
				String line = it.nextLine();
				if (!StringUtils.isEmpty(line)) {
					String data = helperService.parseString(line);
					if (line.startsWith("product/productId")) {
						productReview = new ProductReview();
						productReview.setProductId(data);
					} else if (line.startsWith("review/userId")) {
						productReview.setUserId(data);
					} else if (line.startsWith("review/profileName")) {
						productReview.setProfileName(data);
					} else if (line.startsWith("review/helpfulness")) {
						productReview.setHelpfulness(data);
					} else if (line.startsWith("review/score")) {
						productReview.setScore(helperService.parseDouble(data));
					} else if (line.startsWith("review/time")) {
						productReview.setTime(helperService.parseLong(data));
					} else if (line.startsWith("review/summary")) {
						productReview.setSummary(data);
					} else if (line.startsWith("review/text")) {
						productReview.setReviewText(data);
						taskExecutor.execute(new ExecutorService(queries, productReview));
						productReviews.add(productReview);
					}

				}
			}
		} finally {
			LineIterator.closeQuietly(it);
		}
		Collections.sort(productReviews);
		return productReviews;
	}

}
