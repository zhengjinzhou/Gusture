package zhou.com.gusture;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import static zhou.com.gusture.R.mipmap.ic_launcher;

public class MainActivity extends Activity implements View.OnTouchListener,GestureDetector.OnGestureListener {

    private GestureDetector gestureDetector;
    private static final int FLING_MIN_DISTANCE = 150;
    private static final int FLING_MIN_VELOCITY = 0;
    private ImageView iv_test;
    private int[] mDrawable;
    private int position=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawable = new int[]{R.mipmap.home_safe,R.mipmap.home_tools,R.mipmap.home_trojan};

        gestureDetector = new GestureDetector(this);
        LinearLayout ll = findViewById(R.id.ll);
        iv_test = findViewById(R.id.iv_test);
        iv_test.setOnTouchListener(this);
        iv_test.setLongClickable(true);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.i("touch","是我啊");
        return gestureDetector.onTouchEvent(motionEvent);
    }



    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        if(motionEvent.getX()-motionEvent1.getX() > FLING_MIN_DISTANCE && Math.abs(v)>FLING_MIN_VELOCITY){

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    iv_test.setBackgroundResource(R.mipmap.ic_launcher);
                }
            });
            Toast.makeText(this,"手势向左，不喜欢",Toast.LENGTH_SHORT).show();
        }else if(motionEvent1.getX()-motionEvent.getX()>FLING_MIN_DISTANCE && Math.abs(v)>FLING_MIN_VELOCITY){
            Toast.makeText(this,"手势向右，喜欢",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
