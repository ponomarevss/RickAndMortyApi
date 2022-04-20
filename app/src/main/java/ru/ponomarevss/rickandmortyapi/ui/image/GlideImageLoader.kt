package ru.ponomarevss.rickandmortyapi.ui.image

import android.widget.ImageView
import ru.ponomarevss.rickandmortyapi.mvp.model.image.IImageLoader

class GlideImageLoader: IImageLoader<ImageView> {
    override fun loadInto(url: String, container: ImageView) {
        GlideApp.with(container.context)
            .load(url)
            .placeholder(null)
            .circleCrop()
            .into(container)
    }
}