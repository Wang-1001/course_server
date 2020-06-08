package com.niit.scs.sourseserver.service.impl;

import com.alibaba.fastjson.util.TypeUtils;
import com.niit.scs.sourseserver.domain.CafeInfo;
import com.niit.scs.sourseserver.service.CafeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CafeInfoServiceImpl implements CafeInfoService {

    /*二二二
    @Autowired
    JdbcTemplate jdbcTemplate;

    三三三
    @Resource
    JdbcTemplate jdbcTemplate;*/

    //四四四 构造器注入
    private final JdbcTemplate jdbcTemplate;

    public CafeInfoServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CafeInfo> getAllCafe() {

        /* 一一一 通常使用方法
        * JdbcTemplate jdbcTemplate = new JdbcTemplate();
        * */

        String sql="select * from cafe_info";

        //List<Map<String,Object>> 根据jdbcTemplate.的返回类型确定
        List<Map<String,Object>> sqlResult = jdbcTemplate.queryForList(sql);

        //将 List<Map<String,Object>> 转化为 List<CafeInfo>
        List<CafeInfo> result = new ArrayList<CafeInfo>();

        //把 sqlResult 查询到的结构搬运到 result 里面
        /* sqlResult.for 回车，生成 for 循环*/
        for (Map<String, Object> sqlItem : sqlResult) {// sqlItem 对应数据库中的每一行
            CafeInfo cafeInfo = new CafeInfo();


            //cafeInfo.setId(sqlItem.get("id"));//报错，需要把 Object 类型转化为 Long 类型  --->在pom.xml中添加依赖

            /*在pom.xml中添加依赖
                <dependency>
                    <groupId>com.alibaba</groupId>
                    <artifactId>fastjson</artifactId>
                    <version>1.2.66</version>
                </dependency>*/
            cafeInfo.setId(TypeUtils.castToLong(sqlItem.get("id")));
            cafeInfo.setCafeName(TypeUtils.castToString(sqlItem.get("cafe_name")));
            cafeInfo.setCafeEname(TypeUtils.castToString(sqlItem.get("cafe_ename")));
            cafeInfo.setCafeType(TypeUtils.castToString(sqlItem.get("cafe_type")));
            cafeInfo.setCafeDesc(TypeUtils.castToString(sqlItem.get("cafe_desc")));
            cafeInfo.setCafeMaterial(TypeUtils.castToString(sqlItem.get("cafe_material")));
            cafeInfo.setCafePrice0(TypeUtils.castToFloat(sqlItem.get("cafe_price0")));
            cafeInfo.setCafePrice1(TypeUtils.castToFloat(sqlItem.get("cafe_price1")));

            //将实例添加到 List<CafeInfo> 返回结果中
            result.add(cafeInfo);
        }

        return result;
    }
}
