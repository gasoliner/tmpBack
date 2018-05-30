package cn.tmp.vo;

import cn.tmp.po.User;


public class VoUser extends User {

    private String voPassword;

    private String voRole;

    public VoUser(User user) {
        this.setUid(user.getUid());
        this.setName(user.getName());
        this.setPassword(user.getPassword());
        this.setRid(user.getRid());
    }

    public VoUser() {
    }

    public String getVoPassword() {
        return voPassword;
    }

    public void setVoPassword(String voPassword) {
        this.voPassword = voPassword;
    }

    public String getVoRole() {
        return voRole;
    }

    public void setVoRole(String voRole) {
        this.voRole = voRole;
    }
}
