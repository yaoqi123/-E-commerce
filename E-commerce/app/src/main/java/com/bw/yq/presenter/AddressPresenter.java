package com.bw.yq.presenter;

import com.bw.yq.bean.Address;
import com.bw.yq.bean.MorenBean;
import com.bw.yq.model.AddressIdModel;
import com.bw.yq.model.AddressModel;
import com.bw.yq.view.AddressView;
import com.bw.yq.view.MorenView;

import java.util.ArrayList;

/**
 * @author yaoqi
 * @fileName AddressPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/28 20:28
 */
public class AddressPresenter {
//地址
    private final AddressModel addressModel;

    private final AddressView addressView;
    //默认地址
    private AddressIdModel addressIdModel;
    private  MorenView morenView;

    public AddressPresenter(AddressView address, MorenView moren){
        addressModel = new AddressModel();
        addressIdModel = new AddressIdModel();
        addressView = address;
        morenView = moren;
    }
    //默认地址
    public AddressPresenter(AddressView address){

        addressModel = new AddressModel();

        addressView = address;
    }
    public void address(String sessionId, int userId) {

        addressModel.send(sessionId,userId);
        addressModel.setOnAddressModelListenter(new AddressModel.OnAddressModelListenter() {
            @Override
            public void Address(ArrayList<Address> result) {
                addressView.Address(result);
            }
        });
    }

    public void add(String sessionId, int userId, int id) {
        addressIdModel.send(sessionId,userId,id);
        addressIdModel.setOnAddressIdListenter(new AddressIdModel.OnAddressIdListenter() {
            @Override
            public void OnsId(MorenBean morenBean) {
                morenView.moren(morenBean);
            }
        });
    }
}
