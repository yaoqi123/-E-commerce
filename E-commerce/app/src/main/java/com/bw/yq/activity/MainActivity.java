package com.bw.yq.activity;

import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.yq.R;
import com.bw.yq.base.BaseActivity;
import com.bw.yq.fragment.CartFragment;
import com.bw.yq.fragment.ClassificationFragment;
import com.bw.yq.fragment.HomeFragment;
import com.bw.yq.fragment.MyFragment;
import com.bw.yq.fragment.OrderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.fram)
    FrameLayout fram;
    @BindView(R.id.radio0)
    RadioButton radio0;
    @BindView(R.id.radio1)
    RadioButton radio1;
    @BindView(R.id.radio2)
    RadioButton radio2;
    @BindView(R.id.radio3)
    RadioButton radio3;
    @BindView(R.id.radio4)
    RadioButton radio4;
    @BindView(R.id.group)
    RadioGroup group;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private CartFragment cartFragment;
    private ClassificationFragment classificationFragment;
    private HomeFragment homeFragment;
    private MyFragment fragment;
    private OrderFragment orderFragment;



    @Override
    public Object getPresenter() {
        return null;
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

    }

    @Override
    protected void getData() {
        cartFragment = new CartFragment();
        classificationFragment = new ClassificationFragment();
        homeFragment = new HomeFragment();
        fragment = new MyFragment();
        orderFragment = new OrderFragment();
        transaction.add(R.id.fram,homeFragment);
        transaction.add(R.id.fram,orderFragment);
        transaction.add(R.id.fram,cartFragment);
        transaction.add(R.id.fram,classificationFragment);
        transaction.add(R.id.fram,fragment);
        transaction.show(homeFragment).hide(cartFragment).hide(classificationFragment).hide(orderFragment).hide(fragment);
 transaction.commit();
 group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
     @Override
     public void onCheckedChanged(RadioGroup group, int checkedId) {
         FragmentTransaction transaction1 = manager.beginTransaction();
         switch (checkedId){
             case R.id.radio0:
                 transaction1.show(homeFragment).hide(cartFragment).hide(classificationFragment).hide(orderFragment).hide(fragment).commit();
                 break;
             case R.id.radio1:
                 transaction1.show(classificationFragment).hide(cartFragment).hide(homeFragment).hide(orderFragment).hide(fragment).commit();
                 break;
             case R.id.radio2:
                 transaction1.show(cartFragment).hide(homeFragment).hide(classificationFragment).hide(orderFragment).hide(fragment).commit();
                 break;
             case R.id.radio3:
                 transaction1.show(orderFragment).hide(cartFragment).hide(classificationFragment).hide(homeFragment).hide(fragment).commit();
                 break;
             case R.id.radio4:
                 transaction1.show(fragment).hide(cartFragment).hide(classificationFragment).hide(orderFragment).hide(homeFragment).commit();
                 break;


         }
     }
 });


    }


}
