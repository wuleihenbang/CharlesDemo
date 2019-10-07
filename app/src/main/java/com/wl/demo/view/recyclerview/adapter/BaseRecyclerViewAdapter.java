package com.wl.demo.view.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<SparseArrayViewHolder> {

    protected List<T> mList;

    protected OnItemClickListener mOnItemClickListener;
    protected OnItemLongClickListener mOnItemLongClickListener;
    private int mLayoutId;
    private MultiItemLayoutSupport mMultiItemLayoutSupport;

    public BaseRecyclerViewAdapter(List<T> list, int layoutId){
        this.mList = list;
        this.mLayoutId = layoutId;
    }

    public BaseRecyclerViewAdapter(List<T> list, MultiItemLayoutSupport multiItemLayoutSupport){
        this.mList = list;
        this.mMultiItemLayoutSupport = multiItemLayoutSupport;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if(mMultiItemLayoutSupport != null){
            return mMultiItemLayoutSupport.getLayoutId(getItem(position), position);
        }

        return super.getItemViewType(position);
    }

    protected T getItem(int position){
        return mList == null ? null : mList.get(position);
    }

    @Override
    public int getItemCount(){
        return mList == null ? 0 : mList.size();
    }

    protected View inflateItemView(ViewGroup viewGroup, int layoutId){
        return inflateItemView(viewGroup, layoutId, false);
    }

    protected View inflateItemView(ViewGroup viewGroup, int layoutId, boolean attach){
        return LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, attach);
    }

    @NonNull
    @Override
    public SparseArrayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mMultiItemLayoutSupport != null){
            mLayoutId = viewType;
        }
        return new SparseArrayViewHolder(onCreateItemView(parent, mLayoutId));
    }

    protected View onCreateItemView(ViewGroup parent, int layoutId){
        return LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull SparseArrayViewHolder holder, int position) {
        final T item = getItem(position);
        bindData(holder, item);
        bindItemViewClickListener(holder, item);
    }

    private void bindItemViewClickListener(SparseArrayViewHolder holder, final T item) {
        if(mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onClick(view, item);
                }
            });
        }

        if(mOnItemLongClickListener != null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mOnItemLongClickListener.onLongClick(view, item);
                    return true;
                }
            });
        }
    }

    protected abstract void bindData(SparseArrayViewHolder holder, T item);

}
