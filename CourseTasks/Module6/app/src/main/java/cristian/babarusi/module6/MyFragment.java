package cristian.babarusi.module6;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    private final static MyFragment instance = new MyFragment();
    private String mBehavior = "";

    private TextView mTextViewDisplay;

    public MyFragment() {
        // Required empty public constructor
    }

    public static MyFragment getInstance() {
        return instance;
    }

    public String getBehavior() {
        return this.mBehavior;
    }

    public void setBehavior(String behavior) {
        this.mBehavior = behavior;
    }

    //step 3
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(getActivity(), "onCreateView - fragment", Toast.LENGTH_SHORT).show();
        }

        View view = inflater.inflate(R.layout.fragment_my, container, false);
        mTextViewDisplay = view.findViewById(R.id.fragment_text_view_display);

        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Bundle bundle = MyFragment.getInstance().getArguments();
            if (bundle != null) {
                mTextViewDisplay.setText(bundle.getString(MainActivity.KEY_FRAGMENT_MANUAL_DATA, ""));
            }
        } else if (MyFragment.getInstance().getBehavior().equals("custom")) {
            Bundle bundleMain = MyFragment.getInstance().getArguments();
            if (bundleMain != null) {
                mTextViewDisplay.setText(bundleMain.getString(MainActivity.DATA_FOR_FRAGMENT, ""));
            }
        }

        // Inflate the layout for this fragment
        return view;
    }

    //step 1
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(getActivity(), "onAttach - fragment", Toast.LENGTH_SHORT).show();
        }
    }

    //step 2
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(getActivity(), "onCreate - fragment", Toast.LENGTH_SHORT).show();
        }
    }

    //step 4
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(getActivity(), "onActivityCreated - fragment", Toast.LENGTH_SHORT).show();
        }
    }

    //step 5
    @Override
    public void onStart() {
        super.onStart();
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(getActivity(), "onStart - fragment", Toast.LENGTH_SHORT).show();
        }
    }

    //step 6
    @Override
    public void onResume() {
        super.onResume();
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(getActivity(), "onResume - fragment", Toast.LENGTH_SHORT).show();
        }
    }

    //step 7
    @Override
    public void onPause() {
        super.onPause();
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(getActivity(), "onPause - fragment", Toast.LENGTH_SHORT).show();
        }
    }

    //step 8
    @Override
    public void onStop() {
        super.onStop();
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(getActivity(), "onStop - fragment", Toast.LENGTH_SHORT).show();
        }
    }

    //step 9
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(getActivity(), "onDestroyView - fragment", Toast.LENGTH_SHORT).show();
        }
    }

    //step 10
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(getActivity(), "onDestroy - fragment", Toast.LENGTH_SHORT).show();
        }
    }

    //step 11
    @Override
    public void onDetach() {
        super.onDetach();
        if (MyFragment.getInstance().getBehavior().equals("manual")) {
            Toast.makeText(getActivity(), "onDetach - fragment", Toast.LENGTH_SHORT).show();
        }
    }
}
