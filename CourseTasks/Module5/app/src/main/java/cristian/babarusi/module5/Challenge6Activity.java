package cristian.babarusi.module5;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Challenge6Activity extends AppCompatActivity {

    private RecyclerView mRecyclerViewTasks;
    private Button mButtonAdd;
    private EditText mEditTextItemToAdd;

    List<TasksModel> listTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge6);

        listTasks = new ArrayList<>();
        initView();

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mEditTextItemToAdd.getText().toString();
                if (!text.isEmpty()) {
                    addTask(mEditTextItemToAdd.getText().toString());
                    mEditTextItemToAdd.setText("");
                    //refresh list
                    TasksAdapter tasksAdapter = new TasksAdapter(getTaskSource(), Challenge6Activity.this);
                    mRecyclerViewTasks.setAdapter(tasksAdapter);
                } else {
                    mEditTextItemToAdd.setError(getString(R.string.detected_empty_task));
                    mEditTextItemToAdd.requestFocus();
                }
            }
        });
    }

    private void initView() {
        mButtonAdd = findViewById(R.id.button_add);
        mEditTextItemToAdd = findViewById(R.id.edittext_item_to_add);

        mRecyclerViewTasks = findViewById(R.id.recycler_view_tasks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Challenge6Activity.this);
        mRecyclerViewTasks.setLayoutManager(layoutManager);

        TasksAdapter tasksAdapter = new TasksAdapter(getTaskSource(), Challenge6Activity.this);
        mRecyclerViewTasks.setAdapter(tasksAdapter);
    }

    private void addTask(String txtTask) {
        TasksModel objTask = new TasksModel();
        objTask.setTaskName(txtTask);
        listTasks.add(objTask);
    }

    private List<TasksModel> getTaskSource() {
        return listTasks;
    }

    private void ascundeTastatura(View view) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
