package br.programacaodinamica.cromessages.fragments


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import br.programacaodinamica.cromessages.ColorAdapter
import br.programacaodinamica.cromessages.ColorViewModel

import br.programacaodinamica.cromessages.R
import br.programacaodinamica.cromessages.models.NamedColor
import kotlinx.android.synthetic.main.fragment_favorite_control.*

/**
 * A simple [Fragment] subclass.
 *
 */
class FavoriteControlFragment : Fragment() {

    private lateinit var colorViewModel: ColorViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.let { colorViewModel = ViewModelProviders.of(it).get(ColorViewModel::class.java) }
        return inflater.inflate(R.layout.fragment_favorite_control, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        subscribe()
    }

    private fun setUpRecyclerView(){
        Log.d("FAVORITE", "RECYCLERVIEW")
        colors_grid.adapter = ColorAdapter()
        colors_grid.layoutManager = GridLayoutManager(context, 4)
    }

    private fun subscribe(){
        colorViewModel.newColor.observe(this, Observer {
            val colorAdapter = colors_grid.adapter as? ColorAdapter
            colorAdapter?.setData(colorViewModel.favoriteColors)
        })
    }

}
