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
        words.add(new Word("Red", "weṭeṭṭi", R.drawable.color_red, R.color.category_colors));
        words.add(new Word("Green", "Chokokki", R.drawable.color_green, R.color.category_colors));
        words.add(new Word("Brown", "Takaaki", R.drawable.color_brown, R.color.category_colors));
        words.add(new Word("Gray", "Topoppi", R.drawable.color_gray, R.color.category_colors));
        words.add(new Word("Black", "Kululli", R.drawable.color_black, R.color.category_colors));
        words.add(new Word("White", "Kelelli", R.drawable.color_white, R.color.category_colors));
        words.add(new Word("Dusty Yellow", "Topiise", R.drawable.color_dusty_yellow, R.color.category_colors));
        words.add(new Word("mustard Yellow", "Chiwite", R.drawable.color_mustard_yellow, R.color.category_colors));
        this.mViewHolder.colorsListView = findViewById(R.id.colors_list_view);
        WordAdapter adapter = new WordAdapter(this,words);
        this.mViewHolder.colorsListView.setAdapter(adapter);
    }

    private class ViewHolder {
        ListView colorsListView;
    }
}
