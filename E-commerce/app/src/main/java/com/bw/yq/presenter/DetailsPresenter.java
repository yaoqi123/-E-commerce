package com.bw.yq.presenter;

import com.bw.yq.base.BasePresenter;
import com.bw.yq.bean.Details;
import com.bw.yq.model.DetailsModel;
import com.bw.yq.view.DetailsView;

/**
 * @author yaoqi
 * @fileName DetailsPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/20 19:36
 */
public class DetailsPresenter extends BasePresenter<DetailsView> {

    private final DetailsModel detailsModel;

    public DetailsPresenter(DetailsView Details){
        detailsModel = new DetailsModel();
        super.attchs(Details);
    }
    public void details(int id) {
        detailsModel.send(id);
        detailsModel.setOnDetailsListenter(new DetailsModel.OnDetailsListenter() {
            @Override
            public void OnDetails(Details result) {
                details.Datails(result);
            }
        });
    }
}
