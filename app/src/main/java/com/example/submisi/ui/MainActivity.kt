package com.example.submisi.ui

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submisi.R
import com.example.submisi.adapter.AdapterFootball
import com.example.submisi.helper.Config
import com.example.submisi.model.FootbalClub
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    private var items: MutableList<FootbalClub> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setTitle("Football Club")

        linearLayout {
            orientation = LinearLayout.VERTICAL
            recyclerView {
                id = R.id.rv_football
            }.lparams(width = matchParent, height = matchParent)
        }

        //init
        initData()

        //instance rv
        rv_football.layoutManager = LinearLayoutManager(this)
        rv_football.adapter = AdapterFootball(this, items) {
            //parsing data to details
            startActivity(intentFor<DetailFootball>(Config.KEY_FOOTBALL to it))
        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.club_desc)

        items.clear()
        for (i in name.indices) {
            items.add(
                FootbalClub(
                    name[i],
                    image.getResourceId(i, 0),
                    desc[i]
                    )
            )
        }

        //Recycle the typed array
        image.recycle()
    }
}