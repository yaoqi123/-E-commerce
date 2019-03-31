package com.bw.yq.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.yq.R;
import com.bw.yq.base.BaseActivity;
import com.bw.yq.bean.NewBean;
import com.bw.yq.presenter.NewlyaddedPresenter;
import com.bw.yq.view.NewLyaddedView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.leefeng.citypicker.CityPicker;
import me.leefeng.citypicker.CityPickerListener;

public class NewlyaddedActivity extends BaseActivity implements CityPickerListener ,NewLyaddedView {


    @BindView(R.id.shouhuo)
    EditText shouhuo;
    @BindView(R.id.dianji)
    ImageView dianji;
    @BindView(R.id.shoujianren)
    EditText shoujianren;
    @BindView(R.id.shouji)
    EditText shouji;
    @BindView(R.id.xiangqingdizhi)
    EditText xiangqingdizhi;
    @BindView(R.id.youzheng)
    EditText youzheng;
    @BindView(R.id.tijiao)
    Button tijiao;
    private CityPicker cityPicker;
    private String address = "";
    private NewlyaddedPresenter presenter;
    private boolean aBoolean;
    private int userId;
    private String sessionId;
    private String phone;
    private String realName;
    private String zipCode;
    private String sousuo;
    private String xiangqing;

    @Override
    public Object getPresenter() {
        return null;
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_newlyadded;
    }

    @Override
    protected void initView() {
        cityPicker = new CityPicker(NewlyaddedActivity.this, this);
        SharedPreferences login = getSharedPreferences("login", Context.MODE_PRIVATE);
        sessionId = login.getString("sessionId", "");
        userId = login.getInt("userId", 1);
        aBoolean = login.getBoolean("登陆", false);
        Log.i("ddd", sessionId + "-------" + userId);
        presenter = new NewlyaddedPresenter(this);
    }

    @Override
    protected void getData() {



        dianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityPicker.show();
            }
        });
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aBoolean){
                    //Toast.makeText(NewlyaddedActivity.this, "haoaho", Toast.LENGTH_SHORT).show();
                    phone = shouji.getText().toString().trim();
                    realName = shoujianren.getText().toString().trim();
                    zipCode = youzheng.getText().toString().trim();
                    sousuo = shouhuo.getText().toString().trim();
                    xiangqing = xiangqingdizhi.getText().toString().trim();
                    address = sousuo+" "+xiangqing;
                    presenter.New(userId,sessionId,realName,phone,address,zipCode);
                    finish();
                }else{
                    Toast.makeText(NewlyaddedActivity.this, "没有登陆", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public void getCity(String s) {
        shouhuo.setText(s);
    }

    @Override
    public void onBackPressed() {
        if (cityPicker.isShow()) {
            cityPicker.close();
            return;
        }
        super.onBackPressed();
    }


    @Override
    public void Newly(NewBean newBean) {
        Toast.makeText(this, newBean.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
