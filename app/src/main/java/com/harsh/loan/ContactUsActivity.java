package com.harsh.loan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactUsActivity extends AppCompatActivity {

    LinearLayout remail,rcall,rmsg;
    WebView adress;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        TextView email = (TextView) findViewById(R.id.email);
//         msg = (TextView) findViewById(R.id.msg);
        adress = (WebView) findViewById(R.id.address);

        rcall = (LinearLayout) findViewById(R.id.rcall);
        rmsg = (LinearLayout) findViewById(R.id.rmsg);
        back = (ImageView) findViewById(R.id.back);


        email.setText(Html.fromHtml("<a href=\"mailto:atharvassociates12@gmail.com\">atharvassociates12@gmail.com</a>"));
        email.setMovementMethod(LinkMovementMethod.getInstance());

        adress.loadDataWithBaseURL("",
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
                        "<li>T-84, Slicon Shoppers Udhna, Surat-394210.</li>\n" +
                        "<li>Shop No.1 Above Ronak Electirc,White House,Gunjan Char Rasta,Vapi.\n" +

                        "</ul>\n" +
                        "</li>\n" +
                        "</ul>\n" +
                        "</body>\n" +
                        "</html>",
                "text/html", "UTF-8", "");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        rmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWhatsApp();
            }
        });
        rcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9904404666"));
                startActivity(intent);

            }
        });

    }
    public void openWhatsApp(){
        try {
            String text = "Hey, I am interested to apply for loan, Kindly help through out the process.";

            String toNumber = "919904404666";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}