package com.example.ronak.montecarlo;



import android.app.Fragment;
import android.app.FragmentManager;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity implements TaskFragment.TaskCallbacks {

    Button b;
    TextView t;
    private static final String TAG_TASK_FRAGMENT = "task_fragment";
    private TaskFragment mTaskFragment;

      @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          b = (Button) findViewById(R.id.button1);
          t = (TextView) findViewById(R.id.textView1);

          FragmentManager fm = getFragmentManager();
          mTaskFragment = (TaskFragment) fm.findFragmentByTag(TAG_TASK_FRAGMENT);

          // If the Fragment is non-null, then it is currently being
          // retained across a configuration change.
        /*  if (mTaskFragment == null) {
              mTaskFragment = new TaskFragment();
              fm.beginTransaction().add(mTaskFragment, TAG_TASK_FRAGMENT).commit();
*/

          }

  // execute EstimatePI class containing AsyncTask..............

    public void on_click(View v) {
        EstimatePI e = new EstimatePI(this);
        e.execute(1000);



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

    @Override
    public void onPreExecute() {  }

   @Override
    public void onProgressUpdate(int percent) {  }

    @Override
    public void onCancelled() {  }

    @Override
    public void onPostExecute() {  }
}




