package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FileStorage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String extension;
    private Long fileSize;
    private String hashId;
    private String contentType;
    private String uploadPath;
    private FileStorageStatus fileStorageStatus;

    @Override
    public String toString() {
        return "FileStorage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", extension='" + extension + '\'' +
                ", fileSize=" + fileSize +
                ", hashId='" + hashId + '\'' +
                ", contentType='" + contentType + '\'' +
                ", uploadPath='" + uploadPath + '\'' +
                ", fileStorageStatus=" + fileStorageStatus +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @Enumerated(EnumType.STRING)
    public FileStorageStatus getFileStorageStatus() {
        return fileStorageStatus;
    }

    public void setFileStorageStatus(FileStorageStatus fileStorageStatus) {
        this.fileStorageStatus = fileStorageStatus;
    }

    public FileStorage() {
    }

    public FileStorage(Long id, String name, String extension, Long fileSize, String hashId, String contentType, String uploadPath, FileStorageStatus fileStorageStatus) {
        this.id = id;
        this.name = name;
        this.extension = extension;
        this.fileSize = fileSize;
        this.hashId = hashId;
        this.contentType = contentType;
        this.uploadPath = uploadPath;
        this.fileStorageStatus = fileStorageStatus;
    }
}
