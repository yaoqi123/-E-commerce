package com.bw.yq.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.yq.R;
import com.bw.yq.base.BaseActivity;
import com.bw.yq.bean.Details;
import com.bw.yq.presenter.DetailsPresenter;
import com.bw.yq.view.DetailsView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DetailsActivity extends BaseActivity<DetailsPresenter> implements DetailsView {


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



    @Override
    public DetailsPresenter getPresenter() {
        presenter = new DetailsPresenter(this);
        return presenter;
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_details;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
//        Log.i("yaoqi",id+"");
                presenter.details(id);



    }

    @Override
    public void Datails(Details result) {
        final List<String> list=new ArrayList();

        String[] split = result.getPicture().split("\\,");
        for (int i=0;i<split.length;i++){
            list.add(split[i]);

        }
        list.add(result.getPicture());
        xbanner.setData(list,null);
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(DetailsActivity.this).load(list.get(position)).into((ImageView) view);
                banner.setPageChangeDuration(1000);
            }
        });
        jia.setText("$:"+result.getPrice());
        shu.setText("已售出"+result.getStock()+"件");
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


}
