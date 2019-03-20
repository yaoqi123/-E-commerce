package com.bw.yq.model;

import android.util.Log;

import com.bw.yq.api.Api;
import com.bw.yq.api.Apiservice;
import com.bw.yq.bean.Search;
import com.bw.yq.bean.SearchBean;
import com.bw.yq.uitls.RetrofitUitls;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author yaoqi
 * @fileName SearchModel
 * @package com.bw.yq.model
 * @date 2019/3/19 13:50
 */
public class SearchModel {

    public void send(String keyword, int count, int page) {
        Apiservice apiservice = RetrofitUitls.OnInstents().ApiService(null, null, Api.Searchurl, Apiservice.class);
        apiservice.Search(keyword,page,count).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SearchBean>() {
                    @Override
                    public void onNext(SearchBean searchBean) {
                        List<Search> result = searchBean.getResult();
                        Log.i("xxx",result.toString());
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
