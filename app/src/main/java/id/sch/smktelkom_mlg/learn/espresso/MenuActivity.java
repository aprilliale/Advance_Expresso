package id.sch.smktelkom_mlg.learn.espresso;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.learn.espresso.IdlingResource.SimpleIdlingResource;
import id.sch.smktelkom_mlg.learn.espresso.model.Tea;

/**
 * Created by rongrong on 26/12/2017.
 */

public class MenuActivity extends AppCompatActivity implements ImageDownloader.DelayerCallback {

    public final static String EXTRA_TEA_NAME = "com.example.android.teatime.EXTRA_TEA_NAME";
    Intent mTeaIntent;

    @Nullable
    private SimpleIdlingResource mIdlingResource;

    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar menuToolbar = findViewById(R.id.menu_toolbar);
        setSupportActionBar(menuToolbar);
        getSupportActionBar().setTitle(getString(R.string.menu_title));

        getIdlingResource();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ImageDownloader.downloadImage(this, MenuActivity.this, mIdlingResource);
    }

    @Override
    public void onDone(ArrayList<Tea> teas) {

//        final ArrayList<Tea> teas = new ArrayList<>();
//        teas.add(new Tea(getString(R.string.black_tea_name), R.drawable.black_tea));
//        teas.add(new Tea(getString(R.string.green_tea_name), R.drawable.green_tea));
//        teas.add(new Tea(getString(R.string.white_tea_name), R.drawable.white_tea));
//        teas.add(new Tea(getString(R.string.oolong_tea_name), R.drawable.oolong_tea));
//        teas.add(new Tea(getString(R.string.honey_lemon_tea_name), R.drawable.honey_lemon_tea));
//        teas.add(new Tea(getString(R.string.chamomile_tea_name), R.drawable.chamomile_tea));

        GridView gridview = findViewById(R.id.tea_grid_view);
        TeaMenuAdapter adapter = new TeaMenuAdapter(this, R.layout.grid_item_layout, teas);
        gridview.setAdapter(adapter);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Tea item = (Tea) adapterView.getItemAtPosition(position);
                mTeaIntent = new Intent(MenuActivity.this, OrderActivity.class);
                String teaName = item.getTeaName();
                mTeaIntent.putExtra(EXTRA_TEA_NAME, teaName);
                startActivity(mTeaIntent);

            }
        });
    }
}

