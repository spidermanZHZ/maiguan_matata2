package com.example.administrator.matata_android.zhzbase.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.matata_android.R;


/**
 * 自定义dialog交互窗口
 */
public class CustomDialog {
    private Dialog mProgressDialog;

    private static final String TAG = "CustomDialog";
    private Button yes;//确定按钮
    private Button no;//取消按钮
    private TextView titleTv;//消息标题文本
    private TextView messageTv;//消息提示文本

    private onYesOnClickListener yesOnClickListener;//确定按钮被点击了的监听器
    private onNoOnClickLister noOnClickLister;//取消按钮被点击了的监听器
    //确定文本和取消文本的显示内容
    private String yesStr, noStr;


    private Runnable cancelRunnable=new Runnable() {
        @Override
        public void run() {
         if (mProgressDialog.isShowing()){
             mProgressDialog.cancel();
          }
        }
    };

    /**
     * 设置 progressDialog样式
     * @param context
     */
    public CustomDialog(Context context){
        mProgressDialog=new Dialog(context, R.style.dialog);
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_message_dialog,null);
        yes = (Button)view. findViewById(R.id.yes);
        no = (Button)view. findViewById(R.id.no);
        titleTv = (TextView)view. findViewById(R.id.title);
        messageTv = (TextView)view. findViewById(R.id.message);
        setCancelable(false);
        mProgressDialog.setContentView(view);

        initEvent();

        mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                messageTv.removeCallbacks(cancelRunnable);
            }
        });
        mProgressDialog.show();
    }

    /**
     * 设置是否可以点击屏幕外取消弹窗
     * @param cancelable
     */
    public void setCancelable(boolean cancelable){
        mProgressDialog.setCancelable(cancelable);
    }


    /**
     * 初始化UI的确定和取消监听器
     */
    private void initEvent(){
        //设置确定按钮被点击后，向外界提供监听
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnClickListener!=null){
                    yesOnClickListener.onYesClick();
                }
            }
        });
        // 设置取消按钮被点击后，向外界提供监听
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noOnClickLister!=null){
                    noOnClickLister.onNoClick();
                }
            }
        });
    }
    /**
     * 从外界Activity为Dialog设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        titleTv.setText(title) ;
    }

    /**
     * 从外界Activity为Dialog设置dialog的message
     *
     * @param message
     */
    public void setMessage(String message) {
        messageTv.setText(message);
    }

    public void setYes(String yess){
        yes.setText(yess);
    }
    public void setNo(String noo){
        no.setText(noo);
    }
    /**
     * 显示 ProgressDialog
     */
    public void show(){
        messageTv.removeCallbacks(cancelRunnable);
        if (!mProgressDialog.isShowing()){
            mProgressDialog.show();
        }
    }

    /**
     * 取消弹窗
     */
    public void cancelImediately(){
        mProgressDialog.cancel();
        Log.i(TAG, "mProgressDialog已退出");
    }

    /**
     * 延迟取消
     */
    public void cancel(){
        messageTv.postDelayed(cancelRunnable,1000);
    }


    /**
     * 设置确定按钮的接口
     */
    public interface onYesOnClickListener{
        public void onYesClick();
    }
    /**
     * 设置取消被点击按钮的接口
     */
    public interface  onNoOnClickLister{
        public void onNoClick();
    }
    /**
     * 设置确定按钮内容
     *
     * @param onYesOnClickListener  确定按钮点击接口
     */
    public void setOnYesOnClickListener(onYesOnClickListener onYesOnClickListener){

        this.yesOnClickListener=onYesOnClickListener;
    }

    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param onNoOnClickLister 监听
     */
    public void setNoOnclickListener(onNoOnClickLister onNoOnClickLister){
        this.noOnClickLister=onNoOnClickLister;
    }
}
