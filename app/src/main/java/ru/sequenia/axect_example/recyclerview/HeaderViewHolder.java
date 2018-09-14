package ru.sequenia.axect_example.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.sequenia.axect_example.R;
import ru.sequenia.axect_lib.AxectView;

class HeaderViewHolder extends RecyclerView.ViewHolder implements AxectView {

    private View view;

    HeaderViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.header, parent, false));
        view = itemView.findViewById(R.id.view);
    }

    @Override
    public View getView() {
        return view;
    }
}
