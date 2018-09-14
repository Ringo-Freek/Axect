package ru.sequenia.axect_lib;

/**
 * Задание настроек параллакса
 */
public class AxectBuilder {

    /**
     * Высота элемента, который необходимо анимировать
     */
    private float parallaxHeight = 0;

    /**
     * Изменять scaleX при анимации
     */
    private boolean scaleX = false;

    /**
     * Изменять scaleY при анимации
     */
    private boolean scaleY = false;

    /**
     * Ответчает за увеличение или уменьшение View
     * с паралакс эффектом
     * true - увеличивает по установленным scaleX и scaleY
     * false - уменьшает по установленным scaleX и scaleY
     */
    private boolean zoom = false;

    float getParallaxHeight() {
        return parallaxHeight;
    }

    public AxectBuilder setParallaxHeight(float parallaxHeight) {
        this.parallaxHeight = parallaxHeight;
        return this;
    }

    boolean isScaleX() {
        return scaleX;
    }

    public AxectBuilder setScaleX(boolean scaleX) {
        this.scaleX = scaleX;
        return this;
    }

    boolean isScaleY() {
        return scaleY;
    }

    public AxectBuilder setScaleY(boolean scaleY) {
        this.scaleY = scaleY;
        return this;
    }

    boolean isZoom() {
        return zoom;
    }

    public AxectBuilder setZoom(boolean zoom) {
        this.zoom = zoom;
        return this;
    }
}
