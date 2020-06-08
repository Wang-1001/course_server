package com.niit.scs.sourseserver.service.dto;

import com.niit.scs.sourseserver.domain.CafeInfo;

import java.util.List;

public class CafeBox {
    //两件商品
    List<CafeInfo> cafeInfoList;
    //礼盒售价
    Float totalPrice;

    public List<CafeInfo> getCafeInfoList() {
        return cafeInfoList;
    }

    public void setCafeInfoList(List<CafeInfo> cafeInfoList) {
        this.cafeInfoList = cafeInfoList;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
