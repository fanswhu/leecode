package com.example.myapplication.http;

import com.example.myapplication.bean.BaseResponseParams;
import com.example.myapplication.bean.PostInfo;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface RetrofitService {
    @GET("query")
    Observable<PostInfo> getPostInfo(@Query("type") String type, @Query("postid") String postid);


/**
 * 一些实例
 */

    @GET("service/getIpInfo.php/")
    Observable<Object> getData(@Query("ip") String ip);

    @GET("{url}")
    Observable<Object> executeGet(
            @Path("url") String url,
            @QueryMap Map<String, String> maps);


    @GET("{url}")
    Observable<PostInfo> executePost(
            @Path("url") String url,
            @QueryMap Map<String, Object> maps);

   /* @Multipart
    @POST("{url}")
    Observable<Object> upLoadFile(
            @Path("url") String url,
            @Part("image\\";filename =\\"image.jpg") RequestBody avatar);*/

    @POST("{url}")
    Call<Object> uploadFiles(
            @Url String url,
            @Part("filename") String description,
            @PartMap() Map<String, String> maps);
}
