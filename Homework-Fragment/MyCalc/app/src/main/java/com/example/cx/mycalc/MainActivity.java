package com.example.cx.mycalc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class MainActivity extends FragmentActivity{

    public Fragment fragment1;
    public Fragment fragment2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        // TODO Auto-generated method stub
        FragmentManager fm = getSupportFragmentManager();
        fragment1 = new EditTextFragment();
        fragment2 =  new BtnFragment();
        fm.beginTransaction().add(R.id.edittextfragment, fragment1).commit();
        fm.beginTransaction().add(R.id.btnfragment,fragment2).commit();
    }



}
