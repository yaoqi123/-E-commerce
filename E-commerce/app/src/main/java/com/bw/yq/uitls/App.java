package com.bw.yq.uitls;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author yaoqi
 * @fileName App
 * @package com.bw.yq.uitls
 * @date 2019/3/20 14:42
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
