package com.wl.demo.view.recyclerview.adapter;

public interface MultiItemLayoutSupport<T> {
    int getLayoutId(T item, int position);
}
