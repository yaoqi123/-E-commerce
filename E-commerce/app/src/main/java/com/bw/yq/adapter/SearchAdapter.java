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
import com.bw.yq.bean.Search;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * @author yaoqi
 * @fileName SearchAdapter
 * @package com.bw.yq.adapter
 * @date 2019/3/20 14:09
 */
public class SearchAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
    private Context context;
    private List<Search> result;
    public interface OnsItemClickListenter{
        void ItemClick(String commodityId);
    }
public OnsItemClickListenter itemClickListenter;
    public void setOnsItemClickListenter(OnsItemClickListenter itemClickListenter){
        this.itemClickListenter=itemClickListenter;
    }
    public SearchAdapter(Context context, List<Search> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_item, null, false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
        Search search = result.get(i);
        final String commodityId = search.getCommodityId();
        String commodityName = search.getCommodityName();
        String masterPic = search.getMasterPic();
        String price = search.getPrice();
        myViewHolder.tv2.setText(commodityName);
        myViewHolder.tv1.setText("$:"+price);
        myViewHolder.tu.setImageURI(Uri.parse(masterPic));
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(commodityId);
                Intent intent = new Intent(context, DetailsActivity.class);
                 intent.putExtra("id", id);
                 context.startActivity(intent);
//                itemClickListenter.ItemClick(commodityId);
            }
        });

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends XRecyclerView.ViewHolder {

        private final SimpleDraweeView tu;
        private final TextView tv1;
        private final TextView tv2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tu = itemView.findViewById(R.id.tu);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);

        }
    }
}
