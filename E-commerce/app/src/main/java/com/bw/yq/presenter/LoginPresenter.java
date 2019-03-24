package com.bw.yq.presenter;

import com.bw.yq.base.BasePresenter;
import com.bw.yq.bean.LoginBean;
import com.bw.yq.model.LoginModel;
import com.bw.yq.view.LoginView;

/**
 * @author yaoqi
 * @fileName LoginPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/22 9:15
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    private final LoginModel loginModel;

    public LoginPresenter(LoginView landing){
        loginModel = new LoginModel();
        super.Login(landing);
    }
    public void Login(String phone, String pad) {
        loginModel.send(phone,pad);
        loginModel.setOnLoginModelListenter(new LoginModel.OnLoginModelListenter() {
            @Override
            public void Logins(LoginBean loginBean) {
                landing.landing(loginBean);
            }
        });
    }
}
