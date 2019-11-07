package com.demo.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageDetailActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView;
    EditText nameEditText, urlEditText, keywordsEditText, dateEditText, emailEditText, ratingEditText;
    Button save;
    Food food;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        imageView = findViewById(R.id.detailImageView);
        nameEditText = findViewById(R.id.nameEditText);
        urlEditText = findViewById(R.id.urlEditText);
        keywordsEditText = findViewById(R.id.keywordsEditText);
        dateEditText = findViewById(R.id.dataEditText);
        emailEditText = findViewById(R.id.emailEditText);
        ratingEditText = findViewById(R.id.ratingEditText);
        save= findViewById(R.id.save);

        save.setOnClickListener(this);




        Intent intent = getIntent();
        food = intent.getParcelableExtra("food");
        imageView.setImageResource(food.getImageId());
        nameEditText.setText(food.getName());
        urlEditText.setText(food.getUrl());
        keywordsEditText.setText(food.getKeywords());
        dateEditText.setText(food.getDate());
        emailEditText.setText(food.getEmail());
        ratingEditText.setText(food.getRating() + "");
    }


    @Override
    public void onClick(View view) {
        Intent intent = getIntent();
        if(food !=null){
            food.setName(nameEditText.getText().toString());
            food.setEmail(emailEditText.getText().toString());
            food.setKeywords(keywordsEditText.getText().toString());
            food.setUrl(urlEditText.getText().toString());
            food.setRating(Integer.parseInt(ratingEditText.getText().toString()));
            intent.putExtra("Altered_Result",food);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}



