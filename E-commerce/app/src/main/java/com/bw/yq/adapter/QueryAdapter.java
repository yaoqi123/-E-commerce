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
import com.bw.yq.bean.Querys;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author yaoqi
 * @fileName QueryAdapter
 * @package com.bw.yq.adapter
 * @date 2019/3/23 15:47
 */
public class QueryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Querys> result;

    public QueryAdapter(Context context, List<Querys> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.query_layout, null, false);
        MyQueryViewHolder myQueryViewHolder=new MyQueryViewHolder(view);
        return myQueryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyQueryViewHolder myQueryViewHolder= (MyQueryViewHolder) viewHolder;
        Querys querys = result.get(i);
        final int commodityId = querys.getCommodityId();
        String commodityName = querys.getCommodityName();
        String masterPic = querys.getMasterPic();
        String price = querys.getPrice();
        myQueryViewHolder.ev1.setText("价钱:"+price);
        myQueryViewHolder.ev2.setText(commodityName);
        myQueryViewHolder.sdv.setImageURI(Uri.parse(masterPic));
        myQueryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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
        return result.size();
    }

    public class MyQueryViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView ev1;
        private final TextView ev2;

        public MyQueryViewHolder(@NonNull View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.query_sdv);
            ev1 = itemView.findViewById(R.id.query_ev1);
            ev2 = itemView.findViewById(R.id.query_ev2);
        }
    }
}
