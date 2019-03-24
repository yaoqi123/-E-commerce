package com.bw.yq.presenter;

import com.bw.yq.base.BasePresenter;
import com.bw.yq.bean.Tow;
import com.bw.yq.model.TowModel;
import com.bw.yq.view.TowView;

import java.util.List;

/**
 * @author yaoqi
 * @fileName TowPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/23 11:48
 */
public class TowPresenter extends BasePresenter<TowView> {

    private final TowModel towModel;

    public TowPresenter(TowView tows){
        towModel = new TowModel();
        super.Tows(tows);
    }
    public void tow(String id) {
        towModel.send(id);
        towModel.setOnTowModelListenter(new TowModel.OnTowModelListenter() {
            @Override
            public void OnTow(List<Tow> result) {
                tows.Tows(result);
            }
        });
    }
}
