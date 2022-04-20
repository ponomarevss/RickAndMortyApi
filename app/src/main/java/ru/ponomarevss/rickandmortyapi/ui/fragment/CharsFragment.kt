package ru.ponomarevss.rickandmortyapi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.ponomarevss.rickandmortyapi.databinding.FragmentCharsBinding
import ru.ponomarevss.rickandmortyapi.mvp.presenter.CharsPresenter
import ru.ponomarevss.rickandmortyapi.mvp.view.CharsView
import ru.ponomarevss.rickandmortyapi.ui.App
import ru.ponomarevss.rickandmortyapi.ui.BackButtonListener
import ru.ponomarevss.rickandmortyapi.ui.adapter.CharsRVAdapter
import ru.ponomarevss.rickandmortyapi.ui.image.GlideImageLoader

class CharsFragment: MvpAppCompatFragment(), CharsView, BackButtonListener {
    companion object {
        private const val SPAN_COUNT = 2
        fun newInstance() = CharsFragment()
    }

    val presenter: CharsPresenter by moxyPresenter {
        CharsPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    private var adapter: CharsRVAdapter? = null
    private var vb: FragmentCharsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharsBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun init() {
        vb?.rvChars?.layoutManager = GridLayoutManager(context, SPAN_COUNT)
        adapter = CharsRVAdapter(presenter.charsListPresenter, GlideImageLoader())
        vb?.rvChars?.adapter = adapter
    }

    override fun setTitle(text: String) {
        activity?.title = text
    }

    override fun setHomeButton() {
        val activity = activity as AppCompatActivity
        val actionBar = activity.supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun update() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}