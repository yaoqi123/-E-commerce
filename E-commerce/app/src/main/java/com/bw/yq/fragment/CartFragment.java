package com.bw.yq.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.yq.R;
import com.bw.yq.activity.OrderActivity;
import com.bw.yq.adapter.CartAdapter;
import com.bw.yq.base.BaseFragment;
import com.bw.yq.bean.Result;
import com.bw.yq.presenter.CartPresenter;
import com.bw.yq.view.CartView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
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
    @BindView(R.id.quan)
    CheckBox quan;
    @BindView(R.id.jiaqian)
    TextView jiaqian;
    @BindView(R.id.qujiesuan)
    Button qujiesuan;
    private double sum = 0.0;
    private SharedPreferences login;
    List<Result> list;
    private CartAdapter cartAdapter;
    // private int sum=0;

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
        //获取sessinid userid
        login = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        String sessionId = login.getString("sessionId", "");
        int userId = login.getInt("userId", 1);
        boolean aBoolean = login.getBoolean("登陆", false);
        Log.i("ddd", sessionId + "-------" + userId);
        //查询购物车
        CartPresenter presenter = new CartPresenter(this);
        if (aBoolean) {
            presenter.cart(sessionId, userId);
        } else {
            Toast.makeText(getActivity(), "no", Toast.LENGTH_SHORT).show();
            return;
        }


//管理器
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        cartRlv.setLayoutManager(manager);
        //结算
        qujiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sum != 0) {
                    Intent intent = new Intent(getActivity(), OrderActivity.class);
                    intent.putExtra("sum", sum);
                    Toast.makeText(getContext(), sum + "", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {

                    return;
                }

            }
        });

    }

    //返回数据
    @Override
    public void Cart(final List<Result> result) {
        Log.i("rrr", result.toString() + "xcvbsdfsdf");
        cartAdapter = new CartAdapter(getActivity(), result);
        cartRlv.setAdapter(cartAdapter);
        //总价
        cartAdapter.setOnZongjiaListenter(new CartAdapter.OnZongjiaListenter() {
            @Override
            public void getSum(List<Result> result) {
                double sums = 0.0;
                int ischeck = 0;
                for (int i = 0; i < result.size(); i++) {
                    boolean checd = result.get(i).isChecd();
                    if (checd) {
                        int count = result.get(i).getCount();
                        double price = result.get(i).getPrice();
                        sums += (double) count * price;
                        ischeck++;
                    }
                }
                if (ischeck == result.size()) {
                    quan.setChecked(true);


                } else {
                    quan.setChecked(false);
                }
                sum = sums;
                jiaqian.setText("总价:" + sum + "");

                list = new ArrayList<>();
                for (int i = 0; i < result.size(); i++) {
                    Result result1 = result.get(i);
                    boolean checd = result1.isChecd();
                    if (checd) {

                        list.add(result1);
                    }
                }

                EventBus.getDefault().postSticky(list);

            }

        });
        //全选反选
        quan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quan.isChecked()) {
                    for (int i = 0; i < result.size(); i++) {
                        result.get(i).setChecd(true);
                        int count = result.get(i).getCount();
                        double price = result.get(i).getPrice();
                        sum += ((double) count * price);
                    }
                    jiaqian.setText("总价:" + sum + "");

                } else {
                    for (int i = 0; i < result.size(); i++) {
                        result.get(i).setChecd(false);

                    }
                    sum = 0.0;
                    jiaqian.setText("总价:" + sum + "");


                }
                notifyDataSetChanged();
            }

        });


    }

    @Override
    public void onResume() {
        super.onResume();
        String sessionId = login.getString("sessionId", "");
        int userId = login.getInt("userId", 1);
        boolean aBoolean = login.getBoolean("登陆", false);
        Log.i("ddd", sessionId + "-------" + userId);
        //查询购物车
        CartPresenter presenter = new CartPresenter(this);
        if (aBoolean) {
            presenter.cart(sessionId, userId);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void notifyDataSetChanged() {
        cartAdapter.notifyDataSetChanged();
    }
}
