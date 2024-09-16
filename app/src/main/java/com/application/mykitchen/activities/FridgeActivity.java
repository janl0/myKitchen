package com.application.mykitchen.activities;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.mykitchen.R;
import com.application.mykitchen.adapters.ConsumablesAdapter;
import com.application.mykitchen.entities.Beverage;
import com.application.mykitchen.entities.Consumable;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.*;

public class FridgeActivity extends AppCompatActivity
{
    private ConsumablesAdapter consAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fridge);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // initializeButtons();
        getCons();
        addConsumables();
    }

    /*
    private void initializeButtons()
    {
        Button newConsumable = findViewById(R.id.newConsumable);
        newConsumable.setOnClickListener(b -> {
            try
            {
                createNewConsumableOfType(Beverage.class);
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
    */

    /**
     *
     * @param consumable Typ der Klasse die erstellt werden soll
     * @return
     * @param <T>
     * @throws Exception
     */
    private static <T extends Consumable> T createNewConsumableOfType(Class<T> consumable) throws Exception
    {
        Constructor<T> cons = consumable.getConstructor();

        return cons.newInstance();
    }

    private void getCons()
    {
        //LinkedHashMap<Consumable, Integer> testList = new LinkedHashMap<>();

        List<Consumable> testList = new ArrayList<>();

        for (int i = 0; i < 3; i++)
        {
            Consumable cons = new Beverage();
            cons.setName("Test");
            cons.setSurname("Test2");
            cons.setDrawable(R.drawable.spaghetti_sample);

            testList.add(cons);
        }
        consAdapter = new ConsumablesAdapter(testList);
    }

    private void addConsumablesToGrid(LinkedHashMap<Consumable, Integer> list)
    {

    }

    private void addConsumables()
    {
        RecyclerView recyclerView = findViewById(R.id.shelf);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerView.setAdapter(consAdapter);
    }
}