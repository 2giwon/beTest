package com.egiwon.benxtest.shop.artist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import com.egiwon.benxtest.BR
import com.egiwon.benxtest.R
import com.egiwon.benxtest.base.BaseAdapter
import com.egiwon.benxtest.databinding.BottomArtistBinding
import com.egiwon.benxtest.shop.model.Artist
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ArtistBottomFragment : BottomSheetDialogFragment() {

    private lateinit var binding: BottomArtistBinding

    private var listener: OnArtistClickActionListener? = null

    interface OnArtistClickActionListener {
        fun onArtistClick(artist: Artist)
    }

    private val onArtistClick: (Artist) -> Unit = {
        listener?.onArtistClick(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.bottom_artist, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvArtist.adapter = object : BaseAdapter<Artist>(
            R.layout.item_artist,
            BR.artist,
            onClick = onArtistClick
        ) {}

        arguments?.getParcelableArrayList<Artist>(KEY_ARTIST)?.let {
            binding.list = it
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = (targetFragment as? OnArtistClickActionListener)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        private const val KEY_ARTIST = "key_artist"

        fun newInstance(artists: List<Artist>): ArtistBottomFragment {
            val args = bundleOf(KEY_ARTIST to artists)

            val fragment = ArtistBottomFragment()
            fragment.arguments = args
            return fragment
        }
    }
}