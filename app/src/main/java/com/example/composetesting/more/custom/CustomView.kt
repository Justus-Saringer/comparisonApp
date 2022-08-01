package com.example.composetesting.more.custom

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.composetesting.R
import kotlin.text.Typography.bullet

class CustomView(context: Context, attrs: AttributeSet) : CardView(context, attrs) {

    private var titleTextView: TextView
    private var listView: TextView
    private var imageView: ImageView

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_view, this, true)

        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomView)

        titleTextView = view.findViewById(R.id.title)
        listView = view.findViewById(R.id.list_view)
        imageView = view.findViewById(R.id.image)

        titleTextView.text = typedArray.getString(R.styleable.CustomView_custom_title)
        imageView.setImageDrawable(typedArray.getDrawable(R.styleable.CustomView_android_src))

        typedArray.recycle()
    }

    fun setData(data: MutableList<String>) {
        var formattedData = ""

        data.forEach {
            formattedData += "$bullet $it \n"
        }
        listView.text = formattedData
    }

    fun setImage(image: Drawable?) {
        if (image != null) {
            imageView.setImageDrawable(image)
        }
    }

    fun setTitle(title: String) {
        titleTextView.text = "This is a title"
    }


}