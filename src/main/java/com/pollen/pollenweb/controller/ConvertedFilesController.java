package com.pollen.pollenweb.controller;


import com.pollen.pollenweb.entity.ConvertedFiles;
import com.pollen.pollenweb.mapper.ConvertedFilesMapper;
import com.pollen.pollenweb.service.ConvertedFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2022-02-15
 */
@RestController
@RequestMapping("/convertedFiles")
public class ConvertedFilesController {
    @Autowired
    private ConvertedFilesService convertedFilesService;

    @RequestMapping("/testurl")
    private List<ConvertedFiles> queryTest(){
        return convertedFilesService.showAllConvertedFiles();
    }

    @RequestMapping("/testurl2")
    private List<Map<String,Object>> queryTest2(){
        return convertedFilesService.show2();
    }

}

