package com.pollen.pollenweb.controller.file;

import com.pollen.pollenweb.configuration.ConfigProperties;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("file")
@Slf4j
@EnableConfigurationProperties(ConfigProperties.class)
public class FileController {
    @Autowired
    private ConfigProperties configProperties;
//    @Value("${file.upload.dir}")
//    private String uploadFilePath = configProperties.getFileUploadDir();
//
//    @RequestMapping("/upload")
//    public String httpUpload(@RequestParam("files") MultipartFile files[]){
//        JSONObject object=new JSONObject();
//        for(int i=0;i<files.length;i++){
//            String fileName = files[i].getOriginalFilename();  // 文件名
//            File dest = new File(uploadFilePath +'/'+ fileName);
//            if (!dest.getParentFile().exists()) {
//                dest.getParentFile().mkdirs();
//            }
//            try {
//                files[i].transferTo(dest);
//            } catch (Exception e) {
//                log.error("{}",e);
//                try {
//                    object.put("success",2);
//                } catch (JSONException ex) {
//                    ex.printStackTrace();
//                }
//                try {
//                    object.put("result","程序错误，请重新上传");
//                } catch (JSONException ex) {
//                    ex.printStackTrace();
//                }
//                return object.toString();
//            }
//        }
//        try {
//            object.put("success",1);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        try {
//            object.put("result","文件上传成功");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return object.toString();
//    }

}

