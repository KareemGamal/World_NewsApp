package el1000mile.tpd2.b5twa.navdrawer;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {


    DrawerLayout drawerLayout;
    ListView lv ;

    ImageView img ;
    SharedPreferences sp;

    public static int Source;
    int imageID=0;



    TabLayout tabLayout;
    ViewPager viewPager;



    ArrayList<String> names;
    ArrayList<Integer> Images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showimg();

        img = (ImageView)findViewById(R.id.imageView2);
        lv=(ListView)findViewById(R.id.list);
        drawerLayout=(DrawerLayout)findViewById(R.id.Drawer);




////// Set Default or Permanent Sources And Images using Shared Preferences
        sp = this.getSharedPreferences("source" , getApplicationContext().MODE_PRIVATE);
        int id_Initial = sp.getInt("image" , R.drawable.reuter);
        img.setImageResource(id_Initial);
//////////////////////////////////////////////////////////////////////////////




        ////////// Set Navigation Drawer names and images
        names = new ArrayList<>();
        names.add(0 , "REUTERS");
        names.add(1 , "TIME");
        names.add(2 , "DAILY-MAIL");
        names.add(3 , "THE-GUARDIAN");
        names.add(4 , "BBC News");
        names.add(5 , "FOX-SPORTS");
        names.add(6 , "Four-Four Two");


        Images = new ArrayList<>();
        Images.add(0 , R.drawable.reuter);
        Images.add(1 , R.drawable.times_main);
        Images.add(2 , R.drawable.daily);
        Images.add(3 , R.drawable.theguardian_logo);
        Images.add(4 , R.drawable.bbcnews);
        Images.add(5 , R.drawable.fox);
        Images.add(6 , R.drawable.fftwo);

        ListAdapter listAdapter = new ListAdapter(names , Images , getApplicationContext());
        lv.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();

        lv.setOnItemClickListener(this);




       ////ViewPager And Tab instantiation
        ViewPagerMethod();





    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;
        switch (i)

        {
            case 0 :

                Source = 0;
                imageID = R.drawable.reuter;
                sharedPreferences = getSharedPreferences("source" , MODE_PRIVATE);
                editor = sharedPreferences.edit();

                editor.putInt("Source_URL" , Source);
                editor.putInt("image" , imageID);
                editor.commit();

                finish();
                intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();
                break;

            case 1 :
                Source = 1;
                imageID = R.drawable.times_main;
                sharedPreferences = getSharedPreferences("source" , MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putInt("Source_URL" , Source);
                editor.putInt("image" , imageID);
                editor.commit();
                finish();
                intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();

                break;


            case 2:
                Source = 2;
                imageID = R.drawable.daily;
                sharedPreferences = getSharedPreferences("source" , MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putInt("Source_URL" , Source);
                editor.putInt("image" , imageID);
                editor.commit();
                finish();
                intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();

                break;



            case 3:
                Source = 3;
                imageID = R.drawable.theguardian_logo;
                sharedPreferences = getSharedPreferences("source" , MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putInt("Source_URL" , Source);
                editor.putInt("image" , imageID);
                editor.commit();
                finish();
                intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();

                break;



            case 4:
                Source = 4;
                imageID = R.drawable.bbcnews;
                sharedPreferences = getSharedPreferences("source" , MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putInt("Source_URL" , Source);
                editor.putInt("image" , imageID);
                editor.commit();
                finish();
                intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();

                break;




            case 5 :
                Source = 5;
                imageID = R.drawable.fox;
                sharedPreferences = getSharedPreferences("source" , MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putInt("Source_URL" , Source);
                editor.putInt("image" , imageID);
                editor.commit();
                finish();
                intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();

                break;

            case 6 :
                Source = 6;
                imageID = R.drawable.fftwo;
                sharedPreferences = getSharedPreferences("source" , MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putInt("Source_URL" , Source);
                editor.putInt("image" , imageID);
                editor.commit();
                finish();
                intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();

                break;
        }
    }




    public  void  ViewPagerMethod(){

        viewPager=(ViewPager)findViewById(R.id.vPager);
        tabLayout=(TabLayout)findViewById(R.id.taplayout);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager() , getApplicationContext());
        viewPager.setAdapter(viewPagerAdapter);

        //
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }




    @Override
    public void onBackPressed() {

        super.onBackPressed();
//        Intent i =  new Intent(MainActivity.this , Start.class);
//        startActivity(i);
       // finish();
    }


    public void showimg() {

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().init(config);
    }

}
