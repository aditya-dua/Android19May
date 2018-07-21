package com.adityadua.recyclerviewandroiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    String featuresICS ="Major refinements to the \"Holo\" interface with new Roboto font family\n" +
            "Soft buttons from Android 3.x are now available for use on phones\n" +
            "Separation of widgets in a new tab, listed in a similar manner to applications\n" +
            "Easier-to-create folders, with a drag-and-drop style\n" +
            "Improved visual voicemail with the ability to speed up or slow down voicemail messages\n" +
            "Pinch-to-zoom functionality in the calendar\n" +
            "Integrated screenshot capture (accomplished by holding down the Power and Volume-Down buttons)\n" +
            "Improved error correction on the keyboard\n" +
            "Ability to access applications directly from lock screen\n" +
            "Improved copy and paste functionality\n" +
            "Better voice integration and continuous, real-time speech to text dictation\n" +
            "Face Unlock, a feature that allows users to unlock handsets using facial recognition software[86]\n" +
            "Automatic syncing of browser with users' Chrome bookmarks";

    String featuresKT="Refreshed interface with white elements instead of blue\n" +
            "Clock no longer shows bold hours; all digits are thin. The H, M, and S markings for the stopwatch and timer have been removed, leaving just the numbers.\n" +
            "Ability for applications to trigger translucency in the navigation and status bars[153]\n" +
            "Ability for applications to use \"immersive mode\" to keep the navigation and status bars hidden while maintaining user interaction";

    String featuresLL="Android Runtime (ART) with ahead-of-time (AOT) compilation and improved garbage collection (GC), replacing Dalvik that combines bytecode interpretation with trace-based just-in-time (JIT) compilation[182][184]\n" +
            "Support for 64-bit CPUs\n" +
            "OpenGL ES 3.1 and Android Extension Pack (AEP) on supported GPU configurations\n" +
            "Recent activities screen with tasks instead of applications, up to a configured maximum of tasks per application\n" +
            "Vector drawables, which scale without losing definition\n" +
            "Support for print previews\n" +
            "Material design, bringing a restyled user interface";

    String featuresMM = "Contextual search from keywords within apps.[210]\n" +
            "Introduction of Doze mode, which reduces CPU speed while the screen is off in order to save battery life[211]\n" +
            "App Standby feature\n" +
            "Alphabetically accessible vertical application drawer[212]\n" +
            "Application search bar and favorites\n" +
            "Native fingerprint reader support\n" +
            "Direct Share feature for target-specific sharing between apps[213]\n" +
            "Renamed \"Priority\" mode to \"Do Not Disturb\" mode";

    ItemData itemData[] = {

            new ItemData("Android 4.0.3 Ice Cream Sandwich (API 15)",featuresICS,R.drawable.android_4),
            new ItemData("Android 4.4 KitKat (API 19)",featuresKT,R.drawable.android_4_4),
            new ItemData("Android 5.0 Lollipop (API 21)",featuresLL,R.drawable.android_5),
            new ItemData("Android 6.0 Marshmallow (API 23)",featuresMM,R.drawable.android_6)


    };

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(itemData);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
