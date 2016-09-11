package com.search.service;

import javax.annotation.Resource;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationService {
	@Resource
	private Environment env;

	private String filePath = "search.api.file.path";
	
	private String format = "search.api.character.format";

	public String getFilePath() {
		return env.getProperty(filePath);
	}

	public String getFormat() {
		return env.getProperty(format);
	}

	
}
