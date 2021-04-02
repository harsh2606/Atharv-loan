package com.harsh.loan;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity {



    CardView business,home,mor,car;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        business=(CardView)findViewById(R.id.business);
        home=(CardView)findViewById(R.id.home);
        car=(CardView)findViewById(R.id.car);
        mor=(CardView)findViewById(R.id.mor);





        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashboardActivity.this, BusinessbankActivity.class);
                startActivity(i);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashboardActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashboardActivity.this, CarBankActivity.class);
                startActivity(i);
            }
        });
        mor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashboardActivity.this, MortgageActivity.class);
                startActivity(i);
            }
        });


    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

    @Override
    public void onBackPressed() {

        android.app.AlertDialog.Builder alertDialogBuilder=new android.app.AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are You Sure You Want To Exit???");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yes",(dialog, which) -> {
            finish();
            finishAffinity();
        });
        alertDialogBuilder.setNegativeButton("No",(dialog, which) -> {

        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @SuppressLint("WrongConstant")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_add:
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                return true;
            case R.id.contact:
                Intent intent = new Intent(DashboardActivity.this,ContactUsActivity.class);
                startActivity(intent);
                return true;

            case R.id.share:
            {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Atharv Associates! ✌\n" +
                        "Download a Loan Application. \n" +
                        "\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\n" +
                        "https://play.google.com/store/apps/details?id="+getPackageName());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
            return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
