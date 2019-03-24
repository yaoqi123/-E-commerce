package com.bw.yq.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
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
 * @fileName PzshApapter
 * @package com.bw.yq.adapter
 * @date 2019/3/21 14:02
 */
public class PzshApapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ShowBean.ResultEntity.PzshEntity.CommodityListEntity> commodityList;


    public PzshApapter(Context context, List<ShowBean.ResultEntity.PzshEntity.CommodityListEntity> commodityList) {
        this.context = context;
        this.commodityList = commodityList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pzsh_item, null, false);
        MyPzshMyViewHolder myPzshMyViewHolder=new MyPzshMyViewHolder(view);
        return myPzshMyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ShowBean.ResultEntity.PzshEntity.CommodityListEntity commodityListEntity = commodityList.get(i);
        String commodityName = commodityListEntity.getCommodityName();
        final int commodityId = commodityListEntity.getCommodityId();
        String masterPic = commodityListEntity.getMasterPic();
        int price = commodityListEntity.getPrice();
        ((MyPzshMyViewHolder) viewHolder).textView.setText(commodityName);
        ((MyPzshMyViewHolder) viewHolder).price.setText("$:"+price);
        ((MyPzshMyViewHolder) viewHolder).sdv.setImageURI(Uri.parse(masterPic));
        ((MyPzshMyViewHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
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

    private class   MyPzshMyViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final TextView price;
        private final SimpleDraweeView sdv;

        public MyPzshMyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.pzsh_tilit);
            price = itemView.findViewById(R.id.pzsh_price);
            sdv = itemView.findViewById(R.id.pzsh_sdv);

        }
    }
}
