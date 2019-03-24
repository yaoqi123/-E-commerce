package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.Details;
import com.bw.yq.bean.DetailsBean;
import com.bw.yq.uitls.RetrofitUitls;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author yaoqi
 * @fileName DetailsModel
 * @package com.bw.yq.model
 * @date 2019/3/20 19:43
 */
public class DetailsModel {
    public  interface OnDetailsListenter{
        void OnDetails(Details result);
    }
    public OnDetailsListenter detailsListenter;
    public void setOnDetailsListenter(OnDetailsListenter detailsListenter){
        this.detailsListenter=detailsListenter;
    }
    public void send(int id) {
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(0, null, Api.Searchurl, Apiservice.class);
        apiservice.Show(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<DetailsBean>() {
                    @Override
                    public void onNext(DetailsBean detailsBean) {
                        Details result = detailsBean.getResult();
                        Log.i("xxx",result.toString());
                        if (detailsListenter!=null){
                            detailsListenter.OnDetails(result);
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
