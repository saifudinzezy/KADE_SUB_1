package com.example.submisi.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import com.example.submisi.R
import com.example.submisi.helper.Config
import com.example.submisi.model.FootbalClub
import kotlinx.android.synthetic.main.activity_detail_football.*
import org.jetbrains.anko.*

class DetailFootball : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //parsing
        //https://medium.com/the-lazy-coders-journal/easy-parcelable-in-kotlin-the-lazy-coders-way-9683122f4c00
        var football: FootbalClub  = intent.getParcelableExtra(Config.KEY_FOOTBALL)
        setTitle(football.nameFootbal)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        linearLayout {
            orientation = LinearLayout.VERTICAL

            imageView {
                imageResource = R.drawable.img_acm
                id = R.id.iv_img
            }.lparams(width = matchParent, height = dip(200))
            textView {
                id = R.id.tv_fottball_name
                text = "Name Football"
                gravity = Gravity.CENTER
                textColor = Color.BLACK
                textSize = dip(12).toFloat()
            }.lparams(width = matchParent) {
                topMargin = dip(8)
                bottomMargin = dip(8)
            }
            textView {
                id = R.id.tv_fottball_desc
                text = "Desc Football"
                gravity = Gravity.CENTER
                textColor = Color.BLACK
                textSize = dip(8).toFloat()
            }.lparams(width = matchParent) {
                topMargin = dip(8)
                bottomMargin = dip(8)
            }
        }

        iv_img.setImageResource(football.nameImage)
        tv_fottball_name.setText(football.nameFootbal)
        tv_fottball_desc.setText(football.nameDesc)
    }
}
