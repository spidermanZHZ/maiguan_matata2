package com.example.administrator.matata_android.homepage.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.ArtBuyCompleteBean;
import com.example.administrator.matata_android.bean.WXPayBean;
import com.example.administrator.matata_android.homepage.SerializableMap;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.wxapi.WXPayEntryActivity;
import com.example.administrator.matata_android.wxapi.WXPayUtils;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 营地购买页面---订单页面
 */
public class ArtBuyCompleteActivity extends BaseActivity {

    @BindView(R.id.tv_art_buy_no)
    TextView tvArtBuyNo;
    @BindView(R.id.tv_art_buy_price)
    TextView tvArtBuyPrice;
    @BindView(R.id.tv_art_buy_name)
    TextView tvArtBuyName;
    @BindView(R.id.tv_art_buy_type)
    TextView tvArtBuyType;
    @BindView(R.id.tv_art_buy_date)
    TextView tvArtBuyDate;
    @BindView(R.id.tv_art_buy_people)
    TextView tvArtBuyPeople;
    @BindView(R.id.tv_art_buy_num)
    TextView tvArtBuyNum;
    @BindView(R.id.tv_art_buy_contact)
    TextView tvArtBuyContact;
    @BindView(R.id.tv_art_buy_contact_phone)
    TextView tvArtBuyContactPhone;
    @BindView(R.id.art_buy_price_all)
    TextView artBuyPriceAll;
    @BindView(R.id.art_confirm_buy)
    TextView artConfirmBuy;

    SerializableMap dataMap;

    private String campsite_id;
    private String attribute;
    private String date;
    private String num;
    private String contact;
    private String contact_phone;

    private BaseObserver<ArtBuyCompleteBean> buyCompleteBeanBaseObserver;
    private HashMap<String, Object> campBuyInfoMap ;
    private BaseObserver<WXPayBean> wxPayBeanBaseObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_art_buy_complete);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void getExras() {

        Intent intent = getIntent();
        campsite_id=intent.getStringExtra("campsite_id");
        Bundle bundle = intent.getBundleExtra("mBundle");
        dataMap = (SerializableMap)bundle.getSerializable("myMap");

        if (dataMap != null) {

            attribute=dataMap.get("attribute").toString().trim();
            date=dataMap.get("date").toString().trim();
            num=dataMap.get("num").toString().trim();
            contact=dataMap.get("contact").toString().trim();
            contact_phone=dataMap.get("contact_phone").toString().trim();

        }else {
            return ;
        }

    }

    @Override
    protected void initData() {
        getCampOrder();

    }

    @Override
    protected void setListener() {

    }

    /**
     * 获得订单信息
     */
    public void getCampOrder(){
        campBuyInfoMap=new HashMap<>();
        campBuyInfoMap.put("token", MatataSPUtils.getToken());
        campBuyInfoMap.put("campsite_id",campsite_id);
        campBuyInfoMap.put("attribute",attribute);
        campBuyInfoMap.put("date",date);
        campBuyInfoMap.put("num",num);
        campBuyInfoMap.put("contact",contact);
        campBuyInfoMap.put("contact_phone",contact_phone);

        buyCompleteBeanBaseObserver=new BaseObserver<ArtBuyCompleteBean>(this,false,false) {
            @Override
            public void onSuccess(ArtBuyCompleteBean artBuyCompleteBean) {
                tvArtBuyNo.setText(artBuyCompleteBean.getNo());
                tvArtBuyPrice.setText(getPrice(artBuyCompleteBean.getPrice()));
                tvArtBuyName.setText(artBuyCompleteBean.getCampsite_name());

                tvArtBuyType.setText(artBuyCompleteBean.getAttribute());//套餐类型
                tvArtBuyDate.setText(artBuyCompleteBean.getDate());
                tvArtBuyPeople.setText(artBuyCompleteBean.getAttribute());
                tvArtBuyNum.setText(artBuyCompleteBean.getNum());
                tvArtBuyContact.setText(artBuyCompleteBean.getContact());
                tvArtBuyContactPhone.setText(artBuyCompleteBean.getContact_phone());

                artBuyPriceAll.setText(getPrice(artBuyCompleteBean.getPrice()));

                Toast.makeText(ArtBuyCompleteActivity.this, "获取成功", Toast.LENGTH_SHORT).show();

                artConfirmBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        getpayInfo(artBuyCompleteBean.getId());

                    }
                });

            }
        };

        RetrofitUtil.getInstance().getApiService().getCampOrder(campBuyInfoMap)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(buyCompleteBeanBaseObserver);
        
    }
    /**
     * 调用微信购买商品
     *
     *         "appid": "wx0c29113c18ba2dfc",
     *         "partnerid": "1540786021",
     *         "prepayid": "wx0215103882185636b00407e81547265700",
     *         "noncestr": "5de4b8eedb612",
     *         "timestamp": 1575270638,
     *         "package": "Sign=WXPay",
     *         "sign": "51EE3611FA7253DC36A2278186A8E5B9"
     *
     */
    private void getpayInfo(String id){
        Map<String,Object> map =new HashMap<String, Object>();
        map.put("token",MatataSPUtils.getToken());
        map.put("campsite_order_id",id);
        map.put("pay_type","wx");
        wxPayBeanBaseObserver=new BaseObserver<WXPayBean>(this,false,false) {
            @Override
            public void onSuccess(WXPayBean wXPayBean) {

                Intent intent = new Intent(ArtBuyCompleteActivity.this,WXPayEntryActivity.class);
                intent.putExtra("partnerid",wXPayBean.getPartnerid());
                intent.putExtra("prepayid",wXPayBean.getPrepayid());
                intent.putExtra("noncestr",wXPayBean.getNoncestr());
                intent.putExtra("timestamp",String.valueOf(wXPayBean.getTimestamp()));
                intent.putExtra("package",wXPayBean.getPackageX());
                intent.putExtra("sign",wXPayBean.getSign());
                startActivity(intent);
//                if (wXPayBean!=null){
//                    WXPayUtils.WXPayBuilder builder =new WXPayUtils.WXPayBuilder();
//                    builder.setAppId("wx0c29113c18ba2dfc")
//                            .setPartnerId(wXPayBean.getPartnerid())
//                            .setPrepayId(wXPayBean.getPrepayid())
//                            .setPackageValue(wXPayBean.getPackageX())
//                            .setNonceStr(wXPayBean.getNoncestr())
//                            .setTimeStamp(String.valueOf(wXPayBean.getTimestamp()))
//                            .setSign(wXPayBean.getSign())
//                            .build()
//                            .toWXPayNotSign(ArtBuyCompleteActivity.this,"wx0c29113c18ba2dfc");
//                }
                    finishActivity();
            }
        };
        RetrofitUtil.getInstance().getApiService().payCampsite(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wxPayBeanBaseObserver);



    }



    @Override
    protected boolean onKeyBack() {
        return false;
    }

    @Override
    protected boolean onKeyMenu() {
        return false;
    }

    /**
     * 处理接口返回String类型价格
     */
    public String getPrice(String price) {
        int a = Integer.parseInt(price);
        int b = a / 100;
        return  String.valueOf(b);
    }

}
