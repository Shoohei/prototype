package com.fnsystems.prototype.persistence.storage;

import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

/**
 * Service to store and load files
 */
public interface StorageService {

	/**
	 * Store a file
	 * @param file The file
	 * @param fileId The id
	 */
    void store(MultipartFile file, String fileId);

    /**
     * Load a file
     * @param fileId The file's id
     * @return The file's path
     */
    Path load(String fileId);
}
