package com.bw.yq.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.yq.R;

/**
 * @author yaoqi
 * @fileName ClassificationFragment
 * @package com.bw.yq.fragment
 * @date 2019/3/12 14:38
 */
public class ClassificationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.classification_layout, container, false);
        return view;
    }
}
