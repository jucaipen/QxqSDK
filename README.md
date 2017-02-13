 # QxqSDK
 
 # 图片选择器
 
* 多图选择 <br>
PhotoPickUtil.newInstance().startPhotoPickToList(getActivity(),mPickData);<br>
mPickData:存放选择图片的数组


* 单图选择 <br>
PhotoPickUtil.newInstance().startPhotoPickToOne(getActivity());

* 回调函数 <br>
PhotoPickUtil.newInstance().onActivityResult(requestCode,requestCode,data, new PhotoPickResult() {<br>
                @Override <br>
                public void OneImage(String path) {<br>
                  //path:选择的单张图片的地址<br>
                }<br>
                @Override<br>
                public void ListImage(ArrayList<ImageInfo> arrayList) {<br>
                  //arrayList:选择的图片数组<br>
                }<br>
            });<br>
