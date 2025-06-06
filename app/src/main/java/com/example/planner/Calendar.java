package com.example.planner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //Нижнее меню
    public void toSchedule(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //finish();  // Опционально: закрыть текущий экран
    }
    public void toHomeTasks(View view) {
        Intent intent = new Intent(this, HomeTasks.class);
        startActivity(intent);
        //finish();  // Опционально: закрыть текущий экран
    }
}