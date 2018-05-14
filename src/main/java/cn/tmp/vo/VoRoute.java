package cn.tmp.vo;

import cn.tmp.po.Route;

/**
 * Created by Ww on 2018/5/14.
 */
public class VoRoute extends Route {

    private String voRid;

    private String voAids;

    private Integer[] voAidss;

    public VoRoute(Route route) {
        this.setRtid(route.getRtid());
        this.setName(route.getName());
        this.setRid(route.getRid());
        this.setAids(route.getAids());
        this.setVar(route.getVar());
    }

    public Integer[] getVoAidss() {
        return voAidss;
    }

    public void setVoAidss(Integer[] voAidss) {
        this.voAidss = voAidss;
    }

    public String getVoRid() {
        return voRid;
    }

    public void setVoRid(String voRid) {
        this.voRid = voRid;
    }

    public String getVoAids() {
        return voAids;
    }

    public void setVoAids(String voAids) {
        this.voAids = voAids;
    }
}
