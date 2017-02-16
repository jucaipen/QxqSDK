package com.test;

import com.qxq.photopick.ImageInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/14.
 */
public interface ChooseImageCallBack {

    void OneImage(String path);

    void ListImage(ArrayList<ImageInfo> arrayList);

}
