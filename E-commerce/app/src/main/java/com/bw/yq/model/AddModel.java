package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.AddBean;
import com.bw.yq.uitls.App;
import com.bw.yq.uitls.RetrofitUitls;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author yaoqi
 * @fileName AddModel
 * @package com.bw.yq.model
 * @date 2019/3/26 19:32
 */
public class AddModel {
public interface OnAddListenter {
    void Add(AddBean addBean);
}
public OnAddListenter addListenter;
public void setOnAddListenter(OnAddListenter addListenter){
    this.addListenter=addListenter;

}
    public void send(String sessionId, String json, int userId) {
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(0, null, Api.AddUrl, Apiservice.class);
        apiservice.Add(RequestBody.create(MediaType.parse("text/plain"), json),sessionId,userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<AddBean>() {

                    @Override
                    public void onNext(AddBean addBean) {
                        Log.i("yq",addBean.toString());
                      if (addListenter!=null){
                          addListenter.Add(addBean);
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
