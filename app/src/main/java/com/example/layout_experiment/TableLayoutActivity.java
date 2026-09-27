package com.example.layout_experiment;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class TableLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_table_layout);

        // 强制状态栏文字/图标为白色，因为这个界面的背景是深灰 (#1E1E1E)
        WindowInsetsControllerCompat controller = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        controller.setAppearanceLightStatusBars(false);

        View mainView = findViewById(R.id.main);
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