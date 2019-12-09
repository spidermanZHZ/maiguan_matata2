package com.example.administrator.matata_android.my.adapters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyExtendBean;
import com.example.administrator.matata_android.my.fragments.MyExtendFriendFragment;
import com.example.administrator.matata_android.my.fragments.MyExtendMoneyFragment;
import com.example.administrator.matata_android.my.fragments.MyExtendTeacherFragment;

public class MyExtendSingleTwoAdapter extends DelegateAdapter.Adapter<MyExtendSingleTwoAdapter.SingleLayoutHelperViewHolder> {

    private FragmentActivity mContext;
    private LayoutHelper mHelper;
    private int type;
    private MyExtendBean myExtendBean;
    private MyExtendMoneyFragment myExtendMoneyFragment;
    private MyExtendFriendFragment myExtendFriendFragment;
    private MyExtendTeacherFragment myExtendTeacherFragment;


    public  void addData(MyExtendBean myExtendBean){
        this.myExtendBean=myExtendBean;
        notifyDataSetChanged();
    }
    public MyExtendSingleTwoAdapter(FragmentActivity mContext, LayoutHelper mHelper,MyExtendBean myExtendBean) {
        this.mContext = mContext;
        this.mHelper = mHelper;
        this.myExtendBean=myExtendBean;
    }

    /**
     * 设置显示的fragment
     * @param types
     */
    public void setType(int types){
        this.type=types;
        notifyDataSetChanged();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public SingleLayoutHelperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_extend_single2,parent,false);
        return new SingleLayoutHelperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleLayoutHelperViewHolder singleLayoutHelperViewHolder, int position) {
        if (myExtendBean!=null){
            onFragmentRbClick(type);
        }else {
            Toast.makeText(mContext, "未获取到数据", Toast.LENGTH_SHORT).show();
        }
      
    }



    @Override
    public int getItemCount() {
        return 1;
    }

    /**
     * 切换fragment监听
     * @param type fragment对应角标
     */
    private void onFragmentRbClick(int type){
        //开启事务
        FragmentManager manager = mContext.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        //显示之前将所有的fragment都隐藏起来,在去显示我们想要显示的fragment
        hideFragment(fragmentTransaction);
        switch (type){
            case 0:
                if (myExtendMoneyFragment==null){
                    myExtendMoneyFragment=new MyExtendMoneyFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,myExtendMoneyFragment);
                    //往fragment传递数据
                    Bundle bundle1= new Bundle();
                    bundle1.putSerializable("myExtendMoneyFragment", myExtendBean);
                    myExtendMoneyFragment.setArguments(bundle1);
                }else {
                    fragmentTransaction.show(myExtendMoneyFragment);
                }
                break;
            case 1:
                if (myExtendFriendFragment==null){
                    myExtendFriendFragment=new MyExtendFriendFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,myExtendFriendFragment);
                    //往fragment传递数据
                    Bundle bundle2= new Bundle();
                    bundle2.putSerializable("MyExtendFriendFragment", myExtendBean);
                    myExtendFriendFragment.setArguments(bundle2);
                }else {
                    fragmentTransaction.show(myExtendFriendFragment);
                }
                break;
            case 2:
                if (myExtendTeacherFragment==null){
                    myExtendTeacherFragment=new MyExtendTeacherFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,myExtendTeacherFragment);
                    //往fragment传递数据
                    Bundle bundle3= new Bundle();
                    bundle3.putSerializable("MyExtendTeacherFragment", myExtendBean);
                    myExtendTeacherFragment.setArguments(bundle3);
                }else {
                    fragmentTransaction.show(myExtendTeacherFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    /**
     *  隐藏Fragment的方法
     * @param fragmentTransaction
     */
    private void hideFragment(FragmentTransaction fragmentTransaction){
        //不为空隐藏
        if (myExtendMoneyFragment!=null){
            fragmentTransaction.hide(myExtendMoneyFragment);
        }
        if (myExtendFriendFragment!=null){
            fragmentTransaction.hide(myExtendFriendFragment);
        }
        if (myExtendTeacherFragment!=null){
            fragmentTransaction.hide(myExtendTeacherFragment);
        }
    }



    class SingleLayoutHelperViewHolder extends RecyclerView.ViewHolder{

        public SingleLayoutHelperViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
