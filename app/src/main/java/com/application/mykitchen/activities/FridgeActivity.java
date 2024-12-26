package com.application.mykitchen.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.mykitchen.R;
import com.application.mykitchen.adapters.ConsumablesAdapter;
import com.application.mykitchen.entities.Beverage;
import com.application.mykitchen.entities.Consumable;
import com.application.mykitchen.logic.DBService;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FridgeActivity extends AppCompatActivity
{
    private ConsumablesAdapter consAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fridge);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.context = this;

        initializeButtons();
        getCons();
        addConsumablesToView();
    }

    private void initializeButtons()
    {
        initAddButton();
    }

    private void initAddButton()
    {
        ImageButton add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewConsumableDialog dialog = new NewConsumableDialog(context, FridgeActivity.this, null);
                dialog.startDialog();
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

    private void getCons()
    {
        List<Consumable> testList = new ArrayList<>();

        for (int i = 0; i < 400; i++)
        {
            Consumable cons = new Beverage();
            cons.setName("Test");
            cons.setSurname("Test2");
            cons.setDrawable(R.drawable.spaghetti_sample);

            testList.add(cons);
        }
        consAdapter = new ConsumablesAdapter(testList);
    }

    private void addConsumablesToView()
    {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)this).getWindowManager().getDefaultDisplay().getMetrics(metrics);


        RecyclerView recyclerView = findViewById(R.id.shelf);
        recyclerView.getLayoutParams().height = (int) (metrics.heightPixels * 0.9);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerView.setAdapter(consAdapter);
    }

    private static class NewConsumableDialog
    {
        Context context;
        Activity activity;
        AlertDialog dialog;

        ImageView img_res;
        EditText name;
        EditText surname;
        EditText quant;
        EditText unit;

        public NewConsumableDialog(@NonNull Context context, Activity activity, HashMap<String, String> params)
        {
            this.context = context;
            this.activity = activity;
        }

        public void startDialog()
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            LayoutInflater inflater = activity.getLayoutInflater();

            builder.setView(inflater.inflate(R.layout.dialog_new_consumable, null));
            builder.setCancelable(true);

            dialog = builder.create();
            dialog.show();

            initControls();
            initButtons();
        }

        private void initControls()
        {
            img_res = dialog.findViewById(R.id.cons_img);
            name = dialog.findViewById(R.id.name);
            surname = dialog.findViewById(R.id.surname);
            quant = dialog.findViewById(R.id.quant);
            unit = dialog.findViewById(R.id.unit);
        }

        private void initButtons()
        {
            Button cancel = dialog.findViewById(R.id.cancelButton);
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            Button save = dialog.findViewById(R.id.saveBtn);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DBService service = new DBService(context);

                    Consumable cons = new Consumable();
                    cons.setName(name.getText().toString());
                    cons.setSurname(null);
                    // TODO: Wert soll als Int gespeichert werden
                    cons.setQuant(quant.getText().toString());
                    cons.setUnit(unit.getText().toString());

                    service.addConsumable(cons);
                    dialog.dismiss();
                }
            });
        }

        private void resizeControls()
        {
            int width = dialog.findViewById(R.id.quant_controls).getWidth();

            int width40P = Integer.class.cast(width * 0.4);
            int width50P = Integer.class.cast(width * 0.4);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width40P, quant.getHeight());
            quant.setLayoutParams(params);

            params = new LinearLayout.LayoutParams(width50P, quant.getHeight());
            unit.setLayoutParams(params);
        }
    }
}