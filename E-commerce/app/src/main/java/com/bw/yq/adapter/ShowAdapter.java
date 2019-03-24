package com.bw.yq.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.yq.R;
import com.bw.yq.bean.ShowBean;

import java.util.List;

/**
 * @author yaoqi
 * @fileName ShowAdapter
 * @package com.bw.yq.adapter
 * @date 2019/3/21 11:02
 */
public class ShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ShowBean.ResultEntity result;
    private static final int ONE=0;
    private static final int TWO=1;
    private static final int THERR=2;



    public ShowAdapter(Context context, ShowBean.ResultEntity result) {
        this.context = context;
        this.result = result;
        Log.i("sasss" ,result.toString());
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return ONE;
        }else if (position==1){
            return TWO;
        }else{
            return THERR;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==ONE){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.show_item, null, false);
            MyViewHolder1 myViewHolder1=new MyViewHolder1(view);
            return myViewHolder1;
        }else if(i==TWO){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pzsh, null, false);
           MyViewHolder2 myViewHolder2=new MyViewHolder2(view);
            return myViewHolder2;
        }else{
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mlss_item, null, false);
          MyViewHolder3 myViewHolder3=new MyViewHolder3(view);
            return myViewHolder3;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int type = getItemViewType(i);
        if (type==ONE){
            MyViewHolder1 myViewHolder1= (MyViewHolder1) viewHolder;
            ShowBean.ResultEntity.RxxpEntity rxxp = result.getRxxp();
            String name = rxxp.getName();
            List<ShowBean.ResultEntity.RxxpEntity.CommodityListEntity> commodityList = rxxp.getCommodityList();
            myViewHolder1.show.setText(name);
            LinearLayoutManager manager=new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            myViewHolder1.rlv.setLayoutManager(manager);
            ShowsAdapter showsAdapter = new ShowsAdapter(context, commodityList);
            myViewHolder1.rlv.setAdapter(showsAdapter);

        }else if(type==TWO){
            MyViewHolder2 myViewHolder2= (MyViewHolder2) viewHolder;
            ShowBean.ResultEntity.PzshEntity pzsh = result.getPzsh();
            String name = pzsh.getName();
            List<ShowBean.ResultEntity.PzshEntity.CommodityListEntity> commodityList = pzsh.getCommodityList();
            myViewHolder2.tv1.setText(name);
            LinearLayoutManager manager=new LinearLayoutManager(context);
            myViewHolder2.rlv.setLayoutManager(manager);
            PzshApapter pzshApapter = new PzshApapter(context, commodityList);
            myViewHolder2.rlv.setAdapter(pzshApapter);

        }else{
          MyViewHolder3 myViewHolder3= (MyViewHolder3) viewHolder;
            ShowBean.ResultEntity.MlssEntity mlss = result.getMlss();
            List<ShowBean.ResultEntity.MlssEntity.CommodityListEntity> commodityList = mlss.getCommodityList();
            String name = mlss.getName();
            myViewHolder3.tv.setText(name);
            GridLayoutManager manager=new GridLayoutManager(context,2);
            myViewHolder3.rlv.setLayoutManager(manager);
            MlssAdapter mlssAdapter = new MlssAdapter(context, commodityList);
            myViewHolder3.rlv.setAdapter(mlssAdapter);


        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView show;
        private final RecyclerView rlv;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            show = itemView.findViewById(R.id.show_img);
            rlv = itemView.findViewById(R.id.show_rlv);
        }
    }

    private class MyViewHolder2 extends RecyclerView.ViewHolder {

        private final TextView tv1;
        private final RecyclerView rlv;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.pzsh_tv1);
            rlv = itemView.findViewById(R.id.pzsh_rlv);
        }
    }
    public class MyViewHolder3 extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final RecyclerView rlv;

        public MyViewHolder3(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.mlss_tv);
            rlv = itemView.findViewById(R.id.mlss_rlv);
        }
    }
}
