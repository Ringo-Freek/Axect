package ru.sequenia.axect_lib;

import android.view.View;

/**
 * Интерфейс, который реализует обертка для каждого типа контента
 */
interface Content {
    /**
     * Вешается слушатель на изменения контента,
     * которые влияют на параллакс
     *
     * @param listener - слушатель
     */
    void setContentListener(final ContentListener listener);

    /**
     * @return Возвращает View, для которой применяется эффект параллакса
     */
    View getAxcelView();
}
