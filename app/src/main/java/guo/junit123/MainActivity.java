package guo.junit123;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // get numbers and turn into ints
                EditText et1 = (EditText) findViewById(R.id.et1);
                EditText et2 = (EditText) findViewById(R.id.et2);
                String str1 = et1.getText().toString();
                String str2 = et2.getText().toString();
                String str3 = "Number(s) invalid";

                TextView result = (TextView)findViewById(R.id.result);
                // try parse int,
                int f1 = 0;
                int f2 = 0;
                try {
                    f1 = Integer.parseInt(str1);
                    f2 = Integer.parseInt(str2);
                }
                catch (NumberFormatException e) {
                    result.setText(str3);
                    return;
                }
                // try add and catch overflow
                str3 = "Result invalid";
                try {
                    int num = sum(f1, f2);
                    str3 = Integer.toString(num);
                }
                catch (ArithmeticException e) {
                    result.setText(str3);
                    return;
                }




                result.setText(str3);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public int sum(int a, int b){
        if (b > 0 ? a > Integer.MAX_VALUE - b
                : a < Integer.MIN_VALUE - b) {
            throw new ArithmeticException("overflow");
        }
        return a+b;
    }
}
