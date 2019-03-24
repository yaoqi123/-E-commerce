package com.bw.yq.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.yq.R;
import com.bw.yq.activity.DetailsActivity;
import com.bw.yq.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author yaoqi
 * @fileName ShowsAdapter
 * @package com.bw.yq.adapter
 * @date 2019/3/21 11:20
 */
public class ShowsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ShowBean.ResultEntity.RxxpEntity.CommodityListEntity> commodityList;
//    private int commodityId;

    public ShowsAdapter(Context context, List<ShowBean.ResultEntity.RxxpEntity.CommodityListEntity> commodityList) {
        this.context = context;
        this.commodityList = commodityList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item1_layout, null, false);
        MyViewHolder1 myViewHolder1 = new MyViewHolder1(view);

        return myViewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ShowBean.ResultEntity.RxxpEntity.CommodityListEntity commodityListEntity = commodityList.get(i);
        String masterPic = commodityListEntity.getMasterPic();
        String commodityName = commodityListEntity.getCommodityName();
        final int commodityId = commodityListEntity.getCommodityId();
        int price = commodityListEntity.getPrice();
        ((MyViewHolder1) viewHolder).simp.setImageURI(Uri.parse(masterPic));
        ((MyViewHolder1) viewHolder).tv1.setText(commodityName);
        ((MyViewHolder1) viewHolder).price.setText("$:" + price);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("id", commodityId);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return commodityList.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simp;
        private final TextView tv1;
        private final TextView price;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            simp = itemView.findViewById(R.id.show_simp);
            tv1 = itemView.findViewById(R.id.show_tv1);
            price = itemView.findViewById(R.id.show_price);
        }
    }
}
