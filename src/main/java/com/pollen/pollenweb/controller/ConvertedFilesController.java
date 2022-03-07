package com.pollen.pollenweb.controller;


import com.pollen.pollenweb.entity.ConvertedFiles;
import com.pollen.pollenweb.mapper.ConvertedFilesMapper;
import com.pollen.pollenweb.service.ConvertedFilesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
@Slf4j
public class ConvertedFilesController {
    @Autowired
    private ConvertedFilesService convertedFilesService;

    @RequestMapping("/historylist")
    private List<ConvertedFiles> queryHistoryList(){
        log.info("----list request----");
        return convertedFilesService.showAllConvertedFiles();
    }

    @RequestMapping("/history")
    private Model showHistory(Model model){
        List<ConvertedFiles> list = queryHistoryList();
        return model.addAttribute("history",list);
    }

//    @RequestMapping("/testurl2")
//    private List<Map<String,Object>> queryTest2(){
//        return convertedFilesService.show2();
//    }

}

