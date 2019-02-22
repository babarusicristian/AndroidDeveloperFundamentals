package cristian.babarusi.module4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cristian.babarusi.module4.recyclerview_sources.AndroidVersions;
import cristian.babarusi.module4.recyclerview_sources.AndroidVersionsAdapter;
import cristian.babarusi.module4.recyclerview_sources.Destinations;
import cristian.babarusi.module4.recyclerview_sources.DestinationsAdapter;

public class Bonus2Activity extends AppCompatActivity {

    private RecyclerView mRecyclerViewAndroidVersions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus2);

        initView();
    }

    private void initView() {
        mRecyclerViewAndroidVersions = findViewById(R.id.recyclerview_android_versions);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Bonus2Activity.this);
        mRecyclerViewAndroidVersions.setLayoutManager(layoutManager);

        AndroidVersionsAdapter androidVersionsAdapter = new AndroidVersionsAdapter(getAndroidVersionsSource(), Bonus2Activity.this);
        mRecyclerViewAndroidVersions.setAdapter(androidVersionsAdapter);
    }

    private List<AndroidVersions> getAndroidVersionsSource() {
        List<AndroidVersions> androidList = new ArrayList<>();
        AndroidVersions andVer;

        andVer = new AndroidVersions();
        andVer.setTitle("Cupcake");
        andVer.setDescription("Version: 1.5 Api Level: 3");
        andVer.setPicture(R.drawable.cupcake);
        androidList.add(andVer);

        andVer = new AndroidVersions();
        andVer.setTitle("Donut");
        andVer.setDescription("Version: 1.6 Api Level: 4");
        andVer.setPicture(R.drawable.donut);
        androidList.add(andVer);

        andVer = new AndroidVersions();
        andVer.setTitle("Eclair");
        andVer.setDescription("Version: 2.0 Api Level: 5 - 7");
        andVer.setPicture(R.drawable.eclair);
        androidList.add(andVer);

        andVer = new AndroidVersions();
        andVer.setTitle("Froyo");
        andVer.setDescription("Version: 2.2 - 2.2.3 Api Level: 8");
        andVer.setPicture(R.drawable.froyo);
        androidList.add(andVer);

        andVer = new AndroidVersions();
        andVer.setTitle("Gingerbread");
        andVer.setDescription("Version: 2.3 - 2.3.7 Api Level: 9 - 10");
        andVer.setPicture(R.drawable.gingerbread);
        androidList.add(andVer);

        andVer = new AndroidVersions();
        andVer.setTitle("Honeycomb");
        andVer.setDescription("Version: 3.0 - 3.2.6 Api Level: 11 - 13");
        andVer.setPicture(R.drawable.honeycomb);
        androidList.add(andVer);

        andVer = new AndroidVersions();
        andVer.setTitle("Ice Cream Sandwich");
        andVer.setDescription("Version: 4.0 - 4.0.4 Api Level: 14 - 15");
        andVer.setPicture(R.drawable.ice_cream_sandwich);
        androidList.add(andVer);

        andVer = new AndroidVersions();
        andVer.setTitle("Jelly Bean");
        andVer.setDescription("Version: 4.1 - 4.3.1 Api Level: 16 - 18");
        andVer.setPicture(R.drawable.jelly_bean);
        androidList.add(andVer);

        andVer = new AndroidVersions();
        andVer.setTitle("KitKat");
        andVer.setDescription("Version: 4.4 - 4.4.4 Api Level: 19 - 20");
        andVer.setPicture(R.drawable.kitkat);
        androidList.add(andVer);

        andVer = new AndroidVersions();
        andVer.setTitle("Lollipop");
        andVer.setDescription("Version: 5.0 - 5.1.1 Api Level: 21 - 22");
        andVer.setPicture(R.drawable.lollipop);
        androidList.add(andVer);

        andVer = new AndroidVersions();
        andVer.setTitle("Marshmallow");
        andVer.setDescription("Version: 6.0 - 6.0.1 Api Level: 23");
        andVer.setPicture(R.drawable.marshmallow);
        androidList.add(andVer);

        andVer = new AndroidVersions();
        andVer.setTitle("Nougat");
        andVer.setDescription("Version: 7.0 - 7.1.2 Api Level: 24 - 25");
        andVer.setPicture(R.drawable.nougat);
        androidList.add(andVer);

        andVer = new AndroidVersions();
        andVer.setTitle("Oreo");
        andVer.setDescription("Version: 8.0 - 8.1 Api Level: 26 - 27");
        andVer.setPicture(R.drawable.oreo);
        androidList.add(andVer);

        andVer = new AndroidVersions();
        andVer.setTitle("Pie");
        andVer.setDescription("Version: 9.0 Api Level: 28");
        andVer.setPicture(R.drawable.pie);
        androidList.add(andVer);

        return androidList;
    }
}
