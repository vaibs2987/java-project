package com.search.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.search.command.ApiResponse;
import com.search.command.ResponseMessage;
import com.search.model.ProductReview;
import com.search.service.HelperService;
import com.search.service.ReadingFile;

@Controller
@RequestMapping(value = "/search")
public class SearchController {

	@Autowired
	private ReadingFile readingFile;

	@Autowired
	private HelperService helperService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody ApiResponse<List<ProductReview>> searchQuery(
			@RequestParam String query,
			@RequestParam(defaultValue = "10") int size,
			HttpServletResponse response) {
		List<ProductReview> actualReviews = null;

		ApiResponse<List<ProductReview>> apiResponse = null;
		if (size <= 0) {
			apiResponse = new ApiResponse<List<ProductReview>>(actualReviews);
			apiResponse.setMessage(ResponseMessage.INCORRECT_INPUT);
			return apiResponse;
		}
		if (StringUtils.isEmpty(query) || query.length() < 2) {
			apiResponse = new ApiResponse<List<ProductReview>>(actualReviews);
			apiResponse.setMessage(ResponseMessage.INCORRECT_Query);
			return apiResponse;
		}
		Set<String> querySet = helperService.getQuerySet(query);
		List<ProductReview> productReviews = readingFile
				.getAllProducts(querySet);

		if (size > productReviews.size()) {
			size = productReviews.size() - 1;
		}
		actualReviews = productReviews.subList(0, size);
		return new ApiResponse<List<ProductReview>>(actualReviews);
	}

}
