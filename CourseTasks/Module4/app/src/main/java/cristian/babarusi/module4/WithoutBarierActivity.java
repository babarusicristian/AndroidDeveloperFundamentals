package cristian.babarusi.module4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class WithoutBarierActivity extends AppCompatActivity {

    private Button mButtonAddText;
    private Button mButtonRemoveText;
    private TextView mTextViewText;

    private String mTotalText = "text text text text text text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_without_barier);

        initView();

        mButtonAddText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setTotalText(getTotalText() + " text");
                mTextViewText.setText(getTotalText());
            }
        });

        mButtonRemoveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] temp = getTotalText().split(" ");

                String nou = "";
                for (int i = 0; i < temp.length - 1; i++) {
                    nou += temp[i] + " ";
                }

                setTotalText(nou);
                mTextViewText.setText(getTotalText());
            }
        });
    }

    private void initView() {
        mButtonAddText = findViewById(R.id.button_add_text);
        mButtonRemoveText = findViewById(R.id.button_remove_text);
        mTextViewText = findViewById(R.id.textview_text);
        mTextViewText.setText(getTotalText());
    }

    public String getTotalText() {
        return mTotalText;
    }

    public void setTotalText(String totalText) {
        mTotalText = totalText;
    }
}
