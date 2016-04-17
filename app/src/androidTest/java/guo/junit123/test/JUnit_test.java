package guo.junit123.test;
import android.test.ActivityInstrumentationTestCase2;


import guo.junit123.MainActivity;

/**
 * Created by guozi on 2016/4/16.
 */
public class JUnit_test extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity mainActivity;
    public JUnit_test() {
        super(MainActivity.class);
    }

    public void test_sum(){
        mainActivity = getActivity();
        int a = 99999999;
        int b = 77777777;
        int result = mainActivity.sum(a,b);
        assertEquals(result, a + b);
    }

    public void test_overflow(){
        mainActivity = getActivity();
        int a = 2100000000;
        int b = 2100000000;
        try {
            int result = mainActivity.sum(a, b);
            fail();
        }
        catch(ArithmeticException e) {}

    }

    public void test_underflow(){
        mainActivity = getActivity();
        int a = -2100000000;
        int b = -2100000000;
        try {
            int result = mainActivity.sum(a, b);
            fail();
        }
        catch(ArithmeticException e) {
            // success
        }
    }

    public void test_special(){
        mainActivity = getActivity();
        int a = -2147483648;
        int b = 2147483647;
        int c = 0;

        int result = mainActivity.sum(a, b);
        assertEquals(result, a + b);
        result = mainActivity.sum(b, c);
        assertEquals(result, b + c);
    }
}
