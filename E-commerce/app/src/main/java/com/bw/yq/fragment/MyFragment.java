package com.bw.yq.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.yq.R;
import com.bw.yq.activity.LoginActivity;
import com.bw.yq.base.BaseFragment;
import com.bw.yq.bean.Login;
import com.bw.yq.bean.LoginBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author yaoqi
 * @fileName MyFragment
 * @package com.bw.yq.fragment
 * @date 2019/3/12 14:40
 */
public class MyFragment extends BaseFragment {

    @BindView(R.id.my_head)
    SimpleDraweeView myHead;
    @BindView(R.id.my_name)
    TextView myName;
    @BindView(R.id.my_data)
    TextView myData;
    @BindView(R.id.my_circle)
    TextView myCircle;
    @BindView(R.id.my_footprint)
    TextView myFootprint;
    @BindView(R.id.my_wallet)
    TextView myWallet;
    @BindView(R.id.my_address)
    TextView myAddress;
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
        return R.layout.my_layout;
    }

    @Override
    public Object getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);

    }

    @Override
    protected void getData() {
         myHead.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getActivity(), LoginActivity.class);
                 startActivity(intent);
             }
         });


    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(LoginBean loginBean){
        Login result = loginBean.getResult();
        String nickName = result.getNickName();
        String headPic = result.getHeadPic();
        myHead.setImageURI(Uri.parse(headPic));
        myName.setText(nickName);

    }
}
