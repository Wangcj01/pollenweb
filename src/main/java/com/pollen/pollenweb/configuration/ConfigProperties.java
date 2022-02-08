package com.pollen.pollenweb.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = ConfigProperties.PREFIX)
public class ConfigProperties {
    public static final String PREFIX = "sf";
    private String fileUploadDir;

    public String getFileUploadDir(){
        return fileUploadDir;
    }

    public void setFileUploadDir(String fileUploadDir){
        this.fileUploadDir = fileUploadDir;
    }
}
