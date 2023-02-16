package com.example.project_midas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //initen van de views
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));


        //conecten van de views
        textView1 = findViewById(R.id.text_1);

        //functions
        setColorToGradiant(textView1);
    }


    private void setColorToGradiant(TextView textView){
        TextPaint textPaint = textView.getPaint();
        float width = textPaint.measureText(textView.getText().toString());

        textView.measure(0,0);
        System.out.println(textView.getMeasuredWidth());
        System.out.println(textView.getMeasuredHeight());
        System.out.println(textView.getWidth());
        System.out.println(textView.getHeight());
        System.out.println(width);

        Shader shader = new RadialGradient(textView.getMeasuredWidth()/2,
                textView.getMeasuredHeight()/2,
                textView.getMeasuredWidth()/3,
                new int[]{
                        Color.parseColor("#272A33"),
                        Color.parseColor("#D9C66A")
                },null,Shader.TileMode.MIRROR);
        textView.getPaint().setShader(shader);
    }
}