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

public class ColorsActivity extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getString(R.string.red), "weṭeṭṭi", R.drawable.color_red, R.color.category_colors, R.raw.color_red));
        words.add(new Word(getString(R.string.green), "Chokokki", R.drawable.color_green, R.color.category_colors, R.raw.color_green));
        words.add(new Word(getString(R.string.brown), "Takaaki", R.drawable.color_brown, R.color.category_colors, R.raw.color_brown));
        words.add(new Word(getString(R.string.gray), "Topoppi", R.drawable.color_gray, R.color.category_colors, R.raw.color_gray));
        words.add(new Word(getString(R.string.black), "Kululli", R.drawable.color_black, R.color.category_colors, R.raw.color_black));
        words.add(new Word(getString(R.string.white), "Kelelli", R.drawable.color_white, R.color.category_colors, R.raw.color_white));
        words.add(new Word(getString(R.string.dusty_yellow), "Topiise", R.drawable.color_dusty_yellow, R.color.category_colors, R.raw.color_dusty_yellow));
        words.add(new Word(getString(R.string.mustard_yellow), "Chiwite", R.drawable.color_mustard_yellow, R.color.category_colors, R.raw.color_mustard_yellow));
        this.mViewHolder.colorsListView = findViewById(R.id.colors_list_view);
        WordAdapter adapter = new WordAdapter(this, words);
        this.mViewHolder.colorsListView.setAdapter(adapter);
        this.mViewHolder.colorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        ListView colorsListView;
    }
}
