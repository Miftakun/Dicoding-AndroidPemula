package com.submissionbangkitandroidpemula.wisatapopulerdiindonesia

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.submissionbangkitandroidpemula.wisatapopulerdiindonesia.databinding.ActivityDetailBinding

class DetailActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val DETAIL_WISATA = "detail_wisata"
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wisata = intent.getParcelableExtra<Wisata>(DETAIL_WISATA)
        var name = wisata?.name.toString()
        var description = wisata?.description.toString()
        var photo = wisata?.photo?.toInt()
        var alamat = wisata?.alamat.toString()

        if(wisata!=null){
            binding.tvItemNamedetail.text = name
            binding.descriptionWisatadetail.text = description
            binding.descriptionAlamatdetail.text = alamat
            binding.imageWisatadetail.setImageResource(photo!!)
        }

    }

}