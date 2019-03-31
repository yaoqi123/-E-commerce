package com.bw.yq.presenter;

import com.bw.yq.base.BasePresenter;
import com.bw.yq.bean.AddBean;
import com.bw.yq.bean.Details;
import com.bw.yq.model.AddModel;
import com.bw.yq.model.DetailsModel;
import com.bw.yq.view.AddView;
import com.bw.yq.view.DetailsView;

/**
 * @author yaoqi
 * @fileName DetailsPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/20 19:36
 */
public class DetailsPresenter extends BasePresenter<DetailsView> {

    private final DetailsModel detailsModel;
    private final AddModel addModel;
    private final AddView addView;

    public DetailsPresenter(DetailsView Details, AddView add){
        detailsModel = new DetailsModel();
        addModel = new AddModel();
        addView = add;


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

    public void add(String sessionId, String json, int userId) {
        addModel.send(json,sessionId,userId);
        addModel.setOnAddListenter(new AddModel.OnAddListenter() {
            @Override
            public void Add(AddBean addBean) {
                addView.add(addBean);
            }
        });
    }


}
