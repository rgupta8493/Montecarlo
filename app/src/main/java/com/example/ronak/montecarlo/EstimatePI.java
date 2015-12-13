package com.example.ronak.montecarlo;

import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by ronak on 2/11/2015.
 */
public class EstimatePI extends AsyncTask< Integer ,Void ,Double >  {
    private double x = 0.00000000f;
    private double y = 0.00000000f;
    private double pi = 0.0000000000000f;


    private int c = 0;
    private int s = 0;
    private int u;
    private MainActivity host;

    public EstimatePI(MainActivity host) {
        this.host = host;

    }

    Random r = new Random();


    @Override
    protected void onPreExecute() {
        super.onPreExecute();


        Toast.makeText(host.getBaseContext(),"Check PI value",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected Double doInBackground(Integer... n) {
      try {

                Thread.sleep(1000);
          for (int i = 1; i <= 1000; i++) {

              x = r.nextInt(1000) * 0.001;

              y = r.nextInt(1000) * 0.001;

              if (x * x + y * y <= 1)

                  c = c + 1;
              else
                  s = s + 1;




          }

          onProgressUpdate();

      }
      catch(Exception e){
          System.out.println("" + e);


      }
        return display_result();
    }


    public double display_result() {

        u = c + s;


        pi = 4.00000000000f * (double) c / (double) u;


        return pi;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        Toast.makeText(host.getBaseContext(),"PI Value :\t\t"+ pi,Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPostExecute(Double result) {
        super.onPostExecute(result);
        host.t.setText("PI Value :\t\t " + result);
       try{
           Thread.sleep(200);
       }
       catch(Exception e){
           System.out.println(e);
       }

        try{
            Thread.sleep(1000);

            Toast.makeText(host.getBaseContext(),"Go for Next cycle ",Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            System.out.println(e);
        }


     //  Toast.makeText(host.getBaseContext(),"Go for Next cycle ",Toast.LENGTH_SHORT).show();
    }
}






