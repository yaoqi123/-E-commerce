package com.bw.yq.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.yq.R;
import com.bw.yq.base.BaseFragment;
import com.bw.yq.presenter.SearchPresenter;
import com.bw.yq.wegit.Search;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author yaoqi
 * @fileName HomeFragment
 * @package com.bw.yq.fragment
 * @date 2019/3/12 14:38
 */
public class HomeFragment extends BaseFragment<SearchPresenter> {

    @BindView(R.id.home_search)
    Search homeSearch;
    @BindView(R.id.home_pager)
    ViewPager homePager;
    @BindView(R.id.home_rlv)
    RecyclerView homeRlv;
    Unbinder unbinder;
    private String keyword = "板鞋";
    public int page=1;
    public int count=10;


    @Override
    protected int layoutResID() {
        return R.layout.home_layout;
    }

    @Override
    public SearchPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    protected void getData() {
        homeSearch.setOnSearchListenter(new Search.OnSearchListenter() {
            @Override
            public void OnSearch(String name) {
                keyword = name;
                SearchPresenter searchPresenter = new SearchPresenter();
                searchPresenter.search(keyword,page,count);
            }
        });
    }






    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
