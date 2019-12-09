package com.example.administrator.matata_android.httputils;

import com.example.administrator.matata_android.bean.ArtBuyCompleteBean;
import com.example.administrator.matata_android.bean.ArtCampATListBean;
import com.example.administrator.matata_android.bean.ArtCampBean;
import com.example.administrator.matata_android.bean.ArtCampInfoBean;
import com.example.administrator.matata_android.bean.ChildDetailsBean;
import com.example.administrator.matata_android.bean.ChildId;
import com.example.administrator.matata_android.bean.HomepagerTeacherBean;
import com.example.administrator.matata_android.bean.LoginBean;
import com.example.administrator.matata_android.bean.MusicHotBean;
import com.example.administrator.matata_android.bean.MusicOffLineBean;
import com.example.administrator.matata_android.bean.MusicOnlineBean;
import com.example.administrator.matata_android.bean.MyExtendBean;
import com.example.administrator.matata_android.bean.MyFollowBean;
import com.example.administrator.matata_android.bean.OffLineCourseBean;
import com.example.administrator.matata_android.bean.OnLineCourseBean;
import com.example.administrator.matata_android.bean.TeacherDetailsInfoBean;
import com.example.administrator.matata_android.bean.TeacherInfoBean;
import com.example.administrator.matata_android.bean.TheatreCourseDetailsBean;
import com.example.administrator.matata_android.bean.TheatreHotInfoBean;
import com.example.administrator.matata_android.bean.UserInfoBean;
import com.example.administrator.matata_android.bean.WXPayBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;


/**
 * 请求接口
 *
 *  //    @Path：所有在网址中的参数（URL的问号前面），如：
 * //    http://102.10.10.132/api/Accounts/{accountId}
 * //    @Query：URL问号后面的参数，如：
 * //    http://102.10.10.132/api/Comments?access_token={access_token}
 * //    @QueryMap：相当于多个@Query
 * //    @Field：用于POST请求，提交单个数据
 * //    @Body：相当于多个@Field，以对象的形式提交
 */
public interface APIService {

    /**
     * 登录
     * @param map
     * @return
     */
    @POST("login")
    @FormUrlEncoded
    Observable<BaseBeanResponse<LoginBean>> loginapp(@FieldMap Map<String, Object> map);

    /**
     * 发送手机号验证码
     * @param
     * @return
     */
    @POST("send/code")
    @FormUrlEncoded
    Observable<BaseBeanResponse<Object>>sendcode(@FieldMap Map<String, Object> map);

    /**
     * 验证手机验证码
     * @param map
     * @return
     */
    @POST("check/code")
    @FormUrlEncoded
    Observable<BaseBeanResponse<Object>>confimcode(@FieldMap Map<String,Object> map);

    /**
     *  注册账号
     * @param map
     * @return
     */
    @POST("register")
    @FormUrlEncoded
    Observable<BaseBeanResponse<LoginBean>>registerAccount(@FieldMap Map<String,Object> map);

    /**
     *  找回密码
     * @param map
     * @return
     */
    @POST("find/pwd")
    @FormUrlEncoded
    Observable<BaseBeanResponse<Object>>findpwd(@FieldMap Map<String ,Object> map);



    /**
     * 获取营地列表热门活动列表
     * @param map
     * @return
     */
    @GET("campsite/hot")
    Observable<BaseBeanResponse<ArtCampBean>> getartcampList(@QueryMap Map<String,Object> map);

    /**
     * 获取某一营地全部活动
     * @param map
     * @return
     */
    @GET("campsite")
    Observable<BaseBeanResponse<ArtCampATListBean>> getArtCampAllList(@QueryMap Map<String,Object> map);

    /**
     * 获取营地活动详情
     * @param map
     * @return
     */
    @GET("campsite/details")
    Observable<BaseBeanResponse<ArtCampInfoBean>> getcampatinfo(@QueryMap Map<String ,Object> map);

    /**
     * 获取营地订单信息
     * @param map
     * @return
     */
   @POST("campsite/order")
   @FormUrlEncoded
    Observable<BaseBeanResponse<ArtBuyCompleteBean>>getCampOrder(@FieldMap Map<String,Object> map);



