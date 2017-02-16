package com.test;

import android.view.View;

import com.qxq.base.QxqBaseFragment;
import com.qxq.http.OnHttpCallBackListener;
import com.qxq.http.QxqHttpUtil;
import com.qxq.utils.QxqLogUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/1/3.
 */
public class Fragment3 extends QxqBaseFragment {


    @Override
    protected int setContentView() {
        return R.layout.fragment3;
    }

    @Override
    protected void initData() {

    }


    @Override
    public void initLayout(View view) {
        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QxqHttpUtil.onBind().get("",
                        new OnHttpCallBackListener() {
                            @Override
                            public void onComplete(String json) {
                                QxqLogUtil.onBind().i("TAG","json..."+json);
                            }

                            @Override
                            public void onError(String error) {
                                QxqLogUtil.onBind().i("TAG","error..."+error);
                            }
                        });
            }
        });

        view.findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QxqHttpUtil.onBind().post("", new HashMap<String, String>(), new OnHttpCallBackListener() {
                    @Override
                    public void onComplete(String json) {
                        QxqLogUtil.onBind().i("TAG","json..."+json);
                    }

                    @Override
                    public void onError(String error) {
                        QxqLogUtil.onBind().i("TAG","error..."+error);
                    }
                });
            }
        });

        view.findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                QxqHttpUtil.onBind().postToJson("your url", "your json", new OnHttpCallBackListener() {
                    @Override
                    public void onComplete(String json) {
                        QxqLogUtil.onBind().i("TAG","json..."+json);
                    }

                    @Override
                    public void onError(String error) {
                        QxqLogUtil.onBind().i("TAG","error..."+error);
                    }
                });
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
