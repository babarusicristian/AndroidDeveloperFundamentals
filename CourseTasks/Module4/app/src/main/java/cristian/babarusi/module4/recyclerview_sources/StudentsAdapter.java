package cristian.babarusi.module4.recyclerview_sources;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import cristian.babarusi.module4.R;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsViewHolder> {

    private List<Students> mStudents;  // a list with Students type
    private Context mContext;

    //constructor
    public StudentsAdapter(List<Students> students, Context context) {

        mStudents = students;
        mContext = context;
    }

    //draw layout without populate it, only initialising ...
    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //connection with our custom XML item layout
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_item
                , viewGroup, false);

        return new StudentsViewHolder(itemView);
    }

    //populate information in list, direct on items
    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder studentsViewHolder, int i) {

        Students currentStudent = mStudents.get(i);
        studentsViewHolder.getTextViewFirstName().setText(currentStudent.getFirstName());
        studentsViewHolder.getTextViewLastName().setText(currentStudent.getLastName());

        if (i % 2 == 0) {
            int myColor = mContext.getResources().getColor(R.color.white);
            studentsViewHolder.itemView.setBackgroundColor(myColor);
        } else {
            int myColor = mContext.getResources().getColor(R.color.white_gray);
            studentsViewHolder.itemView.setBackgroundColor(myColor);
        }
    }

    //here must return de numbers of items to be displayed in recyclerview, this are stored in
    // mStudents(in our case)
    @Override
    public int getItemCount() {
        return mStudents.size(); //number of items to display
    }
}
