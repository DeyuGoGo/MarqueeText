package go.deyu.marqueetext

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.animation.LinearInterpolator
import android.widget.HorizontalScrollView
import android.widget.TextView


class MarqueeTextView : HorizontalScrollView {

    private var _textSize: Float = 14F
    private var _textString: String? = null
    private var _textColor: Int = Color.RED
    private var _speed: Int = 10
    private var animator: ObjectAnimator? = null
    private lateinit var mTextView: TextView
    var mText: String?
        get() = _textString
        set(value) {
            _textString = value
            start()
        }
    var mTextColor: Int
        get() = _textColor
        set(value) {
            _textColor = value
            start()
        }
    var mSpeed: Int
        get() = _speed
        set(value) {
            _speed = value
            start()
        }
    var mTextSize: Float
        get() = _textSize
        set(value) {
            _textSize = value
            start()
        }

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        // Load attributes
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.MarqueeTextView, defStyle, 0
        )
        _textString = a.getString(R.styleable.MarqueeTextView_Text)
        _textColor = a.getColor(R.styleable.MarqueeTextView_TextColor, Color.RED)
        _textSize = a.getDimension(R.styleable.MarqueeTextView_TextSize, 14F)
        _speed = a.getInt(R.styleable.MarqueeTextView_Speed, 10)
        a.recycle()

        mTextView = TextView(context).apply {
            layoutParams=LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT ).apply { gravity=  Gravity.CENTER_VERTICAL }
        }
        mTextView.setMaxLines(1)
        addView(mTextView)
        isHorizontalScrollBarEnabled = false
        setOnTouchListener { view, motionEvent -> true}
        start()

    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        start()
    }

    fun start() {
        mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, mTextSize)
        mTextView.setTextColor(mTextColor)
        mTextView.setText(mText)
        animator = null
        if (width != 0 && height != 0) {
            animator = creatCurrentAnimation().let {
                it.duration = mSpeed * 1000L
                it.interpolator = LinearInterpolator()
                it.repeatCount = ValueAnimator.INFINITE
                it
            }
            animator!!.start()
        }
        Log.d("Deyu","$mText")
    }

    private fun creatCurrentAnimation(): ObjectAnimator {
        return ObjectAnimator.ofFloat(
            mTextView,
            "translationX",
            width.toFloat(),
            -mTextView.getMeasuredWidth().toFloat()
        )
    }
}
