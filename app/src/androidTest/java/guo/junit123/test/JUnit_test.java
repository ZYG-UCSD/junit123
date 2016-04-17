package guo.junit123.test;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import guo.junit123.MainActivity;
import guo.junit123.R;

/**
 * Created by guozi on 2016/4/16.
 */
public class JUnit_test extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity mainActivity;
    public JUnit_test() {
        super(MainActivity.class);
    }

    public void test_first(){
        mainActivity = getActivity();

        TextView textView = (TextView) mainActivity.findViewById(R.id.tv1);
        String tester = textView.getText().toString();

        assertEquals("Hello World!", tester);
    }
}
