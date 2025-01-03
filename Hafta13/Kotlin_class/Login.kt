package com.example.messageappwtk

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.messageappwtk.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLoginSignIn.setOnClickListener {
            val uEmail = binding.etLoginEmail.text.toString()
            val uPassword = binding.etLoginPassword.text.toString()
            if (uEmail.isNotEmpty() && uPassword.isNotEmpty())
            {
                auth.signInWithEmailAndPassword(uEmail, uPassword)
                    .addOnSuccessListener {
                        Toast.makeText(this@Login, "Giriş Başarılı", Toast.LENGTH_LONG).show()
                    }
            }
            else
            {
                Toast.makeText(this@Login, "Değerler boş bırakılamaz!", Toast.LENGTH_LONG).show()
            }

        }

        binding.btnLoginSignUp.setOnClickListener {
            startActivity(Intent(this@Login, Register::class.java))
        }


    }
}