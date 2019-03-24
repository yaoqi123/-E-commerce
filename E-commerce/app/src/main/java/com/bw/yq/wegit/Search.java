package com.bw.yq.wegit;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.yq.R;

import butterknife.BindView;

/**
 * @author yaoqi
 * @fileName Search
 * @package com.bw.yq.wegit
 * @date 2019/3/19 10:18
 */
public class Search extends LinearLayout {

    private ImageView img;
    private EditText ev1;
    private TextView dv1;
//搜索
    public interface OnSearchListenter{
        void OnSearch(  String name);
    }
    public OnSearchListenter searchListenter;
    public void setOnSearchListenter(OnSearchListenter searchListenter){
        this.searchListenter=searchListenter;
    }
//二级列表
    public interface OnERjileibiaoListenter{
        void Erji();
}
public OnERjileibiaoListenter eRjileibiaoListenter;
    public void setOnERjileibiaoListenter(OnERjileibiaoListenter eRjileibiaoListenter){
        this.eRjileibiaoListenter=eRjileibiaoListenter;
    }
    public Search(Context context) {
        super(context);
    }

    public Search(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.search_layout, null, false);
        addView(view);
        img = view.findViewById(R.id.search_img);
        ev1 = view.findViewById(R.id.search_ev1);
        dv1 = view.findViewById(R.id.search_dv1);
        dv1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ev1.getText().toString();

                    if (searchListenter!=null){
                        searchListenter.OnSearch(name);

                }

            }
        });
        img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eRjileibiaoListenter!=null){
                    eRjileibiaoListenter.Erji();
                }
            }
        });
    }

    public Search(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
