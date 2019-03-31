package com.bw.yq.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.yq.R;
import com.bw.yq.activity.OrderActivity;
import com.bw.yq.bean.Address;

import java.util.ArrayList;

/**
 * @author yaoqi
 * @fileName AddressAdapter
 * @package com.bw.yq.adapter
 * @date 2019/3/29 15:45
 */
public class AddressAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Address> result;

    public AddressAdapter(Context context, ArrayList<Address> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.address_item, viewGroup, false);
        MyAddressViewHolder myAddressViewHolder = new MyAddressViewHolder(view);
        return myAddressViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        MyAddressViewHolder myAddressViewHolder = (MyAddressViewHolder) viewHolder;
        Address address = result.get(i);
        String realName = address.getRealName();
        String phone = address.getPhone();
        String address1 = address.getAddress();
        myAddressViewHolder.name.setText(realName);
        myAddressViewHolder.phone.setText(phone);
        myAddressViewHolder.address.setText(address1);
        //设为默认地址1：是  2：否
        if (address.getWhetherDefault() == 1) {
            myAddressViewHolder.check.setChecked(true);
        }
        myAddressViewHolder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addressListenter != null) {
                    addressListenter.add(result.get(i).getId());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyAddressViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView phone;
        private final TextView address;
        private final CheckBox check;

        public MyAddressViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.address_name);
            phone = itemView.findViewById(R.id.address_phone);
            address = itemView.findViewById(R.id.address_dizhi);
            check = itemView.findViewById(R.id.address_checks);
        }
    }

    public interface OnAddressListenter {
        void add(int id);
    }

    public OnAddressListenter addressListenter;

    public void setOnAddressListenter(OnAddressListenter addressListenter) {
        this.addressListenter = addressListenter;
    }
}
