package cristian.babarusi.module5;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TasksViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextViewTaskName;

    public TasksViewHolder(@NonNull View itemView) {
        super(itemView);

        mTextViewTaskName = itemView.findViewById(R.id.textview_task_name);
    }

    public TextView getTextViewTaskName() {
        return mTextViewTaskName;
    }

    public void setTextViewTaskName(TextView textViewTaskName) {
        mTextViewTaskName = textViewTaskName;
    }
}
