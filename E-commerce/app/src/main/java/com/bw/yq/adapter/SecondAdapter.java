package com.bw.yq.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.yq.R;
import com.bw.yq.bean.Cecond;

import java.util.List;

/**
 * @author yaoqi
 * @fileName SecondAdapter
 * @package com.bw.yq.adapter
 * @date 2019/3/22 21:12
 */
public class SecondAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Cecond> result;


    public interface OnZhanshiListenter{
        void Onzhan(String id);
    }
    public OnZhanshiListenter zhanshiListenter;
    public void setOnZhanshiListenter(OnZhanshiListenter zhanshiListenter){
        this.zhanshiListenter=zhanshiListenter;
    }

    public SecondAdapter(Context context, List<Cecond> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.second_item, null, false);
        MySecondViewHolder mySecondViewHolder=new MySecondViewHolder(view);
        return mySecondViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        MySecondViewHolder mySecondViewHolder= (MySecondViewHolder) viewHolder;
        Cecond cecond = result.get(i);
        String name = cecond.getName();

        mySecondViewHolder.pop.setText(name);
        mySecondViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zhanshiListenter!=null){
                    zhanshiListenter.Onzhan(result.get(i).getId());
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    private class MySecondViewHolder extends RecyclerView.ViewHolder {

        private final TextView pop;

        public MySecondViewHolder(@NonNull View itemView) {
            super(itemView);
            pop = itemView.findViewById(R.id.pop_tv1);
        }
    }
}
