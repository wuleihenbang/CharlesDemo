package com.wl.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initCommonView();
        initViews();
        bindDatas();
    }

    private void initCommonView() {
        mToolbar = findViewById(R.id.tool_bar);
        if(mToolbar != null){
            mToolbar.setTitle(getCommonTitle());
            setSupportActionBar(mToolbar);
            mToolbar.setNavigationIcon(R.drawable.btn_back_selector);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }

    protected abstract String getCommonTitle();

    protected abstract void initViews();

    protected abstract void bindDatas();
}
