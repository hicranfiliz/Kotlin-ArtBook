package com.example.kotlinartbook

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kotlinartbook.databinding.ActivityArtBinding
import com.google.android.material.snackbar.Snackbar

class ArtActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        // view tarafindan cagrilacagini soyluyoruz.
        fun saveButtonClicked(view: View) {

        }

        fun selectImage(view: View) {

            // daha onceden izin verilmis mi kontrol et
            // Compat kullaniyporuz cunku eski versiyonlarda izin yok. Izin istemeyecekken istemeyelim diye Compat kullaniyoruz.

            // izinleri manifeste eklemek yeterli. Burada sadece kontrol ediyoruz.
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // izin alma mantigini kullaniciya gostereyim mi?
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        android.Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                ) {
                    // rationale : gosterdikten sonra isteyecegim
                    // Toats mesaji yapmiyorum cunku Snackbar'da tiklanacak bir dugme de var.
                    // Indefinite: belirsiz..
                    // setAction ile butonun adi ne olsun..
                    Snackbar.make(view, "Permission needed for Gallery", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Give Permission", View.OnClickListener {
                            //request permission:
                        }).show()
                } else {
                    // request permission: izin isteme : gostermeden isteyecegim..
                }

            } else {
                // resmin oldugu uri lazim.
                val intentToGallery =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                // intent
            }
        }
    }
}