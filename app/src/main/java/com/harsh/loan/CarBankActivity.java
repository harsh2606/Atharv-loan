package com.harsh.loan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class CarBankActivity extends AppCompatActivity {

    GridView gridView;
    ImageView back;

    String[] demo = {"HDFC", "ICICI", "AXIS", "Kotak",
            "IDFC First Bank","Tata Capital"};

    int[] image ={R.drawable.hdfc,R.drawable.icici,R.drawable.axixx,R.drawable.kotak,R.drawable.idfc,R.drawable.tatacapital,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_bank);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CustomGrid adapter = new CustomGrid(CarBankActivity.this, demo, image);
        gridView=(GridView)findViewById(R.id.gridview);
        back=(ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                Toast.makeText(BusinessBankActivity.this, "You Clicked at " +demo[+ position], Toast.LENGTH_SHORT).show();
                Document();

            }
        });
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void Document(){

        final Dialog alertDialog1 = new Dialog(CarBankActivity.this, R.style.CustomDialog);
        alertDialog1.setContentView(R.layout.document);
        ImageView wrong= alertDialog1.findViewById(R.id.wrong);
        WebView text= alertDialog1.findViewById(R.id.text);

        text.loadDataWithBaseURL("",
                "<html>\n" +
                        "<head>\n" +
                        "<style>\n" +
                        "table, th, td {\n" +
                        "  border: 1px solid #e8eaeb;\n" +
                        "  border-collapse: collapse;\n" +
                        "}\n" +
                        "</style>\n" +
                        "</head>\n" +
                        "<body>\n" +

                        "<ul style=\"list-style-type: disc;margin-left: -25px;line-height: 24px;margin-top: -5px;\">\n" +
                        "<li>Rate of Interest Between 13% to 16%.</li>\n" +
                        "<li>Require Document:-\n" +
                        "<ul style=\"list-style-type circle;margin-left: -25px;\">\n" +
                        "<li><strong>KYC</strong> </li>\n" +
                        "<li><strong>Bank Statement Of Last 12 Months</strong></li>\n" +
                        "<li><strong>Last Two (2) Year ITR & Audit Report  </strong> </li>\n" +
                        "<li><strong> Loan Letter / Sangsan Letter</strong> </li>\n" +
                        "<li><strong>  GST</strong> </li>\n" +
                        "<li><strong> Car RcBook</strong> </li>\n" +
                        "<li><strong>Insurance Copy</strong> </li>\n" +
                        "</ul>\n" +
                        "</li>\n" +
                        "</ul>\n" +
                        "</body>\n" +
                        "</html>",
                "text/html", "UTF-8", "");

        alertDialog1.setCancelable(true);
        alertDialog1.show();


        wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog1.dismiss();
            }
        });






    }
}