package com.niit.scs.sourseserver.service.impl;

import com.alibaba.fastjson.util.TypeUtils;
import com.niit.scs.sourseserver.domain.CafeInfo;
import com.niit.scs.sourseserver.service.CafeInfoService;
import com.niit.scs.sourseserver.service.dto.CafeBox;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

    /**
     * 获取全部商品
     * @return
     */
    @Override
    public List<CafeInfo> getAllCafe() {
        /* 一一一 通常使用方法
        * JdbcTemplate jdbcTemplate = new JdbcTemplate();
        * */

        //编写 SQL 查询
        String sql="select * from cafe_info";

        //执行 SQL 得到的结果类型          List<Map<String,Object>> 根据 jdbcTemplate. 的返回类型确定
        List<Map<String,Object>> sqlResult = jdbcTemplate.queryForList(sql);

        //将 SQL得到的结构类型 (List<Map<String,Object>>) 转化为最终结果类型 (List<CafeInfo>)
        List<CafeInfo> result = new ArrayList<CafeInfo>();

        //把 sqlResult 查询到的结构搬运到 result 里面          sqlResult.for 回车，生成 for 循环
        for (Map<String, Object> sqlItem : sqlResult) {// sqlItem 对应数据库中的每一行
            //新初始化一个实例
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

    /**
     * 返回一个礼盒
     * @return
     */
    @Override
    public CafeBox getGiftBox() {
        //获取所有商品
        List<CafeInfo> allCafe = getAllCafe();//调用上面已有的方法

        //产生两个随机数
        Integer r1 = 0, r2 = 0;
        Random random =  new Random();
        do{
            r1 = random.nextInt(allCafe.size());
            r2 = random.nextInt(allCafe.size());
        }while (r1 == r2);


        //按照随机数从集合中取出对应咖啡
        CafeInfo cafe1 = allCafe.get(r1);
        CafeInfo cafe2 = allCafe.get(r2);

        //计算礼盒总价
        Float totalPrice = 0f;
        if (cafe1.getCafeType().equals("大师咖啡")){
            totalPrice += cafe1.getCafePrice0()*0.8f;
        }else {
            totalPrice += cafe1.getCafePrice0()*0.6f;
        }
        if (cafe2.getCafeType().equals("大师咖啡")){
            totalPrice += cafe2.getCafePrice0()*0.8f;
        }else {
            totalPrice += cafe2.getCafePrice0()*0.6f;
        }

        //返回
        //创建礼盒
        CafeBox result = new CafeBox();
        //礼盒总价
        result.setTotalPrice(totalPrice);
        //创建两杯咖啡的 List
        List<CafeInfo> cafeInfoList = new ArrayList<CafeInfo>();
        cafeInfoList.add(cafe1);
        cafeInfoList.add(cafe2);
        result.setCafeInfoList(cafeInfoList);

        return result;
    }
}
