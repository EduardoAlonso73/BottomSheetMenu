package com.example.bottomsheetfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bottomsheetfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IOnClickListener {
    private lateinit var mBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.idBtnShowBottomSheet.setOnClickListener { shoeBottomSheet() }
    }



    private fun shoeBottomSheet() {BottomSheetMenu(this,this@MainActivity,  NameProvider.listName).show()}

    override fun onClick(name: NameEntities) {}


}