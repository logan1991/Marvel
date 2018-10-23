package com.oskarszymczyk.suhero.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.oskarszymczyk.suhero.R
import com.oskarszymczyk.suhero.data.Superhero
import com.oskarszymczyk.suhero.databinding.ItemProgressBinding
import com.oskarszymczyk.suhero.databinding.ItemSimpleCharacterBinding
import com.oskarszymczyk.suhero.ui.Refreshable
import com.oskarszymczyk.suhero.ui.viewdatas.ItemCharacterViewData
import com.oskarszymczyk.suhero.ui.viewdatas.ItemProgressViewData
import com.oskarszymczyk.suhero.ui.welcome.superheromanagement.OnSuperheroDataListener
import com.oskarszymczyk.suhero.ui.welcome.superheromanagement.SelectedSuperheroManger
import com.oskarszymczyk.suhero.ui.welcome.superheromanagement.SuperheroData
import java.util.*
import javax.inject.Inject

class WelcomeAdapter @Inject constructor(
        private val selectedSuperheroManger: SelectedSuperheroManger)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Refreshable, OnSuperheroDataListener{

    val CHARACTER_TYPE = 0
    val PROGRESS_TYPE = 1

    var selectedSuperheroPosition: Int = -1
    var endOfData = false
    set(value) {
        field = value
        if(value){
            notifyItemChanged(itemCount)
        }
    }
    private var superheroList = listOf<Superhero>()
    private var lastItemPosition = 0

    init {
        selectedSuperheroManger.addObserver(this)
    }

    fun reinitData(){
        endOfData = false
        selectedSuperheroPosition = -1
        lastItemPosition = 0
    }

    override fun updateValue(superheroData: SuperheroData) {
        val oldPosition = selectedSuperheroPosition
        notifyItemChanged(superheroData.position)
        selectedSuperheroPosition = superheroData.position
        notifyItemChanged(oldPosition)
    }

    override fun <T> refreshData(data: List<T>) {
        superheroList = data as List<Superhero>
        notifyItemRangeChanged(lastItemPosition, itemCount)
        lastItemPosition = itemCount
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType: Int): RecyclerView.ViewHolder {
        if (itemType == CHARACTER_TYPE) {
            val binding = DataBindingUtil.inflate<ItemSimpleCharacterBinding>(LayoutInflater.from(viewGroup.context),
                    R.layout.item_simple_character,
                    viewGroup,
                    false)
            return CharacterItemViewHolder(binding)
        } else {
            val progressBinding = DataBindingUtil.inflate<ItemProgressBinding>(LayoutInflater.from(viewGroup.context),
                    R.layout.item_progress,
                    viewGroup,
                    false)
            return ProgressViewHolder(progressBinding)
        }
    }

    override fun getItemCount(): Int {
        return if(hideProgressOnLastPosition()) {
            superheroList.size
        }else{
            superheroList.size + 1
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == (itemCount-1) && !hideProgressOnLastPosition()) {
            PROGRESS_TYPE
        } else {
            CHARACTER_TYPE
        }
    }


    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == CHARACTER_TYPE) {
            (viewHolder as CharacterItemViewHolder).bind(superhero = superheroList[position], position = position)
        } else {
            (viewHolder as ProgressViewHolder).bind(hideProgressOnLastPosition())
        }
    }

    private fun hideProgressOnLastPosition() = endOfData || superheroList.isEmpty()


    inner class CharacterItemViewHolder(
            private val itemSimpleCharacterBinding: ItemSimpleCharacterBinding)
        : RecyclerView.ViewHolder(itemSimpleCharacterBinding.root) {

        fun bind(superhero: Superhero, position: Int) {
            if (itemSimpleCharacterBinding.characterItem == null) {
                itemSimpleCharacterBinding.characterItem = ItemCharacterViewData(selectedSuperheroManger)
            }
            itemSimpleCharacterBinding.characterItem!!.initView(superhero, position)
            itemSimpleCharacterBinding.characterItem!!.refreshBackground(position == selectedSuperheroPosition)
        }
    }

    class ProgressViewHolder(
            private val progressBinding: ItemProgressBinding)
        : RecyclerView.ViewHolder(progressBinding.root) {

        fun bind(hideProgress: Boolean){
            if(progressBinding.progress == null){
                progressBinding.progress = ItemProgressViewData()
            }
            progressBinding.progress!!.showProgress.set(!hideProgress)
        }
    }
}