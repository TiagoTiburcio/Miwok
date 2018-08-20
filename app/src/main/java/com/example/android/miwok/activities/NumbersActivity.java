package com.example.android.miwok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.adapters.WordAdapter;
import com.example.android.miwok.entities.Word;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // this.mViewHolder.numbersLinearLayout = findViewById(R.id.numbers_linear_layout);
        this.mViewHolder.numbersListView = findViewById(R.id.numbers_list_view);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("One", "Lutti", R.drawable.number_one  , R.color.category_numbers));
        words.add(new Word("Two", "otiiko", R.drawable.number_two  , R.color.category_numbers));
        words.add(new Word("Three", "tolookosu", R.drawable.number_three  , R.color.category_numbers));
        words.add(new Word("Four", "oyyisa", R.drawable.number_four  , R.color.category_numbers));
        words.add(new Word("Five", "massokka", R.drawable.number_five  , R.color.category_numbers));
        words.add(new Word("Six", "temmokka", R.drawable.number_six  , R.color.category_numbers));
        words.add(new Word("Seven", "kenekaku", R.drawable.number_seven  , R.color.category_numbers));
        words.add(new Word("Eight", "kawinta", R.drawable.number_eight  , R.color.category_numbers));
        words.add(new Word("Nine", "wo'e", R.drawable.number_nine  , R.color.category_numbers));
        words.add(new Word("Ten", "na'aacha", R.drawable.number_ten  , R.color.category_numbers));

        WordAdapter adapter = new WordAdapter(this, words);

        this.mViewHolder.numbersListView.setAdapter(adapter);

    }

    private class ViewHolder {
        ListView numbersListView;
    }
}
