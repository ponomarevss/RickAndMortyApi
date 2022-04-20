package ru.ponomarevss.rickandmortyapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.ponomarevss.rickandmortyapi.databinding.ItemCharBinding
import ru.ponomarevss.rickandmortyapi.mvp.model.image.IImageLoader
import ru.ponomarevss.rickandmortyapi.mvp.presenter.list.ICharsListPresenter
import ru.ponomarevss.rickandmortyapi.mvp.view.list.CharItemView

class CharsRVAdapter(
    val presenter: ICharsListPresenter,
    val imageLoader: IImageLoader<ImageView>
) : RecyclerView.Adapter<CharsRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemCharBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(val vb: ItemCharBinding) : RecyclerView.ViewHolder(vb.root), CharItemView {

        override fun setName(text: String) = with(vb) { tvName.text = text }

        override fun setSpecies(text: String) = with(vb) { tvSpecies.text = text }

        override fun setGender(text: String) = with(vb) { tvGender.text = text }

        override fun loadImage(url: String): Unit = with(vb) {
            imageLoader.loadInto(url, ivChar)
        }

        override var pos = -1
    }
}