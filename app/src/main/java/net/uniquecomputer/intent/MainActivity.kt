package net.uniquecomputer.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
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

    }
}