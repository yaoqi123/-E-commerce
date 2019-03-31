package com.bw.yq.wegit;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bw.yq.R;
import com.bw.yq.adapter.CartAdapter;
import com.bw.yq.bean.Result;

import java.util.List;

/**
 * @author yaoqi
 * @fileName Counter
 * @package com.bw.yq.wegit
 * @date 2019/3/28 14:42
 */
public class Counter extends LinearLayout {

    private EditText shu;

     int i=0;
     int count;
     List<Result> result;
    CartAdapter cartAdapter;




    public Counter(Context context) {
        super(context);
    }

    public Counter(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.counter, null, false);
        addView(view);
        shu = view.findViewById(R.id.shu);
        Button jia = view.findViewById(R.id.jia);
        Button jian = view.findViewById(R.id.jian);
        jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = shu.getText().toString().trim();
                int n = Integer.parseInt(num);
                n++;
                shu.setText(""+n);
                //获取但前对象
                Result result = Counter.this.result.get(i);
                //设置数量
                result.setCount(n);
                //刷新适配器
                cartAdapter.notifyDataSetChanged();
                if (onCounterListenter!=null){
                    onCounterListenter.getCounter();
                }

            }
        });
        jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = shu.getText().toString().trim();
                int j = Integer.parseInt(s);

                if (s.equals("0")){
                    Toast.makeText(getContext(), "不能小于0", Toast.LENGTH_SHORT).show();
                }else {
                    j--;
                    shu.setText(""+j);
                    Result result1 = Counter.this.result.get(i);
                   result1.setCount(j);
                    cartAdapter.notifyDataSetChanged();
                    if (onCounterListenter!=null){
                        onCounterListenter.getCounter();
                    }


                }
            }
        });

    }
    public Counter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//获取适配器的数据 参数   集合   当前下标  适配器
    public void getconut(List<Result> result, int i, CartAdapter cartAdapter) {
        Log.i("jiaqian",i+"");
        this.cartAdapter=cartAdapter;
        this.result=result;
        this.i=i;
        this.count = result.get(i).getCount();
        this.shu.setText(""+this.count);

    }
//加减回调
    public interface OnCounterListenter{
        void getCounter();
    }
public OnCounterListenter onCounterListenter;
    public void setOnCounterListenter(OnCounterListenter onCounterListenter){
        this.onCounterListenter=onCounterListenter;
    }
}
