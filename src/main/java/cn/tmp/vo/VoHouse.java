package cn.tmp.vo;

import cn.tmp.po.House;


public class VoHouse extends House {

    private String voHid;

    private String voImg;

    public VoHouse() {}

    public VoHouse(House house) {
        this.setHoid(house.getHoid());
        this.setHid(house.getHid());
        this.setName(house.getName());
        this.setPrice(house.getPrice());
        this.setBedcount(house.getBedcount());
        this.setStar(house.getStar());
        this.setIswifi(house.getIswifi());
        this.setImg(house.getImg());
        this.setInfo(house.getInfo());


    }

    public String getVoHid() {
        return voHid;
    }

    public void setVoHid(String voHid) {
        this.voHid = voHid;
    }

    public String getVoImg() {
        return voImg;
    }

    public void setVoImg(String voImg) {
        this.voImg = voImg;
    }
}
