package com.bw.yq.presenter;

import com.bw.yq.model.OrderModel;

/**
 * @author yaoqi
 * @fileName OrderPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/29 21:14
 */
public class OrderPresenter {

    private final OrderModel orderModel;

    public OrderPresenter(){
        orderModel = new OrderModel();

    }
    public void order(int userId, String sessionId, String json1, double sum, int id) {
        orderModel.send(userId,sessionId,json1,sum,id);

    }
}
