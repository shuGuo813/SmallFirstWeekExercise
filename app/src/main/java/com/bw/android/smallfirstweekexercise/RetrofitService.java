package com.bw.android.smallfirstweekexercise;

import com.bw.android.smallfirstweekexercise.bean.FoodBean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RetrofitService {
    @GET("dish_list.php?")
    Observable<FoodBean> getSearchFood(@Query("stage_id") String id,
                                                @Query("limit") String limit,
                                                @Query("page") String page);
//@GET
//Call<FoodBean> getSearchFood(@Url String url);

}
