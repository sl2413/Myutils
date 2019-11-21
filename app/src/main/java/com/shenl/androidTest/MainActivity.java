package com.shenl.androidTest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.shenl.utils.Image.ImageUtils;
import com.shenl.utils.MyUtils.DateUtils;
import com.shenl.utils.MyUtils.PageUtils;
import com.shenl.utils.activity.BaseActivity;
import com.shenl.utils.superlibrary.adapter.BaseViewHolder;
import com.shenl.utils.superlibrary.adapter.SuperBaseAdapter;
import com.shenl.utils.superlibrary.recycleview.SuperRecyclerView;
import com.shenl.utils.view.TimeDataView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private SuperRecyclerView sup_list;
    private TimeDataView tdv_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    @Override
    public void initView() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), com.shenl.utils.R.mipmap.ic_launcher);
        PageUtils.showNotification(MainActivity.this,bitmap,1,"测试","测试内容......");
        sup_list = findViewById(R.id.sup_list);

        //倒计时
        tdv_time = findViewById(R.id.tdv_time);
    }

    @Override
    public void initData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<50;i++){
            list.add("条目"+i);
        }
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        sup_list.setLayoutManager(manager);
        sup_list.setRefreshEnabled(true);
        sup_list.setAdapter(new myAdapter(MainActivity.this,list));

        DateUtils.LimitedTime(DateUtils.DateToSecond("2019-11-23 00:00:00"),tdv_time);
    }

    @Override
    public void initEvent() {

    }

    public void openPhoto(View v){
        ImageUtils.openPhoto(MainActivity.this);
    }


    class myAdapter extends SuperBaseAdapter<String>{

        public myAdapter(Context context, List<String> data) {
            super(context, data);
        }

        @Override
        protected void convert(BaseViewHolder holder, String item, int position) {
            holder.setText(R.id.tv_text,item);
        }

        @Override
        protected int getItemViewLayoutId(int position, String item) {
            return R.layout.item;
        }
    }
}
