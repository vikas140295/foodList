package com.demo.food;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Food burger, pasta, pizza, wraps;
    ArrayList<Food> foods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        burger = new Food(
                " Spicy Chicken Burger",
                "https://www.tasteofhome.com/wp-content/uploads/2018/01/Scrum-Delicious-Burgers_EXPS_CHMZ19_824_B10_30_2b.jpg",
                "Burger",
                "burgerking@gmail.com",
                new Date().toString(),
                5,
                R.drawable.burger);
        pasta = new Food(
                "Veg Alfredo Pasta",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZ7P_5DcgwUueIvj_rUPxZgQON_T9dQFH47aEts5kdwPiczpiSoA",
                "Pasta",
                "italianpasta@gmail.com",
                new Date().toString(),
                5,
                R.drawable.pasta);
        pizza = new Food(
                "Cheese Burst Pizza",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzt6M--p_2mkg_s2MvNf8BQr-z6TqsK4swVGWfrEXx7AeTJLTPqA",
                "Pizza",
                "pizzahut@gmail.com",
                new Date().toString(),
                5,
                R.drawable.pizza);
        wraps = new Food(
                "Chicken Kebab Wraps",
                "http://res.cloudinary.com/culturemap-com/image/upload/ar_4:3,c_fill,g_faces:center,w_1200/v1521046541/photos/271173_original.jpg",
                "Wraps",
                "kebabroll@gmail.com",
                new Date().toString(),
                5,
                R.drawable.wraps);
        foods.add(burger);
        foods.add(pasta);
        foods.add(pizza);
        foods.add(pasta);



    }

    public void burgerDetailsActivity(View view) {
        Intent intent = new Intent(this, ImageDetailActivity.class);
        intent.putExtra("food", burger);

        startActivityForResult(intent,0);
    }

    public void pastaDetailsActivity(View view) {
        Intent intent = new Intent(this, ImageDetailActivity.class);
        intent.putExtra("food", pasta);

        startActivityForResult(intent,1);
    }

    public void pizzaDetailsActivity(View view) {
        Intent intent = new Intent(this, ImageDetailActivity.class);
        intent.putExtra("food", pizza);

        startActivityForResult(intent,2);
    }

    public void wrapsDetailsActivity(View view) {
        Intent intent = new Intent(this, ImageDetailActivity.class);
        intent.putExtra("food", wraps);
        startActivityForResult(intent,3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == RESULT_OK) {
            Food result = data.getParcelableExtra("Altered_Result");
            foods.get(requestCode).setName(result.getName());
            foods.get(requestCode).setUrl((result.getUrl()));
            foods.get(requestCode).setKeywords(result.getDate());
            foods.get(requestCode).setEmail(result.getEmail());
        }
    }
}