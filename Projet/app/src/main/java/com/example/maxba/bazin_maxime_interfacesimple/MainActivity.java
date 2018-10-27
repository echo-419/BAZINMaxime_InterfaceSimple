package com.example.maxba.bazin_maxime_interfacesimple;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.String;





public class MainActivity extends AppCompatActivity {

    public String appNom;
    public String alert;
    public EditText nom;
    public EditText prenom;
    public String adresse;
    public TextView date;
    public TextView mail;
    public SimpleDateFormat df;
    public String formatDate;
    public RadioGroup GrpSexe;
    public RadioButton H;
    public RadioButton F;
    public EditText Heure;
    public Button BtRAZ;
    public Button BtValide;
    public CheckBox CB1,CB2,CB3,CB4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appNom=getString(R.string.app_name);
        alert=getString(R.string.ConsoleMsg);
        date=(TextView) findViewById(R.id.TV_date);
        nom=(EditText) findViewById(R.id.ED_Nom);
        prenom=(EditText) findViewById(R.id.ED_Prenom);
        mail=(TextView) findViewById(R.id.TV_Mail) ;
        GrpSexe=(RadioGroup)  findViewById(R.id.RG_Sexe);
        H=(RadioButton)  findViewById(R.id.RB_H);
        F=(RadioButton)  findViewById(R.id.RB_F);
        CB1=(CheckBox) findViewById(R.id.CB_C);
        CB2=(CheckBox) findViewById(R.id.CB_Cpp);
        CB3=(CheckBox) findViewById(R.id.CB_Java);
        CB4=(CheckBox) findViewById(R.id.CB_Delphi);
        Heure=(EditText) findViewById(R.id.ED_Heure);
        BtRAZ=(Button)findViewById(R.id.BT_RAZ);
        BtValide=(Button)findViewById(R.id.BT_Valide);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i(alert,  appNom);

        Calendar c = Calendar.getInstance();
        df = new SimpleDateFormat("dd-MM-yyyy");
        formatDate = df.format(c.getTime());
        date.setText(formatDate);

        H.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int duration=Toast.LENGTH_LONG;
                if (H.isChecked()){
                    Toast.makeText(MainActivity.this,"Bienvenue Monsieur "+nom.getText(),duration ).show();
                }
            }
        });
        F.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int duration=Toast.LENGTH_LONG;
                if (F.isChecked()){
                    Toast.makeText(MainActivity.this,"Bienvenue Madame "+nom.getText(),duration ).show();
                }
            }
        });


        mail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                adresse= nom.getText()+"."+ prenom.getText() + "@Ludus-academie.com" ;
                mail.setText(adresse);
            }
        });



       Heure.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
                //Log.i(alert,  "ENTRER");
                Editable HEURE=Heure.getText();
                int Heurenbr=Integer.parseInt(String.valueOf(HEURE));

                    if (Heurenbr<=10) {
                        Heure.setTextColor(Color.GREEN);
                    }
                    if (Heurenbr<=20 && Heurenbr>10) {
                        Heure.setTextColor(Color.YELLOW);
                    }
                    if (Heurenbr>20) {
                        int duration=Toast.LENGTH_LONG;
                        Heure.setTextColor(Color.RED);
                        Toast.makeText(MainActivity.this,"Vous jouez trops "+prenom.getText(),duration ).show();
                    }
                }




        });

       BtRAZ.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               nom.setText("");
               prenom.setText("");
               mail.setText(getString(R.string.mail));
               F.setChecked(true);
               CB1.setChecked(false);
               CB2.setChecked(false);
               CB3.setChecked(false);
               CB4.setChecked(false);
               Heure.setText("");
               Heure.setTextColor(Color.BLACK);


           }
       });

       BtValide.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.i(alert,  "Date:"+date.getText());
               Log.i(alert,  "Nom:"+nom.getText());
               Log.i(alert,  "Prénom:"+prenom.getText());
               Log.i(alert,  "Mail:"+mail.getText());
               if (F.isChecked())Log.i(alert,  "Sexe:"+F.getText());
               if (H.isChecked())Log.i(alert,  "Sexe:"+H.getText());

               if (CB1.isChecked())Log.i(alert,  "Connait le :"+CB1.getText());
               if (CB2.isChecked())Log.i(alert,  "Connait le :"+CB2.getText());
               if (CB3.isChecked())Log.i(alert,  "Connait le :"+CB3.getText());
               if (CB4.isChecked())Log.i(alert,  "Connait le :"+CB4.getText());

               Log.i(alert,  "Moyenne d'heure jouer :"+Heure.getText());

           }
       });





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
}
