package com.application.mykitchen.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.application.mykitchen.R;

public class VHConsumablesAdapter {
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView consQuant;
        private final ImageView consImg;

        public ViewHolder(View view)
        {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO Consumable-Activity
                }
            });

            consQuant = (TextView) view.findViewById(R.id.foodQuantity);
            consImg = (ImageView) view.findViewById(R.id.foodImage);
        }

        public TextView getTextView() {
            return consQuant;
        }

        public ImageView getImageView() {
            return consImg;
        }
    }
}
