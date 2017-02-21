package com.example.cx.startservicefromanotherapp;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //startService(new Intent(this,AppService.class));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //stopService(new Intent(this,AppService.class));
    }


}

