package com.test;

import android.app.Application;

import com.qxq.http.QxqHttpUtil;
import com.qxq.utils.QxqDialogUtil;
import com.qxq.utils.QxqLogUtil;
import com.qxq.utils.QxqToastUtil;

/**
 * Created by Administrator on 2017/1/5.
 */
public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        QxqHttpUtil.initSDK(getApplicationContext());
        QxqHttpUtil.onBind().setBaseUrl("http://api.1313m.com/");
        QxqLogUtil.init(true);
        QxqToastUtil.init(getApplicationContext());
        QxqDialogUtil.init();

    }
}
