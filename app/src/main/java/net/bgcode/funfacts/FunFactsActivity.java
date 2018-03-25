package net.bgcode.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();

    // Declare our view variables
    private RelativeLayout relativeLayout;
    private TextView factTextView;
    private Button showFactButton;

    private FactBook factBook = new FactBook();
    private ColorWheel colorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // assign the views from layout file to variables
        factTextView = findViewById(R.id.funFactTextView);
        showFactButton = findViewById(R.id.showFactButton);
        relativeLayout = findViewById(R.id.relLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Update screen with new fact
                factTextView.setText(factBook.getFact());

                int color = colorWheel.getColor();

                relativeLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);

            }
        };

        showFactButton.setOnClickListener(listener);

        Log.d(TAG, "We're logging from the onCreate() method!");
        // Toast.makeText(this, "Activity Created.", Toast.LENGTH_SHORT).show();

    }
}
