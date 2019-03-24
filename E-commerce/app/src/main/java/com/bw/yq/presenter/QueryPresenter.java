package com.bw.yq.presenter;


import com.bw.yq.base.BasePresenter;
import com.bw.yq.bean.Querys;
import com.bw.yq.model.QueryModel;
import com.bw.yq.view.QueryView;

import java.util.List;

/**
 * @author yaoqi
 * @fileName QueryPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/23 15:15
 */
public class QueryPresenter extends BasePresenter<QueryView> {

    private final QueryModel queryModel;

    public QueryPresenter(QueryView querys){
        queryModel = new QueryModel();
        super.Querys(querys);

    }

    public void query(String id) {
        queryModel.send(id);
        queryModel.setOnQueryListenter(new QueryModel.OnQueryListenter() {
            @Override
            public void Querys(List<Querys> result) {
                querys.Query(result);
            }
        });
    }
}
