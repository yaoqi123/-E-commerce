package com.bw.yq.uitls;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author yaoqi
 * @fileName RetrofitUitls
 * @package com.bw.yq.uitls
 * @date 2019/3/19 13:52
 */
public class RetrofitUitls {
    private static RetrofitUitls retrofitUitls;
    private RetrofitUitls(){

    }
    public static RetrofitUitls OnInstents(){
        if (retrofitUitls==null){
            synchronized (RetrofitUitls.class){

                if (retrofitUitls==null){
                    retrofitUitls=new RetrofitUitls();
                }
            }
        }

        return retrofitUitls;
    }
    public static Retrofit getRetrofit(final String userId, final String sessionId,String url){
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {

            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                if (!TextUtils.isEmpty(userId)&&!TextUtils.isEmpty(sessionId)){
                    Request request=chain.request()
                            .newBuilder()
                            .addHeader("userId",userId)
                            .addHeader("sessionId",sessionId)
                            .build();
                    return chain.proceed(request);

                }else {
                    Request request = chain.request();
                    return chain.proceed(request);

                }


            }
        }).build();
       Retrofit  retrofit=new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
       return retrofit;
    }
 public <T> T ApiService(final String userId, final String sessionId,String url,Class<T> service){
        Retrofit retrofit=getRetrofit(userId,sessionId,url);
       T t = retrofit.create(service);
       return t;

 }
}
