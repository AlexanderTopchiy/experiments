package com.wyverx.recyclers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LeakActivity extends AppCompatActivity {

    private static SomeInnerClass someInnerClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);

        if (someInnerClass == null) {
            someInnerClass = new SomeInnerClass();
        }
    }


    class SomeInnerClass {
    }
}
