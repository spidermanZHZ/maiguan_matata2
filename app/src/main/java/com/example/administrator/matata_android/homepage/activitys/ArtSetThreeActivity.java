package com.example.administrator.matata_android.homepage.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.BarUtils;
import com.example.administrator.matata_android.MainActivity;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.TheatreCourseDetailsBean;
import com.example.administrator.matata_android.homepage.adapters.ArtSetDataAdapter;
import com.example.administrator.matata_android.homepage.adapters.TheatreCollageTwoSingleLayoutHelperAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class ArtSetThreeActivity extends BaseActivity {

    @BindView(R.id.title_bar)
    TitleBar titleBar;
    @BindView(R.id.line_chart)
    LineChartView lineChart;
    String[] date = {"第1个月", "第2个月", "第3个月", "第4个月", "第5个月", "第6个月", "第7个月", "第8个月", "第9个月", "第10个月"};//X轴的标注
    int[] score = {10, 22, 35, 43, 50, 64, 70, 80, 92, 100};//图表的数据点 int[] score= {10,22,25,33,40,50,56,60,72,80};砖家、学神、学霸、学弱、学渣、文盲
    @BindView(R.id.rv)
    RecyclerView rv;
    private ArtSetDataAdapter artSetDataAdapter;
    private BaseObserver<TheatreCourseDetailsBean> beanBaseObservers;
    private List<PointValue> mPointValues = new ArrayList<PointValue>();
    private List<AxisValue> mAxisXValues = new ArrayList<AxisValue>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_art_set_three);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        BarUtils.setStatusBarColor(this, getResources().getColor(R.color.background_art_set), true);
    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                Intent intent = new Intent(ArtSetThreeActivity.this, MainActivity.class);
                intent.putExtra("HomePageFragment", -1);
                startActivity(intent);
                ActivityUtils.finishActivity(ArtSetThreeActivity.this);
                ActivityUtils.finishActivity(ArtsetTwoActivity.class);
                ActivityUtils.finishActivity(ArtSetActivity.class);
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });
        getAxisXLables();//获取x轴的标注
        getAxisPoints();//获取坐标点
        initLineChart();//初始化
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        getCourseDetails();
        artSetDataAdapter=new ArtSetDataAdapter(this,null);
        rv.setAdapter(artSetDataAdapter);

    }

    /**
     * 2      * 设置X 轴的显示
     * 3
     */
    private void getAxisXLables() {
        for (int i = 0; i < date.length; i++) {
            mAxisXValues.add(new AxisValue(i).setLabel(date[i]));
        }
    }

    /**
     * 11      * 图表的每个点的显示
     * 12
     */
    private void getAxisPoints() {
        for (int i = 0; i < score.length; i++) {
            mPointValues.add(new PointValue(i, score[i]));
        }
    }

    private void initLineChart() {
        Line line = new Line(mPointValues).setColor(Color.parseColor("#FFCD41"));  //折线的颜色（橙色）
        List<Line> lines = new ArrayList<Line>();
        line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状  这里是圆形 （有三种 ：ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.DIAMOND）
        line.setCubic(false);//曲线是否平滑，即是曲线还是折线
        line.setFilled(false);//是否填充曲线的面积
        line.setHasLabels(true);//曲线的数据坐标是否加上备注
//      line.setHasLabelsOnlyForSelected(true);//点击数据坐标提示数据（设置了这个line.setHasLabels(true);就无效）
        line.setHasLines(true);//是否用线显示。如果为false 则没有曲线只有点显示
        line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示（每个数据点都是个大的圆点）
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setHasTiltedLabels(true);  //X坐标轴字体是斜的显示还是直的，true是斜的显示
        axisX.setTextColor(Color.GRAY);  //设置字体颜色
        //axisX.setName("date");  //表格名称
        axisX.setTextSize(10);//设置字体大小
        axisX.setMaxLabelChars(8); //最多几个X轴坐标，意思就是你的缩放让X轴上数据的个数7<=x<=mAxisXValues.length
        axisX.setValues(mAxisXValues);  //填充X轴的坐标名称
        data.setAxisXBottom(axisX); //x 轴在底部
        //data.setAxisXTop(axisX);  //x 轴在顶部
        axisX.setHasLines(true); //x 轴分割线

        // Y轴是根据数据的大小自动设置Y轴上限(在下面我会给出固定Y轴数据个数的解决方案)
        Axis axisY = new Axis();  //Y轴
        axisY.setName("目标完成度%");//y轴标注
        axisY.setTextSize(10);//设置字体大小
        data.setAxisYLeft(axisY);  //Y轴设置在左边
        //data.setAxisYRight(axisY);  //y轴设置在右边


        //设置行为属性，支持缩放、滑动以及平移
        lineChart.setInteractive(true);
        lineChart.setZoomType(ZoomType.HORIZONTAL);
        lineChart.setMaxZoom((float) 2);//最大方法比例
        lineChart.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        lineChart.setLineChartData(data);
        lineChart.setVisibility(View.VISIBLE);
        /**注：下面的7，10只是代表一个数字去类比而已
         * 当时是为了解决X轴固定数据个数。见（http://forum.xda-developers.com/tools/programming/library-hellocharts-charting-library-t2904456/page2）;
         */
        Viewport v = new Viewport(lineChart.getMaximumViewport());
        v.left = 0;
        v.right = 7;
        lineChart.setCurrentViewport(v);
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
    /**
     * 获取戏剧全部课程列表
     */
    private void getCourseDetails() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());


        beanBaseObservers = new BaseObserver<TheatreCourseDetailsBean>(this, true, false) {
            @Override
            public void onSuccess(TheatreCourseDetailsBean theatreCourseDetailsBean) {

                artSetDataAdapter.addData(theatreCourseDetailsBean);
                artSetDataAdapter.setOnItemClickListener(new ArtSetDataAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(mContext, TheatreCollageCourseDetailsActivity.class);
                        String id ;
//                        if (theatreCourseDetailsBean.getData().size()==1){
//                           id =String.valueOf(theatreCourseDetailsBean.getData().get(0).getId());
//                        }else {
//                            id =String.valueOf(theatreCourseDetailsBean.getData().get(position).getId());
//                        }
                        id =String.valueOf(theatreCourseDetailsBean.getData().get(position).getId());
                        intent.putExtra("offlineId",id);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                });
            }

        };
        RetrofitUtil.getInstance().getApiService().getTheatreCourseDetails(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(beanBaseObservers);


    }

}
