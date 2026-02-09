package zeev.fraiman.twosin;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

public class GraphView extends View {

    private Paint paint;
    private Paint axisPaint;
    private String type;
    private float amp1, freq1, phase1;
    private float amp2, freq2, phase2;

    private ValueAnimator animator;
    private float animatorValue = 0f;
    private boolean centerAxes = true; // By default, axes are centered

    public GraphView(Context context) {
        super(context);
        init();
    }

    public GraphView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GraphView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.STROKE);

        axisPaint = new Paint();
        axisPaint.setColor(Color.BLACK);
        axisPaint.setStrokeWidth(3f);

        animator = ValueAnimator.ofFloat(0f, 1f);
        animator.setDuration(10000);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(animation -> {
            animatorValue = (float) animation.getAnimatedValue();
            invalidate();
        });
    }

    public void setParameters(String type, int amp1, int freq1, int phase1, int amp2, int freq2, int phase2) {
        this.type = type;
        this.amp1 = amp1 / 100f;
        this.freq1 = freq1 / 10f;
        this.phase1 = (float) Math.toRadians(phase1);
        this.amp2 = amp2 / 100f;
        this.freq2 = freq2 / 10f;
        this.phase2 = (float) Math.toRadians(phase2);

        if (animator.isRunning()) {
            animator.cancel();
        }
        animator.start();
    }

    public void setCenterAxes(boolean centerAxes) {
        this.centerAxes = centerAxes;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;

        // Draw axes
        if (centerAxes) {
            canvas.drawLine(0, centerY, width, centerY, axisPaint);
            canvas.drawLine(centerX, 0, centerX, height, axisPaint);
        } else {
            canvas.drawLine(0, centerY, width, centerY, axisPaint); // X-axis
            canvas.drawLine(0, 0, 0, height, axisPaint);     // Y-axis at the left
        }

        if (type == null) {
            return;
        }

        if (type.equals("same_axis")) {
            float lastX = 0;
            float lastY = centerY;
            int totalPoints = (int) (width * animatorValue);
            for (int i = 0; i < totalPoints; i++) {
                float x = i;
                float angle1 = (float) (2 * Math.PI * freq1 * (x / width) + phase1);
                float y1 = (float) (amp1 * height / 4 * Math.sin(angle1));
                float angle2 = (float) (2 * Math.PI * freq2 * (x / width) + phase2);
                float y2 = (float) (amp2 * height / 4 * Math.sin(angle2));
                float y = centerY - (y1 + y2);
                if (i > 0) {
                    canvas.drawLine(lastX, lastY, x, y, paint);
                }
                lastX = x;
                lastY = y;
            }
        } else if (type.equals("perpendicular_axes")) {
            int totalPoints = (int) (1000 * animatorValue);
            float lastX = (float) (centerX + (amp1 * width / 2 * Math.sin(phase1)));
            float lastY = (float) (centerY - (amp2 * height / 2 * Math.sin(phase2)));
            for (int i = 0; i <= totalPoints; i++) {
                float t = (float) (i * 2 * Math.PI / 1000);
                float angle1 = (float) (2 * Math.PI * freq1 * t + phase1);
                float x = (float) (centerX + (amp1 * width / 2 * Math.sin(angle1)));
                float angle2 = (float) (2 * Math.PI * freq2 * t + phase2);
                float y = (float) (centerY - (amp2 * height / 2 * Math.sin(angle2)));
                canvas.drawLine(lastX, lastY, x, y, paint);
                lastX = x;
                lastY = y;
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (animator.isRunning()) {
            animator.cancel();
        }
    }
}
