package com.kinishinai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private TextView resultWorkTextView;
    private ResultRecyclerViewAdapter adapter;
    private RecyclerView recyclerViewResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        recyclerViewResultView = findViewById(R.id.recyclerViewResultView);
        //TODO apa book
        String workCitatedResult1 = getIntent().getStringExtra("work1");
        String workCitatedResult2 = getIntent().getStringExtra("work2");
        String bookTitle = getIntent().getStringExtra("bookTitle");
        String inTextCitatedResult = getIntent().getStringExtra("inText");

        adapter = new ResultRecyclerViewAdapter(this);
        recyclerViewResultView.setAdapter(adapter);
        recyclerViewResultView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<CitationResult> CiResult = new ArrayList<>();
        CiResult.add(new CitationResult(workCitatedResult1, workCitatedResult2, inTextCitatedResult, bookTitle));
        adapter.setUserInsertedData(CiResult);
        //apa book

    }



}