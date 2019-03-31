package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.NewBean;
import com.bw.yq.uitls.RetrofitUitls;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author yaoqi
 * @fileName NewlyaddedModel
 * @package com.bw.yq.model
 * @date 2019/3/29 14:06
 */
public class NewlyaddedModel {
   public interface OnNewlyaddedModelListenter{
       void newlyadded(NewBean newBean);
   }
   public OnNewlyaddedModelListenter newlyaddedModelListenter;
   public void setOnNewlyaddedModelListenter(OnNewlyaddedModelListenter newlyaddedModelListenter){
       this.newlyaddedModelListenter=newlyaddedModelListenter;

   }

    public void send(int userId, String sessionId, String realName, String phone, String address, String zipCode) {
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(0, null, Api.NewUrl, Apiservice.class);
        apiservice.New(sessionId,userId,realName,phone,address,zipCode).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSubscriber<NewBean>() {
            @Override
            public void onNext(NewBean newBean) {
              if (newlyaddedModelListenter!=null){
                  newlyaddedModelListenter.newlyadded(newBean);

              }
            }

            @Override
            public void onError(Throwable t) {
               // Log.i("shouhuo",t.toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
