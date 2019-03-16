package com.bw.android.smallfirstweekexercise.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bw.android.smallfirstweekexercise.R;
import com.bw.android.smallfirstweekexercise.bean.FoodBean;
import com.bw.android.smallfirstweekexercise.presenter.Presenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements Iview{
    Unbinder unbinder;
    @BindView(R.id.rev)
    RecyclerView rev;
    Presenter presenter = new Presenter(this);
    MyrevAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rev.setLayoutManager(manager);
        rev.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rev.setItemAnimator(new DefaultItemAnimator());
        presenter.handleData();

    }

    @Override
    public void loadDataSuccess(List<FoodBean.DataBean> list) {
        Log.e("LSG","V层 listSize =" + list.size());
        Log.e("LSG","V层 listData =" + list.get(0).getPic());
        adapter = new MyrevAdapter();
        adapter.refresh(list);
        rev.setAdapter(adapter);
    }

    @Override
    public void loadDataFail() {
        Toast.makeText(this, "数据加载失败!", Toast.LENGTH_SHORT).show();
    }
}
