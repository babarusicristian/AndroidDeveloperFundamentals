package cristian.babarusi.module4.recyclerview_sources;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import cristian.babarusi.module4.R;

public class StudentsViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextViewFirstName;
    private TextView mTextViewLastName;

    //constructor
    public StudentsViewHolder(@NonNull View itemView) {
        super(itemView);

        mTextViewFirstName = itemView.findViewById(R.id.textview_first_name);
        mTextViewLastName = itemView.findViewById(R.id.textview_last_name);
    }

    public TextView getTextViewFirstName() {
        return mTextViewFirstName;
    }

    public void setTextViewFirstName(TextView textViewFirstName) {
        mTextViewFirstName = textViewFirstName;
    }

    public TextView getTextViewLastName() {
        return mTextViewLastName;
    }

    public void setTextViewLastName(TextView textViewLastName) {
        mTextViewLastName = textViewLastName;
    }
}
