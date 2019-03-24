package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.Result;
import com.bw.yq.bean.CartBean;
import com.bw.yq.uitls.RetrofitUitls;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author yaoqi
 * @fileName CartModel
 * @package com.bw.yq.model
 * @date 2019/3/24 14:14
 */
public class CartModel {
    public interface OnCartModelListenter{
        void OnCart( List<Result> result);
    }
    public OnCartModelListenter cartModelListenter;
    public void setOnCartModelListenter(OnCartModelListenter cartModelListenter){
        this.cartModelListenter=cartModelListenter;
    }
    public void send(String sessionId, int userId) {
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(userId, sessionId, Api.CratUrl, Apiservice.class);
        apiservice.Cart().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<CartBean>() {
                    @Override
                    public void onNext(CartBean cartBean) {
                        List<Result> result = cartBean.getResult();
//                        Log.i("qqq",result.size()+"");
                        if (cartModelListenter!=null){
                            cartModelListenter.OnCart(result);

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
