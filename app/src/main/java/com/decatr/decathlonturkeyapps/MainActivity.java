package com.decatr.decathlonturkeyapps;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private Button button;
    Context context;

    {
        context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView= (WebView) findViewById(R.id.web1);
        WebSettings webSettings =webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://decatr.com/decathlonApps/welcome.php");
        webView.setWebViewClient(new WebViewClient());

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("http://decatr.com/decathlonApps/welcome.php");
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack())
        {
            webView.goBack();

            return true;

        }



        else if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey()
    {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Çıkış Yapmak İstediğinize Emin Misiniz?")
                .setPositiveButton("Evet", new DialogInterface.OnClickListener()
                {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1)
                    {

                        finish();
                        //close();


                    }
                })
                .setNegativeButton("Hayır", new DialogInterface.OnClickListener()
                {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1)
                    {
                    }
                })
                .show();

    }

}
