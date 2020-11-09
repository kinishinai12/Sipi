package com.kinishinai.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FillUpActivity2 extends AppCompatActivity {
    private EditText edtAuthorFirst, edtAuthorLast, edtEditorFirst, edtEditorLast, edtTranslatorFirst, edtTranslatorLast,
    edtJournalTitle, edtVolume, edtNumber, edtYear, edtArticleTitle, edtPages, edtDOI, edtDate;
    private Button btnAdd, btnApa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_up2);

        edtAuthorFirst = findViewById(R.id.edtTextAuthorFirst1);
        edtAuthorLast = findViewById(R.id.edtTextAuthorLast1);

        edtEditorFirst = findViewById(R.id.edtEditorFirst);
        edtEditorLast = findViewById(R.id.edtEditorLast);

        edtTranslatorFirst = findViewById(R.id.edtTranslatorFirst);
        edtTranslatorLast = findViewById(R.id.edtTranslatorLast);

        edtJournalTitle = findViewById(R.id.edtJournalTitle);
        edtVolume = findViewById(R.id.edtVolume);
        edtNumber = findViewById(R.id.edtNumber);
        edtPages = findViewById(R.id.edtPages);
        edtDOI = findViewById(R.id.edtDOI);
        edtDate = findViewById(R.id.edtDate);
        edtYear = findViewById(R.id.edtYear);
        edtArticleTitle = findViewById(R.id.edtArticleTitle);

        btnAdd = findViewById(R.id.btnAdd);
        btnApa = findViewById(R.id.btnAPA);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_clear,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.clear_menu:
                edtAuthorFirst.setText("");
                edtAuthorLast.setText("");

                edtEditorFirst.setText("");
                edtEditorLast.setText("");

                edtTranslatorFirst.setText("");
                edtTranslatorLast.setText("");

                edtJournalTitle.setText("");
                edtVolume.setText("");
                edtNumber.setText("");
                edtPages.setText("");
                edtDOI.setText("");
                edtDate.setText("");
                edtYear.setText("");
                edtArticleTitle.setText("");
                Toast.makeText(this, "clear", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}