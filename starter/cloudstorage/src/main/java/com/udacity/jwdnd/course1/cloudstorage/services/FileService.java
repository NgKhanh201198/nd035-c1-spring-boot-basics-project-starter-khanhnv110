package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.entity.File;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileService
 *
 * @author Nguyen_Khanh
 */
@Service
public class FileService {
    private final UserService userService;
    private final FileMapper fileMapper;

    public FileService(UserService userService, FileMapper fileMapper) {
        this.userService = userService;
        this.fileMapper = fileMapper;
    }

    public File getFileByFileId(Integer fileId) {
        return fileMapper.getFileByFileId(fileId);
    }

    public boolean existsFilename(String fileName) {
        return fileMapper.existsFilename(fileName) != null;
    }

    public List<File> getFileListByUserId() {
        return fileMapper.getFileListByUserId(userService.getUserId());
    }

    public void createFiles(File file) {
        fileMapper.insert(file);
    }

    public boolean deleteFiles(Integer fileId) {
        return fileMapper.delete(fileId);
    }
}
