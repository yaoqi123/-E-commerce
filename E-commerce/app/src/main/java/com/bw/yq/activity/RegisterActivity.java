package com.bw.yq.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.yq.R;
import com.bw.yq.base.BaseActivity;
import com.bw.yq.bean.Register;
import com.bw.yq.presenter.RegisterPresenter;
import com.bw.yq.view.RegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterView {


    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.yan)
    EditText yan;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.tiao)
    TextView tiao;
    @BindView(R.id.zc)
    Button zc;

    @Override
    public RegisterPresenter getPresenter() {
        presenter = new RegisterPresenter(this);
        return presenter;
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {
   zc.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           String phone = name.getText().toString().trim();
           String pwd = pass.getText().toString().trim();
           if (TextUtils.isEmpty(phone)&&TextUtils.isEmpty(pwd)){
               Toast.makeText(RegisterActivity.this, "不能为空", Toast.LENGTH_SHORT).show();



           }
           presenter.register(phone,pwd);
       }
   });
   tiao.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           finish();
       }
   });


    }


    @Override
    public void register(Register register) {
        String message = register.getMessage();
        Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show();
    }
}
