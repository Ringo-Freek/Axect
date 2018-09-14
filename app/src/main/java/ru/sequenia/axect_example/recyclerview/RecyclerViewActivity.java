package ru.sequenia.axect_example.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.sequenia.axect_example.R;
import ru.sequenia.axect_lib.Axect;
import ru.sequenia.axect_lib.AxectBuilder;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        RecyclerView list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Adapter adapter = new Adapter(getLayoutInflater());
        adapter.setItems(getItems());
        list.setAdapter(adapter);

        AxectBuilder builder = new AxectBuilder();
        builder.setParallaxHeight(getResources().getDimension(R.dimen.height));
        Axect parallax = new Axect(builder);
        parallax.setContent(list);
    }

    private List<Object> getItems() {
        List<Object> items = new ArrayList<>();
        items.add(new Object());
        for (int i = 0; i < 20; i++) {
            items.add("postion " + i);
        }
        return items;
    }
}
