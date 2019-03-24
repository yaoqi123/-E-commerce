package com.bw.yq.presenter;

import com.bw.yq.base.BasePresenter;
import com.bw.yq.bean.Cecond;
import com.bw.yq.model.SecondModel;
import com.bw.yq.view.SecondView;

import java.util.List;

/**
 * @author yaoqi
 * @fileName SecondPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/22 20:07
 */
public class SecondPresenter extends BasePresenter<SecondView> {

    private final SecondModel secondModel;

    public SecondPresenter(SecondView second){
        secondModel = new SecondModel();
        super.Second(second);

    }
    public void second() {
        secondModel.send();
        secondModel.setOnSecondListenter(new SecondModel.OnSecondListenter() {
            @Override
            public void second(List<Cecond> result) {
                second.cond(result);
            }
        });
    }
}
