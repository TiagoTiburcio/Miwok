package com.example.android.miwok.adapters;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.miwok.R;
import com.example.android.miwok.entities.Word;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    private ViewHolder mViewHolder = new ViewHolder();

    public WordAdapter(@NonNull Activity context, @NonNull List<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word courrentWordList =  getItem(position);

        this.mViewHolder.listItemRelativeLayout = listItemView.findViewById(R.id.list_item_relative_layout);
        this.mViewHolder.defaultTranslationTextView = listItemView.findViewById(R.id.default_text_view);
        this.mViewHolder.miwokTranslationTextView = listItemView.findViewById(R.id.miwok_text_view);
        this.mViewHolder.symbolWordImageView = listItemView.findViewById(R.id.symbol_image_view);

        if (courrentWordList != null) {
            this.mViewHolder.listItemRelativeLayout.setBackgroundResource(courrentWordList.getBackColor());
            this.mViewHolder.defaultTranslationTextView.setText(courrentWordList.getmDefaultTranslation());
            this.mViewHolder.miwokTranslationTextView.setText(courrentWordList.getMiwokTranslation());
            if (courrentWordList.getmSymbolWord() != 0) {
                this.mViewHolder.symbolWordImageView.setImageResource(courrentWordList.getmSymbolWord());
            } else {
                this.mViewHolder.symbolWordImageView.setVisibility(View.GONE);
            }
        }
        return listItemView;
    }

    private class ViewHolder {
        RelativeLayout listItemRelativeLayout;
        TextView defaultTranslationTextView;
        TextView miwokTranslationTextView;
        ImageView symbolWordImageView;
    }
}
