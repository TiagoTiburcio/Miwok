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
        words.add(new Word(getString(R.string.where_are_you_going), "minto wuksus", R.color.category_phrases, R.raw.phrase_where_are_you_going));
        words.add(new Word(getString(R.string.what_is_your_name), "tinnә oyaase'nә ", R.color.category_phrases, R.raw.phrase_what_is_your_name));
        words.add(new Word(getString(R.string.my_name_is), "oyaaset... ", R.color.category_phrases, R.raw.phrase_my_name_is));
        words.add(new Word(getString(R.string.how_are_you_feeling), "michәksәs? ", R.color.category_phrases, R.raw.phrase_how_are_you_feeling));
        words.add(new Word(getString(R.string.i_m_feeling_good), "kuchi achit ", R.color.category_phrases, R.raw.phrase_im_feeling_good));
        words.add(new Word(getString(R.string.are_you_coming), "әәnәs'aa? ", R.color.category_phrases, R.raw.phrase_are_you_coming));
        words.add(new Word(getString(R.string.yes_i_m_coming), "hәә’ әәnәm ", R.color.category_phrases, R.raw.phrase_yes_im_coming));
        words.add(new Word(getString(R.string.i_m_coming), "әәnәm ", R.color.category_phrases, R.raw.phrase_im_coming));
        words.add(new Word(getString(R.string.let_s_go), "yoowutis ", R.color.category_phrases, R.raw.phrase_lets_go));
        words.add(new Word(getString(R.string.come_here), "әnni'nem ", R.color.category_phrases, R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, words);

        this.mViewHolder.phrasesListView = findViewById(R.id.phrases_list_view);

        this.mViewHolder.phrasesListView.setAdapter(adapter);
        this.mViewHolder.phrasesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMediaPlayer = MediaPlayer.create(view.getContext(), words.get(position).getmSoundWord());
                mMediaPlayer.start();
                Toast.makeText(view.getContext(), getString(R.string.play) + " " + words.get(position).getMiwokTranslation(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class ViewHolder {
        ListView phrasesListView;
    }
}
