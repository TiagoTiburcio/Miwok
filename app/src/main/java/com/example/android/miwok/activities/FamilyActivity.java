package com.example.android.miwok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.adapters.WordAdapter;
import com.example.android.miwok.entities.Word;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private ViewHolder mvViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Father", "әpә",getResources().getDrawable(R.drawable.family_father)));
        words.add(new Word("Mother", "әṭa",getResources().getDrawable(R.drawable.family_mother)));
        words.add(new Word("Son", "angsi",getResources().getDrawable(R.drawable.family_son)));
        words.add(new Word("Daughter", "tune",getResources().getDrawable(R.drawable.family_daughter)));
        words.add(new Word("Older Brother", "taachi",getResources().getDrawable(R.drawable.family_older_brother)));
        words.add(new Word("Younger Brother", "chalitti",getResources().getDrawable(R.drawable.family_younger_brother)));
        words.add(new Word("Older Sister", "teṭe",getResources().getDrawable(R.drawable.family_older_sister)));
        words.add(new Word("Younger Sister", "kolliti",getResources().getDrawable(R.drawable.family_younger_sister)));
        words.add(new Word("Grandmother", "AMAkolliti",getResources().getDrawable(R.drawable.family_grandmother)));
        words.add(new Word("Grand Father", "paapa",getResources().getDrawable(R.drawable.family_grandfather)));

        this.mvViewHolder.familyListView = findViewById(R.id.family_list_view);

        WordAdapter adapter = new WordAdapter(this, words);
        this.mvViewHolder.familyListView.setAdapter(adapter);

    }

    private class ViewHolder {
        ListView familyListView;
    }
}
