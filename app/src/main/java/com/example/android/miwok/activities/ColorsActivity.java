package com.example.android.miwok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.adapters.WordAdapter;
import com.example.android.miwok.entities.Word;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Red", "weṭeṭṭi",getResources().getDrawable(R.drawable.color_red), getResources().getColor(R.color.category_colors)));
        words.add(new Word("Green", "Chokokki",getResources().getDrawable(R.drawable.color_green)));
        words.add(new Word("Brown", "Takaaki",getResources().getDrawable(R.drawable.color_brown)));
        words.add(new Word("Gray", "Topoppi",getResources().getDrawable(R.drawable.color_gray)));
        words.add(new Word("Black", "Kululli",getResources().getDrawable(R.drawable.color_black)));
        words.add(new Word("White", "Kelelli",getResources().getDrawable(R.drawable.color_white)));
        words.add(new Word("Dusty Yellow", "Topiise",getResources().getDrawable(R.drawable.color_dusty_yellow)));
        words.add(new Word("mustard Yellow", "Chiwite",getResources().getDrawable(R.drawable.color_mustard_yellow)));
        this.mViewHolder.colorsListView = findViewById(R.id.colors_list_view);
        WordAdapter adapter = new WordAdapter(this,words);
        this.mViewHolder.colorsListView.setAdapter(adapter);
    }

    private class ViewHolder {
        ListView colorsListView;
    }
}
