package com.huyphungkien.service;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	void init();

	void delete(String storeFileName) throws IOException;

	Path load(String filename);

	Resource loadAsResource(String fileName);

	void store(MultipartFile file, String storeFilename);

	String getStorageFileName(MultipartFile file, String id);
	
}
