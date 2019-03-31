package com.bw.yq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.yq.R;
import com.bw.yq.adapter.CartAdapter;
import com.bw.yq.base.BaseActivity;
import com.bw.yq.bean.Address;
import com.bw.yq.bean.Result;
import com.bw.yq.presenter.AddressPresenter;
import com.bw.yq.presenter.OrderPresenter;
import com.bw.yq.view.AddressView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends BaseActivity implements AddressView {


    @BindView(R.id.order_rlv)
    RecyclerView orderRlv;
    @BindView(R.id.address_name)
    TextView addressName;
    @BindView(R.id.address_phone)
    TextView addressPhone;
    @BindView(R.id.address_dizhi)
    TextView addressDizhi;
    @BindView(R.id.commit)
    Button commit;
    private String sessionId;
    private int userId;
    private int id;
    private boolean checd;
    private int commodityId;
    private int count;

    private OrderPresenter orderPresenter;
    private double sum;

    private String json1;

    @Override
    public Object getPresenter() {
        return null;
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_order;
    }

    @Override
    protected void initView() {
        //布局管理器
        orderRlv.setLayoutManager(new LinearLayoutManager(this));
        EventBus.getDefault().register(this);
        Intent intent = getIntent();

        //获取价钱
        sum = intent.getDoubleExtra("sum", 0.0);
        Toast.makeText(this, sum + "", Toast.LENGTH_SHORT).show();
        //获取sessionid  userid
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        userId = sp.getInt("userId", 1);
        Log.i("uuuu", sessionId + "+++++++===" + userId);
        //地址
        AddressPresenter addressPresenter = new AddressPresenter(this);
        addressPresenter.address(sessionId, userId);


    }

    @Override
    protected void getData() {
        orderPresenter = new OrderPresenter();



    }

    //地址数据
    @Override
    public void Address(ArrayList<Address> result) {
        for (int i = 0; i < result.size(); i++) {
            Address address = result.get(i);
            //获取订单
            id = address.getId();
            //判断选中状态  1是选中
            if (address.getWhetherDefault() == 1) {
                addressName.setText(result.get(i).getRealName());
                addressPhone.setText(result.get(i).getPhone());
                addressDizhi.setText(result.get(i).getAddress());
            }

        }
//        Log.i("opo", id + "");


    }
    //提交提单
    @OnClick(R.id.commit)
    public void onViewClicked() {
        Log.i("vvvvv", userId + "--" + sessionId + "--" + sum + "--" + id + "---" + json1);
        orderPresenter.order(userId, sessionId, json1, sum, id);

    }
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getdata(List<Result> result) {
        //适配器
        orderRlv.setAdapter(new CartAdapter(this, result));


        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < result.size(); i++) {
            Result result1 = result.get(i);
            boolean checd = result1.isChecd();
            if (checd) {
                result1.setChecd(true);
                int commodityId = result1.getCommodityId();
                int count = result1.getCount();
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("commodityId", commodityId);
                    jsonObject.put("amount", count);
                    jsonArray.put(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        json1 = jsonArray.toString();
        Toast.makeText(this, json1, Toast.LENGTH_SHORT).show();
    }





}



