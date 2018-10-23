package com.oskarszymczyk.suhero.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.oskarszymczyk.suhero.R
import com.oskarszymczyk.suhero.data.Superhero
import com.oskarszymczyk.suhero.databinding.ItemSimpleCharacterBinding
import com.oskarszymczyk.suhero.ui.Refreshable
import com.oskarszymczyk.suhero.ui.viewdatas.ItemCharacterViewData

class WelcomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Refreshable {

    override fun <T> refreshData(data: List<T>) {
        superheroList = data as List<Superhero>
    }

    var superheroList: List<Superhero> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemSimpleCharacterBinding>(LayoutInflater.from(viewGroup.context), R.layout.item_simple_character, viewGroup, false)
        return CharacterItemViewHolder(binding)
    }

    override fun getItemCount(): Int =
            superheroList.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as CharacterItemViewHolder).bind(superhero = superheroList[position])
    }


    class CharacterItemViewHolder(private val itemSimpleCharacterBinding: ItemSimpleCharacterBinding) : RecyclerView.ViewHolder(itemSimpleCharacterBinding.root) {

        fun bind(superhero: Superhero) {
            if (itemSimpleCharacterBinding.characterItem == null) {
                itemSimpleCharacterBinding.characterItem = ItemCharacterViewData()
            }
            itemSimpleCharacterBinding.characterItem!!.initView(superhero)
        }
    }
}