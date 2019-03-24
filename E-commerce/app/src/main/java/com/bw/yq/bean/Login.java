package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName Login
 * @package com.bw.yq.bean
 * @date 2019/3/22 15:31
 */
public class Login {
    private String headPic;
    private String nickName;
    private String phone;
    private String sessionId;
    private int sex;
    private int userId;

    public Login(String headPic, String nickName, String phone, String sessionId, int sex, int userId) {
        this.headPic = headPic;
        this.nickName = nickName;
        this.phone = phone;
        this.sessionId = sessionId;
        this.sex = sex;
        this.userId = userId;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Login{" +
                "headPic='" + headPic + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", sex=" + sex +
                ", userId=" + userId +
                '}';
    }
}
