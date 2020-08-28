package com.textsticker;

import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextStickerView textSticker;
    int canvasWidth, canvasHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        canvasHeight = displayMetrics.heightPixels;
        canvasWidth = displayMetrics.widthPixels;
    }

    public void addSticker(View view) {
        Font font = new Font();
        font.setColor(-16777216);
        font.setSize(0.075f);
        createTextStickView(0, "My Sticker", font, this.canvasWidth / 2, this.canvasHeight / 2,
                0.0f, 1.0f, 0, 0, Layout.Alignment.ALIGN_CENTER, 255, false, false, 0.0f, 10.0f);
    }

    private void createTextStickView(int i, String str, Font font, int i2, int i3, float f, float f2, int i4, int i5,
                                     Layout.Alignment alignment, int i6, boolean z, boolean z2, float f3, float f4) {
        this.textSticker = new TextStickerView(this, this.canvasWidth, this.canvasHeight);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        this.textSticker.setLayoutParams(layoutParams);
        this.textSticker.setText(str);
        this.textSticker.setLayoutX(i2);
        this.textSticker.setLayoutY(i3);
        this.textSticker.setRotateAngle(f);
        this.textSticker.setScale(f2);
        this.textSticker.setPaddingLeft(i4);
        this.textSticker.setPaddingRight(i5);
        this.textSticker.setFont(font);
        this.textSticker.setAlign(alignment);
        this.textSticker.setOpacity(i6);
        this.textSticker.setUnderLine(z);
        this.textSticker.setStrikethrough(z2);
        this.textSticker.setLetterSpacing(f3);
        this.textSticker.setLineSpacing(f4);
        this.textSticker.setTag(Integer.valueOf(i));
        this.textSticker.setOperationListener(new TextStickerView.OperationListener() {
            public void onUnselect(TextStickerView textStickerView) {
            }

            public void onDelete(TextStickerView textStickerView) {
                ((RelativeLayout) findViewById(R.id.rlMain)).removeView(textSticker);
                ((RelativeLayout) findViewById(R.id.rlMain)).requestLayout();
            }

            public void onEdit(TextStickerView textStickerView) {
                if (textStickerView.isInEditMode())
                    textStickerView.setInEdit(false);
                else textStickerView.setInEdit(true);
            }

            public void onTouch(TextStickerView textStickerView) {

            }

            public void onSelect(TextStickerView textStickerView) {
                textSticker.setInEdit(true);
                textSticker.setShowHelpBox(true);
            }
        });
        ((RelativeLayout) findViewById(R.id.rlMain)).addView(textSticker);
        ((RelativeLayout) findViewById(R.id.rlMain)).requestLayout();
    }
}