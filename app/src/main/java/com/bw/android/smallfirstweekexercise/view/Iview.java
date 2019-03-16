package com.bw.android.smallfirstweekexercise.view;

import com.bw.android.smallfirstweekexercise.bean.FoodBean;

import java.util.List;

public interface Iview {
    void loadDataSuccess(List<FoodBean.DataBean> list);

    void loadDataFail();
}
