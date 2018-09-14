package ru.sequenia.axect_lib;

import android.support.v4.widget.NestedScrollView;
import android.view.View;

/**
 * Обертка для контента типа NestedScrollView
 */
class NestedScrollViewContent implements Content {

    private NestedScrollView content;
    private AxectView axcelView;
    private NestedScrollView.OnScrollChangeListener listener;

    NestedScrollViewContent(NestedScrollView content, View parallaxView) {
        this.content = content;
        this.axcelView = new AxectViewNestedScrollView(parallaxView);
    }

    NestedScrollViewContent(NestedScrollView content, View parallaxView,
                            NestedScrollView.OnScrollChangeListener listener) {
        this.content = content;
        this.axcelView = new AxectViewNestedScrollView(parallaxView);
        this.listener = listener;
    }

    @Override
    public void setContentListener(final ContentListener contentListener) {
        if (contentListener == null || content == null) {
            return;
        }

        content.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY,
                                       int oldScrollX, int oldScrollY) {
                contentListener.onScrolled(scrollX - oldScrollX, scrollY - oldScrollY);

                if (listener != null) {
                    listener.onScrollChange(v, scrollX, scrollY, oldScrollX, oldScrollY);
                }
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
