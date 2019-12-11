package com.example.administrator.matata_android.growup.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.growup.activity.ChangChildInfoActivity;
import com.example.administrator.matata_android.growup.activity.FristChangChildInfoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 单行布局
 */
public class NotChildSingleLayoutHelperAdapter extends DelegateAdapter.Adapter<NotChildSingleLayoutHelperAdapter.SingleLayoutHelperViewHolder> {


    private Context mContext;

    private LayoutHelper mHelper;


    public NotChildSingleLayoutHelperAdapter(Context mContext, LayoutHelper mHelper) {
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_not_child, parent, false);
        return new SingleLayoutHelperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleLayoutHelperViewHolder holder, int position) {

        holder.growUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FristChangChildInfoActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return 1;
    }

    class SingleLayoutHelperViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.grow_up_btn)
        Button growUpBtn;
        @BindView(R.id.grow_up_iv)
        ImageView growUpIv;
        public SingleLayoutHelperViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
