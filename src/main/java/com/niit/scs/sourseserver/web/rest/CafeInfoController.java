package com.niit.scs.sourseserver.web.rest;


import com.niit.scs.sourseserver.domain.CafeInfo;

import com.niit.scs.sourseserver.service.CafeInfoService;
import com.niit.scs.sourseserver.service.dto.CafeBox;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//配置接口注解 添加接口标记
@RestController
@RequestMapping("/api")
public class CafeInfoController {

    private final CafeInfoService cafeInfoService;

    public CafeInfoController(CafeInfoService cafeInfoService) {//cafeInfoService报错 Could not autowire. No beans of 'CafeInfoService' type found --->在 CafeInfoServiceImpl 中加入注解 @Service
        this.cafeInfoService = cafeInfoService;
    }

    /**
     * 获取全部商品
     * @return
     */
    @GetMapping("/demo/items")
    //     返回类型
    public ResponseEntity getAllCafe(){

        //this.cafeInfoService.getAllCafe();//拿到数据  List<CafeInfo> result //接收数据

        List<CafeInfo> result = this.cafeInfoService.getAllCafe();
        return ResponseEntity.ok(result);
        // 抛出异常
        /*try{
            List<CafeInfo> result = this.cafeInfoService.getAllCafe();
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }*/

    }

    /**
     * 咖啡礼盒
     * @return
     */
    @GetMapping("/dmeo/cafe-box")
    public ResponseEntity getCafeBox(){
        CafeBox result = this.cafeInfoService.getGiftBox();
        return ResponseEntity.ok(result);
    }

}
