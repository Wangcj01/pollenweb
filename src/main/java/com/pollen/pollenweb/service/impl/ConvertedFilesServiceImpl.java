package com.pollen.pollenweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pollen.pollenweb.entity.ConvertedFiles;
import com.pollen.pollenweb.entity.User;
import com.pollen.pollenweb.mapper.ConvertedFilesMapper;
import com.pollen.pollenweb.service.ConvertedFilesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2022-01-28
 */
@Service
public class ConvertedFilesServiceImpl extends ServiceImpl<ConvertedFilesMapper, ConvertedFiles> implements ConvertedFilesService {
    @Autowired
    private ConvertedFilesMapper convertedFilesMapper;

    @Override
    public ConvertedFiles queryConvertedFilesByID(ConvertedFiles convertedFiles){
        QueryWrapper<ConvertedFiles> wrapper=new QueryWrapper<>();
        wrapper.eq("file_id",convertedFiles.getFileName());
        return convertedFilesMapper.selectOne(wrapper);
    }

    @Override
    public List<ConvertedFiles> showAllConvertedFiles() {
        return convertedFilesMapper.selectList(null);
    }

    @Override
    public List<Map<String,Object>> show2(){
        QueryWrapper<ConvertedFiles> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("file_name");
        List<Map<String, Object>> maps = convertedFilesMapper.selectMaps(queryWrapper);
        return maps;
    }

}
