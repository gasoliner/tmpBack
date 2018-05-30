package cn.tmp.vo;

import cn.tmp.po.Attraction;


public class VoAttraction extends Attraction {

    private String voRid;

    private String voImg;

    public VoAttraction(Attraction attraction) {
        this.setAid(attraction.getAid());
        this.setRid(attraction.getRid());
        this.setName(attraction.getName());
        this.setAddr(attraction.getAddr());
        this.setOpentime(attraction.getOpentime());
        this.setImg(attraction.getImg());
        this.setInfo(attraction.getInfo());
        this.setPrice(attraction.getPrice());
        this.setLevel(attraction.getLevel());
        this.setScore(attraction.getScore());
    }

    public VoAttraction(){}

    public String getVoRid() {
        return voRid;
    }

    public void setVoRid(String voRid) {
        this.voRid = voRid;
    }

    public String getVoImg() {
        return voImg;
    }

    public void setVoImg(String voImg) {
        this.voImg = voImg;
    }

}
