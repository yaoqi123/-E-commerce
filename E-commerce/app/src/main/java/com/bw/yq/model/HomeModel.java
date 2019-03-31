package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.Banner;
import com.bw.yq.bean.BannerBean;
import com.bw.yq.uitls.RetrofitUitls;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author yaoqi
 * @fileName HomeModel
 * @package com.bw.yq.model
 * @date 2019/3/20 20:25
 */
public class HomeModel {
public interface OnHomeModelListenter{
    void Home(List<Banner> result);

}
public OnHomeModelListenter homeModelListenter;
public void setOnHomeModelListenter(OnHomeModelListenter homeModelListenter){
    this.homeModelListenter=homeModelListenter;
}
    public void banner() {
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(0, null, Api.BannerUrl, Apiservice.class);
        apiservice.Banner().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BannerBean>() {
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        List<Banner> result = bannerBean.getResult();

                        if (homeModelListenter!=null){
                            homeModelListenter.Home(result);
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
