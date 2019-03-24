package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName Cecond
 * @package com.bw.yq.model
 * @date 2019/3/22 20:23
 */
public class Cecond {
    private String id;
    private String name;

    public Cecond(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cecond{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
