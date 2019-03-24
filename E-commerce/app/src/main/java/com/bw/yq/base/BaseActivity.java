package com.bw.yq.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @author yaoqi
 * @fileName BaseActivity
 * @package com.bw.yq.base
 * @date 2019/3/18 13:42
 */
public abstract class BaseActivity<V> extends AppCompatActivity {

    public V presenter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResID());
        ButterKnife.bind(this);
        presenter = getPresenter();


        initView();
        getData();
    }




    public abstract V getPresenter();


    protected abstract int layoutResID();

    protected abstract void initView();

    protected abstract void getData();

}
