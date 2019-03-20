package com.bw.yq.api;

import com.bw.yq.bean.SearchBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author yaoqi
 * @fileName Apiservice
 * @package com.bw.yq.api
 * @date 2019/3/19 14:15
 */
public interface Apiservice {
   //&page=1&
   @GET("findCommodityByKeyword")
   Flowable<SearchBean> Search(@Query("keyword")String keyword, @Query("page") int page,@Query("count") int count);
}
