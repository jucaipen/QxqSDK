QxqSDK
====

提供各种工具类、网络请求、文件上传下载、图片选择、应用检查更新等功能,极大的提升了开发的效率<br><br>
更多功能正在完善中......


------

Android Studio依赖方法
-------

在工程的build.gradle中添加如下代码,一步轻松搞定

```java
compile 'com.github.qxq.library:qxqsdk:1.0.1'
```

1、图片选择器
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

2、网络请求
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
