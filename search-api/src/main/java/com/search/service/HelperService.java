package com.search.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class HelperService {

	public Set<String> getQuerySet(String str) {
		String[] array = str.split(",");
		Set<String> set = new HashSet<String>();
		for (String string : array) {
			set.add(string);
		}
		return set;
	}

	public String parseString(String str) {
		String[] array = str.split(":");
		if (array.length > 1) {
			return array[1].trim();

		}
		return "";
	}

	public double parseDouble(String str) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException ex) {
			return 0d;
		}
	}

	
	public Long parseLong(String str) {
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException ex) {
			return 0l;
		}
	}
}
