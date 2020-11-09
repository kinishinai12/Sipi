package com.kinishinai.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCitationStyleList;
    private CitationStyleListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCitationStyleList = findViewById(R.id.recycleViewCitationStyleList);

        showDataCitationStyles();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_setting,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings_item:
                Intent intent = new Intent(this, SettingActivity.class);
                this.startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDataCitationStyles(){
        adapter = new CitationStyleListAdapter(this);
        adapter.setCitationFormat(StyleUtils.getInstance().getAllCitationStyle());

        recyclerViewCitationStyleList.setAdapter(adapter);
        recyclerViewCitationStyleList.setLayoutManager(new GridLayoutManager(this,2));
    }

}