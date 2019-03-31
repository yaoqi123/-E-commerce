package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.QueryBean;
import com.bw.yq.bean.Querys;
import com.bw.yq.uitls.RetrofitUitls;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author yaoqi
 * @fileName QueryModel
 * @package com.bw.yq.model
 * @date 2019/3/23 15:22
 */
public class QueryModel  {

public interface OnQueryListenter{
    void Querys(List<Querys> result);
}
public OnQueryListenter queryListenter;
public void setOnQueryListenter(OnQueryListenter queryListenter){
    this.queryListenter=queryListenter;
}
    public void send(String id) {
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(0, null, Api.QueryUrl, Apiservice.class);
        apiservice.Query(id,1,10).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSubscriber<QueryBean>() {
            @Override
            public void onNext(QueryBean queryBean) {
                List<Querys> result = queryBean.getResult();

                if (queryListenter!=null){
                    queryListenter.Querys(result);
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
