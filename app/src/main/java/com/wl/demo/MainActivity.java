package com.wl.demo;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wl.demo.model.MainModel;
import com.wl.demo.utils.FileUtils;
import com.wl.demo.view.recyclerview.GridViewDivider;
import com.wl.demo.view.recyclerview.adapter.MainRecyclerViewAdapter;
import com.wl.demo.view.recyclerview.adapter.OnItemClickListener;

import java.util.List;

public class MainActivity extends BaseActivity {


    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected String getCommonTitle() {
        return "Demo";
    }

    @Override
    protected void initViews() {
        mRecyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new GridViewDivider());
    }


    @Override
    protected void bindDatas() {
        JSONObject jsonObject = JSON.parseObject(FileUtils.readAssets(this, "main.json"));
        if(jsonObject != null){
            JSONArray jsonArray = (JSONArray) jsonObject.get("menu");
            List<MainModel> mainModelList = JSON.parseArray(jsonArray.toString(), MainModel.class);
            MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(mainModelList);
            mRecyclerView.setAdapter(adapter);
            adapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onClick(View view, Object item) {

                }
            });
        }
    }


}
