package com.example.administrator.matata_android.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 微信支付
 * intent.putExtra("partnerid",wXPayBean.getPartnerid());
 * intent.putExtra("prepayid",wXPayBean.getPrepayid());
 * intent.putExtra("noncestr",wXPayBean.getNoncestr());
 * intent.putExtra("timestamp",String.valueOf(wXPayBean.getTimestamp()));
 * intent.putExtra("package",wXPayBean.getPackageX());
 * intent.putExtra("sign",wXPayBean.getSign());
 */
public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {

    private static final String TAG = "matata_android.wxapi";
    @BindView(R.id.title_bar)
    TitleBar titleBar;
    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.empty_tv)
    TextView emptyTv;
    @BindView(R.id.ll_study_course)
    LinearLayout llStudyCourse;

    private String errorMsg = "";
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
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void getExras() {
        Intent intent = getIntent();
        partnerid = intent.getStringExtra("partnerid");
        prepayid = intent.getStringExtra("prepayid");
        noncestr = intent.getStringExtra("noncestr");
        timestamp = intent.getStringExtra("timestamp");
        packages = intent.getStringExtra("package");
        sign = intent.getStringExtra("sign");

    }

    @Override
    protected void initData() {
            titleBar.setOnTitleBarListener(new OnTitleBarListener() {
                @Override
                public void onLeftClick(View v) {
                    finishActivity();
                }

                @Override
                public void onTitleClick(View v) {

                }

                @Override
                public void onRightClick(View v) {

                }
            });
        api = WXAPIFactory.createWXAPI(this, "wx0c29113c18ba2dfc", false);
        api.handleIntent(getIntent(), this);
        api.registerApp("wx0c29113c18ba2dfc");
        Runnable payRunnable = new Runnable() {//这里注意要放在子线程
            @Override
            public void run() {
                PayReq request = new PayReq();//调用微信App对象
                //下面设置必要的参数，后台已返回
                request.appId = "wx0c29113c18ba2dfc";
                request.partnerId = partnerid;
                request.prepayId = prepayid;
                request.packageValue = noncestr;
                request.nonceStr = timestamp;
                request.timeStamp = packages;
                request.sign = sign;
                Log.e("chx", "run: " + "appId--" + request.appId + "--nonceStr--" + request.nonceStr + "--sign--" + request.sign);
                api.sendReq(request);//发送调起微信的请求
            }
        };
        Thread payThread = new Thread(payRunnable);
        payThread.start();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
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
        int re = baseReq.getType();
    }

    @Override
    public void onResp(BaseResp baseResp) {
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK: //发送成功
                setPaySuccessInfo();
                errorMsg = "支付结束，请稍后到我的订单中查看详细信息";
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL://发送取消
                errorMsg = "支付取消" + baseResp.errCode;
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED://发送被拒绝
                errorMsg = "支付失败，请稍后到我的订单页面重新购买" + baseResp.errCode;
                break;
            default://发送返回
                errorMsg = "支付失败，请返回上级页面重新购买" + baseResp.errCode + baseResp.errStr;
                break;

        }
        setErrorInfo();
    }

    public void setPaySuccessInfo() {
        emptyTv.setText(errorMsg);
    }

    public void setErrorInfo() {
        emptyTv.setText(errorMsg);

    }


}
