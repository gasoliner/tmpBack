package cn.tmp.vo;

import cn.tmp.po.Orders;

/**
 * Created by Ww on 2018/5/20.
 */
public class VoOrders extends Orders {

    private String voPublish;

    private String voCid;

    private String voAction;


    public VoOrders(Orders order) {
        this.setOid(order.getOid());
        this.setName(order.getName());
        this.setSum(order.getSum());
        this.setTime(order.getTime());
        this.setState(order.getState());
        this.setCid(order.getCid());
        this.setVar(order.getVar());
    }

    public VoOrders() {
    }

    public String getVoAction() {
        return voAction;
    }

    public void setVoAction(String voAction) {
        this.voAction = voAction;
    }

    public String getVoPublish() {
        return voPublish;
    }

    public void setVoPublish(String voPublish) {
        this.voPublish = voPublish;
    }

    public String getVoCid() {
        return voCid;
    }

    public void setVoCid(String voCid) {
        this.voCid = voCid;
    }
}
