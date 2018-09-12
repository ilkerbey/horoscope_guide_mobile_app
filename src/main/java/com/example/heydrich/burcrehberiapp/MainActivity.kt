package com.example.heydrich.burcrehberiapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.heydrich.burcrehberiapp.R.id.listburc
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   lateinit var tumBurcBilgileri : ArrayList<Burc>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor=resources.getColor(R.color.statusBarColor)

        veriKaynagiHazirla()



        var myBaseAdapter = BurclarBaseAdapter(this,tumBurcBilgileri)

        listburc.adapter=myBaseAdapter

        listburc.setOnItemClickListener { adapterView, view, i, l ->

            var intent = Intent(this@MainActivity,DetayActivity::class.java)
            intent.putExtra("position",i)
            intent.putExtra("tumBurcBilgileri",tumBurcBilgileri)
            startActivity(intent) }



        }

    private fun veriKaynagiHazirla() {
        tumBurcBilgileri = ArrayList<Burc>(12)
        var burclar = resources.getStringArray(R.array.Burclar)
        var burcTarihleri = resources.getStringArray(R.array.BurcTarih)
        var burcSembolleri = arrayOf(R.drawable.koc,R.drawable.boga,R.drawable.ikizler,R.drawable.yengec,
                R.drawable.aslan,R.drawable.basak,R.drawable.terazi,R.drawable.akrep,R.drawable.yay,R.drawable.oglak,R.drawable.kova,R.drawable.balik)
        var burcBuyukResimler = arrayOf(R.drawable.kocb,R.drawable.bogab,R.drawable.ikizlerb,R.drawable.yengecb,R.drawable.aslanb,R.drawable.basakb,
                R.drawable.terazib,R.drawable.akrepb,R.drawable.yayb,R.drawable.oglakb,R.drawable.kovab,R.drawable.balikb)

        var burcGenelOzellikler = resources.getStringArray(R.array.BurcGenelOzellikler)

        for (i in 0..11){

            var arrayListeEklenecekBurc = Burc(burclar[i],burcTarihleri[i],burcSembolleri[i],burcBuyukResimler[i],burcGenelOzellikler[i])
            tumBurcBilgileri.add(arrayListeEklenecekBurc)
        }

    }
}



