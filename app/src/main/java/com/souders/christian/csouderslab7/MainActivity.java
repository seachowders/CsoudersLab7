package com.souders.christian.csouderslab7;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView x = (ImageView)findViewById(R.id.x);
        x.setTag(R.drawable.x);
        ImageView o = (ImageView)findViewById(R.id.o);
        o.setTag(R.drawable.o);
        x.setOnTouchListener(this);
        o.setOnTouchListener(this);


        if(savedInstanceState != null)
        {
            setSavedListeners(savedInstanceState);
        }
        else
        {
            setDragListeners();
        }






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id ==R.id.action_about)
        {
            Toast.makeText(getApplicationContext(), "Lab 7, Winter 2016, Christian Souders", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            View.DragShadowBuilder drag = new View.DragShadowBuilder(v);
            v.startDrag(null, drag, v, 0);
            return true;
        }

        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        if(event.getAction() == DragEvent.ACTION_DROP)
        {

            View view = (View)event.getLocalState();
            int id = (int)view.getTag();
            int tag = (int)v.getTag();
            int blank = R.drawable.blank;
            if(tag!= blank)
                return false;
            ((ImageView)v).setImageResource(id);
            v.setTag(id);
            return true;
        }
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        ImageView image1 = (ImageView)findViewById(R.id.imageView1);
        outState.putInt("one", (int)image1.getTag());
        ImageView image2 = (ImageView)findViewById(R.id.imageView3);
        outState.putInt("two", (int) image2.getTag());
        ImageView image3 = (ImageView)findViewById(R.id.imageView5);
        outState.putInt("three", (int) image3.getTag());
        ImageView image4 = (ImageView)findViewById(R.id.imageView21);
        outState.putInt("four", (int) image4.getTag());
        ImageView image5 = (ImageView)findViewById(R.id.imageView23);
        outState.putInt("five", (int) image5.getTag());
        ImageView image6 = (ImageView)findViewById(R.id.imageView25);
        outState.putInt("six", (int) image6.getTag());
        ImageView image7 = (ImageView)findViewById(R.id.imageView31);
        outState.putInt("seven", (int) image7.getTag());
        ImageView image8 = (ImageView)findViewById(R.id.imageView33);
        outState.putInt("eight", (int) image8.getTag());
        ImageView image9 = (ImageView)findViewById(R.id.imageView35);
        outState.putInt("nine", (int)image9.getTag());
        super.onSaveInstanceState(outState);
    }


    public void setSavedListeners(Bundle savedInstanceState)
    {
        ImageView image1 = (ImageView)findViewById(R.id.imageView1);
        image1.setImageResource(savedInstanceState.getInt("one"));
        image1.setTag(savedInstanceState.getInt("one"));
        image1.setOnDragListener(this);
        ImageView image2 = (ImageView)findViewById(R.id.imageView3);
        image2.setImageResource(savedInstanceState.getInt("two"));
        image2.setTag(savedInstanceState.getInt("two"));
        image2.setOnDragListener(this);
        ImageView image3 = (ImageView)findViewById(R.id.imageView5);
        image3.setImageResource(savedInstanceState.getInt("three"));
        image3.setTag(savedInstanceState.getInt("three"));
        image3.setOnDragListener(this);
        ImageView image4 = (ImageView)findViewById(R.id.imageView21);
        image4.setImageResource(savedInstanceState.getInt("four"));
        image4.setTag(savedInstanceState.getInt("four"));
        image4.setOnDragListener(this);
        ImageView image5 = (ImageView)findViewById(R.id.imageView23);
        image5.setImageResource(savedInstanceState.getInt("five"));
        image5.setTag(savedInstanceState.getInt("five"));
        image5.setOnDragListener(this);
        ImageView image6 = (ImageView)findViewById(R.id.imageView25);
        image6.setImageResource(savedInstanceState.getInt("six"));
        image6.setTag(savedInstanceState.getInt("six"));
        image6.setOnDragListener(this);
        ImageView image7 = (ImageView)findViewById(R.id.imageView31);
        image7.setImageResource(savedInstanceState.getInt("seven"));
        image7.setTag(savedInstanceState.getInt("seven"));
        image7.setOnDragListener(this);
        ImageView image8 = (ImageView)findViewById(R.id.imageView33);
        image8.setImageResource(savedInstanceState.getInt("eight"));
        image8.setTag(savedInstanceState.getInt("eight"));
        image8.setOnDragListener(this);
        ImageView image9 = (ImageView)findViewById(R.id.imageView35);
        image9.setImageResource(savedInstanceState.getInt("nine"));
        image9.setTag(savedInstanceState.getInt("nine"));
        image9.setOnDragListener(this);
    }
    public void setDragListeners()
    {
        ImageView image1 = (ImageView)findViewById(R.id.imageView1);
        image1.setTag(R.drawable.blank);
        image1.setOnDragListener(this);
        ImageView image2 = (ImageView)findViewById(R.id.imageView3);
        image2.setTag(R.drawable.blank);
        image2.setOnDragListener(this);
        ImageView image3 = (ImageView)findViewById(R.id.imageView5);
        image3.setTag(R.drawable.blank);
        image3.setOnDragListener(this);
        ImageView image4 = (ImageView)findViewById(R.id.imageView21);
        image4.setTag(R.drawable.blank);
        image4.setOnDragListener(this);
        ImageView image5 = (ImageView)findViewById(R.id.imageView23);
        image5.setTag(R.drawable.blank);
        image5.setOnDragListener(this);
        ImageView image6 = (ImageView)findViewById(R.id.imageView25);
        image6.setTag(R.drawable.blank);
        image6.setOnDragListener(this);
        ImageView image7 = (ImageView)findViewById(R.id.imageView31);
        image7.setTag(R.drawable.blank);
        image7.setOnDragListener(this);
        ImageView image8 = (ImageView)findViewById(R.id.imageView33);
        image8.setTag(R.drawable.blank);
        image8.setOnDragListener(this);
        ImageView image9 = (ImageView)findViewById(R.id.imageView35);
        image9.setTag(R.drawable.blank);
        image9.setOnDragListener(this);
    }
}
