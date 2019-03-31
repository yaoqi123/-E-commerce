package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.ShowBean;
import com.bw.yq.uitls.RetrofitUitls;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.OkHttpClient;

/**
 * @author yaoqi
 * @fileName ShowModel
 * @package com.bw.yq.model
 * @date 2019/3/21 10:35
 */
public class ShowModel {
public interface OnShowModelListenter{
    void Show(ShowBean.ResultEntity result);
}
public OnShowModelListenter showModelListenter;
public void setOnShowModelListenter(OnShowModelListenter showModelListenter){
    this.showModelListenter=showModelListenter;
}
    public void send() {
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(0, null, Api.ShowUrl, Apiservice.class);
        apiservice.Shows().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ShowBean>() {
                    @Override
                    public void onNext(ShowBean showBean) {
                        ShowBean.ResultEntity result = showBean.getResult();

                        if (showModelListenter!=null){
                            showModelListenter.Show(result);
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
