package com.bawei.wangchu0106;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:王楚
 *@Date: 2020/1/6
 *@Time:9:46
 *@Description:${DESCRIPTION}
 **/
@Entity
public class greenDao {
    private Long name;
    private String price;
    @Generated(hash = 185066816)
    public greenDao(Long name, String price) {
        this.name = name;
        this.price = price;
    }
    @Generated(hash = 593051474)
    public greenDao() {
    }
    public Long getName() {
        return this.name;
    }
    public void setName(Long name) {
        this.name = name;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
