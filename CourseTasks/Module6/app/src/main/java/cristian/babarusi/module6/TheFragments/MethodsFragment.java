package cristian.babarusi.module6.TheFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.MessageFormat;

import cristian.babarusi.module6.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MethodsFragment extends Fragment {

    private TextView mTextViewDisplayResultsForMethods;


    public MethodsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_methods, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        mTextViewDisplayResultsForMethods = view.findViewById(R.id.text_view_display_results_for_methods);
    }


    public void displayAddiction(int a, int b) {
        int res = a + b;
        mTextViewDisplayResultsForMethods.setText(MessageFormat.format("{0} {1}", getString(R.string.the_addiction_is), res));
    }

    public void displaySubstraction(int a, int b) {
        int res = a - b;
        mTextViewDisplayResultsForMethods.setText(MessageFormat.format("{0} {1}", getString(R.string.the_substraction_is), res));
    }

}
