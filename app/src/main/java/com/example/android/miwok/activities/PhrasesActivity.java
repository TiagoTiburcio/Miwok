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

public class PhrasesActivity extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Where are you going?", "minto wuksus", R.color.category_phrases, R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә ", R.color.category_phrases, R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset... ", R.color.category_phrases, R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs? ", R.color.category_phrases, R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "kuchi achit ", R.color.category_phrases, R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa? ", R.color.category_phrases, R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm ", R.color.category_phrases, R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "әәnәm ", R.color.category_phrases, R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "yoowutis ", R.color.category_phrases, R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem ", R.color.category_phrases, R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, words);

        this.mViewHolder.phrasesListView = findViewById(R.id.phrases_list_view);

        this.mViewHolder.phrasesListView.setAdapter(adapter);
        this.mViewHolder.phrasesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMediaPlayer = MediaPlayer.create(view.getContext(), words.get(position).getmSoundWord());
                mMediaPlayer.start();
                Toast.makeText(view.getContext(), getString(R.string.play) + " " + words.get(position).getMiwokTranslation(), Toast.LENGTH_SHORT);
            }
        });
    }

    private class ViewHolder {
        ListView phrasesListView;
    }
}
