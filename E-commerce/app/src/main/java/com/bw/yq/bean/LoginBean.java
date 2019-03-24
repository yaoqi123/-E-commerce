package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName LoginBean
 * @package com.bw.yq.bean
 * @date 2019/3/22 15:24
 */
public class LoginBean {
    private Login result;
    private String message;
    private String status;

    public Login getResult() {
        return result;
    }

    public void setResult(Login result) {
        this.result = result;
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
