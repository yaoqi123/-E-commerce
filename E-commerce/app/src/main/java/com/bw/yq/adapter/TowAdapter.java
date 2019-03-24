package com.bw.yq.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.yq.R;
import com.bw.yq.bean.Tow;

import java.util.List;

/**
 * @author yaoqi
 * @fileName TowAdapter
 * @package com.bw.yq.adapter
 * @date 2019/3/23 14:38
 */
public class TowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Tow> result;
public interface OnQueryListenter{
    void Onquery(String id);
}
public OnQueryListenter queryListenter;
public void setOnQueryListenter(OnQueryListenter queryListenter){
    this.queryListenter=queryListenter;
}




    public TowAdapter(Context context, List<Tow> result) {
        this.context = context;
        this.result = result;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tow_layout, null, false);
        MyTowViewHolder myTowViewHolder=new MyTowViewHolder(view);
        return myTowViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
MyTowViewHolder myTowViewHolder= (MyTowViewHolder) viewHolder;
        Tow tow = result.get(i);

        final String name = tow.getName();
        myTowViewHolder.tow.setText(name);
        myTowViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                queryListenter.Onquery(result.get(i).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyTowViewHolder extends RecyclerView.ViewHolder {

        private final TextView tow;

        public MyTowViewHolder(@NonNull View itemView) {
            super(itemView);
            tow = itemView.findViewById(R.id.tow_tv1);
        }
    }
}
