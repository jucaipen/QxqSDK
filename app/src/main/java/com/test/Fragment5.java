package com.test;

import android.content.DialogInterface;
import android.view.View;

import com.qxq.base.QxqBaseFragment;
import com.qxq.utils.QxqDialogUtil;
import com.qxq.utils.QxqToastUtil;

/**
 * Created by Administrator on 2017/2/15.
 */
public class Fragment5 extends QxqBaseFragment {
    @Override
    protected int setContentView() {
        return R.layout.fragment5;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initLayout(View view) {

    }

    @Override
    public void initListener(View view) {
        view.findViewById(R.id.btn1).setOnClickListener(this);
        view.findViewById(R.id.btn2).setOnClickListener(this);
        view.findViewById(R.id.btn3).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                QxqDialogUtil.onBind(getActivity())
                        .setTitle("提示")
                        .setMessage("your message")
                        .setSetCancelable(true)
                        .setSetCanceledOnTouchOutside(false)
                        .showDialog();
                break;
            case R.id.btn2:
                QxqDialogUtil.onBind(getActivity())
                        .setTitle("提示")
                        .setMessage("your message")
                        .setSetCancelable(true)
                        .setSetCanceledOnTouchOutside(false)
                        .setBtn1Text("确定")
                        .setBtn1Listener(new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .showDialog();
                break;
            case R.id.btn3:
                QxqDialogUtil.onBind(getActivity())
                        .setTitle("提示")
                        .setMessage("your message")
                        .setSetCancelable(true)
                        .setSetCanceledOnTouchOutside(false)
                        .setBtn1Text("确定")
                        .setBtn2Text("取消")
                        .setBtn1Listener(new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                QxqToastUtil.onBind().showLongToast("确定");
                            }
                        })
                        .setBtn2Listener(new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .showDialog();
                break;
        }
    }
}
