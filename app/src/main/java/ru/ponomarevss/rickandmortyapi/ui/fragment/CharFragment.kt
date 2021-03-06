package ru.ponomarevss.rickandmortyapi.ui.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.ponomarevss.rickandmortyapi.BuildConfig.CHAR_ARG
import ru.ponomarevss.rickandmortyapi.databinding.FragmentCharBinding
import ru.ponomarevss.rickandmortyapi.mvp.model.entity.Char
import ru.ponomarevss.rickandmortyapi.mvp.presenter.CharPresenter
import ru.ponomarevss.rickandmortyapi.mvp.view.CharView
import ru.ponomarevss.rickandmortyapi.ui.App
import ru.ponomarevss.rickandmortyapi.ui.BackButtonListener
import ru.ponomarevss.rickandmortyapi.ui.image.GlideImageLoader

class CharFragment : MvpAppCompatFragment(), CharView, BackButtonListener {
    companion object {
        fun newInstance(charUrl: String) = CharFragment().apply {
            arguments = Bundle().apply {
                putString(CHAR_ARG, charUrl)
            }
        }
    }

    val presenter: CharPresenter by moxyPresenter {
        val charUrl = arguments?.getString(CHAR_ARG) as String
        CharPresenter(charUrl).apply {
            App.instance.appComponent.inject(this)
        }
    }

    private var vb: FragmentCharBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun setTitle(text: String) {
        activity?.title = text
    }

    override fun setStatus(text: String) = with(vb) {
        this?.tvStatus?.text = text
    }

    override fun setSpecies(text: String) = with(vb) {
        this?.tvSpecies?.text = text
    }

    override fun setGender(text: String) = with(vb) {
        this?.tvGender?.text = text
    }

    override fun setOriginName(text: String) = with(vb) {
        this?.tvOriginName?.text = text
    }

    override fun setLocationName(text: String) = with(vb) {
        this?.tvLocationName?.text = text
    }

    override fun setCreated(text: String) = with(vb) {
        this?.tvCreated?.text = text
    }

    override fun loadImage(url: String) {
        vb?.ivChar?.let { GlideImageLoader().loadInto(url, it) }
    }

    override fun setHomeButton() {
        val activity = activity as AppCompatActivity
        val actionBar = activity.supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun setAlert(text: String) {
        AlertDialog.Builder(requireContext())
            .setMessage(text)
            .setPositiveButton(android.R.string.cancel) { _, _ ->
                backPressed()
            }
            .show()
    }

    override fun backPressed() = presenter.backPressed()
}