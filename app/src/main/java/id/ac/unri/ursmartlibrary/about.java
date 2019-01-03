package id.ac.unri.ursmartlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class about extends AppCompatActivity {

    ImageButton ibPhoto1;
    ImageButton ibPhoto2;
    ImageButton ibPhoto3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ibPhoto1 = (ImageButton) findViewById(R.id.photo1);
        ibPhoto2 = (ImageButton) findViewById(R.id.photo2);
        ibPhoto3 = (ImageButton) findViewById(R.id.photo3);

        ibPhoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(about.this, "Ahmad Maulana, 1507113792", Toast.LENGTH_LONG).show();
            }
        });

        ibPhoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(about.this, "M Muflih Fikri A, 1507123530", Toast.LENGTH_LONG).show();
            }
        });

        ibPhoto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(about.this, "Roby Esta Sunara, 150113198", Toast.LENGTH_LONG).show();
            }
        });
    }
}
