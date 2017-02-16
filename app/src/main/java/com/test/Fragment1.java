package com.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qxq.base.QxqBaseFragment;
import com.qxq.photopick.ImageInfo;
import com.qxq.photopick.PhotoPickResult;
import com.qxq.photopick.PhotoPickUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/3.
 */
public class Fragment1 extends QxqBaseFragment implements ChooseImageCallBack{

    private ArrayList<ImageInfo> mPickData = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();
    private TextView textView;

    @Override
    protected int setContentView() {
        return R.layout.fragment1;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initLayout(View view) {
        textView = (TextView) view.findViewById(R.id.text);
    }

    @Override
    public void initListener(View view) {
        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addImage(true);
            }
        });

        view.findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addImage(false);
            }
        });
    }

    public void addImage(boolean bool){
        if(bool){
            PhotoPickUtil.newInstance().startPhotoPickToList(getActivity(),mPickData);
        }else{
            PhotoPickUtil.newInstance().startPhotoPickToOne(getActivity());
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void OneImage(String path) {
        images.clear();
        images.add(path);
        textView.setText(path);
    }

    @Override
    public void ListImage(ArrayList<ImageInfo> arrayList) {
        mPickData.clear();
        mPickData.addAll(arrayList);
        StringBuffer sb = new StringBuffer();
        for(ImageInfo imageInfo : mPickData){
            sb.append(imageInfo.path);
            sb.append("\n");
        }

        textView.setText(sb.toString());
    }
}
