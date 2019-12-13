package com.example.administrator.matata_android.my.activitys;


import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.dialog.TextDialog;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.TResult;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 编辑保存用户信息
 */

public class ChangeUserInfoActivity extends TakePhotoActivity {

    @BindView(R.id.change_child_head)
    ImageView changeChildHead;
    @BindView(R.id.change_child_name)
    EditText changeChildName;
    @BindView(R.id.change_child_sign)
    EditText changeChildSign;
    @BindView(R.id.adjust_btn_confim)
    Button adjustBtnConfim;
    @BindView(R.id.rb_man)
    RadioButton rbMan;
    @BindView(R.id.rb_woman)
    RadioButton rbWoman;
    @BindView(R.id.rg_gender)
    RadioGroup rgGender;
    @BindView(R.id.change_child_age)
    EditText changeChildAge;
    @BindView(R.id.title_bar)
    TitleBar titleBar;
    @BindView(R.id.ll_child_info)
    LinearLayout llChildInfo;
    @BindView(R.id.child_info_frist_tv)
    TextView childInfoFristTv;


    //TakePhoto
    private TakePhoto takePhoto;
    private CropOptions cropOptions; //裁剪参数
    private CompressConfig compressConfig;//压缩参数
    private Uri imageUri; //图片保存路径

    private BaseObserver<Object> baseObserver;
    private String headUrl;
    private String name;
    private String age;
    private String sex;
    private String signature;
    private TextDialog textDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chang_user_info);
        ButterKnife.bind(this);
        //ininData();
        initDatass();
    }

    private void initDatass() {

        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                ActivityUtils.finishActivity(ChangeUserInfoActivity.class);
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });

        childInfoFristTv.setVisibility(View.GONE);
        //获取TakePhoto实例
        takePhoto = getTakePhoto();
        //设置裁剪参数
        cropOptions = new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(false).create();
        //设置压缩参数
        compressConfig = new CompressConfig.Builder().setMaxSize(50 * 1024).setMaxPixel(800).create();
        takePhoto.onEnableCompress(compressConfig, true); //设置为需要压缩
        changeChildHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageUri = getImageCropUri();
                //拍照并裁剪
                //takePhoto.onPickFromCaptureWithCrop(imageUri,cropOptions);
                //从相册中选取图片并裁剪
                takePhoto.onPickFromGalleryWithCrop(imageUri, cropOptions);
            }
        });
        setClickLister();

    }

    /**
     * 点击事件
     */
    private void setClickLister() {

        adjustBtnConfim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = changeChildName.getText().toString();
                age = changeChildAge.getText().toString();
                signature = changeChildSign.getText().toString();
                sex = "1";
                rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.rb_man:
                                sex = "1";
                                break;
                            case R.id.rb_woman:
                                sex = "0";
                                break;
                        }
                    }
                });
                if (StringUtils.isEmpty(name)) {
                    showTextDialog("请输入用户姓名");
                    return;
                } else if (StringUtils.isEmpty(age)) {
                    showTextDialog("请输入用户年龄");
                    return;
                } else if (StringUtils.isEmpty(signature)) {
                    showTextDialog("请输入家庭住址");
                    return;
                }
                setChildInfo(name, sex, signature);
            }
        });

    }

    //获得照片输出保存URL
    private Uri getImageCropUri() {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        return Uri.fromFile(file);
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        String iconPath = result.getImage().getOriginalPath();
        headUrl = iconPath;
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

    /**
     * 上传学员信息
     */
    private void setChildInfo(String name, String sex, String address) {

        RequestBody tokenBody = RequestBody.create(MediaType.parse("multipart/form-data"), MatataSPUtils.getToken());
        RequestBody nameBody = RequestBody.create(MediaType.parse("multipart/form-data"), name);
        RequestBody sexBody = RequestBody.create(MediaType.parse("multipart/form-data"), sex);
        RequestBody addressBody = RequestBody.create(MediaType.parse("multipart/form-data"), address);
        //头像上传
        File file = new File(headUrl);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part head_fileBody = MultipartBody.Part.createFormData("head_file", file.getName(), requestBody);

        baseObserver = new BaseObserver<Object>(this, true, true) {
            @Override
            public void onSuccess(Object o) {
                showTextDialog("用户信息更新成功");

                ActivityUtils.finishActivity(ChangeUserInfoActivity.this);
            }
        };
        RetrofitUtil.getInstance().getApiService().addUserInfo(tokenBody, nameBody, sexBody, addressBody, head_fileBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseObserver);


    }

    /**
     * 显示提示弹窗
     *
     * @param text 弹窗提示语
     */
    public void showTextDialog(String text) {
        if (textDialog == null)
            textDialog = new TextDialog(this);
        textDialog.setText(text);
        textDialog.show();
    }

}
