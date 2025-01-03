package com.example.messageappwtk

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.messageappwtk.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        auth = FirebaseAuth.getInstance() // Singleton mimariyi uygulamayı sağlayan yapıdır.
        db = FirebaseFirestore.getInstance() // Herbir classtan yalnız ve yalnızca 1 tane nesne oluşturulabilir
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegister.setOnClickListener {
            val uName = binding.etUsername.text.toString()
            val uEmail = binding.etEmail.text.toString()
            val uPassword = binding.etPassword.text.toString()
            if(uName.isNotEmpty() && uEmail.isNotEmpty() && uPassword.isNotEmpty())
            {
                val user = hashMapOf(
                    "username" to uName,
                    "Email" to uEmail
                )
                auth.createUserWithEmailAndPassword(uEmail, uPassword)
                    .addOnSuccessListener {
                        Toast.makeText(this@Register, "Kayıt Başarılı", Toast.LENGTH_LONG).show()
                        db.collection("Users").document(auth.currentUser!!.uid)
                            .set(user)
                            .addOnSuccessListener {
                                startActivity(Intent(this@Register, Login::class.java))
                                finish()
                            }
                    }
            }
            else
            {
                Toast.makeText(this@Register, "Değerler boş bırakılamaz!", Toast.LENGTH_LONG).show()
            }
        }


    }
}