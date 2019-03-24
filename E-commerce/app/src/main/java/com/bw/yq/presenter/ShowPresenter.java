package com.bw.yq.presenter;

import com.bw.yq.base.BasePresenter;
import com.bw.yq.bean.ShowBean;
import com.bw.yq.model.ShowModel;
import com.bw.yq.view.ShowView;

/**
 * @author yaoqi
 * @fileName ShowPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/21 9:30
 */
public class ShowPresenter extends BasePresenter<ShowView> {

    private final ShowModel showModel;

    public ShowPresenter(ShowView show){
        showModel = new ShowModel();
        super.shows(show);
    }
    public void show() {
        showModel.send();
        showModel.setOnShowModelListenter(new ShowModel.OnShowModelListenter() {
            @Override
            public void Show(ShowBean.ResultEntity result) {
                show.Show(result);
            }
        });
    }
}
