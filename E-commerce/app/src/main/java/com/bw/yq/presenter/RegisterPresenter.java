package com.bw.yq.presenter;

import com.bw.yq.base.BasePresenter;
import com.bw.yq.bean.Register;
import com.bw.yq.model.RegisterModel;
import com.bw.yq.view.RegisterView;

/**
 * @author yaoqi
 * @fileName RegisterPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/22 18:57
 */
public class RegisterPresenter extends BasePresenter<RegisterView> {

    private final RegisterModel registerModel;

    public RegisterPresenter(RegisterView regis){
        registerModel = new RegisterModel();
        super.Regis(regis);
    }
    public void register(String phone, String pwd) {
        registerModel.send(phone,pwd);
        registerModel.setOnRegisterModelListenter(new RegisterModel.OnRegisterModelListenter() {
            @Override
            public void Reis(Register register) {
                regis.register(register);
            }
        });
    }
}
