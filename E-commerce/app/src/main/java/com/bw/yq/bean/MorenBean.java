package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName MorenBean
 * @package com.bw.yq.bean
 * @date 2019/3/29 20:30
 */
public class MorenBean {
    private String message;
    private String status;

    public MorenBean(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MorenBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
