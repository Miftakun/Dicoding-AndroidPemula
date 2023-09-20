package com.submissionbangkitandroidpemula.wisatapopulerdiindonesia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.submissionbangkitandroidpemula.wisatapopulerdiindonesia.DetailActivity.Companion.DETAIL_WISATA

class MainActivity : AppCompatActivity() {
    private lateinit var rvWisata: RecyclerView
    private val list = ArrayList<Wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvWisata = findViewById(R.id.rv_wisata)
        rvWisata.setHasFixedSize(true)

        list.addAll(getListWisata())
        showRecyclerList()
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when(item.itemId){
           R.id.tbInfo ->{
               startActivity(Intent(this, AboutActivity::class.java))
               return true
           }
           else -> true
       }
        return true
    }

        private fun getListWisata(): ArrayList<Wisata>{
            val alamat = resources.getStringArray(R.array.data_alamat)
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.obtainTypedArray(R.array.data_images)
            val listWisata = ArrayList<Wisata>()
            for (i in dataName.indices) {
                val wisata = Wisata(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), alamat[i])
                listWisata.add(wisata)
            }
            return listWisata
        }

    private fun showRecyclerList() {
        rvWisata.layoutManager = LinearLayoutManager(this)
        val listWisataAdapter = ListWisataAdapter(list)
        rvWisata.adapter = listWisataAdapter
        listWisataAdapter.setOnItemClickCallback(object : ListWisataAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Wisata) {
                showSelectedWisata(data)
            }
        })
    }
    private fun showSelectedWisata(wisata: Wisata) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(DETAIL_WISATA, wisata)
        rvWisata.context.startActivity(intent)
    }
}