    /**
     *  添加一名学员
     *  图片文件上传，需要添加@Multipart注解
     * @return
     */
    @Multipart
    @POST("child/add")
    Observable<BaseBeanResponse<ChildId>>addStudent(@Part("token")RequestBody token,@Part("name")RequestBody name,@Part("sex")RequestBody sex,@Part("age")RequestBody age,@Part("signature")RequestBody signature,@Part MultipartBody.Part image);


    /**
     * 根据id获取学员详情
     * @param map
     * @return
     */
    @GET("child/details")
    Observable<BaseBeanResponse<ChildDetailsBean>> getChildDetails(@QueryMap Map<String ,Object> map);

    /**
     *  找回密码
     * @param map
     * @return
     */
    @POST("child/plan")
    @FormUrlEncoded
    Observable<BaseBeanResponse<Object>>changeTime(@FieldMap Map<String ,Object> map);



    /**
     * 音乐学院最新上架
     * @param map
     * @return
     */
    @GET("course/new")
    Observable<BaseBeanResponse<List<MusicHotBean>>> getMusicHot(@QueryMap Map<String ,Object> map);

    /**
     * 音乐学院线上课程
     * @param map
     * @return
     */
    @GET("course/online")
    Observable<BaseBeanResponse<MusicOnlineBean>> getMusicOnline(@QueryMap Map<String ,Object> map);

    /**
     * 音乐学院线下课程
     * @param map
     * @return
     */
    @GET("course/offline")
    Observable<BaseBeanResponse<MusicOffLineBean>> getMusicOffline(@QueryMap Map<String ,Object> map);

    /**
     * 音乐学院线上课程详情
     * @param map
     * @return
     */
    @GET("course/online/details")
    Observable<BaseBeanResponse<OnLineCourseBean>> getOnlineCourse(@QueryMap Map<String ,Object> map);

    /**
     * 首页信息
     * @param map
     * @return
     */
    @GET("index")
    Observable<BaseBeanResponse<HomepagerTeacherBean>> getHomePagerInfo(@QueryMap Map<String ,Object> map);


    /**
     * 首页信息
     * @param map
     * @return
     */
    @GET("course/drama/new")
    Observable<BaseBeanResponse<TheatreHotInfoBean>> getTheatreInfo(@QueryMap Map<String ,Object> map);
    /**
     * 戏剧学院课程列表
     * @param map
     * @return
     */
    @GET("course/drama")
    Observable<BaseBeanResponse<TheatreCourseDetailsBean>> getTheatreCourseDetails(@QueryMap Map<String ,Object> map);

    /**
     * 音乐学院线下课程详情
     * @param map
     * @return
     */
    @GET("course/offline/details")
    Observable<BaseBeanResponse<OffLineCourseBean>> getOfflineCourse(@QueryMap Map<String ,Object> map);

    /**
     * 老师列表
     * @param map
     * @return
     */
    @GET("teacher")
    Observable<BaseBeanResponse<TeacherInfoBean>> getTeacherList(@QueryMap Map<String ,Object> map);

    /**
     * 音乐学院线下课程详情
     * @param map
     * @return
     */
    @GET("teacher/details")
    Observable<BaseBeanResponse<TeacherDetailsInfoBean>> getTeacherDetails(@QueryMap Map<String ,Object> map);
    /**
     * 获取用户个人信息
     * @param map
     * @return
     */
    @GET("user")
    Observable<BaseBeanResponse<UserInfoBean>> getUserInfo(@QueryMap Map<String ,Object> map);


    /**
     * 收藏课程丶教师
     * @param
     * @return
     */
    @POST("favorite")
    @FormUrlEncoded
    Observable<BaseBeanResponse<Object>>favoriteProject(@FieldMap Map<String, Object> map);

    /**
     * 获取我的收藏列表
     * @param map
     * @return
     */
    @GET("user/favorite")
    Observable<BaseBeanResponse<MyFollowBean>> getFavoriteProject(@QueryMap Map<String ,Object> map);

    /**
     * 购买营地接口
     * @param
     * @return
     */
    @POST("campsite/pay")
    @FormUrlEncoded
    Observable<BaseBeanResponse<WXPayBean>>payCampsite(@FieldMap Map<String, Object> map);

    /**
     * 获取推广中心资源
     * @param map
     * @return
     */
    @GET("user/popularize")
    Observable<BaseBeanResponse<MyExtendBean>> getExtendInfo(@QueryMap Map<String ,Object> map);

}
