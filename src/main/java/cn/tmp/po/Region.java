package cn.tmp.po;

public class Region {
    private Integer rid;

    private String name;

    private String var;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var == null ? null : var.trim();
    }
}