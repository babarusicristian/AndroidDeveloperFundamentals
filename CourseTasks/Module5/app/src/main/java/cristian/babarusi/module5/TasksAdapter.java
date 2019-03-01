package cristian.babarusi.module5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksViewHolder> {

    private Context mContext;
    private List<TasksModel> mListTasks;

    public TasksAdapter(List<TasksModel> list, Context context) {
        mContext = context;
        mListTasks = list;
    }

    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tasks_item
                , viewGroup, false);
        return new TasksViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder tasksViewHolder, final int i) {
        TasksModel currentTask = mListTasks.get(i);
        tasksViewHolder.getTextViewTaskName().setText(currentTask.getTaskName());
    }

    @Override
    public int getItemCount() {
        return mListTasks.size();
    }
}
