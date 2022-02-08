package com.pollen.pollenweb.result;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;

/*
    给前端返回json格式数据
 */

public class ResultMapUtil {
    /*
    登录返回结果
     */
    public static HashMap<String,Object> getHashMapLogin(String msg,String code){
        HashMap<String,Object> resultMap=new HashMap<>();
        resultMap.put("msg",msg);
        resultMap.put("code",code);
        if("1".equals(code)){
            resultMap.put("icon",1);
        }else{
            resultMap.put("icon",3);
        }
        resultMap.put("anim",4);
        return resultMap;
    }

    //注册返回结果
    public static Object getHashMapSave(int i) {
        HashMap<String,Object> resultMap = new HashMap<>();
        if(i == 0){
            resultMap.put("msg","注册失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else if(i==2){
            resultMap.put("msg","账号已存在");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else if(i==3){
            resultMap.put("msg","用户名已被使用");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","注册成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }
        return resultMap;
    }

    //异常返回结果
    public static Object getHashMapException(Exception e) {
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg",e.getMessage());
        return resultMap;
    }

    /**
     * 分页查询结果
     */
    public static HashMap<String,Object> getHashMapMysqlPage(IPage<?> object){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",object.getTotal());
        resultMap.put("data",object.getRecords());
        return resultMap;
    }
}
