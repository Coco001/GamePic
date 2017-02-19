package cqupt.gamepic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import cqupt.gamepic.config.Config;
import cqupt.gamepic.view.GameView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Activity的引用
    private static MainActivity mActivity;
    // 记录分数
    private TextView mTvScore;
    // 历史记录分数
    private TextView mTvHighScore;
    private int mHighScore;
    // 目标分数
    private TextView mTvGoal;
    private int mGoal;
    // 重新开始按钮
    private Button mBtnRestart;
    // 撤销按钮
    private Button mBtnRevert;
    // 选项按钮
    private Button mBtnOptions;
    // 游戏面板
    private GameView mGameView;
    private int[] mResPicId;
    public static List<Bitmap> mPicList;

    public MainActivity() {
        mActivity = this;
    }

    //获取当前Activity的引用
    public static MainActivity getGameActivity() {
        return mActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化View
        initView();
        mResPicId = new int[]{
                R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                R.drawable.pic7, R.drawable.pic8, R.drawable.pic9,
                R.drawable.pic10, R.drawable.pic11, R.drawable.pic12
        };
        mPicList = new ArrayList<>();
        Bitmap[] bitmaps = new Bitmap[mResPicId.length];
        for (int i = 0; i < bitmaps.length; i++) {
            bitmaps[i] = BitmapFactory.decodeResource(getResources(), mResPicId[i]);
            mPicList.add(bitmaps[i]);
        }
        mGameView = new GameView(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.game_panel);
        // 为了GameView能居中
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.game_panel_rl);
        relativeLayout.addView(mGameView);
    }

    /**
     * 初始化View
     */
    private void initView() {
        mTvScore = (TextView) findViewById(R.id.scroe);
        mTvGoal = (TextView) findViewById(R.id.tv_Goal);
        mTvHighScore = (TextView) findViewById(R.id.record);
        mBtnRestart = (Button) findViewById(R.id.btn_restart);
        mBtnRevert = (Button) findViewById(R.id.btn_revert);
        mBtnOptions = (Button) findViewById(R.id.btn_option);
        mBtnRestart.setOnClickListener(this);
        mBtnRevert.setOnClickListener(this);
        mBtnOptions.setOnClickListener(this);
        mHighScore = Config.mSp.getInt(Config.KEY_HIGH_SCROE, 0);
        mGoal = Config.mSp.getInt(Config.KEY_GAME_GOAL, 2048);
        mTvHighScore.setText("" + mHighScore);
        mTvGoal.setText("" + mGoal);
        mTvScore.setText("0");
        setScore(0, 0);
    }

    public void setGoal(int num) {
        mTvGoal.setText(String.valueOf(num));
    }

    /**
     * 修改得分
     *
     * @param score score
     * @param flag  0 : score pic1 : high score
     */
    public void setScore(int score, int flag) {
        switch (flag) {
            case 0:
                mTvScore.setText("" + score);
                break;
            case 1:
                mTvHighScore.setText("" + score);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_restart:
                //弹出窗体，让用户确认
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("NOTICE")
                        .setMessage("是否重置")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                mGameView.startGame();
                                setScore(0, 0);
                                return;
                            }
                        })
                        .setNegativeButton("NO",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        return;
                                    }
                                }).create().show();
                break;
            case R.id.btn_revert:
                mGameView.revertGame();
                break;
            case R.id.btn_option:
                Intent intent = new Intent(MainActivity.this, ConfigPreference.class);
                startActivityForResult(intent, 0);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            mGoal = Config.mSp.getInt(Config.KEY_GAME_GOAL, 2048);
            mTvGoal.setText("" + mGoal);
            getHighScore();
            mGameView.startGame();
        }
    }

    /**
     * 获取最高记录
     */
    private void getHighScore() {
        int score = Config.mSp.getInt(Config.KEY_HIGH_SCROE, 0);
        setScore(score, 1);
    }
}