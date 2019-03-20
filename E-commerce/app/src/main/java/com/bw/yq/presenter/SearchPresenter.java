package com.bw.yq.presenter;

import com.bw.yq.model.SearchModel;

/**
 * @author yaoqi
 * @fileName SearchPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/19 13:49
 */
public class SearchPresenter {

    private final SearchModel searchModel;

    public SearchPresenter(){

        searchModel = new SearchModel();
    }
    public void search(String keyword, int count, int page) {
        searchModel.send(keyword,page,count);
    }
}
