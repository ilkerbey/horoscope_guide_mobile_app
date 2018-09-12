package com.example.heydrich.burcrehberiapp

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.graphics.Palette
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var position = intent.extras.get("position") as Int
        var tumburcbilgileri = intent.extras.get("tumBurcBilgileri") as ArrayList<Burc>

        tvBurcOzellikleri.setText(tumburcbilgileri.get(position).burcGenelOzellikleri)
        header.setImageResource(tumburcbilgileri.get(position).burcBuyukResim)
        setSupportActionBar(anim_toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        var bitmap = BitmapFactory.decodeResource(resources,tumburcbilgileri.get(position).burcBuyukResim)

        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette) {
                var color = palette?.getVibrantColor(R.attr.colorAccent)
                collapsing_toolbar.setContentScrimColor(color)
                window.statusBarColor=color
            }

        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
