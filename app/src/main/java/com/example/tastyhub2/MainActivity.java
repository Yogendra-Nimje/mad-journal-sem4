package com.example.tastyhub2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.example.tastyhub2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.burgur, R.drawable.pizza, R.drawable.noddles, R.drawable.pasta, R.drawable.shahipanner, R.drawable.dosa, R.drawable.vegberiyani};
        int[] ingredientList = {R.string.pastaIngredients, R.string.maggiIngredients, R.string.cakeIngredients, R.string.pancakeIngredients, R.string.pizzaIngredients, R.string.burgerIngredients, R.string.friesIngredients};
        int[] descList = {R.string.pastaDesc, R.string.maggieDesc, R.string.cakeDesc, R.string.pancakeDesc, R.string.pizzaDesc, R.string.burgerDesc, R.string.friesDesc};
        String[] nameList = {"Burgur", "Pizza", "Noodles", "Desi Pasta", "Shahi Paneer", "South Indian Dosa", "Veg Biriyani"};
        String[] timeList = {"30 mins", "2 mins", "45 mins", "10mins", "60 mins", "45mins", "30mins"};

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }

        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);
        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, activity_details.class);
                intent.putExtra("name",nameList[position]);
                intent.putExtra("time", timeList[position]);
                intent.putExtra("ingredients", ingredientList[position]);
                intent.putExtra("desc", descList[position]);
                intent.putExtra("image", imageList[position]);
                startActivity(intent);
            }
        });
        Intent i = this.getIntent();
    }
}