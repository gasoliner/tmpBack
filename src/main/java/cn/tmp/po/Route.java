package cn.tmp.po;

public class Route {
    private Integer rtid;

    private String name;

    private Integer rid;

    private String aids;

    private String var;

    public Integer getRtid() {
        return rtid;
    }

    public void setRtid(Integer rtid) {
        this.rtid = rtid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getAids() {
        return aids;
    }

    public void setAids(String aids) {
        this.aids = aids == null ? null : aids.trim();
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var == null ? null : var.trim();
    }
}