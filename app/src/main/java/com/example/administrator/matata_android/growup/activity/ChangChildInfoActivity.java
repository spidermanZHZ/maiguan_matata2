package com.example.administrator.matata_android.growup.activity;


import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.matata_android.R;
import com.github.florent37.singledateandtimepicker.SingleDateAndTimePicker;
import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 编辑改变学员信息
 */

public class ChangChildInfoActivity extends TakePhotoActivity {

    @BindView(R.id.change_child_head)
    ImageView changeChildHead;
    @BindView(R.id.change_child_name)
    EditText changeChildName;
    @BindView(R.id.change_child_sign)
    EditText changeChildSign;
    @BindView(R.id.adjust_btn_confim)
    Button adjustBtnConfim;

//TakePhoto
       private TakePhoto takePhoto;
        private CropOptions cropOptions; //裁剪参数
       private CompressConfig compressConfig;//压缩参数
       private Uri imageUri; //图片保存路径


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chang_child_info);
        ButterKnife.bind(this);
        //ininData();
        initDatas();
    }

    private void initDatas(){
     //获取TakePhoto实例
    takePhoto = getTakePhoto();
    //设置裁剪参数
    cropOptions = new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(false).create();
    //设置压缩参数
    compressConfig=new CompressConfig.Builder().setMaxSize(50*1024).setMaxPixel(800).create();
    takePhoto.onEnableCompress(compressConfig,true); //设置为需要压缩
        changeChildHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageUri=getImageCropUri();
                //拍照并裁剪
                //takePhoto.onPickFromCaptureWithCrop(imageUri,cropOptions);
                //从相册中选取图片并裁剪
                takePhoto.onPickFromGalleryWithCrop(imageUri, cropOptions);
            }
        });

    }
    //获得照片输出保存URL
    private Uri getImageCropUri(){
        File file=new File(Environment.getExternalStorageDirectory(),"/temp/"+System.currentTimeMillis()+".jpg");
        if (!file.getParentFile().exists())file.getParentFile().mkdirs();
        return Uri.fromFile(file);
    }


    /**
     * 导入资源
     */
    private void ininData() {
        TakePhoto takePhoto = getTakePhoto();
        CropOptions.Builder builder = new CropOptions.Builder();
        builder.setAspectX(800).setAspectY(800);//裁剪设置
        builder.setWithOwnCrop(true);
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            boolean mkdirs = file.getParentFile().mkdirs();
            if (!mkdirs) {
                ToastUtils.showShort("文件目录创建失败");
            }
        }
        Uri imageUri = Uri.fromFile(file);
        CompressConfig config = new CompressConfig.Builder()
                .setMaxSize(102400)
                .setMaxPixel(400)
                .enableReserveRaw(true)
                .create();
        takePhoto.onEnableCompress(config, true);
        changeChildHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto.onPickFromDocumentsWithCrop(imageUri, builder.create());//启动相册

            }
        });


    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        String iconPath =result.getImage().getOriginalPath();
        Glide.with(this).load(iconPath).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(changeChildHead);
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }


}
