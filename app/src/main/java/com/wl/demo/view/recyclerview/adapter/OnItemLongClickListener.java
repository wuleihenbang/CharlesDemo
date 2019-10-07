package com.wl.demo.view.recyclerview.adapter;

import android.view.View;

public interface OnItemLongClickListener<T> {
    void onLongClick(View view, T item);
}
