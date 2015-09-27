package com.example.tata.horoskop;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_us, menu);
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
        if (id == R.id.notification) {
            startActivity(new Intent(this, SettingsNotificationActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendEmail(View view) {
        Intent intent = null, chooser = null;

        if(view.getId() == R.id.iv_imageEmail){
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to={"ivyempress@ivyempress..com","ivana.lukic@gmx.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "From Astro Horoscope app");
            intent.putExtra(Intent.EXTRA_TEXT, "Hi, how can we improve our app?");
            intent.setType("message/rfc22");
            chooser = Intent.createChooser(intent, "Send email");
            startActivity(chooser);

        }

    }
}
