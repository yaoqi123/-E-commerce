package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.Cecond;
import com.bw.yq.bean.CecondBean;
import com.bw.yq.uitls.RetrofitUitls;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author yaoqi
 * @fileName SecondModel
 * @package com.bw.yq.model
 * @date 2019/3/22 20:18
 */
public class SecondModel {
public interface OnSecondListenter{
    void second(List<Cecond> result);
}
public OnSecondListenter secondListenter;
public void setOnSecondListenter(OnSecondListenter secondListenter){
    this.secondListenter=secondListenter;
}
    public void send() {
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(0, null, Api.CecondUrl, Apiservice.class);
        apiservice.Cecond().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<CecondBean>() {
                    @Override
                    public void onNext(CecondBean cecondBean) {

                        List<Cecond> result = cecondBean.getResult();

                        if (secondListenter!=null){
                            secondListenter.second(result);
                        }

                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i("xxx",t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
