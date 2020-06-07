package com.niit.scs.sourseserver.domain;

public class CafeInfo {
   private Long id;
   private String cafeName;
   private String cafeEname;
   private String cafeType;
   private String cafeDesc;
   private String cafeMaterial;
   private Float cafePrice0;
   private Float cafePrice1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public String getCafeEname() {
        return cafeEname;
    }

    public void setCafeEname(String cafeEname) {
        this.cafeEname = cafeEname;
    }

    public String getCafeType() {
        return cafeType;
    }

    public void setCafeType(String cafeType) {
        this.cafeType = cafeType;
    }

    public String getCafeDesc() {
        return cafeDesc;
    }

    public void setCafeDesc(String cafeDesc) {
        this.cafeDesc = cafeDesc;
    }

    public String getCafeMaterial() {
        return cafeMaterial;
    }

    public void setCafeMaterial(String cafeMaterial) {
        this.cafeMaterial = cafeMaterial;
    }

    public Float getCafePrice0() {
        return cafePrice0;
    }

    public void setCafePrice0(Float cafePrice0) {
        this.cafePrice0 = cafePrice0;
    }

    public Float getCafePrice1() {
        return cafePrice1;
    }

    public void setCafePrice1(Float cafePrice1) {
        this.cafePrice1 = cafePrice1;
    }
}
