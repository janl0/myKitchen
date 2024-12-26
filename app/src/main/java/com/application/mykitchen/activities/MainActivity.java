package com.application.mykitchen.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.application.mykitchen.R;

/**
 * @author Jan Lindauer
 */
public class MainActivity extends AppCompatActivity {
    LinearLayout dishLayout;
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dishLayout = findViewById(R.id.card_view);
        btn = findViewById(R.id.add);

        ImageButton btnI = findViewById(R.id.basket);
        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDish("Spaghetti", R.drawable.spaghetti_sample);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FridgeActivity.class);
                startActivity(intent);
            }
        });

        addDish("Spaghetti", R.drawable.spaghetti_sample);
    }

    private void addDish(String title, Integer img)
    {
        View view = getLayoutInflater().inflate(R.layout.dish, null);

        TextView titleView = view.findViewById(R.id.dishTitle);
        titleView.setText(title);

        ImageView dishImage = view.findViewById(R.id.dishImage);
        dishImage.setImageResource(img);

        dishLayout.addView(view);
    }
}