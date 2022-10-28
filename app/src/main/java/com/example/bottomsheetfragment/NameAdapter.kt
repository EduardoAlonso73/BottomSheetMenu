package com.example.bottomsheetfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheetfragment.databinding.ItemNameBinding

class NameAdapter(private var nNama:MutableList<NameEntities>, private val listener:IOnClickListener)
    :RecyclerView.Adapter<NameAdapter.ViewHolder>(){
    private lateinit var  mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     mContext = parent.context
        val view=LayoutInflater.from(mContext).inflate(R.layout.item_name,parent,false)
        return  ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val _nameList=nNama[position]
        with(holder){
            setListener(_nameList)
            mBinding.tvName.text=_nameList.name

        }
    }

    override fun getItemCount(): Int =nNama.size

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val mBinding=ItemNameBinding.bind(view)
        fun setListener(name:NameEntities){
            mBinding.root.setOnClickListener { listener.onClick(name) }
        }
    }
}