package com.test;

import android.app.ProgressDialog;
import android.view.View;

import com.qxq.base.QxqBaseFragment;
import com.qxq.download.OnDownLoadListener;
import com.qxq.http.QxqHttpUtil;
import com.qxq.photopick.ImageInfo;
import com.qxq.photopick.PhotoPickUtil;
import com.qxq.upload.OnUpLoadListener;
import com.qxq.utils.QxqToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/3.
 */
public class Fragment2 extends QxqBaseFragment implements ChooseImageCallBack{


    private ArrayList<ImageInfo> mPickData = new ArrayList<>();

    @Override
    protected int setContentView() {
        return R.layout.fragment2;
    }

    @Override
    protected void initData() {

    }


    @Override
    public void initLayout(View view) {
        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog dialog = new ProgressDialog(getActivity());
                dialog.setTitle("下载");
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setCancelable(true);
                dialog.setMax(100);
                dialog.show();
                QxqHttpUtil.onBind()
                        .setDownLoadUrl("")
                        .setDownLoadFilePath("")
                        .setDownLoadFileName("")
                        .setDownLoadListener(new OnDownLoadListener() {
                            @Override
                            public void onSuccess() {
                                QxqToastUtil.onBind().showLongToast("下载完成!");
                                dialog.dismiss();
                            }
                            @Override
                            public void onFailure(String error) {
                                QxqToastUtil.onBind().showLongToast("下载失败!"+error);
                                dialog.dismiss();
                            }
                            @Override
                            public void onLoading(long l, long l1) {
                                int progress = ((int) ((l1 / (float) l) * 100));
                                dialog.setProgress(progress);
                            }
                        })
                        .download();
            }
        });

        view.findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog dialog = new ProgressDialog(getActivity());
                dialog.setTitle("上传");
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setCancelable(true);
                dialog.setMax(100);
                dialog.show();

                String url = "your upLoad url";
                String path = "file path";
                Map<String ,String> map = new HashMap<String, String>();

                QxqHttpUtil.onBind()
                        .setUpLoadFileName("icon")
                        .setUpLoadFilePath(path)
                        .setUpLoadMap(map)
                        .setUpLoadUrl(url)
                        .setUpLoadListener(new OnUpLoadListener() {
                            @Override
                            public void onSuccess() {
                                QxqToastUtil.onBind().showLongToast("上传成功!");
                                dialog.dismiss();
                            }

                            @Override
                            public void onFailure(String error) {
                                QxqToastUtil.onBind().showLongToast("上传失败!"+error);
                                dialog.dismiss();
                            }

                            @Override
                            public void onLoading(long total, long progress) {
                                int progress2 = ((int) ((total / (float) progress) * 100));
                                dialog.setProgress(progress2);
                            }
                        })
                        .uploadInfo();


            }
        });

        view.findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhotoPickUtil.newInstance().startPhotoPickToList(getActivity(),mPickData);

            }
        });

        view.findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhotoPickUtil.newInstance().startPhotoPickToOne(getActivity());

            }
        });

    }

    @Override
    public void initListener(View view) {

    }

    @Override
    public void onClick(View view) {

    }


    @Override
    public void OneImage(String path) {
        final ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setTitle("上传");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);
        dialog.setMax(100);
        dialog.show();
        QxqHttpUtil.onBind()
                .setUpLoadFilePath(path)
                .setUpLoadFileName("")
                .setUpLoadUrl("")
                .setUpLoadIsImage(true)
                .setUpLoadListener(new OnUpLoadListener() {
                    @Override
                    public void onSuccess() {
                        QxqToastUtil.onBind().showLongToast("上传成功!");
                        dialog.dismiss();
                    }

                    @Override
                    public void onFailure(String error) {
                        QxqToastUtil.onBind().showLongToast("上传失败!"+error);
                        dialog.dismiss();
                    }

                    @Override
                    public void onLoading(long total, long progress) {
                        int progress2 = ((int) ((total / (float) progress) * 100));
                        dialog.setProgress(progress2);
                    }
                })
                .upload();
    }

    @Override
    public void ListImage(ArrayList<ImageInfo> arrayList) {
        mPickData.clear();
        mPickData.addAll(arrayList);

        final ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setTitle("上传");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);
        dialog.setMax(100);
        dialog.show();

        Map<String,String> map = new HashMap<String, String>();
        for(int i = 0 ; i < arrayList.size() ; i++){
            ImageInfo imageInfo = arrayList.get(i);
            String path = imageInfo.path;
            map.put("",path);
        }

        QxqHttpUtil.onBind()
                .setUpLoadFiles(map)
                .setUpLoadIsImage(true)
                .setUpLoadUrl("")
                .setUpLoadListener(new OnUpLoadListener() {
                    @Override
                    public void onSuccess() {
                        QxqToastUtil.onBind().showLongToast("上传成功!");
                        dialog.dismiss();
                    }

                    @Override
                    public void onFailure(String error) {
                        QxqToastUtil.onBind().showLongToast("上传失败!"+error);
                        dialog.dismiss();
                    }

                    @Override
                    public void onLoading(long total, long progress) {
                        int progress2 = ((int) ((total / (float) progress) * 100));
                        dialog.setProgress(progress2);
                    }
                })
                .uploadFiles();
    }
}
