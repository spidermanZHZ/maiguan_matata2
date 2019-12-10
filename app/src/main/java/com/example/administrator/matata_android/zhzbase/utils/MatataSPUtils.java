package com.example.administrator.matata_android.zhzbase.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

/**
 * 自定义SP工具类
 */
public class MatataSPUtils {


    private final String SP_NAME = "language_setting";
    private final String TAG_LANGUAGE = "language_select";
    private final String TAG_SYSTEM_LANGUAGE = "system_language";
    private static volatile MatataSPUtils instance;

    private final SharedPreferences mSharedPreferences;

    private Locale systemCurrentLocal = Locale.ENGLISH;


    public MatataSPUtils(Context context) {
        mSharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }


    public void saveLanguage(int select) {
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putInt(TAG_LANGUAGE, select);
        edit.commit();
    }

    public int getSelectLanguage() {
        return mSharedPreferences.getInt(TAG_LANGUAGE, 0);
    }


    public Locale getSystemCurrentLocal() {
        return systemCurrentLocal;
    }

    public void setSystemCurrentLocal(Locale local) {
        systemCurrentLocal = local;
    }

    public static MatataSPUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (MatataSPUtils.class) {
                if (instance == null) {
                    instance = new MatataSPUtils(context);
                }
            }
        }
        return instance;
    }

    /**
     * 保存用户是否添加学员
     * @param isHaveStudent app语言
     */
    public static void saveIsHaveStudent(String isHaveStudent){
        SPUtils.getInstance("UserParts").put("isHaveStudent",isHaveStudent);


    }

    public static String getIsHaveStudent(){
        return SPUtils.getInstance("UserParts").getString("isHaveStudent");
    }


    /**
     * 保存app内语言格式
     * @param languageConfig app语言
     */
    public static void saveLanguageConfig(String languageConfig){
        SPUtils.getInstance("AppLanguage").put("languageConfig",languageConfig);


    }

    public static String getLanguageConfig(){
        return SPUtils.getInstance("AppLanguage").getString("languageConfig");
    }

    /**
     * 保存用户token
     * @param token
     */
    public static void saveToken(String token){
        SPUtils.getInstance("UserParts").put("token",token);

    }
    public static String getToken(){
        return SPUtils.getInstance("UserParts").getString("token");
    }

    /**
     * 保存用户账号
     * @param phone
     */

    public static void saveAccount(String phone){
        SPUtils.getInstance("UserParts").put("phone",phone);
    }
    public static String getAccount(){
        return SPUtils.getInstance("UserParts").getString("phone");

    }

    /**
     * 保存用户密码
     * @param pwd
     */
    public static void savePassword(String pwd){
        SPUtils.getInstance("UserParts").put("pwd",pwd);
    }
    public static  String getPassword(){
        return SPUtils.getInstance("UserParts").getString("pwd");
    }
    /**
     * 保存用户是否是会员
     * @param isVip 0：不是;1:是
     */
    public static void saveIsVip(String isVip){
        SPUtils.getInstance("UserParts").put("isVip",isVip);
    }
    public static  String getIsVip(){
        return SPUtils.getInstance("UserParts").getString("isVip");
    }
    /**
     * 保存用户id
     * @param userId
     */
    public static void saveUserId(String userId){
        SPUtils.getInstance("UserParts").put("userId",userId);
    }
    public static  String getUserId(){
        return SPUtils.getInstance("UserParts").getString("userId");
    }



    /**
      * 保存用户选择价格position
     */
    public static void savePricePosition(int position){
        SPUtils.getInstance("UserParts").put("position",position);
    }
    public static int getPricePosition(){
        return SPUtils.getInstance("UserParts").getInt("position");
    }

    /**
     * 保存Bean类
     * @param context
     * @param t
     * @param fileName
     * @param keyName
     * @param <T>
     */
    public static <T> void saveBean2Sp(Context context, T t, String fileName, String keyName) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        ByteArrayOutputStream bos;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(t);
            byte[] bytes = bos.toByteArray();
            String ObjStr = Base64.encodeToString(bytes, Base64.DEFAULT);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(keyName, ObjStr);
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.flush();
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Toast.makeText(context, "保存个人信息成功", Toast.LENGTH_SHORT).show();
    }

    public static <T extends Object> T getBeanFromSp(Context context, String fileName, String keyNme) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        byte[] bytes = Base64.decode(preferences.getString(keyNme, ""), Base64.DEFAULT);
        ByteArrayInputStream bis;
        ObjectInputStream ois = null;
        T obj = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bis);
            obj = (T) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }






}
