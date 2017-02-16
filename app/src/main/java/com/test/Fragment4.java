package com.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qxq.base.QxqBaseFragment;
import com.qxq.checkUpdate.UpdateManager;
import com.qxq.http.OnHttpCallBackListener;
import com.qxq.http.QxqHttpUtil;
import com.qxq.utils.QxqUtils;

/**
 * Created by Administrator on 2017/1/3.
 */
public class Fragment4 extends QxqBaseFragment {

    @Override
    protected int setContentView() {
        return R.layout.fragment4;
    }

    @Override
    protected void initData() {

    }


    @Override
    public void initLayout(View view) {
        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateManager.init().setContext(getActivity())
                        .setUpdateUrl("your url")//你的更新地址
                        .setUpdateFilePath("")//设置下载后apk的存放路径
                        .setUpdateFileName("")//设置下载后apk的名字  如:test.apk
                        .getVersion();
            }
        });
    }

    @Override
    public void initListener(View view) {

    }

    @Override
    public void onClick(View view) {

    }
}
