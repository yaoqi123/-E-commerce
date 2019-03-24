package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName Register
 * @package com.bw.yq.bean
 * @date 2019/3/22 19:06
 */
public class Register {
         private String  message;
        private  String    status;

    public Register(String message, String status) {
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
}
