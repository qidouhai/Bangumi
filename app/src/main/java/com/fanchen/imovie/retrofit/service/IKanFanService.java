package com.fanchen.imovie.retrofit.service;

import com.fanchen.imovie.annotation.JsoupSource;
import com.fanchen.imovie.annotation.JsoupType;
import com.fanchen.imovie.annotation.MethodSource;
import com.fanchen.imovie.annotation.MethodType;
import com.fanchen.imovie.annotation.RetrofitSource;
import com.fanchen.imovie.annotation.RetrofitType;
import com.fanchen.imovie.entity.face.IBangumiMoreRoot;
import com.fanchen.imovie.entity.face.IHomeRoot;
import com.fanchen.imovie.entity.face.IPlayUrls;
import com.fanchen.imovie.entity.face.IVideoDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by fanchen on 2017/11/16.
 */
@RetrofitType(RetrofitSource.IKANFAN_API)
public interface IKanFanService {

    /**
     *
     * @param path
     * @param page
     * @return
     */
    @GET("{path}/index{page}.html")
    @JsoupType(JsoupSource.IKANFAN)
    @MethodType(value = MethodSource.HOME)
    @RetrofitType(isJsoupResponse = true)
    Call<IHomeRoot> home(@Path("path") String path,@Path("page")Integer page);

    /**
     *
     * @param page
     * @param keyword
     * @return
     */
    @GET("search/{keyword}-{page}.html")
    @JsoupType(JsoupSource.IKANFAN)
    @MethodType(value = MethodSource.SEARCH)
    @RetrofitType(isJsoupResponse = true)
    Call<IBangumiMoreRoot> search(@Path("page") Integer page, @Path("keyword") String keyword);

    /**
     * @param path
     * @return
     */
    @GET("ac/{path}/")
    @JsoupType(JsoupSource.IKANFAN)
    @MethodType(value = MethodSource.DETAILS)
    @RetrofitType(isJsoupResponse = true)
    Call<IVideoDetails> details(@Path("path") String path);

    /**
     * @param path
     * @return
     */
    @GET
    @JsoupType(JsoupSource.IKANFAN)
    @MethodType(value = MethodSource.PLAYURL)
    @RetrofitType(isJsoupResponse = true)
    Call<IPlayUrls> playUrl(@Url String path);
}
