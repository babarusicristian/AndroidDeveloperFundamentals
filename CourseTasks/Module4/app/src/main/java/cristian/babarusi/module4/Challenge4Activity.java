package cristian.babarusi.module4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cristian.babarusi.module4.recyclerview_sources.Destinations;
import cristian.babarusi.module4.recyclerview_sources.DestinationsAdapter;

public class Challenge4Activity extends AppCompatActivity {

    private RecyclerView mRecyclerViewDestinations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge4);

        initView();
    }

    private void initView() {
        mRecyclerViewDestinations = findViewById(R.id.recyclerview_destinations);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Challenge4Activity.this);
        mRecyclerViewDestinations.setLayoutManager(layoutManager);

        DestinationsAdapter destinationsAdapter = new DestinationsAdapter(getDestinations(), Challenge4Activity.this);
        mRecyclerViewDestinations.setAdapter(destinationsAdapter);
    }

    private List<Destinations> getDestinations() {
        List<Destinations> destinationsList = new ArrayList<>();
        Destinations dest;

        dest = new Destinations();
        dest.setTitle("Holiday 2017");
        dest.setDescription("Islands");
        dest.setPicture(R.drawable.islands);
        destinationsList.add(dest);

        dest = new Destinations();
        dest.setTitle("Fall 2017");
        dest.setDescription("Rome");
        dest.setPicture(R.drawable.rome);
        destinationsList.add(dest);

        dest = new Destinations();
        dest.setTitle("Summer 2017");
        dest.setDescription("London");
        dest.setPicture(R.drawable.london);
        destinationsList.add(dest);

        dest = new Destinations();
        dest.setTitle("Winter 2017");
        dest.setDescription("Paris");
        dest.setPicture(R.drawable.paris);
        destinationsList.add(dest);

        dest = new Destinations();
        dest.setTitle("Spring 2018");
        dest.setDescription("San Francisco");
        dest.setPicture(R.drawable.san_francisco);
        destinationsList.add(dest);

        dest = new Destinations();
        dest.setTitle("Summer 2018");
        dest.setDescription("Greece");
        dest.setPicture(R.drawable.greece);
        destinationsList.add(dest);

        dest = new Destinations();
        dest.setTitle("Summer 2018");
        dest.setDescription("Cairo");
        dest.setPicture(R.drawable.cairo);
        destinationsList.add(dest);

        return destinationsList;
    }
}
