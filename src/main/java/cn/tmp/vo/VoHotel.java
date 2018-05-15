package cn.tmp.vo;

import cn.tmp.po.Hotel;

/**
 * Created by cqx on 2018/5/15.
 */
public class VoHotel extends Hotel {

    private String voImg;

    public VoHotel(Hotel hotel) {
        this.setHid(hotel.getHid());
        this.setName(hotel.getName());
        this.setAddr(hotel.getAddr());
        this.setScore(hotel.getScore());
        this.setStar(hotel.getStar());
        this.setPhone(hotel.getPhone());
        this.setImg(hotel.getImg());
        this.setInfo(hotel.getInfo());
    }

    public VoHotel(){}

    public String getVoImg() {
        return voImg;
    }

    public void setVoImg(String voImg) {
        this.voImg = voImg;
    }
}
