package ru.sequenia.axect_lib;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Класс по убравлению параллакса
 */
public class Axect implements ContentListener {
    /**
     * Высота элемента, который необходимо анимировать
     */
    private float parallaxHeight;

    /**
     * Изменять scaleX при анимации
     */
    private boolean scaleX;

    /**
     * Изменять scaleY при анимации
     */
    private boolean scaleY;

    /**
     * Ответчает за увеличение или уменьшение View
     * с паралакс эффектом
     * true - увеличивает по установленным scaleX и scaleY
     * false - уменьшает по установленным scaleX и scaleY
     */
    private boolean zoom;

    /**
     * Текущее положение контента
     */
    private float scrollPosition = 0;

    /**
     * Обертка для скролящегося контента
     */
    private Content content;

    public Axect(AxectBuilder builder) {
        if (builder == null) {
            return;
        }
        this.parallaxHeight = builder.getParallaxHeight();
        this.scaleX = builder.isScaleX();
        this.scaleY = builder.isScaleY();
        this.zoom = builder.isZoom();
    }

    /**
     * Задачается контент, в котором находится View для эффекта парллакса
     *
     * @param view - контент
     */
    public void setContent(RecyclerView view) {
        content = new RecyclerViewContent(view);
        content.setContentListener(this);
    }

    /**
     * Задачается контент, в котором находится View для эффекта парллакса
     *
     * @param view         - контент
     * @param parallaxView - View, для которой создается эффект параллакса
     */
    public void setContent(NestedScrollView view, View parallaxView) {
        content = new NestedScrollViewContent(view, parallaxView);
        content.setContentListener(this);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        scrollPosition += dy;
        if (parallaxHeight == 0) {
            return;
        }
        onParallaxView(Math.min(scrollPosition / parallaxHeight, 1));
    }

    /**
     * Паралакс View
     *
     * @param slideOffset - свиг
     */
    private void onParallaxView(float slideOffset) {
        if (content == null) {
            return;
        }

        View view = content.getAxcelView();
        if (view == null) {
            return;
        }

        translation(view, slideOffset);
        scale(view, slideOffset);
        view.invalidate();
    }

    private void translation(View view, float slideOffset) {
        float dy = slideOffset / 2;
        float translate = dy * parallaxHeight;
        view.setTranslationY(translate);
    }

    /**
     * Меняется scale для View
     *
     * @param view        - для которой применяется эффект параллакса
     * @param slideOffset - значение смещения относительно исходного положения
     */
    private void scale(View view, float slideOffset) {
        if (!scaleY && !scaleX) {
            return;
        }

        float scale = Math.max(1 - slideOffset, 0.5f);
        float scaleValue = !zoom ? scale : 1 / scale;

        if (scaleX) {
            view.setScaleX(scaleValue);
        }

        if (scaleY) {
            view.setScaleY(scaleValue);
        }
    }
}
