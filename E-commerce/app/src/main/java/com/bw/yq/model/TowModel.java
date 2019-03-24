package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.Tow;
import com.bw.yq.bean.TowBean;
import com.bw.yq.uitls.RetrofitUitls;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author yaoqi
 * @fileName TowModel
 * @package com.bw.yq.model
 * @date 2019/3/23 11:50
 */
public class TowModel {
public interface OnTowModelListenter{

   void OnTow(List<Tow> result);
}
public OnTowModelListenter towModelListenter;
public void setOnTowModelListenter(OnTowModelListenter towModelListenter){
    this.towModelListenter=towModelListenter;
}
    public void send(String id) {
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(0, null, Api.TowUrl, Apiservice.class);
        apiservice.Tow(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<TowBean>() {
                    @Override
                    public void onNext(TowBean towBean) {
                        List<Tow> result = towBean.getResult();
                        Log.i("ll",result.toString());
                        if (towModelListenter!=null){
                            towModelListenter.OnTow(result);
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
