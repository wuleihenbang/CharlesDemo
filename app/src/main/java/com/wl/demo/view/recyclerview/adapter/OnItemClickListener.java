package com.wl.demo.view.recyclerview.adapter;

import android.view.View;

public interface OnItemClickListener<T> {
    void onClick(View view, T item);
}
