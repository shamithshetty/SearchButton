package com.example.searchbutton;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import static android.view.Gravity.CENTER;

public class SearchButton extends LinearLayout {
    private Interpolator mInterpolator;
    private float textSize,length;
    private int backColor,textColor,borderColor;
    private float borderWidth;
    private String placeHolder;
    private ImageView imageView;
    private EditText editText;

    public SearchButton(Context context) {
        super(context);
        init(context);
    }

    public SearchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context) {
        backColor=Color.WHITE;
        textColor=Color.BLACK;
        placeHolder="Button";
        borderWidth=0;
        textSize=20;
        placeHolder="search";
        length=200;
        borderColor=Color.WHITE;
        addContent();
    }
    private void init(Context context, AttributeSet attrs) {
        mInterpolator = new DecelerateInterpolator();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextView);
        try {
            // getting letterDuration from XML attribute
            placeHolder=typedArray.getString(R.styleable.TextView_placeHolder);
            backColor=typedArray.getColor(R.styleable.TextView_backColor,Color.WHITE);
            borderColor=typedArray.getColor(R.styleable.TextView_borderColor,Color.WHITE);
            textColor=typedArray.getColor(R.styleable.TextView_textColor,Color.BLACK);
            borderWidth=typedArray.getDimensionPixelSize(R.styleable.TextView_borderWidthSize,0);
            textSize=typedArray.getDimensionPixelSize(R.styleable.TextView_textSize,20);
            length=typedArray.getDimensionPixelSize(R.styleable.TextView_length,200);
            addContent();
        } finally {
            typedArray.recycle();
        }
    }

    public String getText(){
        return editText.getText().toString();
    }
    public void setText(String str) {
        editText.setText(str);
    }
    public void close(){
        animationWidthClose();

    }
    public void open(){
        editText.setVisibility(View.VISIBLE);
        animationWidth();
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public int getBackColor() {
        return backColor;
    }

    public void setBackColor(int backColor) {
        this.backColor = backColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(int borderColor) {
        this.borderColor = borderColor;
    }

    public float getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(float borderWidth) {
        this.borderWidth = borderWidth;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    private void addContent(){
        imageView=new ImageView(getContext());
        editText=new EditText(getContext());
        editText.setMinWidth(0);
        editText.setMaxLines(1);
        editText.setSingleLine(true);
        setPadding(20,10,20,10);
        setOrientation(HORIZONTAL);
        editText.setHint(placeHolder);
        setBackground(getAngleDrawable(new float[]{30, 30, 30, 30, 30, 30, 30, 30},borderWidth,borderColor,backColor));
        setGravity(CENTER);
        setMinimumWidth(150);
        setMinimumHeight(150);
        imageView.setMinimumWidth(70);
        imageView.setMinimumWidth(70);
        imageView.setImageResource(R.drawable.ic_search);
        addView(imageView);
        addView(editText);
        editText.setVisibility(View.GONE);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setVisibility(View.VISIBLE);
                animationWidth();
            }
        });
    }
    public static GradientDrawable getAngleDrawable(float[] _radius, float strokeWidth, int strokeColor, int backColor)
    {
        GradientDrawable gradientDrawable= new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setCornerRadii(_radius);
        gradientDrawable.setColor(backColor);
        gradientDrawable.setStroke((int)strokeWidth, strokeColor);
        return gradientDrawable;
    }
    public void animationWidth(){

        ValueAnimator anim = ValueAnimator.ofInt(editText.getWidth(), (int)length);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                LinearLayout.LayoutParams params=(LinearLayout.LayoutParams) editText.getLayoutParams();
                params.width=val;
                editText.setLayoutParams(params);
            }
        });
        anim.setDuration(2000);
        anim.start();
    }
    public void animationWidthClose(){

        ValueAnimator anim = ValueAnimator.ofInt((int)length,0);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                LinearLayout.LayoutParams params=(LinearLayout.LayoutParams) editText.getLayoutParams();
                params.width=val;
                editText.setLayoutParams(params);
                if(val==2){
                    editText.setVisibility(View.GONE);
                }
            }
        });
        anim.setDuration(2000);
        anim.start();
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);

    }
}
