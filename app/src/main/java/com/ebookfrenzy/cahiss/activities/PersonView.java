package com.ebookfrenzy.cahiss.activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ebookfrenzy.cahiss.R;

public class PersonView extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView name;
    ImageView delete;

    public PersonView(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.cardImage);
        name = itemView.findViewById(R.id.cardName);
        delete = itemView.findViewById(R.id.delete);
    }
}
