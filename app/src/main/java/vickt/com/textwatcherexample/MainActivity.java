package vickt.com.textwatcherexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static EditText etNumber1, etNumber2;
    public TextView tvAnswer;
    public int a, b, ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etNumber1 = (EditText) findViewById(R.id.et1);
        etNumber2 = (EditText) findViewById(R.id.et2);
        tvAnswer = (TextView) findViewById(R.id.tvAnswer);

    

        etNumber1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                /**
                 * Check if the new value of the edittext A is empty
                 *      -If it is empty, set the value of a = 0
                 *       This prevents a null pointer when you try to convert the empty string to an int
                 *       
                 * Then perform the sum of a, and b
                 * Then set the answer
                 * */
                if(!s.toString().equals("")) {
                    a = Integer.parseInt(s.toString());
                }else{
                    a = 0;
                }
                ans = addNumbers(a, b);

                tvAnswer.setText(String.valueOf(ans)); //Has to be a string
            }
        });


        etNumber2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!s.toString().equals("")) {
                    b = Integer.parseInt(s.toString());
                }else{
                    b = 0;
                }

                ans = addNumbers(a, b);
                tvAnswer.setText(String.valueOf(ans));
            }
        });

    }





    public int addNumbers(int a, int b){
        return a + b;
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
}
