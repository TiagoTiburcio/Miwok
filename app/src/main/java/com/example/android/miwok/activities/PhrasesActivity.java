package com.example.android.miwok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.adapters.WordAdapter;
import com.example.android.miwok.entities.Word;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Where are you going?", "minto wuksus", R.color.category_phrases));
        words.add(new Word("What is your name?", "tinnә oyaase'nә ", R.color.category_phrases));
        words.add(new Word("My name is...", "oyaaset... ", R.color.category_phrases));
        words.add(new Word("How are you feeling?", "michәksәs? ", R.color.category_phrases));
        words.add(new Word("I’m feeling good.", "kuchi achit ", R.color.category_phrases));
        words.add(new Word("Are you coming?", "әәnәs'aa? ", R.color.category_phrases));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm ", R.color.category_phrases));
        words.add(new Word("I’m coming.", "әәnәm ", R.color.category_phrases));
        words.add(new Word("Let’s go.", "yoowutis ", R.color.category_phrases));
        words.add(new Word("Come here.", "әnni'nem ", R.color.category_phrases));

        WordAdapter adapter = new WordAdapter(this, words);

        this.mViewHolder.phrasesListView = findViewById(R.id.phrases_list_view);

        this.mViewHolder.phrasesListView.setAdapter(adapter);
    }

    private class ViewHolder {
        ListView phrasesListView;
    }
}
