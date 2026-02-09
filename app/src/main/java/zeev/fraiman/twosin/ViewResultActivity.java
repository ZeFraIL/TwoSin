package zeev.fraiman.twosin;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ViewResultActivity extends AppCompatActivity {

    private GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_result);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        graphView = findViewById(R.id.graphView);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        int amp1 = intent.getIntExtra("amp1", 50);
        int freq1 = intent.getIntExtra("freq1", 5);
        int phase1 = intent.getIntExtra("phase1", 0);
        int amp2 = intent.getIntExtra("amp2", 50);
        int freq2 = intent.getIntExtra("freq2", 5);
        int phase2 = intent.getIntExtra("phase2", 0);

        graphView.setParameters(type, amp1, freq1, phase1, amp2, freq2, phase2);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
