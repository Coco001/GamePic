package cqupt.gamepic.bean;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import cqupt.gamepic.R;
import cqupt.gamepic.config.Config;


public class Item extends FrameLayout {
    // Item显示数字
    private int showNum;
    // 数字Title
    private TextView mTvNum;
    // 数字Title LayoutParams
    private LayoutParams mParams;

    public Item(Context context, int num) {
        super(context);
        this.showNum = num;
        // 初始化Item
        initCardItem();
    }

    private void initCardItem() {
        // 设置面板背景色，是由Frame拼起来的
        setBackgroundColor(Color.GRAY);
        mTvNum = new TextView(getContext());
        setNum(showNum);
        // 修改5X5时字体太大
        int gameLines = Config.mSp.getInt(Config.KEY_GAME_LINES, 4);
        if (gameLines == 4) {
            mTvNum.setTextSize(30);
        } else if (gameLines == 5) {
            mTvNum.setTextSize(23);
        } else {
            mTvNum.setTextSize(18);
        }
        TextPaint tp = mTvNum.getPaint();
        tp.setFakeBoldText(true);
        mTvNum.setGravity(Gravity.CENTER);
        mParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        mParams.setMargins(5, 5, 5, 5);
        addView(mTvNum, mParams);
    }

    public View getItemView() {
        return mTvNum;
    }

    public int getNum() {
        return showNum;
    }

    public void setNum(int num) {
        this.showNum = num;
        Bitmap bitmap;
        Drawable drawable;
        // 设置背景颜色
        switch (num) {
            case 0:
                mTvNum.setBackgroundColor(0x00000000);
                break;
            case 2:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic1);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                break;
            case 4:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic2);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                //mTvNum.setBackgroundColor(0xffeee5db);
                break;
            case 8:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic3);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                //mTvNum.setBackgroundColor(0xffeee0ca);
                break;
            case 16:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic4);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                //mTvNum.setBackgroundColor(0xfff2c17a);
                break;
            case 32:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic5);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                //mTvNum.setBackgroundColor(0xfff59667);
                break;
            case 64:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic6);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                //mTvNum.setBackgroundColor(0xfff68c6f);
                break;
            case 128:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic7);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                //mTvNum.setBackgroundColor(0xfff66e3c);
                break;
            case 256:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic8);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                //mTvNum.setBackgroundColor(0xffedcf74);
                break;
            case 512:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic9);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                //mTvNum.setBackgroundColor(0xffedcc64);
                break;
            case 1024:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic10);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                //mTvNum.setBackgroundColor(0xffedc854);
                break;
            case 2048:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic11);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                //mTvNum.setBackgroundColor(0xffedc54f);
                break;
            case 4096:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic12);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                //mTvNum.setBackgroundColor(0xffedc32e);
                break;
            case 8192:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic14);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                break;
            case 16384:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic15);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                break;
            case 32768:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic16);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                break;
            case 65536:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic17);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                break;
            default:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic17);
                drawable = new BitmapDrawable(getResources(),bitmap);
                mTvNum.setBackground(drawable);
                //mTvNum.setBackgroundColor(0xff3c4a34);
                break;
        }
    }
}