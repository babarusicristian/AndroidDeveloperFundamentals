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
public class InterfaceFragment extends Fragment implements MyInterfaceFragments{

    private TextView mTextViewDisplayText;


    public InterfaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_interface, container, false);

        initView(view);

        return view;
    }

    private void initView(View view) {
        mTextViewDisplayText = view.findViewById(R.id.text_view_display_text);
    }

    @Override
    public void displayText(String str) {
        mTextViewDisplayText.setText(MessageFormat.format("Your text is: {0}", str));
    }
}
