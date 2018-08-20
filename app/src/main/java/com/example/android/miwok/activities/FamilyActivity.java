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
        words.add(new Word("Father", "әpә",  R.drawable.family_father, R.color.category_family));
        words.add(new Word("Mother", "әṭa",  R.drawable.family_mother  , R.color.category_family));
        words.add(new Word("Son", "angsi",  R.drawable.family_son  , R.color.category_family));
        words.add(new Word("Daughter", "tune",  R.drawable.family_daughter  , R.color.category_family));
        words.add(new Word("Older Brother", "taachi",  R.drawable.family_older_brother  , R.color.category_family));
        words.add(new Word("Younger Brother", "chalitti",  R.drawable.family_younger_brother  , R.color.category_family));
        words.add(new Word("Older Sister", "teṭe",  R.drawable.family_older_sister  , R.color.category_family));
        words.add(new Word("Younger Sister", "kolliti",  R.drawable.family_younger_sister  , R.color.category_family));
        words.add(new Word("Grandmother", "AMAkolliti",  R.drawable.family_grandmother  , R.color.category_family));
        words.add(new Word("Grand Father", "paapa",  R.drawable.family_grandfather  , R.color.category_family));

        this.mvViewHolder.familyListView = findViewById(R.id.family_list_view);

        WordAdapter adapter = new WordAdapter(this, words);
        this.mvViewHolder.familyListView.setAdapter(adapter);

    }

    private class ViewHolder {
        ListView familyListView;
    }
}
