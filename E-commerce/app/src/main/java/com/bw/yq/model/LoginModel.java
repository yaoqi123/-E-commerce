package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.R;
import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.Login;
import com.bw.yq.bean.LoginBean;
import com.bw.yq.uitls.RetrofitUitls;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author yaoqi
 * @fileName LoginModel
 * @package com.bw.yq.model
 * @date 2019/3/22 14:26
 */
public class LoginModel {
    public interface OnLoginModelListenter{
        void Logins(LoginBean loginBean);
    }
    public OnLoginModelListenter loginModelListenter;
    public void setOnLoginModelListenter(OnLoginModelListenter loginModelListenter){
        this.loginModelListenter=loginModelListenter;
    }
    private Map<String,String> map=new HashMap<>();

    public void send(String phone, String pad) {
        map.put("phone",phone);
        map.put("pwd",pad);
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(0, null, Api.LoginUrl, Apiservice.class);
        apiservice.Login(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                           if (loginModelListenter!=null){
                               loginModelListenter.Logins(loginBean);
                           }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
