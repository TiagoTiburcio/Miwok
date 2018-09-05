package com.example.android.miwok.activities;

import android.content.Context;
import android.media.AudioManager;
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
        words.add(new Word(getString(R.string.one), "Lutti", R.drawable.number_one  , R.color.category_numbers, R.raw.number_one));
        words.add(new Word(getString(R.string.two), "otiiko", R.drawable.number_two  , R.color.category_numbers, R.raw.number_two));
        words.add(new Word(getString(R.string.three), "tolookosu", R.drawable.number_three  , R.color.category_numbers, R.raw.number_three));
        words.add(new Word(getString(R.string.four), "oyyisa", R.drawable.number_four  , R.color.category_numbers, R.raw.number_four));
        words.add(new Word(getString(R.string.five), "massokka", R.drawable.number_five  , R.color.category_numbers, R.raw.number_five));
        words.add(new Word(getString(R.string.six), "temmokka", R.drawable.number_six  , R.color.category_numbers, R.raw.number_six));
        words.add(new Word(getString(R.string.seven), "kenekaku", R.drawable.number_seven  , R.color.category_numbers, R.raw.number_seven));
        words.add(new Word(getString(R.string.eight), "kawinta", R.drawable.number_eight  , R.color.category_numbers, R.raw.number_eight));
        words.add(new Word(getString(R.string.nine), "wo'e", R.drawable.number_nine  , R.color.category_numbers, R.raw.number_nine));
        words.add(new Word(getString(R.string.ten), "na'aacha", R.drawable.number_ten  , R.color.category_numbers, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words);


        this.mViewHolder.numbersListView.setAdapter(adapter);
        this.mViewHolder.numbersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AudioManager am = (AudioManager) view.getContext().getSystemService(Context.AUDIO_SERVICE);
                AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
                    @Override
                    public void onAudioFocusChange(int focusChange) {

                    }
                };
                // Request audio focus for playback
                int result = am.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback
                    mMediaPlayer = MediaPlayer.create(view.getContext(), words.get(position).getmSoundWord());
                    mMediaPlayer.start();
                    am.abandonAudioFocus(afChangeListener);
                }
                Toast.makeText(view.getContext(), getString(R.string.play) + " " + words.get(position).getMiwokTranslation(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        mMediaPlayer.stop();
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
    private class ViewHolder {
        ListView numbersListView;
    }
}
