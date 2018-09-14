package ru.sequenia.axect_example.nestedscrollview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ru.sequenia.axect_example.R;
import ru.sequenia.axect_lib.Axect;
import ru.sequenia.axect_lib.AxectBuilder;

public class NestedScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nestedscrollview);

        NestedScrollView content = findViewById(R.id.content);
        View view = findViewById(R.id.view);

        AxectBuilder builder = new AxectBuilder();
        builder.setParallaxHeight(getResources().getDimension(R.dimen.height))
                .setScaleY(true)
                .setScaleX(true);
        Axect parallax = new Axect(builder);
        parallax.setContent(content, view);
    }
}
