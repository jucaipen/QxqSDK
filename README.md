QxqSDK
====

提供各种工具类、网络请求、文件上传下载、图片选择、应用检查更新等功能，极大的提升了开发的效率<br><br>
更多功能正在完善中......


------

Android Studio依赖方法
-------

在工程的build.gradle中添加如下代码,一步轻松搞定

```java
compile 'com.github.qxq.library:qxqsdk:1.0.1'
```

1、工具类
-------
* ToastUtil
```java

msg:String类型的Toast文本
strRes:在string.xml中定义的文本的id

showShortToast(String msg);
showShortToast(int strRes);

showLongToast(String msg);
showLongToast(int strRes);

showToast(String msg,int duration);
showToast(String msg, int duration,int gravity);

调用方法
1、在程序的Application中初始化ToastUtil
   ToastUtil.init(getApplicationContext());
2、ToastUtil.onBind().showToast();

```

* LogUtil
```java
调用方法
1、在程序的Application中初始化LogUtil
   LogUtil.init(true);
   //参数：当参数为true时打印log，否则不打印log   当应用在调试阶段设置为true，当应用正式上线后设置为false
   
2、LogUtil.onBind().i(String tag, String desc);

```


* DialogUtil
```java

调用方法
1、在程序的Application中初始化DialogUtil
   DialogUtil.init();
2、DialogUtil.onBind(this)//注:这里的this必须为activity不能是Context
             .setTitle("")//diaolog标题
             .setMessage("")//diaolog描述
             .setBtn1Text("")//第一个按钮的文本
             .setBtn2Text("")//第二个按钮的文本
             .setSetCancelable(false)//设置按返回键时dialog是否消失
             .setSetCanceledOnTouchOutside(false)//设置点击dialog以外区域时dialog是否消失
             .setBtn1Listener(new DialogInterface.OnClickListener{})//设置第一个按钮的点击回调
             .setBtn2Listener(new DialogInterface.OnClickListener{})//设置第二个按钮的点击回调
             .showDialog();

```

* QxqUtils


详情请见


2、图片选择器
-------
 
* 多图选择 <br>
```java
PhotoPickUtil.newInstance().startPhotoPickToList(getActivity(),mPickData);
mPickData:存放选择图片的数组
```
* 单图选择 <br>
```java
PhotoPickUtil.newInstance().startPhotoPickToOne(getActivity());
```
* 回调函数 <br>

```java
//在程序的onActivityResult中调用如下回调函数
PhotoPickUtil.newInstance().onActivityResult(requestCode,requestCode,data, new PhotoPickResult() {
                @Override 
                public void OneImage(String path) {
                  //path:选择的单张图片的地址
                }
                @Override
                public void ListImage(ArrayList<ImageInfo> arrayList) {
                  //arrayList:选择的图片数组
                }
            });
```

3、网络请求
-------

* GET请求

>参数
>>url:你需要请求的url地址


>>OnHttpCallBackListener:请求完成后的回调函数


```java
QxqHttpUtil.onBind().get("your url",
                        new OnHttpCallBackListener() {
                            @Override
                            public void onComplete(String json) {
                                ShowLog("json..."+json);
                            }

                            @Override
                            public void onError(String error) {
                                ShowLog("error..."+error);
                            }
                        });
```
* POST请求

>参数
>>url:你需要请求的url地址

>>map:你需要请求的参数集

>>OnHttpCallBackListener:请求完成后的回调函数

```java
QxqHttpUtil.onBind().post("your url", map, new OnHttpCallBackListener() {
                    @Override
                    public void onComplete(String json) {
                        ShowLog("json..."+json);
                    }

                    @Override
                    public void onError(String error) {
                        ShowLog("error..."+error);
                    }
                });
```
