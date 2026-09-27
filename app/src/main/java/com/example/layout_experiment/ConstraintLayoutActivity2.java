package com.example.layout_experiment;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConstraintLayoutActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_constraint_layout2);
        
        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            final int originalPaddingLeft = mainView.getPaddingLeft();
            final int originalPaddingTop = mainView.getPaddingTop();
            final int originalPaddingRight = mainView.getPaddingRight();
            final int originalPaddingBottom = mainView.getPaddingBottom();

            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
                v.setPadding(originalPaddingLeft + systemBars.left, originalPaddingTop + systemBars.top,
                        originalPaddingRight + systemBars.right, originalPaddingBottom + systemBars.bottom);
                return insets;
            });
        }
    }
}