package com.niit.scs.sourseserver.service;

import com.niit.scs.sourseserver.domain.CafeInfo;
import com.niit.scs.sourseserver.service.dto.CafeBox;

import java.util.List;


public interface CafeInfoService {

    //返回类型      方法名（传入参数）
    List<CafeInfo> getAllCafe();

    /**
     * 返回一个礼盒
     * @return
     */
    CafeBox getGiftBox();

}
