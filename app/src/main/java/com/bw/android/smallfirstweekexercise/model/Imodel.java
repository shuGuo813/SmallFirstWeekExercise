package com.bw.android.smallfirstweekexercise.model;

import com.bw.android.smallfirstweekexercise.bean.FoodBean;

import java.util.List;

public interface Imodel {
    void loadSuccess(List<FoodBean.DataBean> list);

    void loadFail();
}
