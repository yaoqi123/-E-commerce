package com.bw.yq.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.yq.R;
import com.bw.yq.bean.Result;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author yaoqi
 * @fileName CartAdapter
 * @package com.bw.yq.adapter
 * @date 2019/3/24 15:07
 */
public class CartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Result> result;

    public CartAdapter(Context context, List<Result> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item, null, false);
        MyCartViewHolder myCartViewHolder=new MyCartViewHolder(view);
        return myCartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyCartViewHolder myCartViewHolder= (MyCartViewHolder) viewHolder;
        Result result = this.result.get(i);
        int commodityId = result.getCommodityId();
        String commodityName = result.getCommodityName();
        String pic = result.getPic();
        String price = result.getPrice();
        myCartViewHolder.ev1.setText(commodityName);
        myCartViewHolder.tv2.setText("价钱:"+price);
        myCartViewHolder.sdv.setImageURI(Uri.parse(pic));

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyCartViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView ev1;
        private final TextView tv2;

        public MyCartViewHolder(@NonNull View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.cart_sdv);
            ev1 = itemView.findViewById(R.id.cart_tv1);
            tv2 = itemView.findViewById(R.id.cart_tv2);
        }
    }
}
