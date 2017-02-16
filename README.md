QxqSDK
====

提供各种基类、工具类、Android6.0动态权限管理、网络请求、文件上传下载、图片选择、应用检查更新等功能，极大的提升了开发的效率<br><br>
更多功能正在完善中......<br>


Demo请见https://github.com/qxq5434/qxqsdkExample
------

Android Studio依赖方法
-------

在工程的build.gradle中添加如下代码,一步轻松搞定

```java
compile 'com.github.qxq.library:qxqsdk:1.0.1'
```
基类
-------

* QxqBaseActivity <br>
Activity的基类

* QxqBaseFragment <br>
Fragment的基类

* QxqBaseSwipeBackActivity <br>
带有滑动返回功能的Activity的基类

* QxqBaseMVPActivity <br>
MVP架构的Activity基类

* QxqBaseMVPSwipeBackActivity <br>
带有滑动返回的MVP架构的Activity基类

继承以上基类需实现以下四个抽象方法<br>
```java

/**
 * 初始化布局
 */
protected abstract void initLayout();

/**
 * 初始化数据
 */
protected abstract void initData();

/**
 * 设置控件事件
 */
protected abstract void initListener();

/**
 * 设置界面视图
 */
protected abstract void setContentView();

```
基类自带一个加载方法<br>
```java
//加载
showLoadingDialog(this,"正在加载...");
//注:this必须为Activity

//关闭
if(dlg != null)
   dlg.dismiss();

```
基类自带Activity跳转方法<br>
```java
startAnimActivity(TestActivity.class,new String[]{"参数名1","参数名2"},new String[]{"参数值1","参数值2"});
```
基类自带Activity返回方法<br>
```java
backAnimActivity();
```
基类自带权限管理方法(Activity)
```java
//你程序用到的权限集
String[] mPermissionList = new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CALL_PHONE};
checkPermission(mPermissionList);
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

详情请见https://github.com/qxq5434/QxqSDK/blob/master/QxqUtils


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

* 注册相关Activity
```xml
<activity
    android:name="com.qxq.photopick.PhotoPickActivity"
    android:configChanges="orientation|keyboardHidden"
    android:screenOrientation="portrait"
    >
</activity>
<activity
    android:name="com.qxq.photopick.PhotoPickDetailActivity"
    android:configChanges="orientation|keyboardHidden"
    android:screenOrientation="portrait"
    />
<activity
    android:name="com.qxq.photopick.CropImageUIActy"
    android:configChanges="orientation|keyboardHidden"
    android:screenOrientation="portrait"
    />

```

QxqHttpUtil
-------

运用RxJava+Retrofit2+OkHttp完成以下功能

>功能

>>get、post网络请求

>>文件上传

>>文件下载


在你的Application中初始化QxqHttpUtil
```java

QxqHttpUtil.initSDK(getApplicationContext());
QxqHttpUtil.onBind().setBaseUrl("your baseurl");

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
                                QxqLogUtil.onBind().i("TAG","json..."+json);
                            }

                            @Override
                            public void onError(String error) {
                                QxqLogUtil.onBind().i("TAG","error..."+error);
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
                        QxqLogUtil.onBind().i("TAG","json..."+json);
                    }

                    @Override
                    public void onError(String error) {
                        QxqLogUtil.onBind().i("TAG","error..."+error);
                    }
                });
```

* POST请求上传json

>参数

>>url:你需要请求的url地址

>>json:你需要传递的json

>>OnHttpCallBackListener:请求完成后的回调函数

```java
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

```


4、文件下载
-------

```java

 QxqHttpUtil.onBind()
            .setDownLoadUrl("your file download url")
            .setDownLoadFilePath("/testDownLoad")//文件下载后存放的文件夹
            .setDownLoadFileName("test.apk")//文件下载后的名字
            .setDownLoadListener(new OnDownLoadListener() {
                @Override
                public void onSuccess() {
                    QxqToastUtil.onBind().showLongToast("下载完成!");
                    dialog.dismiss();
                }
                @Override
                public void onFailure(String error) {
                    QxqToastUtil.onBind().showLongToast("下载失败!"+error);
                }
                @Override
                public void onLoading(long l, long l1) {
                    //文件下载进度
                    int progress = ((int) ((l1 / (float) l) * 100));
                }
            })
            .download();

```

5、文件上传
-------

* 单个文件上传
```java

 QxqHttpUtil.onBind()
            .setUpLoadFilePath("file path")//需要上传的文件路径
            .setUpLoadFileName("")//服务器的文件参数名
            .setUpLoadUrl("")//上传的地址
            .setUpLoadIsImage(true)//设置上传的文件是否是图片，默认为true
            .setUpLoadListener(new OnUpLoadListener() {
                @Override
                public void onSuccess() {
                    QxqToastUtil.onBind().showLongToast("上传成功!");
                }

                @Override
                public void onFailure(String error) {
                    QxqToastUtil.onBind().showLongToast("上传失败!"+error);
                }

                @Override
                public void onLoading(long total, long progress) {
                    //进度
                    int progress2 = ((int) ((total / (float) progress) * 100));
                }
            })
            .upload();

```

* 多文件上传
```java

Map<String,File> map = new HashMap<String, File>();
map.put("image0",new File(""));
map.put("image1",new File(""));
map.put("image2",new File(""));

QxqHttpUtil.onBind()
           .setUpLoadFiles(map)//需要上传的文件集
           .setUpLoadUrl("url")//上传的地址
           .setUpLoadIsImage(true)//设置上传的文件是否是图片，默认为true
           .setUpLoadListener(new OnUpLoadListener() {
               @Override
               public void onSuccess() {
                   QxqToastUtil.onBind().showLongToast("上传成功!");
               }

               @Override
               public void onFailure(String error) {
                   QxqToastUtil.onBind().showLongToast("上传失败!"+error);
               }

               @Override
               public void onLoading(long total, long progress) {
                   //进度
                   int progress2 = ((int) ((total / (float) progress) * 100));
               }
           })
           .uploadFiles();

```

* 文件上传 (from表单格式，适用于注册或者修改个人信息用户头像和用户信息一起上传)
```java
String url = "your upload url";
Map<String ,String> map = new HashMap<String, String>();
map.put("id","123");
map.put("nickname","test");

QxqHttpUtil.onBind()
           .setUpLoadFileName("icon")//服务器图片参数名
           .setUpLoadFilePath("file path")//你需要上传的文件路径
           .setUpLoadMap(map)//你的用户信息
           .setUpLoadUrl(url)//你的上传地址
           .setUpLoadIsImage(true)//设置上传的文件是否是图片，默认为true
           .setUpLoadListener(new OnUpLoadListener() {
               @Override
               public void onSuccess() {
                   QxqToastUtil.onBind().showLongToast("上传成功!");
               }

               @Override
               public void onFailure(String error) {
                   QxqToastUtil.onBind().showLongToast("上传失败!"+error);
               }

               @Override
               public void onLoading(long total, long progress) {
                   //上传的进度
                   int progress2 = ((int) ((total / (float) progress) * 100));
               }
           })
           .uploadInfo();
```

6、程序检查更新
-------
```java
注:服务器返回的json数据应为如下格式
{
    "data": {
        "version": "1.0",
        "url": "your apk downlod url",
        "message": "your update message"
    }
}

UpdateManager.init().setContext(getActivity())
                        .setUpdateUrl("your url")//你的更新地址
                        .setUpdateFilePath("")//设置下载后apk的存放路径
                        .setUpdateFileName("")//设置下载后apk的名字
                        .getVersion();
```
