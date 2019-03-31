package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName AddBean
 * @package com.bw.yq.bean
 * @date 2019/3/26 19:40
 */
public class AddBean {
  String status;
  String message;

    public AddBean(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AddBean{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

