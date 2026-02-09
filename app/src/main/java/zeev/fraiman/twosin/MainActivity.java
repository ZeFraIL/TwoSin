package zeev.fraiman.twosin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 4000;
    private boolean activityStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        VideoView videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.twosin;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        videoView.setOnCompletionListener(mp -> {
            startJunctionActivity();
        });

        videoView.start();

        new Handler().postDelayed(this::startJunctionActivity, SPLASH_DELAY);
    }

    private void startJunctionActivity() {
        if (!activityStarted) {
            activityStarted = true;
            Intent intent = new Intent(MainActivity.this, JunctionActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
