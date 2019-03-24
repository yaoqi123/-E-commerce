package com.bw.yq.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.yq.R;
import com.bw.yq.adapter.CartAdapter;
import com.bw.yq.base.BaseFragment;
import com.bw.yq.bean.Result;
import com.bw.yq.presenter.CartPresenter;
import com.bw.yq.view.CartView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author yaoqi
 * @fileName CartFragment
 * @package com.bw.yq.fragment
 * @date 2019/3/12 14:39
 */
public class CartFragment extends BaseFragment implements CartView {


    @BindView(R.id.cart_rlv)
    RecyclerView cartRlv;
    Unbinder unbinder;

    @Override
    public Object getSecondPresenter() {
        return null;
    }

    @Override
    public Object getShowPresenter() {
        return null;
    }

    @Override
    public Object getHomePresenter() {
        return null;
    }

    @Override
    protected int layoutResID() {
        return R.layout.cart_layout;
    }

    @Override
    public Object getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    protected void getData() {
        SharedPreferences login = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        String sessionId = login.getString("sessionId", "");
        int userId = login.getInt("userId", 1);
        Log.i("ddd", sessionId + "-------" + userId);
        CartPresenter presenter = new CartPresenter(this);
        presenter.cart(sessionId, userId);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        cartRlv.setLayoutManager(manager);

    }

    @Override
    public void Cart(List<Result> result) {
        CartAdapter cartAdapter = new CartAdapter(getActivity(), result);
        cartRlv.setAdapter(cartAdapter);

    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
