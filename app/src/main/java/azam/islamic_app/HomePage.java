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


    }


    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()){

            case R.id.tasbeehCard :
                i = new Intent(this,TasbeehApp.class);
                startActivity(i);
                break;
        }

    }



    }


