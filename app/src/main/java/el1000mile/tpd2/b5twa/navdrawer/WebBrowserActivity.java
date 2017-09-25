package el1000mile.tpd2.b5twa.navdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class WebBrowserActivity extends AppCompatActivity {

    WebView wv ;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);

        Intent i = getIntent();
        url=i.getStringExtra("url");
        wv=(WebView)findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }






}
