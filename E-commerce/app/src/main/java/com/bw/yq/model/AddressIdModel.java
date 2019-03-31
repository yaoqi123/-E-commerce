package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.MorenBean;
import com.bw.yq.uitls.RetrofitUitls;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author yaoqi
 * @fileName AddressIdModel
 * @package com.bw.yq.model
 * @date 2019/3/29 20:20
 */
public class AddressIdModel {
public interface OnAddressIdListenter{
    void OnsId(MorenBean morenBean);
}
public OnAddressIdListenter addressIdListenter;
public void setOnAddressIdListenter(OnAddressIdListenter addressIdListenter){
    this.addressIdListenter=addressIdListenter;
}
    public void send(String sessionId, int userId, int id) {
        final Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(0, null, Api.MorenUrl, Apiservice.class);
        apiservice.Moren(sessionId,userId,id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<MorenBean>() {
                    @Override
                    public void onNext(MorenBean morenBean) {
                        Log.i("xxxxx",morenBean.toString());
                        if (addressIdListenter!=null){
                            addressIdListenter.OnsId(morenBean);
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
