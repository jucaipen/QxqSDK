package com.test;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import com.qxq.base.QxqSwipeBackActivity;
import com.qxq.photopick.ImageInfo;
import com.qxq.photopick.PhotoPickResult;
import com.qxq.photopick.PhotoPickUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/29.
 */
public class FragmentToActivity extends QxqSwipeBackActivity {

    private  Fragment fragment = null;

    @Override
    public void initLayout() {

    }

    @Override
    protected void initData() {


        int type = Integer.parseInt(getIntent().getStringExtra("type"));
        switch (type){
            case 1:
                fragment = new Fragment1();
                break;
            case 2:
                fragment = new Fragment2();
                break;
            case 3:
                fragment = new Fragment3();
                break;
            case 4:
                fragment = new Fragment4();
                break;
            case 5:
                fragment = new Fragment5();
                break;
        }

        getSupportFragmentManager().beginTransaction().add(R.id.main_activity_fragment_layout,fragment).commit();
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.fragmentmain);
    }


    @Override
    public void onClick(View view) {

    }

    ChooseImageCallBack callBack;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callBack = (ChooseImageCallBack) fragment;
        PhotoPickUtil.newInstance().onActivityResult(requestCode,resultCode,data, new PhotoPickResult() {
            @Override
            public void OneImage(String path) {
                callBack.OneImage(path);
            }
            @Override
            public void ListImage(ArrayList<ImageInfo> arrayList) {
                callBack.ListImage(arrayList);
            }
        });
    }
}
