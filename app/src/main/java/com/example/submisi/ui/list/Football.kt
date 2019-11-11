package com.example.submisi.ui.list

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class Football: AnkoComponent<ViewGroup>{
    companion object {
        val tvTitleId = 1
        val iVimage = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui){
        verticalLayout {
            lparams(matchParent, wrapContent)
            orientation = LinearLayout.HORIZONTAL
            padding = dip(16)

            imageView {
                id = iVimage
            }.lparams {
                height = dip(75)
                width = dip(75)
            }

            textView {
                id = tvTitleId
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                textSize = 16f // <- it is sp, no worries
                textColor = Color.BLACK
            }

        }
    }
}