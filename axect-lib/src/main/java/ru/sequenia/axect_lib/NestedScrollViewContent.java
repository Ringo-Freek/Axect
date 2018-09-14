package ru.sequenia.axect_lib;

import android.support.v4.widget.NestedScrollView;
import android.view.View;

/**
 * Обертка для контента типа NestedScrollView
 */
class NestedScrollViewContent implements Content {

    private NestedScrollView content;
    private AxectView axcelView;

    NestedScrollViewContent(NestedScrollView content, View parallaxView) {
        this.content = content;
        this.axcelView = new AxectViewNestedScrollView(parallaxView);
    }

    @Override
    public void setContentListener(final ContentListener listener) {
        if (listener == null || content == null) {
            return;
        }

        content.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY,
                                       int oldScrollX, int oldScrollY) {
                listener.onScrolled(scrollX - oldScrollX, scrollY - oldScrollY);
            }
        });
    }

    @Override
    public View getAxcelView() {
        return axcelView != null ? axcelView.getView() : null;
    }

    /**
     * Обертка для реализации интерфейса
     */
    class AxectViewNestedScrollView implements AxectView {

        private View parallaxView;

        AxectViewNestedScrollView(View parallaxView) {
            this.parallaxView = parallaxView;
        }

        @Override
        public View getView() {
            return parallaxView;
        }
    }
}
