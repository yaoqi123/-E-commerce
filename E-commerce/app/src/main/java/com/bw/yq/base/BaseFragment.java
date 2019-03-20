package com.bw.yq.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author yaoqi
 * @fileName BaseFragment
 * @package com.bw.yq.base
 * @date 2019/3/20 10:03
 */
public abstract class BaseFragment<T> extends Fragment {

    public T presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(layoutResID(), container, false);


        initView(view);
        presenter = getPresenter();
        getData();
        return view;
    }


    protected abstract int layoutResID();

    public abstract T getPresenter();

    protected abstract void initView(View view);

    protected abstract void getData();
}
