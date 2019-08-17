package com.twm.quakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create ArrayList
        ArrayList<Show> ArrListearthquakes = new ArrayList<Show>();

        //create View instance to ListView = earthquakeListView
        ListView earthquakeListView = (ListView) findViewById(R.id.List);


        //Add Items to arrayList
        ArrListearthquakes.add(new Show(3.0, "88km N of-Yelizovo, Russia", 1454124312220L));
        ArrListearthquakes.add(new Show(6.1, "94km SSE of -Taron, Papua New Guinea", 1453777820750L));
        ArrListearthquakes.add(new Show(9.3, "50km NNE of -Al Hoceima, Morocco", 1453695722730L));
        ArrListearthquakes.add(new Show(7.0, "86km E of -Old Iliamna, Alaska", 1453631430230L));
        ArrListearthquakes.add(new Show(1.5, "215km SW of -Tomatlan, Mexico", 1453399617650L));
        ArrListearthquakes.add(new Show(6.7, "52km SE of -Shizunai, Japan", 1452741933640L));
        ArrListearthquakes.add(new Show(4.1, "12km WNW of -Charagua, Bolivia", 1452741928270L));
        ArrListearthquakes.add(new Show(8.2, "74km NW of -Rumoi, Japan", 1452532083920L));
        ArrListearthquakes.add(new Show(2.5, "227km SE of -Sarangani, Philippines", 1452530285900L));
        ArrListearthquakes.add(new Show(12.0, "  -Pacific-Antarctic Ridge", 1451986454620L));

        EarthQuacke_ArrayAdapter earthQuacke_arrayAdapter = new EarthQuacke_ArrayAdapter(MainActivity.this, ArrListearthquakes);

        earthquakeListView.setAdapter(earthQuacke_arrayAdapter);


    }
}
