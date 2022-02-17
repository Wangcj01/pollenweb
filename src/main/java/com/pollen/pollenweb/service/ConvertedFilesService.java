package com.pollen.pollenweb.service;

import com.pollen.pollenweb.entity.ConvertedFiles;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2022-02-15
 */
public interface ConvertedFilesService extends IService<ConvertedFiles> {

    public ConvertedFiles queryConvertedFilesByID(ConvertedFiles convertedFiles);

    public List<ConvertedFiles> showAllConvertedFiles();

    public List<Map<String,Object>> show2();
}
