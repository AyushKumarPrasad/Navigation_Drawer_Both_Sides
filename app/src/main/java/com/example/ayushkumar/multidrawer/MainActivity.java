package com.example.ayushkumar.multidrawer;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity
{
    Toolbar t1;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawwerToggle;
    ImageButton imgLeft, imgRight;
    GridView gv, drawer_left, drawer_right ;
    CustomAdapter cl1, cl2, cl3;
    int img[];
    String name [];
    String j;
    Context con = this ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t1);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        gv = (GridView) findViewById(R.id.main_grid);
        drawer_left = (GridView) findViewById(R.id.drawer_left);
        drawer_right = (GridView) findViewById(R.id.drawer_right);
        imgLeft = (ImageButton) findViewById(R.id.imgLeft);
        imgRight = (ImageButton) findViewById(R.id.imgRight);
        mDrawerLayout.setDrawerListener(mDrawwerToggle);

        imgLeft.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                if (mDrawerLayout.isDrawerOpen(drawer_left))
                {
                    mDrawerLayout.closeDrawer(drawer_left);
                }

                else if (!mDrawerLayout.isDrawerOpen(drawer_left))
                {
                    mDrawerLayout.openDrawer(drawer_left);
                }

                if (mDrawerLayout.isDrawerOpen(drawer_right))
                {
                    mDrawerLayout.closeDrawer(drawer_right);
                }
            }
        });
        imgRight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (mDrawerLayout.isDrawerOpen(drawer_right))
                {
                    mDrawerLayout.closeDrawer(drawer_right);
                }

                else if (!mDrawerLayout.isDrawerOpen(drawer_right))
                {
                    mDrawerLayout.openDrawer(drawer_right);
                }

                if (mDrawerLayout.isDrawerOpen(drawer_left))
                {
                    mDrawerLayout.closeDrawer(drawer_left);
                }
            }
        });
        getData();

    }

    private void getData()
    {
        j = "Ayush,Ashish,Neha,Shiva";
        name = j.split(",");
        img = new int[]{R.drawable.calendar, R.drawable.friends, R.drawable.lovely_time, R.drawable.team_time};

        cl1 = new CustomAdapter(name, con, img);
        gv.setAdapter(cl1);

        cl2 = new CustomAdapter(name, con, img);
        drawer_left.setAdapter(cl1);

        cl3 = new CustomAdapter(name, con, img);
        drawer_right.setAdapter(cl1);

    }
}
