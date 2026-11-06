package com.example.galeria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button buttonWstecz;

    private Button dalej;

    private static List <Integer> zdjeciaId = new ArrayList<>();

    private int aktualneZdjecie =0;


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



    dalej = findViewById(R.id.button1);
        buttonWstecz = findViewById(R.id.buttonCofaj);
        imageView = findViewById(R.id.imageView);
    dalej.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                if (aktualneZdjecie == 0){
                    aktualneZdjecie = zdjeciaId.size()-1;
                }else {
                    aktualneZdjecie --;
                }
                imageView.setImageResource(zdjeciaId.get(aktualneZdjecie));
                }
            }
    );
}
    private void dodajZdiecia(){
        zdjeciaId.add(R.drawable.listek);
        zdjeciaId.add(R.drawable.las);
        zdjeciaId.add(R.drawable.szyszka);
        zdjeciaId.add(R.drawable.wyspa);
    }
}