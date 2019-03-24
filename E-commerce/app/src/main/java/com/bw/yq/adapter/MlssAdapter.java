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
 * @fileName MlssAdapter
 * @package com.bw.yq.adapter
 * @date 2019/3/21 14:24
 */
public class MlssAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ShowBean.ResultEntity.MlssEntity.CommodityListEntity> commodityList;


    public MlssAdapter(Context context, List<ShowBean.ResultEntity.MlssEntity.CommodityListEntity> commodityList) {
        this.context = context;
        this.commodityList = commodityList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mlss, null, false);
        MyMlssViewHolder myMlssViewHolder=new MyMlssViewHolder(view);
        return myMlssViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ShowBean.ResultEntity.MlssEntity.CommodityListEntity commodityListEntity = commodityList.get(i);
        String commodityName = commodityListEntity.getCommodityName();
        String masterPic = commodityListEntity.getMasterPic();
        int price = commodityListEntity.getPrice();
        final int  commodityId = commodityListEntity.getCommodityId();
        ((MyMlssViewHolder) viewHolder).tv2.setText(commodityName);
        ((MyMlssViewHolder) viewHolder).price.setText("$:"+price);
        ((MyMlssViewHolder) viewHolder).sdv.setImageURI(Uri.parse(masterPic));
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

    private class MyMlssViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv2;
        private final SimpleDraweeView sdv;
        private final TextView price;

        public MyMlssViewHolder(@NonNull View itemView) {
            super(itemView);
            tv2 = itemView.findViewById(R.id.mlss_tv2);
            sdv = itemView.findViewById(R.id.mlss_sdv);
            price = itemView.findViewById(R.id.mlss_price);
        }
    }
}
