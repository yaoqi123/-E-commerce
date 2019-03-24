package com.bw.yq.presenter;

import com.bw.yq.base.BasePresenter;
import com.bw.yq.bean.Search;
import com.bw.yq.model.SearchModel;
import com.bw.yq.view.SeachView;

import java.util.List;

/**
 * @author yaoqi
 * @fileName SearchPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/19 13:49
 */
public class SearchPresenter extends BasePresenter<SeachView> {

    private final SearchModel searchModel;

    public SearchPresenter(SeachView view){

        searchModel = new SearchModel();
       super.attch(view);
    }
    public void search(String keyword, int count, int page) {
        searchModel.send(keyword,page,count);
        searchModel.setOnSeachModelListenter(new SearchModel.OnSeachModelListenter() {
            @Override
            public void seach(List<Search> result) {
                view.view(result);
            }
        });
    }
}
