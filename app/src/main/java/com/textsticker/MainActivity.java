package com.textsticker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
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
        TextStickerView textSticker = new TextStickerView(this, this.canvasWidth, this.canvasHeight);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        textSticker.setLayoutParams(layoutParams);
        textSticker.setText(str);
        textSticker.setLayoutX(i2);
        textSticker.setLayoutY(i3);
        textSticker.setRotateAngle(f);
        textSticker.setScale(f2);
        textSticker.setPaddingLeft(i4);
        textSticker.setPaddingRight(i5);
        textSticker.setFont(font);
        textSticker.setAlign(alignment);
        textSticker.setOpacity(i6);
        textSticker.setUnderLine(z);
        textSticker.setStrikethrough(z2);
        textSticker.setLetterSpacing(f3);
        textSticker.setLineSpacing(f4);
        textSticker.setTag(Integer.valueOf(i));
        textSticker.setOperationListener(new TextStickerView.OperationListener() {
            public void onUnselect(TextStickerView textStickerView) {
            }

            public void onDelete(TextStickerView textStickerView) {
                ((RelativeLayout) findViewById(R.id.rlMain)).removeView(textSticker);
                ((RelativeLayout) findViewById(R.id.rlMain)).requestLayout();
            }

            public void onEdit(TextStickerView textStickerView) {
                editSticker(textStickerView);
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

    private void editSticker(TextStickerView textStickerView) {
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setText(textStickerView.getText());
        input.setPadding(80,40,40,40);
        input.requestFocus();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Enter text")
                .setView(input)
                .setPositiveButton("OK", (dialog, which) -> {
                    String userInput = input.getText().toString();
                    textStickerView.setText(userInput);
                    textStickerView.invalidate();
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
        builder.show();
    }
}