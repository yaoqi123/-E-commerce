package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.Address;
import com.bw.yq.bean.AddressBean;
import com.bw.yq.uitls.RetrofitUitls;

import java.util.ArrayList;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author yaoqi
 * @fileName AddressModel
 * @package com.bw.yq.model
 * @date 2019/3/28 20:30
 */
public class AddressModel {
public interface OnAddressModelListenter{
    void Address( ArrayList<Address> result);
}
public OnAddressModelListenter addressModelListenter;
public void setOnAddressModelListenter(OnAddressModelListenter addressModelListenter){
    this.addressModelListenter=addressModelListenter;
}
    public void send(String sessionId, int userId) {
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(0, null, Api.AddressUrl, Apiservice.class);
        apiservice.Address(sessionId,userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<AddressBean>() {
                    @Override
                    public void onNext(AddressBean addressBean) {

                        ArrayList<Address> result = addressBean.getResult();
                        if (addressModelListenter!=null){
                            addressModelListenter.Address(result);
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
