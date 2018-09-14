package ru.sequenia.axect_lib;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Обертка для контента типа RecyclerView
 */
public class RecyclerViewContent implements Content {

    private RecyclerView content;

    RecyclerViewContent(RecyclerView content) {
        this.content = content;
    }

    @Override
    public void setContentListener(final ContentListener listener) {
        if (listener == null || content == null) {
            return;
        }

        content.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                listener.onScrolled(dx, dy);
            }
        });
    }

    @Override
    public View getAxcelView() {
        return findAxcelView();
    }

    /**
     * Поиск AxcelView среди списка ViewHolder
     *
     * @return - View, реализуемое AxcelView
     */
    private View findAxcelView() {
        if (content == null) {
            return null;
        }

        for (int i = 0; i < content.getChildCount(); i++) {
            RecyclerView.ViewHolder viewHolder = content.getChildViewHolder(content.getChildAt(i));
            if (viewHolder instanceof AxectView) {
                return ((AxectView) viewHolder).getView();
            }
        }
        return null;
    }
}
