package ru.sequenia.axect_lib;

interface ContentListener {

    /**
     * Слушатель на изменения положения скролла контента
     *
     * @param dx - изменение по x
     * @param dy - изменение по y
     */
    void onScrolled(int dx, int dy);
}
