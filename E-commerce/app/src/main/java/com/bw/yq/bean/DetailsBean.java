package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName DetailsBean
 * @package com.bw.yq.bean
 * @date 2019/3/19 19:11
 */
public class DetailsBean {
public Details result;


    public DetailsBean(Details result) {
        this.result = result;
    }

    public Details getResult() {
        return result;
    }

    public void setResult(Details result) {
        this.result = result;
    }
}
