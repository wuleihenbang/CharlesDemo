package com.wl.demo.view.recyclerview.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.wl.demo.R;
import com.wl.demo.model.MainModel;
import com.wl.demo.utils.DisplayUtils;

import java.util.List;

public class MainRecyclerViewAdapter extends BaseRecyclerViewAdapter<MainModel> {

    public MainRecyclerViewAdapter(List<MainModel> list) {
        super(list, R.layout.main_list_item);
    }

    @Override
    protected View onCreateItemView(ViewGroup parent, int layoutId) {
        View itemView = super.onCreateItemView(parent, layoutId);
        itemView.setLayoutParams(new ViewGroup.LayoutParams(DisplayUtils.getScreenWidth() / 3, DisplayUtils.getScreenHeight() / 5));
        return itemView;
    }

    @Override
    protected void bindData(SparseArrayViewHolder holder, MainModel item) {
        holder.setText(R.id.name, item.name);
    }
}
