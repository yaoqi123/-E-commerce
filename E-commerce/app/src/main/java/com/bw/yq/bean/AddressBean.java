package com.bw.yq.bean;

import java.util.ArrayList;

/**
 * @author yaoqi
 * @fileName AddressBean
 * @package com.bw.yq.bean
 * @date 2019/3/28 20:36
 */
public class AddressBean {
    ArrayList<Address> result;
    private String status;
    private String message;

    public AddressBean(ArrayList<Address> result, String status, String message) {
        this.result = result;
        this.status = status;
        this.message = message;
    }

    public ArrayList<Address> getResult() {
        return result;
    }

    public void setResult(ArrayList<Address> result) {
        this.result = result;
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
        return "AddressBean{" +
                "result=" + result +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
