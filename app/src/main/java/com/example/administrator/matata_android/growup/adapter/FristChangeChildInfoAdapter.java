package com.example.administrator.matata_android.growup.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;
import com.hjq.bar.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 单行布局,加载没有添加学员页面
 */
public class FristChangeChildInfoAdapter extends DelegateAdapter.Adapter<FristChangeChildInfoAdapter.SingleLayoutHelperViewHolder> {

    private Context mContext;
    private LayoutHelper mHelper;
    private static final String URL = "https://www.maiguanjy.com/";
    private String child_id;

    public FristChangeChildInfoAdapter(Context mContext, LayoutHelper mHelper) {
        this.mContext = mContext;
        this.mHelper = mHelper;

    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public SingleLayoutHelperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_chang_child_info, parent, false);
        return new SingleLayoutHelperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleLayoutHelperViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class SingleLayoutHelperViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_bar)
        TitleBar titleBar;
        @BindView(R.id.ll_child_info)
        LinearLayout llChildInfo;
        @BindView(R.id.child_info_frist_tv)
        TextView childInfoFristTv;
        @BindView(R.id.change_child_head)
        ImageView changeChildHead;
        @BindView(R.id.change_child_name)
        EditText changeChildName;
        @BindView(R.id.rb_man)
        RadioButton rbMan;
        @BindView(R.id.rb_woman)
        RadioButton rbWoman;
        @BindView(R.id.rg_gender)
        RadioGroup rgGender;
        @BindView(R.id.change_child_age)
        EditText changeChildAge;
        @BindView(R.id.change_child_sign)
        EditText changeChildSign;
        @BindView(R.id.adjust_btn_confim)
        Button adjustBtnConfim;
        public SingleLayoutHelperViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
