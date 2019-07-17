package br.programacaodinamica.cromessages.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.programacaodinamica.cromessages.ColorViewModel

import br.programacaodinamica.cromessages.R
import kotlinx.android.synthetic.main.fragment_color_selection.*


/**
 * A simple [Fragment] subclass.
 *
 */
class ColorSelectionFragment : Fragment() {

    private lateinit var colorViewModel: ColorViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.let { colorViewModel = ViewModelProviders.of(it).get(ColorViewModel::class.java) }
        return inflater.inflate(R.layout.fragment_color_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribe()
    }

    private fun subscribe(){
        colorViewModel.color.observe(this, Observer {
            color_card.setCardBackgroundColor(it)
        })
    }
}
