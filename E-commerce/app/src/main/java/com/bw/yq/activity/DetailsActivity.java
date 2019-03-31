package com.bw.yq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.yq.R;
import com.bw.yq.adapter.CartAdapter;
import com.bw.yq.base.BaseActivity;
import com.bw.yq.bean.AddBean;
import com.bw.yq.bean.Details;
import com.bw.yq.bean.Result;
import com.bw.yq.presenter.CartPresenter;
import com.bw.yq.presenter.DetailsPresenter;
import com.bw.yq.view.AddView;
import com.bw.yq.view.CartView;
import com.bw.yq.view.DetailsView;
import com.stx.xhb.xbanner.XBanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity<DetailsPresenter> implements DetailsView, CartView, AddView {


    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.jia)
    TextView jia;
    @BindView(R.id.shu)
    TextView shu;
    @BindView(R.id.jieshao)
    TextView jieshao;
    @BindView(R.id.web)
    WebView web;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private JSONArray jsonArray;
    private String sessionId;
    private int userId;
    private CartPresenter presenter1;
    private SharedPreferences sp;
    private int id;
    private JSONObject jsonObject=null;


    //实例化详情页P
    @Override
    public DetailsPresenter getPresenter() {
        presenter = new DetailsPresenter(this, this);
        return presenter;
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_details;
    }

    @Override
    protected void initView() {
        //查询购物车
        presenter1 = new CartPresenter(this);


    }

    @Override
    protected void getData() {
        Intent intent = getIntent();

//获取详情页信息
        int id = intent.getIntExtra("id", 0);
       Log.i("yaoqi",id+"");
        presenter.details(id);

        //获取sessionid,userid
        sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        userId = sp.getInt("userId", 1);
        Toast.makeText(this, sessionId + "--------" + userId, Toast.LENGTH_SHORT).show();
        //点击查询购物车
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sessionId = sp.getString("sessionId", "");
                int userId = sp.getInt("userId", 1);
                boolean aBoolean = sp.getBoolean("登陆", false);
                if (aBoolean) {
                    presenter1.cart(sessionId, userId);
                    Log.i("iii", sessionId + "-------------------" + userId);
                } else {
                    Toast.makeText(DetailsActivity.this, "no", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    //详情页信息
    @Override
    public void Datails(Details result) {
        id = result.getCommodityId();
Log.i("xua",id+"");
        final List<String> list = new ArrayList();
        String[] split = result.getPicture().split("\\,");
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);

        }
        list.add(result.getPicture());
        xbanner.setData(list, null);
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(DetailsActivity.this).load(list.get(position)).into((ImageView) view);
                banner.setPageChangeDuration(1000);
            }
        });
        jia.setText("$:" + result.getPrice());
        shu.setText("已售出" + result.getStock() + "件");
        jieshao.setText(result.getCommodityName());
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);//支持JS
        String js = "<script type=\"text/javascript\">" +
                "var imgs = document.getElementsByTagName('img');" + // 找到img标签
                "for(var i = 0; i<imgs.length; i++){" +  // 逐个改变
                "imgs[i].style.width = '100%';" +  // 宽度改为100%
                "imgs[i].style.height = 'auto';" +
                "}" +
                "</script>";
        web.loadDataWithBaseURL(null, result.getDetails() + js, "text/html", "utf-8", null);


    }

    //查询购物车信息
    @Override
    public void Cart(List<Result> result) {
        Log.i("ttt", result.toString());
        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject1 = new JSONObject();
        //判断是否为空
        if (result.size() != 0) {
            for (int i = 0; i < result.size(); i++) {
                Result result1 = result.get(i);
                int commodityId = result1.getCommodityId();
                int count = result1.getCount();
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("commodityId", commodityId);
                    jsonObject.put("count", count);
                    jsonArray.put(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            try {

                jsonObject1.put("commodityId", id);
                jsonObject1.put("count", 1);
                jsonArray.put(jsonObject1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //添加
            presenter.add(jsonArray.toString(), sessionId, userId);
        } else {
            Toast.makeText(this, "no9999", Toast.LENGTH_SHORT).show();
            try {
                jsonObject.put("commodityId", id);
                jsonObject.put("count", 1);
                jsonArray.put(jsonObject);
                presenter.add(jsonArray.toString(), sessionId, userId);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


    }

    //添加数据
    @Override
    public void add(AddBean addBean) {
        String message = addBean.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
