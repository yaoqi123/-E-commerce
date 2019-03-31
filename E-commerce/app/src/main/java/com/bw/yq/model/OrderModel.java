package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.OrderBean;
import com.bw.yq.uitls.RetrofitUitls;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author yaoqi
 * @fileName OrderModel
 * @package com.bw.yq.model
 * @date 2019/3/29 21:57
 */
public class OrderModel {

    public void send(int userId, String sessionId, String json1, double sum, int id) {
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(0, null, Api.OrderUrl, Apiservice.class);
        apiservice.Order(sessionId,userId,RequestBody.create(MediaType.parse("text/plain"), json1),sum,id)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSubscriber<OrderBean>() {
            @Override
            public void onNext(OrderBean orderBean) {
                Log.i("uio",orderBean.toString());
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
