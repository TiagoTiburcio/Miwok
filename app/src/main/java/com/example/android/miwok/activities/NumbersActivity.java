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
        words.add(new Word("One", "Lutti",getResources().getDrawable(R.drawable.number_one)));
        words.add(new Word("Two", "otiiko",getResources().getDrawable(R.drawable.number_two)));
        words.add(new Word("Three", "tolookosu",getResources().getDrawable(R.drawable.number_three)));
        words.add(new Word("Four", "oyyisa",getResources().getDrawable(R.drawable.number_four)));
        words.add(new Word("Five", "massokka",getResources().getDrawable(R.drawable.number_five)));
        words.add(new Word("Six", "temmokka",getResources().getDrawable(R.drawable.number_six)));
        words.add(new Word("Seven", "kenekaku",getResources().getDrawable(R.drawable.number_seven)));
        words.add(new Word("Eight", "kawinta",getResources().getDrawable(R.drawable.number_eight)));
        words.add(new Word("Nine", "wo'e",getResources().getDrawable(R.drawable.number_nine)));
        words.add(new Word("Ten", "na'aacha",getResources().getDrawable(R.drawable.number_ten)));

        WordAdapter adapter = new WordAdapter(this, words);

        this.mViewHolder.numbersListView.setAdapter(adapter);

    }

    private class ViewHolder {
        ListView numbersListView;
    }
}
