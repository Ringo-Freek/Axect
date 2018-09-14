package ru.sequenia.axect_example.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

class Adapter extends RecyclerView.Adapter {

    private int HEADER = 0;
    private int ITEM = 1;

    private LayoutInflater inflater;
    private List<Object> items;

    Adapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return viewType == HEADER ? new HeaderViewHolder(inflater, parent)
                : new ItemViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == ITEM) {
            ((ItemViewHolder) holder).bind((String) items.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return !(items.get(position) instanceof String) ? HEADER : ITEM;
    }

    public void setItems(List<Object> items) {
        this.items = items;
        notifyDataSetChanged();
    }

}

