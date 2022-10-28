package com.example.bottomsheetfragment

import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetMenu(private val _this:IOnClickListener, context: Context, private val item:MutableList<NameEntities>) {
    private val bottomSheetDialog:BottomSheetDialog= BottomSheetDialog(context)

    init {
        val view=LayoutInflater.from(context).inflate(R.layout.bottom_sheet_dialog,null)
        bottomSheetDialog.setCancelable(false)
        val btnClose = view.findViewById<ImageButton>(R.id.idBtnDismiss)
        btnClose.setOnClickListener { bottomSheetDialog.dismiss() }
        bottomSheetDialog.setContentView(view)

        with(view){
            findViewById<RecyclerView>(R.id.recyclerview).apply {
                adapter = NameAdapter(item,_this)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)

            }
        }


    }

    fun show(){
        bottomSheetDialog.show()
    }
}