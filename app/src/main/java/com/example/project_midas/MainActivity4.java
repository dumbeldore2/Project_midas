package com.example.project_midas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    //initen van views
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //view functies
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));

        //conecten van imageview
        textView2 = findViewById(R.id.text_2);

        //functions
        fun_click_1();
    }

    public void fun_click_1(){
        textView2.setOnClickListener(v -> {
            final Dialog dialog = new Dialog(MainActivity4.this);
            //title ios meegegeven dus niet nodig
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            //buiten het view klikken beindig de dialog
            dialog.setCancelable(true);
            //dialog linken
            dialog.setContentView(R.layout.activity_main4_dialog);

            //init de views van het dialoog
            final EditText editText = dialog.findViewById(R.id.edit_text_1);
            final EditText editText2 = dialog.findViewById(R.id.edit_text_2);
            Button button = dialog.findViewById(R.id.button);

            //button function
            button.setOnClickListener(v1 -> {
                String name = editText.getText().toString();
                String amount = editText2.getText().toString();
                dialog.dismiss();
            });

            dialog.show();
        });
    }
}