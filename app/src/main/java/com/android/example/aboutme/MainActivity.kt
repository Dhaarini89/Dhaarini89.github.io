package com.android.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.aboutme.databinding.ActivityMainBinding
import com.android.example.aboutme.model.MyName

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var myName: MyName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        myName = MyName(getString(R.string.default_name),getString(R.string.greeting))

        dataBinding.myname = myName

        dataBinding.btnDone.setOnClickListener {
            updateName()
        }
    }
    fun updateName()
    {
        dataBinding.apply {
            myName?.name = editName.text.toString()
            myName?.greetings =
                getString(R.string.greeting).replace("Alex", editName.text.toString())

            invalidateAll()

            editName.setText("")


        }
    }
}