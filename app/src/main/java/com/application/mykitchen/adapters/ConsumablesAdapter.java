package com.application.mykitchen.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.mykitchen.R;
import com.application.mykitchen.entities.Consumable;

import java.util.List;

/**
 * @author Jan Lindauer
 */
public class ConsumablesAdapter extends RecyclerView.Adapter<VHConsumablesAdapter.ViewHolder>
{
    private List<Consumable> consumablesDataSet;

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public ConsumablesAdapter(List<Consumable> dataSet) {
        consumablesDataSet = dataSet;
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    @NonNull
    @Override
    public VHConsumablesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.consumable, viewGroup, false);

        return new VHConsumablesAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull VHConsumablesAdapter.ViewHolder viewHolder, final int position)
    {
        viewHolder.getTextView().setText(consumablesDataSet.get(position).getName());
        viewHolder.getImageView().setImageResource(consumablesDataSet.get(position).getDrawable());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return consumablesDataSet.size();
    }
}
