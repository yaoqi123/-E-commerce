package com.bw.yq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bw.yq.R;
import com.bw.yq.adapter.AddressAdapter;
import com.bw.yq.base.BaseActivity;
import com.bw.yq.bean.Address;
import com.bw.yq.bean.MorenBean;
import com.bw.yq.presenter.AddressPresenter;
import com.bw.yq.presenter.LoginPresenter;
import com.bw.yq.view.AddressView;
import com.bw.yq.view.MorenView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddressActivity extends BaseActivity implements AddressView ,MorenView {


    @BindView(R.id.xingzeng)
    Button xingzeng;
    @BindView(R.id.address_rlv)
    RecyclerView addressRlv;
    private AddressPresenter presenter;
    private String sessionId;
    private int userId;

    @Override
    public Object getPresenter() {
        return null;
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_address;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {
        //接受userid  sesseionid
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        userId = sp.getInt("userId", 1);
        Log.i("uuuu", sessionId + "+++++++===" + userId);
        presenter = new AddressPresenter(this,this);

     //跳转到新增页面
        xingzeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddressActivity.this, NewlyaddedActivity.class);
                startActivity(intent);
            }
        });
        //地址P
        presenter.address(sessionId, userId);
        //布局管理器
        LinearLayoutManager manager=new LinearLayoutManager(this);
        addressRlv.setLayoutManager(manager);
    }


    @Override
    public void Address(ArrayList<Address> result) {
        //适配器
        AddressAdapter addressAdapter = new AddressAdapter(this, result);
        addressRlv.setAdapter(addressAdapter);
        //默认地址
        addressAdapter.setOnAddressListenter(new AddressAdapter.OnAddressListenter() {
            @Override
            public void add(int id) {
                presenter.add(sessionId,userId,id);
            }
        });




    }

//成功默认
    @Override
    public void moren(MorenBean morenBean) {
        Toast.makeText(this, morenBean.getMessage(), Toast.LENGTH_SHORT).show();
        presenter.address(sessionId, userId);
    }
}
