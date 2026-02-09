package zeev.fraiman.twosin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JunctionActivity extends AppCompatActivity {

    private SeekBar seekBarAmplitude1, seekBarFrequency1, seekBarPhase1;
    private SeekBar seekBarAmplitude2, seekBarFrequency2, seekBarPhase2;
    private TextView textViewAmplitude1, textViewFrequency1, textViewPhase1;
    private TextView textViewAmplitude2, textViewFrequency2, textViewPhase2;
    private GraphView graphView1, graphView2;
    private Button buttonSameAxis, buttonPerpendicularAxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junction);

        // Initialize views
        setupViews();

        // Setup listeners
        setupListeners();

        // Initial update
        updateGraph1();
        updateGraph2();
        updateTextViews();
    }

    private void setupViews() {
        seekBarAmplitude1 = findViewById(R.id.seekBarAmplitude1);
        seekBarFrequency1 = findViewById(R.id.seekBarFrequency1);
        seekBarPhase1 = findViewById(R.id.seekBarPhase1);
        seekBarAmplitude2 = findViewById(R.id.seekBarAmplitude2);
        seekBarFrequency2 = findViewById(R.id.seekBarFrequency2);
        seekBarPhase2 = findViewById(R.id.seekBarPhase2);

        textViewAmplitude1 = findViewById(R.id.textViewAmplitude1);
        textViewFrequency1 = findViewById(R.id.textViewFrequency1);
        textViewPhase1 = findViewById(R.id.textViewPhase1);
        textViewAmplitude2 = findViewById(R.id.textViewAmplitude2);
        textViewFrequency2 = findViewById(R.id.textViewFrequency2);
        textViewPhase2 = findViewById(R.id.textViewPhase2);

        graphView1 = findViewById(R.id.graphView1);
        graphView2 = findViewById(R.id.graphView2);
        graphView1.setCenterAxes(false);
        graphView2.setCenterAxes(false);

        buttonSameAxis = findViewById(R.id.buttonSameAxis);
        buttonPerpendicularAxes = findViewById(R.id.buttonPerpendicularAxes);
    }

    private void setupListeners() {
        SeekBar.OnSeekBarChangeListener listener1 = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateGraph1();
                updateTextViews();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        };

        seekBarAmplitude1.setOnSeekBarChangeListener(listener1);
        seekBarFrequency1.setOnSeekBarChangeListener(listener1);
        seekBarPhase1.setOnSeekBarChangeListener(listener1);

        SeekBar.OnSeekBarChangeListener listener2 = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateGraph2();
                updateTextViews();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        };

        seekBarAmplitude2.setOnSeekBarChangeListener(listener2);
        seekBarFrequency2.setOnSeekBarChangeListener(listener2);
        seekBarPhase2.setOnSeekBarChangeListener(listener2);

        buttonSameAxis.setOnClickListener(v -> openResultActivity("same_axis"));
        buttonPerpendicularAxes.setOnClickListener(v -> openResultActivity("perpendicular_axes"));
    }

    private void updateGraph1() {
        graphView1.setParameters("same_axis",
                seekBarAmplitude1.getProgress(),
                seekBarFrequency1.getProgress(),
                seekBarPhase1.getProgress(),
                0, 0, 0); // We only draw one wave here
    }

    private void updateGraph2() {
        graphView2.setParameters("same_axis",
                seekBarAmplitude2.getProgress(),
                seekBarFrequency2.getProgress(),
                seekBarPhase2.getProgress(),
                0, 0, 0); // We only draw one wave here
    }

    private void updateTextViews() {
        textViewAmplitude1.setText(String.valueOf(seekBarAmplitude1.getProgress()));
        textViewFrequency1.setText(String.valueOf(seekBarFrequency1.getProgress()));
        textViewPhase1.setText(String.valueOf(seekBarPhase1.getProgress()));
        textViewAmplitude2.setText(String.valueOf(seekBarAmplitude2.getProgress()));
        textViewFrequency2.setText(String.valueOf(seekBarFrequency2.getProgress()));
        textViewPhase2.setText(String.valueOf(seekBarPhase2.getProgress()));
    }

    private void openResultActivity(String type) {
        Intent intent = new Intent(JunctionActivity.this, ViewResultActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("amp1", seekBarAmplitude1.getProgress());
        intent.putExtra("freq1", seekBarFrequency1.getProgress());
        intent.putExtra("phase1", seekBarPhase1.getProgress());
        intent.putExtra("amp2", seekBarAmplitude2.getProgress());
        intent.putExtra("freq2", seekBarFrequency2.getProgress());
        intent.putExtra("phase2", seekBarPhase2.getProgress());
        startActivity(intent);
    }
}
