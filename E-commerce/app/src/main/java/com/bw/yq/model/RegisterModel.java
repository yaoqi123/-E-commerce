package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.Register;
import com.bw.yq.uitls.RetrofitUitls;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author yaoqi
 * @fileName RegisterModel
 * @package com.bw.yq.model
 * @date 2019/3/22 19:03
 */
public class RegisterModel {
    public interface OnRegisterModelListenter{
        void Reis(Register register);
    }
    public OnRegisterModelListenter registerModelListenter;
    public void setOnRegisterModelListenter(OnRegisterModelListenter registerModelListenter){
        this.registerModelListenter=registerModelListenter;
    }
    Map<String,String> map=new HashMap<>();




    public void send(String phone, String pwd) {
        map.put("phone",phone);
        map.put("pwd",pwd);
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(0, null, Api.RegisterUrl, Apiservice.class);
        apiservice.Register(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<Register>() {
                    @Override
                    public void onNext(Register register) {
                        String message = register.getMessage();

                       if (registerModelListenter!=null){
                           registerModelListenter.Reis(register);
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
