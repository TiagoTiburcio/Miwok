/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.miwok.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        this.mViewHolder.numbersTextView = findViewById(R.id.numbers_text_view);
        this.mViewHolder.familyTextView = findViewById(R.id.family_text_view);
        this.mViewHolder.colorsTextView = findViewById(R.id.colors_text_view);
        this.mViewHolder.phraseTextView = findViewById(R.id.phrases_text_view);

        this.listeners();

    }

    private void listeners() {
        this.mViewHolder.numbersTextView.setOnClickListener(this);
        this.mViewHolder.familyTextView.setOnClickListener(this);
        this.mViewHolder.colorsTextView.setOnClickListener(this);
        this.mViewHolder.phraseTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent mIntent;
        if (view.getId() == findViewById(R.id.numbers_text_view).getId()) {
            mIntent = new Intent(view.getContext(), NumbersActivity.class);
            startActivity(mIntent);
        } else if (view.getId() == findViewById(R.id.family_text_view).getId()) {
            mIntent = new Intent(view.getContext(), FamilyActivity.class);
            startActivity(mIntent);
        } else if (view.getId() == findViewById(R.id.colors_text_view).getId()) {
            mIntent = new Intent(view.getContext(), ColorsActivity.class);
            startActivity(mIntent);
        } else if (view.getId() == findViewById(R.id.phrases_text_view).getId()) {
            mIntent = new Intent(view.getContext(), PhrasesActivity.class);
            startActivity(mIntent);
        }
    }

    private class ViewHolder {
        TextView numbersTextView;
        TextView familyTextView;
        TextView colorsTextView;
        TextView phraseTextView;
    }
}
