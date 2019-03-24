package com.bw.yq.presenter;

import android.support.v7.widget.CardView;

import com.bw.yq.base.BasePresenter;
import com.bw.yq.bean.Result;
import com.bw.yq.model.CartModel;
import com.bw.yq.view.CartView;

import java.util.List;

/**
 * @author yaoqi
 * @fileName CartPresenter
 * @package com.bw.yq.presenter
 * @date 2019/3/24 14:08
 */
public class CartPresenter extends BasePresenter<CartView> {

    private final CartModel cartModel;

    public CartPresenter(CartView cart){
        cartModel = new CartModel();
        super.Carts(cart);

    }
    public void cart(String sessionId, int userId) {
        cartModel.send(sessionId,userId);
        cartModel.setOnCartModelListenter(new CartModel.OnCartModelListenter() {
            @Override
            public void OnCart(List<Result> result) {
                cart.Cart(result);
            }
        });
    }
}
