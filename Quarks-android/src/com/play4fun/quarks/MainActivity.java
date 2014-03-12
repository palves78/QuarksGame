package com.play4fun.quarks;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
<<<<<<< HEAD
        super.onCreate(savedInstanceState);        
        initialize(new QuarksGame());
=======
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        initialize(new QuarksGame(), cfg);
>>>>>>> casa
    }
}