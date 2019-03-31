package com.bw.yq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.yq.R;
import com.bw.yq.adapter.QueryAdapter;
import com.bw.yq.base.BaseActivity;
import com.bw.yq.bean.Querys;
import com.bw.yq.presenter.QueryPresenter;
import com.bw.yq.view.QueryView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QueryActivity extends BaseActivity<QueryPresenter> implements QueryView {


    @BindView(R.id.query_rlv)
    RecyclerView queryRlv;

    @Override
    public QueryPresenter getPresenter() {
        presenter = new QueryPresenter(this);
        return presenter;
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_query;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        presenter.query(id);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        queryRlv.setLayoutManager(manager);


    }


    @Override
    public void Query(List<Querys> result) {
        QueryAdapter adapter = new QueryAdapter(this, result);
        queryRlv.setAdapter(adapter);
    }
}
