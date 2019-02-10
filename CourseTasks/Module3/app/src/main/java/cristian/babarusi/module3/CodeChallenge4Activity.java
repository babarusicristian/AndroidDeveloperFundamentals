package cristian.babarusi.module3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

public class CodeChallenge4Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner mSpinnerExample;
    private ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_challenge4);

        initView();
    }

    private void initView() {
        mSpinnerExample = findViewById(R.id.spinner_example);
        spinnerAdapter = new ArrayAdapter<String>(CodeChallenge4Activity.this, android.R.layout.simple_spinner_item, getSpinnerSource());
        mSpinnerExample.setAdapter(spinnerAdapter);
        mSpinnerExample.setOnItemSelectedListener(this);
    }

    private ArrayList<String> getSpinnerSource() {
        ArrayList<String> sourceList = new ArrayList<>();
        sourceList.add("Cupcake");
        sourceList.add("Donut");
        sourceList.add("Eclair");
        sourceList.add("KitKat");
        sourceList.add("Pie");

        return sourceList;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String textSelected = getSpinnerSource().get(position);
        Toast.makeText(CodeChallenge4Activity.this, "Selected: " + textSelected, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
