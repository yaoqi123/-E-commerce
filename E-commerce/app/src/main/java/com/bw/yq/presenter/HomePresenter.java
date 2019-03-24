package com.bw.yq.presenter;

import com.bw.yq.base.BasePresenter;
import com.bw.yq.bean.Banner;
import com.bw.yq.model.HomeModel;
import com.bw.yq.view.BannerView;

import java.util.List;

/**
 * @author yaoqi
 * @fileName HomePresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/20 20:17
 */
public class HomePresenter extends BasePresenter<BannerView> {

    private final HomeModel homeModel;

    public HomePresenter(BannerView Banner){
        homeModel = new HomeModel();
       super.banner(Banner);
    }
    public void banner() {
        homeModel.banner();
        homeModel.setOnHomeModelListenter(new HomeModel.OnHomeModelListenter() {
            @Override
            public void Home(List<Banner> result) {
                banner.Banner(result);
            }
        });

    }
}
