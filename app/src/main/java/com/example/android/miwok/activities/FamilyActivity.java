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

public class FamilyActivity extends AppCompatActivity {
    private ViewHolder mvViewHolder = new ViewHolder();
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getString(R.string.father), "әpә",  R.drawable.family_father, R.color.category_family, R.raw.family_father));
        words.add(new Word(getString(R.string.mother), "әṭa",  R.drawable.family_mother  , R.color.category_family, R.raw.family_mother));
        words.add(new Word(getString(R.string.son), "angsi",  R.drawable.family_son  , R.color.category_family, R.raw.family_son));
        words.add(new Word(getString(R.string.daughter), "tune",  R.drawable.family_daughter  , R.color.category_family, R.raw.family_daughter));
        words.add(new Word(getString(R.string.older_brother), "taachi",  R.drawable.family_older_brother  , R.color.category_family, R.raw.family_older_brother));
        words.add(new Word(getString(R.string.younger_brother), "chalitti",  R.drawable.family_younger_brother  , R.color.category_family, R.raw.family_younger_brother));
        words.add(new Word(getString(R.string.older_sister), "teṭe",  R.drawable.family_older_sister  , R.color.category_family, R.raw.family_older_sister));
        words.add(new Word(getString(R.string.younger_sister), "kolliti",  R.drawable.family_younger_sister  , R.color.category_family, R.raw.family_younger_sister));
        words.add(new Word(getString(R.string.grandmother), "AMAkolliti",  R.drawable.family_grandmother  , R.color.category_family, R.raw.family_grandmother));
        words.add(new Word(getString(R.string.grandfather), "paapa",  R.drawable.family_grandfather  , R.color.category_family, R.raw.family_grandfather));

        this.mvViewHolder.familyListView = findViewById(R.id.family_list_view);

        WordAdapter adapter = new WordAdapter(this, words);
        this.mvViewHolder.familyListView.setAdapter(adapter);
        this.mvViewHolder.familyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        ListView familyListView;
    }
}
