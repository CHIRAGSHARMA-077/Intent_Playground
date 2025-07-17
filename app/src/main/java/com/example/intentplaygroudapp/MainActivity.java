package com.example.intentplaygroudapp;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.intentplaygroudapp.R;

public class MainActivity extends AppCompatActivity {

    private static final int IMAGE_PICK_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNavigate = findViewById(R.id.btnNavigate);
        Button btnOpenWebsite = findViewById(R.id.btnOpenWebsite);
        Button btnShareText = findViewById(R.id.btnShareText);
        Button btnPickImage = findViewById(R.id.btnPickImage);
        Button btnInfo = findViewById(R.id.btnInfo);

        btnNavigate.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, com.example.intentplaygroudapp.SecondActivity.class);
            startActivity(intent); // Explicit
        });

        btnOpenWebsite.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent); // Implicit
        });

        btnShareText.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Hey! Check out this cool app.");
            startActivity(Intent.createChooser(intent, "Share using")); // Implicit using Extra text function
        });

        btnPickImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, IMAGE_PICK_CODE); // Implicit using pick image code
        });

        btnInfo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, com.example.intentplaygroudapp.InfoActivity.class);
            startActivity(intent); // Explicit
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_PICK_CODE && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            Toast.makeText(this, "Image Picked: " + imageUri.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
