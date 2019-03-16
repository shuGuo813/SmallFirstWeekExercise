package com.bw.android.smallfirstweekexercise.view;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bw.android.smallfirstweekexercise.bean.FoodBean;
import com.bw.android.smallfirstweekexercise.R;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MyrevAdapter extends RecyclerView.Adapter<MyrevAdapter.MyviewHolder> {
    List<FoodBean.DataBean> list = new ArrayList<>();
    public void refresh(List<FoodBean.DataBean> list){
        this.list = list;
        notifyDataSetChanged();
        Log.e("LSG","适配器 listSize =" + list.size());
    }
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rev_layout, null);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyviewHolder myviewHolder, int i) {
        myviewHolder.tv_revlayout.setText(list.get(i).getTitle());
//        Glide.with(myviewHolder.itemView.getContext()).load(list.get(i).getPic()).asBitmap().centerCrop().into(new BitmapImageViewTarget(myviewHolder.iv_revlayout) {
//            @Override
//            protected void setResource(Bitmap resource) {
//                RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(myviewHolder.itemView.getContext().getResources(), resource);
//                circularBitmapDrawable.setCircular(true);
//                myviewHolder.iv_revlayout.setImageDrawable(circularBitmapDrawable);
//            }
//        });
        Glide.with(myviewHolder.itemView.getContext())
                .load(list.get(i).getPic())
                .bitmapTransform(new CropCircleTransformation(myviewHolder.itemView.getContext()))
                .into(myviewHolder.iv_revlayout);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder{
        ImageView iv_revlayout;
        TextView tv_revlayout;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            iv_revlayout = itemView.findViewById(R.id.iv_revlayout);
            tv_revlayout = itemView.findViewById(R.id.tv_revlayout);
        }
    }
}
