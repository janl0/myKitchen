package com.application.mykitchen.entities;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.mykitchen.R;

public class Dish extends RecyclerView.ViewHolder {
    private ImageView image;
    private TextView dishTitle;
    private ImageButton btn;

    /**
     * Konstruktor
     *
     * @param context Kontext in den der View platziert wird
     */
    public Dish(@NonNull View context) {
        super(context);

        image = context.findViewById(R.id.dishImage);
        dishTitle = context.findViewById(R.id.dishTitle);
        btn = context.findViewById(R.id.dishBtn);
    }

    /**
     *
     * @param drawable Bild des Gerichts
     */
    public void setImageResource(Integer drawable)
    {
        image.setImageResource(drawable);
    }

    /**
     *
     * @param title Titel des Gerichts
     */
    public void setDishTitle(String title)
    {
        dishTitle.setText(title);
    }

    /**
     * TODO
     */
    public void setBtnOnClick()
    {
        // TODO
    }
}
