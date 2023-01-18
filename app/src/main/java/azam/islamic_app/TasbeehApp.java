package azam.islamic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class TasbeehApp extends AppCompatActivity {

    int counter;
    int limit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_tasbeeh_app);

        TextView txtCount = findViewById(R.id.txtCounter);
        Button btnCount = findViewById(R.id.btnTasbeeh);
//        Button btn100 = findViewById(R.id.btn100);
        Button btnReset = findViewById(R.id.btnReset);
//        Button btnnoLimit = findViewById(R.id.btnNolimit);

        counter = 0;
        limit = 0;

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                counter++;

//                if(limit == 100 & counter <100){
//
//                    counter++;
//                }
                 if (limit == 0){
                    counter++;
                }

                txtCount.setText(""+counter);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                txtCount.setText(""+counter);
            }
        });
//        btn100.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                limit = 100;
//            }
//        });

//        btnnoLimit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                limit = 0;
//            }
//        });

    }
}