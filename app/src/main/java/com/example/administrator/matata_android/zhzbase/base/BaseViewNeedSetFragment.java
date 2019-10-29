package com.example.administrator.matata_android.zhzbase.base;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 *
 * startActivityForRe自定义BaseFragmentsult()、onActivityResult（）方法传递数据也可以用EventBus代替
 * BaseApplication.getInstance()
 */
public abstract class BaseViewNeedSetFragment extends Fragment {


    private Activity activity;

    /**
     * 判断activity是否为空；
     *  getActivity():获得Fragment依附的Activity对象。
     *  Fragment里边的getActivity()不推荐使用原因如下：
     *  这个方法会返回当前Fragment所附加的Activity，
     *  当Fragment生命周期结束并销毁时，getActivity()返回的是null，
     *  所以在使用时要注意判断null或者捕获空指针异常。
     * @return activity
     */
    @Nullable
    @Override
    public Context getContext() {
        activity=getActivity();
        if (activity==null){
            return BaseApplication.getInstance();
        }
        return activity;
    }



}