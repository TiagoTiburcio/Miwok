package com.example.android.miwok.activities;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.miwok.R;
import com.example.android.miwok.adapters.WordAdapter;
import com.example.android.miwok.entities.Word;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // this.mViewHolder.numbersLinearLayout = findViewById(R.id.numbers_linear_layout);
        this.mViewHolder.numbersListView = findViewById(R.id.numbers_list_view);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("One", "Lutti", R.drawable.number_one  , R.color.category_numbers, R.raw.number_one));
        words.add(new Word("Two", "otiiko", R.drawable.number_two  , R.color.category_numbers, R.raw.number_two));
        words.add(new Word("Three", "tolookosu", R.drawable.number_three  , R.color.category_numbers, R.raw.number_three));
        words.add(new Word("Four", "oyyisa", R.drawable.number_four  , R.color.category_numbers, R.raw.number_four));
        words.add(new Word("Five", "massokka", R.drawable.number_five  , R.color.category_numbers, R.raw.number_five));
        words.add(new Word("Six", "temmokka", R.drawable.number_six  , R.color.category_numbers, R.raw.number_six));
        words.add(new Word("Seven", "kenekaku", R.drawable.number_seven  , R.color.category_numbers, R.raw.number_seven));
        words.add(new Word("Eight", "kawinta", R.drawable.number_eight  , R.color.category_numbers, R.raw.number_eight));
        words.add(new Word("Nine", "wo'e", R.drawable.number_nine  , R.color.category_numbers, R.raw.number_nine));
        words.add(new Word("Ten", "na'aacha", R.drawable.number_ten  , R.color.category_numbers, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words);


        this.mViewHolder.numbersListView.setAdapter(adapter);
        this.mViewHolder.numbersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMediaPlayer = MediaPlayer.create(view.getContext(), words.get(position).getmSoundWord());
                mMediaPlayer.start();
                Toast.makeText(view.getContext(), getString(R.string.play) + " " + words.get(position).getMiwokTranslation(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class ViewHolder {
        ListView numbersListView;
    }
}
