package com.bw.yq.api;

import com.bw.yq.bean.AddBean;
import com.bw.yq.bean.AddressBean;
import com.bw.yq.bean.BannerBean;
import com.bw.yq.bean.CartBean;
import com.bw.yq.bean.DetailsBean;
import com.bw.yq.bean.LoginBean;
import com.bw.yq.bean.MorenBean;
import com.bw.yq.bean.NewBean;
import com.bw.yq.bean.OrderBean;
import com.bw.yq.bean.QueryBean;
import com.bw.yq.bean.Register;
import com.bw.yq.bean.SearchBean;
import com.bw.yq.bean.ShowBean;
import com.bw.yq.bean.CecondBean;
import com.bw.yq.bean.TowBean;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
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
    Flowable<CartBean> Cart(@Header("sessionId") String sessionId, @Header("userId") int userId);

    @Multipart
    @PUT("syncShoppingCart")
    Flowable<AddBean> Add(@Part("data") RequestBody json, @Header("sessionId") String sessionId, @Header("userId") int userId);

    @GET("receiveAddressList")
    Flowable<AddressBean> Address(@Header("sessionId") String sessionId, @Header("userId") int userId);


    @POST("addReceiveAddress")
//int userId, String sessionId, String realName, String phone, String address, String zipCode
    Flowable<NewBean> New(@Header("sessionId") String sessionId, @Header("userId") int userId, @Query("realName") String realName, @Query("phone") String phone, @Query("address") String address, @Query("zipCode") String zipCode);

    @POST("setDefaultReceiveAddress")
    Flowable<MorenBean> Moren(@Header("sessionId") String sessionId, @Header("userId") int userId, @Query("id") int id);

    @Multipart
    @POST("createOrder")
    Flowable<OrderBean> Order(@Header("sessionId") String sessionId, @Header("userId") int userId, @Part("orderInfo") RequestBody orderInfo, @Query("totalPrice") double sum, @Query("addressId") int id);
}
