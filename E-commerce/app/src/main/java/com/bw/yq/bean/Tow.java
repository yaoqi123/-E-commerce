package com.bw.yq.bean;

/**
 * @author yaoqi
 * @fileName Tow
 * @package com.bw.yq.bean
 * @date 2019/3/23 14:13
 */
public class Tow {
  private String   id;
     private String  name;

    public Tow(String id, String name) {
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
        return "Tow{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
