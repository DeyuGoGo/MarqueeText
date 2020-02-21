# MarqueeText  [ ![MarqueeText](https://api.bintray.com/packages/deyugogo/maven/marqueetext/images/download.svg) ](https://bintray.com/deyugogo/maven/marqueetext/_latestVersion)

跑馬燈

### 效果图

<img src="/MarqueeView.gif" style="width: 30%;">

#### Gradle:

    implementation 'com.deyu:marqueetext:1.0.0'

#### 属性

| Attribute         | Description | 
|:---				     |:---| 
| Text         | string for show | 
| TextColor         | text color | 
| TextSize         | text size | 
| Speed         | TimeUnit Second | 

#### XML

    <go.deyu.marqueetext.MarqueeTextView
        android:id="@+id/marquee_text_view"
        android:layout_width="200sp"
        android:layout_height="wrap_content"
        android:background="@android:color/holo_blue_bright"
        app:Text="Hello,MarqueeTextViewHello"
        app:TextColor="@android:color/white"
        app:TextSize="20sp"
        app:Speed="3"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/btn_text"/>

#### Activity

        val marqueeTextView :MarqueeTextView = marquee_text_view
        marqueeTextView.mTextSize = 16F
        marqueeTextView.mText = "e04"
        marqueeTextView.mSpeed = 10
        marqueeTextView.mTextColor = Color.GREEN


