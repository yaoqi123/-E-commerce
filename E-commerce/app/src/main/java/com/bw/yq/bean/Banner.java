package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName Banner
 * @package com.bw.yq.bean
 * @date 2019/3/20 20:28
 */
public class Banner {
    public String imageUrl;

    public Banner(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
