package go.deyu.marqueetextsample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_color.setOnClickListener { marquee_text_view.mTextColor =if( marquee_text_view.mTextColor == Color.DKGRAY )Color.RED else Color.DKGRAY }
        btn_size.setOnClickListener { marquee_text_view.mTextSize =if( marquee_text_view.mTextSize == 16F )20F else 16F }
        btn_speed.setOnClickListener { marquee_text_view.mSpeed =if( marquee_text_view.mSpeed == 5 )10 else 5}
        btn_text.setOnClickListener { marquee_text_view.mText =if( marquee_text_view.mText.equals("Is In Hello?"))"Is In Hafo?" else "Is In Hello?" }
    }
    @UsedByReflection(value = "activity_main.xml")
    fun go (){
    }
}
