package com.bw.yq.api;

import com.bw.yq.bean.BannerBean;
import com.bw.yq.bean.CartBean;
import com.bw.yq.bean.DetailsBean;
import com.bw.yq.bean.LoginBean;
import com.bw.yq.bean.QueryBean;
import com.bw.yq.bean.Register;
import com.bw.yq.bean.SearchBean;
import com.bw.yq.bean.ShowBean;
import com.bw.yq.bean.CecondBean;
import com.bw.yq.bean.TowBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author yaoqi
 * @fileName Apiservice
 * @package com.bw.yq.api
 * @date 2019/3/19 14:15
 */
public interface Apiservice {
    //&page=1&
    @GET("findCommodityByKeyword")
    Flowable<SearchBean> Search(@Query("keyword") String keyword, @Query("page") int page, @Query("count") int count);

    @GET("findCommodityDetailsById")
    Flowable<DetailsBean> Show(@Query("commodityId") int commodityId);

    @GET("bannerShow")
    Flowable<BannerBean> Banner();

    @GET("commodityList")
    Flowable<ShowBean> Shows();

    @POST("login")
    Flowable<LoginBean> Login(@QueryMap Map<String, String> login);

    @POST("register")
    Flowable<Register> Register(@QueryMap Map<String, String> register);
//    http://172.17.8.100/small/commodity/v1/findFirstCategory

    @GET("findFirstCategory")
    Flowable<CecondBean> Cecond();

    @GET("findSecondCategory")
    Flowable<TowBean> Tow(@Query("firstCategoryId") String id);

    @GET("findCommodityByCategory")
    Flowable<QueryBean> Query(@Query("categoryId") String id, @Query("page") int page, @Query("count") int count);

    @GET("findShoppingCart")
    Flowable<CartBean> Cart();
}
