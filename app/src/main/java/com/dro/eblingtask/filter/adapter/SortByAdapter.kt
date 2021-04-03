package com.dro.eblingtask.filter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.dro.eblingtask.databinding.ItemSortByBinding



class SortByAdapter(context: Context, resource: Int, val objects: Array<out String>) :
    ArrayAdapter<String>(context, resource, objects){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val binding = ItemSortByBinding.inflate(LayoutInflater.from(parent.context), parent, false )

        binding.title = objects[position]

        return binding.root
    }

    override fun getCount(): Int {
        return objects.size
    }

    override fun getItem(position: Int): String? {
        return objects[position]
    }

    override fun isEnabled(position: Int): Boolean {

        return position != 0

    }


}