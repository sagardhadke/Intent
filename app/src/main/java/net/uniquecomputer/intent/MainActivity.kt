package net.uniquecomputer.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.uniquecomputer.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Implicit Intent
        binding.apply {
            //call, Open Call Dialer App
            call.setOnClickListener {
                val number = 9876543210
                val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: +91 $number"))
                startActivity(callIntent)
            }

            //Mail
            mail.setOnClickListener {
                val email = "sagardeveloper@duck.com"
                val emailIntent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:$email"))
                startActivity(emailIntent)
            }

            //Web
            web.setOnClickListener {
                val webUrl = "https://sagardhadke.netlify.app/"
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))
                startActivity(webIntent)
            }

            //Instagram
            instagram.setOnClickListener {
                val instaUrl = "https://www.instagram.com/sagardhadke_uc/"
                val instaIntent = Intent(Intent.ACTION_VIEW, Uri.parse(instaUrl))
                startActivity(instaIntent)
            }

            //Linkedin
            linkedin.setOnClickListener {
                val linkedinUrl = "https://linkedin.com/in/sagardhadke"
                val linkedinIntent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedinUrl))
                startActivity(linkedinIntent)
            }
        }

        //Explicit Intent
        //Open  Gallery and Pick Image

        binding.apply {
            openimg.setOnClickListener {
               val openGellery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(openGellery, 101)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == RESULT_OK){
            binding.apply {
                openimg.setImageURI(data?.data)
                openimg.isClickable = false
                reset.visibility = View.VISIBLE
                reset.setOnClickListener {
                    reset.visibility = View.GONE
                    openimg.setImageResource(R.drawable.pickimg)
                    openimg.isClickable = true
                }
            }
        }
    }

}