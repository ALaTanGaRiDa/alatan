package com.jiyuns.alatan_kaoshi.api;

import com.jiyuns.alatan_kaoshi.bean.CateBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 阿拉坦   H1810B
 * Date: 2019/6/13
 * Time: 11:18
 */
public interface ApiService {

    //  http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1
    //

    String baseUrl = "http://www.qubaobei.com/ios/cf/";
    @GET("dish_list.php?stage_id=1&limit=20&page=1")
    Observable<CateBean> getData();
}
