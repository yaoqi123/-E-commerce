package com.bw.yq.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.yq.R;
import com.bw.yq.activity.DetailsActivity;
import com.bw.yq.activity.QueryActivity;
import com.bw.yq.adapter.SearchAdapter;
import com.bw.yq.adapter.SecondAdapter;
import com.bw.yq.adapter.ShowAdapter;
import com.bw.yq.adapter.TowAdapter;
import com.bw.yq.base.BaseFragment;
import com.bw.yq.bean.Banner;
import com.bw.yq.bean.Cecond;
import com.bw.yq.bean.ShowBean;
import com.bw.yq.bean.Tow;
import com.bw.yq.presenter.HomePresenter;
import com.bw.yq.presenter.SearchPresenter;
import com.bw.yq.presenter.SecondPresenter;
import com.bw.yq.presenter.ShowPresenter;
import com.bw.yq.presenter.TowPresenter;
import com.bw.yq.view.BannerView;
import com.bw.yq.view.SeachView;
import com.bw.yq.view.SecondView;
import com.bw.yq.view.ShowView;
import com.bw.yq.view.TowView;
import com.bw.yq.wegit.Search;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Flowable;

/**
 * @author yaoqi
 * @fileName HomeFragment
 * @package com.bw.yq.fragment
 * @date 2019/3/12 14:38
 */
public class HomeFragment extends BaseFragment<SearchPresenter, HomePresenter, ShowPresenter, SecondPresenter> implements SeachView, BannerView, ShowView, SecondView, TowView {

    @BindView(R.id.home_search)
    Search homeSearch;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.li)
    LinearLayout li;
    @BindView(R.id.home_rlv)
    XRecyclerView homeRlv;
    @BindView(R.id.home_pager)
    XBanner homePager;
    @BindView(R.id.rlv1)
    RecyclerView rlv1;
    Unbinder unbinder;

    private String keyword = "板鞋";
    public int page = 1;
    public int count = 10;
    private RecyclerView rlv;
    private RecyclerView rlv11;


    @Override
    public SecondPresenter getSecondPresenter() {
        secondpresenter = new SecondPresenter(this);
        return secondpresenter;
    }

    @Override
    public ShowPresenter getShowPresenter() {
        showpresenter = new ShowPresenter(this);
        showpresenter.show();
        return showpresenter;
    }

    @Override
    public HomePresenter getHomePresenter() {

        homepresenter = new HomePresenter(HomeFragment.this);
        homepresenter.banner();
        return homepresenter;
    }

    @Override
    protected int layoutResID() {
        return R.layout.home_layout;
    }

    @Override
    public SearchPresenter getPresenter() {
        presenter = new SearchPresenter(HomeFragment.this);

        return presenter;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        homeRlv.setLayoutManager(manager);
        homeRlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });


    }


    @Override
    protected void getData() {

        homeSearch.setOnSearchListenter(new Search.OnSearchListenter() {
            @Override
            public void OnSearch(String name) {
                if (TextUtils.isEmpty(name)) {
                    homeRlv.setVisibility(View.GONE);
                    homePager.setVisibility(View.VISIBLE);
                    rlv1.setVisibility(View.VISIBLE);
                    return;
                }

                homeRlv.setVisibility(View.VISIBLE);

                keyword = name;

                presenter.search(keyword, page, count);
            }
        });
        homeSearch.setOnERjileibiaoListenter(new Search.OnERjileibiaoListenter() {
            @Override
            public void Erji() {
                Toast.makeText(getActivity(), "好好", Toast.LENGTH_SHORT).show();
                secondpresenter.second();
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void view(List<com.bw.yq.bean.Search> result) {
        if (result.size() == 0) {

            li.setVisibility(View.VISIBLE);

        } else {
            li.setVisibility(View.GONE);
            SearchAdapter searchAdapter = new SearchAdapter(getActivity(), result);
            homeRlv.setAdapter(searchAdapter);

        }


    }


    @Override
    public void Banner(final List<Banner> result) {
//        for (int i = 0; i < result.size(); i++) {
//            Log.i("xxxxx", result.get(i).imageUrl);
//        }

        homePager.setData(result, null);
        homePager.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(result.get(position).getImageUrl()).into((ImageView) view);
                homePager.setPageChangeDuration(3000);
            }
        });

    }


    @Override
    public void Show(ShowBean.ResultEntity result) {
        ShowAdapter showAdapter = new ShowAdapter(getActivity(), result);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rlv1.setLayoutManager(manager);
//        Log.i("xxxxx",result.getRxxp().getCommodityList().toString());
        rlv1.setAdapter(showAdapter);
    }


    @Override
    public void cond(List<Cecond> result) {
        View view = View.inflate(getActivity(), R.layout.pop_layout, null);
        RecyclerView rlv = view.findViewById(R.id.rlv);
        rlv11 = view.findViewById(R.id.pop_rlv1);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rlv.setLayoutManager(manager);
        SecondAdapter secondAdapter = new SecondAdapter(getActivity(), result);
        rlv.setAdapter(secondAdapter);
        PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, 150);
        // 点击pop外部，pop消失
        popupWindow.setOutsideTouchable(true);
        // pop必须设置背景色，否则无效果
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
        // pop里面的控件点击不了，因为没有焦点
        // 需要给pop设置焦点
        popupWindow.setFocusable(true);
        ImageView tu = homeSearch.findViewById(R.id.search_img);
        popupWindow.showAsDropDown(tu);


        secondAdapter.setOnZhanshiListenter(new SecondAdapter.OnZhanshiListenter() {
            @Override
            public void Onzhan(String id) {
                TowPresenter towPresenter = new TowPresenter(HomeFragment.this);
                towPresenter.tow(id);
            }
        });


    }

    @Override
    public void Tows(List<Tow> result) {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rlv11.setLayoutManager(manager);
        TowAdapter towAdapter = new TowAdapter(getActivity(), result);
        rlv11.setAdapter(towAdapter);
        towAdapter.setOnQueryListenter(new TowAdapter.OnQueryListenter() {
            @Override
            public void Onquery(String id) {
                Intent intent = new Intent(getActivity(), QueryActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

    }
}
