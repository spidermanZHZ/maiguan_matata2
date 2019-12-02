package com.example.administrator.matata_android.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * 微信支付
 *   intent.putExtra("partnerid",wXPayBean.getPartnerid());
 *                 intent.putExtra("prepayid",wXPayBean.getPrepayid());
 *                 intent.putExtra("noncestr",wXPayBean.getNoncestr());
 *                 intent.putExtra("timestamp",String.valueOf(wXPayBean.getTimestamp()));
 *                 intent.putExtra("package",wXPayBean.getPackageX());
 *                 intent.putExtra("sign",wXPayBean.getSign());
 */
public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {

    private static final String TAG="matata_android.wxapi";

    private String errorMsg="";
    private IWXAPI api;
    private String partnerid;
    private String prepayid;
    private String noncestr;
    private String timestamp;
    private String packages;
    private String sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_wxpay_entry);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void getExras() {
        Intent intent = getIntent();
        partnerid=intent.getStringExtra("partnerid");
        prepayid=intent.getStringExtra("prepayid");
        noncestr=intent.getStringExtra("noncestr");
        timestamp=intent.getStringExtra("timestamp");
        packages=intent.getStringExtra("package");
        sign=intent.getStringExtra("sign");

    }

    @Override
    protected void initData() {

        api=WXAPIFactory.createWXAPI(this,"wx0c29113c18ba2dfc",false);
        api.handleIntent(getIntent(),this);
        api.registerApp("wx0c29113c18ba2dfc");
        Runnable payRunnable =new Runnable() {//这里注意要放在子线程
            @Override
            public void run() {
                PayReq request=new PayReq();//调用微信App对象
                //下面设置必要的参数，后台已返回
                request.appId = "wx0c29113c18ba2dfc";
                request.partnerId = partnerid;
                request.prepayId = prepayid;
                request.packageValue =noncestr;
                request.nonceStr = timestamp;
                request.timeStamp = packages;
                request.sign =sign;
                Log.e("chx", "run: " + "appId--"+request.appId + "--nonceStr--"+ request.nonceStr+ "--sign--" + request.sign);
                api.sendReq(request);//发送调起微信的请求
            }
        };
        Thread payThread=new Thread(payRunnable);
        payThread.start();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent,this);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected boolean onKeyBack() {
        return false;
    }

    @Override
    protected boolean onKeyMenu() {
        return false;
    }

    //微信发送请求到第三方应用时，会回调到该方法
    @Override
    public void onReq(BaseReq baseReq) {
        int re=baseReq.getType();
    }

    @Override
    public void onResp(BaseResp baseResp) {
        switch (baseResp.errCode){
            case BaseResp.ErrCode.ERR_OK: //发送成功
                setPaySuccessInfo();
                errorMsg="支付结束，请稍后到我的订单中查看详细信息";
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL://发送取消
                errorMsg="支付取消"+baseResp.errCode;
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED://发送被拒绝
                errorMsg="支付失败，请稍后到我的订单页面重新购买"+baseResp.errCode;
                break;
            default://发送返回
                errorMsg="支付失败，请返回上级页面重新购买"+baseResp.errCode;
                break;

        }
        setErrorInfo();
    }

    public void setPaySuccessInfo(){
        Toast.makeText(mContext, "购买成功后续操作", Toast.LENGTH_SHORT).show();
    }
    public void setErrorInfo(){

        Toast.makeText(mContext, errorMsg, Toast.LENGTH_SHORT).show();

    }


}
