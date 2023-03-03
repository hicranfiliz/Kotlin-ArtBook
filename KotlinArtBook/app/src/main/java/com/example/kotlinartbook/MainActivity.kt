package com.example.kotlinartbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.kotlinartbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    // art menu'yu buraya baglamam gerekiyor. Bunun icin 2 fonksiyonu override etmem gerekli.
    // onCreate'te baglama islemini yapacagiz.

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        //inflater : ne zaman xml ile kodu birbirine baglamaya calisacaksak inflate kullaniyoruz.
        // Ama yukarida nasil layoutInflater cagiriyorsak burada da menuInflater cagiracagiz.

        val menuInflater = menuInflater
        // Bizden 2 parametre ister: 1. olusturdugumuz menu(R.menu diyerek ulasabiliriz.)
        // 2.hangi menu ile baglayacagim
        menuInflater.inflate(R.menu.art_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    // onoptions'ta menuye tiklairsa ne olacak onu yapacagiz.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.add_art_item) {
            val intent = Intent(this@MainActivity, ArtActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}