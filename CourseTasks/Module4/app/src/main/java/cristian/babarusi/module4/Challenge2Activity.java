package cristian.babarusi.module4;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cristian.babarusi.module4.recyclerview_sources.Students;
import cristian.babarusi.module4.recyclerview_sources.StudentsAdapter;

public class Challenge2Activity extends AppCompatActivity {

    private static final int STUDENTS_NUM = 34;

    private RecyclerView mRecyclerViewStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge2);

        initView();
    }

    private void initView() {
        mRecyclerViewStudents = findViewById(R.id.recyclerview_students);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Challenge2Activity.this);
        mRecyclerViewStudents.setLayoutManager(layoutManager);

        StudentsAdapter studentsAdapter = new StudentsAdapter(getStudents(), Challenge2Activity.this);
        mRecyclerViewStudents.setAdapter(studentsAdapter);

    }

    private List<Students> getStudents() {

        List<Students> studentsList = new ArrayList<>();
        Students students;

        for (int i = 0; i < STUDENTS_NUM; i++ ) {
            students = new Students();
            students.setFirstName(getString(R.string.firstname) + " " + (i+1));
            students.setLastName(getString(R.string.lastname) + " " + (i+1));
            studentsList.add(students);
        }
        return studentsList;
    }
}
