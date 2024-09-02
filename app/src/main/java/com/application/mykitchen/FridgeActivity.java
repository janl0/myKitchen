package com.application.mykitchen;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.application.mykitchen.consumables.Beverage;
import com.application.mykitchen.consumables.Consumable;

import java.lang.reflect.Constructor;

public class FridgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fridge);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeButtons();
    }

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
}