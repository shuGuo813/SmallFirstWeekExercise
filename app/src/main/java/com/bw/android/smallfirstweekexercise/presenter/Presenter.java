package com.bw.android.smallfirstweekexercise.presenter;

import android.util.Log;

import com.bw.android.smallfirstweekexercise.bean.FoodBean;
import com.bw.android.smallfirstweekexercise.model.Imodel;
import com.bw.android.smallfirstweekexercise.model.Model;
import com.bw.android.smallfirstweekexercise.view.Iview;

import java.util.List;

public class Presenter implements Imodel {
    Iview iview;

    public Presenter(Iview iview){
        this.iview = iview;
    }
    Model model = new Model(this,"http://www.qubaobei.com/ios/cf/",1,20,1);
    public void handleData(){
        model.getdata();
    }
    @Override
    public void loadSuccess(List<FoodBean.DataBean> list) {
        Log.e("LSG","P层 listSize =" + list.size());
        iview.loadDataSuccess(list);
    }

    @Override
    public void loadFail() {

    }
}
