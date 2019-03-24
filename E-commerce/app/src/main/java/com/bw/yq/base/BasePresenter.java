package com.bw.yq.base;

/**
 * @author yaoqi
 * @fileName BasePresenter
 * @package com.bw.yq.base
 * @date 2019/3/20 13:58
 */
public abstract class BasePresenter<T> {
    public T view;

    public void attch(T view) {
        this.view = view;
    }

    public T details;

    public void attchs(T details) {
        this.details = details;

    }

    ;
    public T banner;

    public void banner(T banner) {
        this.banner = banner;
    }

    ;
    public T show;

    public void shows(T show) {
        this.show = show;
    }

    ;
    public T landing;

    public void Login(T landing) {
        this.landing = landing;
    }

    ;
    public T regis;

    public void Regis(T regis) {
        this.regis = regis;
    }

    ;
    public T second;

    public void Second(T second) {
        this.second = second;
    }

    ;
    public T tows;

    public void Tows(T tows) {
        this.tows = tows;
    }

    ;
public T querys;
    public void Querys(T querys) {
        this.querys=querys;
    }
public T cart;
    public void Carts(T cart){
        this.cart=cart;
    };
}
