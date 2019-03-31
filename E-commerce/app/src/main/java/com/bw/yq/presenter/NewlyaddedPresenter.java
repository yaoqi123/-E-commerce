package com.bw.yq.presenter;

import com.bw.yq.bean.NewBean;
import com.bw.yq.model.NewlyaddedModel;
import com.bw.yq.view.NewLyaddedView;

/**
 * @author yaoqi
 * @fileName NewlyaddedPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/29 9:14
 */
public class NewlyaddedPresenter {

    private final NewlyaddedModel newlyaddedModel;
    private final NewLyaddedView newLyaddedView;

    public NewlyaddedPresenter(NewLyaddedView news){
        newlyaddedModel = new NewlyaddedModel();
        newLyaddedView = news;
    }
    public void New(int userId, String sessionId, String realName, String phone, String address, String zipCode) {
        newlyaddedModel.send(userId,sessionId,realName,phone,address,zipCode);
        newlyaddedModel.setOnNewlyaddedModelListenter(new NewlyaddedModel.OnNewlyaddedModelListenter() {
            @Override
            public void newlyadded(NewBean newBean) {
                newLyaddedView.Newly(newBean);
            }
        });

    }
}
