package azam.islamic_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class HomePage extends AppCompatActivity implements View.OnClickListener {

    public CardView card1;
    public CardView quranAndDua;
    public CardView dua;
    public CardView zikirNamaj;
    public CardView amol;
    public CardView todbir;
    public CardView zikir;
    public CardView ziyarat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_home_page);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.textView4);
        textViewDate.setText(currentDate);

        card1 = findViewById(R.id.tasbeehCard);

        card1.setOnClickListener(this);

        quranAndDua = findViewById(R.id.quranErDua);
        quranAndDua.setOnClickListener(this);

        dua = findViewById(R.id.dua);
        dua.setOnClickListener(this);

        zikirNamaj = findViewById(R.id.zikirAndNamaj);
        zikirNamaj.setOnClickListener(this);

        amol = findViewById(R.id.amol);
        amol.setOnClickListener(this);

        todbir = findViewById(R.id.todbir);
        todbir.setOnClickListener(this);

        zikir = findViewById(R.id.zikir);
        zikir.setOnClickListener(this);

        ziyarat = findViewById(R.id.ziyarot);
        ziyarat.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()){

            case R.id.tasbeehCard :
                i = new Intent(this,TasbeehApp.class);
                startActivity(i);
                break;

            case R.id.quranErDua:
                i = new Intent(this,QuranErDua.class);
                startActivity(i);
                break;

            case R.id.dua:
                i = new Intent(this,Dua.class);
                startActivity(i);
                break;

            case R.id.ziyarot:
                i = new Intent(this,Ziyarot.class);
                startActivity(i);
                break;

            case R.id.zikirAndNamaj:
                i = new Intent(this,ZikirAndNamaj.class);
                startActivity(i);
                break;

            case R.id.amol:
                i = new Intent(this,Amol.class);
                startActivity(i);
                break;

            case R.id.todbir:
                i = new Intent(this,Todbir.class);
                startActivity(i);
                break;

            case R.id.zikir:
                i = new Intent(this,Zikir.class);
                startActivity(i);
                break;
        }

    }



    }


