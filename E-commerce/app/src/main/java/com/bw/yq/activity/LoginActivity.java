package com.bw.yq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.yq.R;
import com.bw.yq.base.BaseActivity;
import com.bw.yq.bean.Login;
import com.bw.yq.bean.LoginBean;
import com.bw.yq.presenter.LoginPresenter;
import com.bw.yq.uitls.Judgment;
import com.bw.yq.view.LoginView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {


    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.login_layout)
    RelativeLayout loginLayout;
    @BindView(R.id.userpass)
    EditText userpass;
    @BindView(R.id.jizhu)
    CheckBox jizhu;
    @BindView(R.id.zhuce)
    TextView zhuce;
    @BindView(R.id.deng)
    Button deng;

    @Override
    public LoginPresenter getPresenter() {
        presenter = new LoginPresenter(this);
        return presenter;
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {
 deng.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         String phone = username.getText().toString().trim();
         String pad = userpass.getText().toString().trim();
         boolean mobileNO = Judgment.isMobileNO(phone);
         if (!mobileNO){
             Toast.makeText(LoginActivity.this, "手机格式不正确", Toast.LENGTH_SHORT).show();
             return;
         }
         if(pad.length()<3){
             Toast.makeText(LoginActivity.this, "密码长度不能小于三", Toast.LENGTH_SHORT).show();
             return;
         }
         presenter.Login(phone,pad);
     }
 });
zhuce.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
});


    }


    @Override
    public void landing(LoginBean loginBean) {
        Login result = loginBean.getResult();
        String sessionId = result.getSessionId();
        int userId = result.getUserId();
        String headPic = result.getHeadPic();
        String nickName = result.getNickName();
        SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("登陆",true);
        edit.putString("sessionId",sessionId);
        edit.putInt("userId",userId);
        edit.commit();
        EventBus.getDefault().post(loginBean);
        finish();
    }
}
