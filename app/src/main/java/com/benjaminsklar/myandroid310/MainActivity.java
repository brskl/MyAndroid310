package com.benjaminsklar.myandroid310;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.uxVolley)
    public void onVolley() {
        Intent intent = new Intent(this, VolleyActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.uxSearch)
    public void onSearch() {
        onSearchRequested();
    }

    @OnClick(R.id.uxFacebook)
    public void onFacebook() {
        Intent intent = new Intent(this, FacebookActivity.class);
        startActivity(intent);
    }

}
