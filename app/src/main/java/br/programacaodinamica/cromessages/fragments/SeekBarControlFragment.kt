package br.programacaodinamica.cromessages.fragments


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.programacaodinamica.cromessages.ColorViewModel

import br.programacaodinamica.cromessages.R
import kotlinx.android.synthetic.main.fragment_color_selection.*
import kotlinx.android.synthetic.main.fragment_seek_bar_control.*

/**
 * A simple [Fragment] subclass.
 *
 */
class SeekBarControlFragment : Fragment() {
    private lateinit var colorViewModel: ColorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.let { colorViewModel = ViewModelProviders.of(it).get(ColorViewModel::class.java) }

        return inflater.inflate(R.layout.fragment_seek_bar_control, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
        subscribe()
    }
    private fun subscribe(){
        colorViewModel.color.observe(this, Observer {
            val red = Color.red(it)
            val green = Color.green(it)
            val blue = Color.blue(it)
            dec_code_textview.text = "($red, $green, $blue)"
            red_seekbar.progress = red
            green_seekbar.progress = green
            blue_seekbar.progress = blue
        })
    }

    private fun setUpListeners(){
        val seekBarChangeListener = object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, value: Int, fromUser: Boolean) {
                if(fromUser){
                    when(seekBar?.id){
                        red_seekbar.id -> colorViewModel.red = value
                        green_seekbar.id -> colorViewModel.green = value
                        blue_seekbar.id -> colorViewModel.blue = value
                    }
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        }
        red_seekbar.setOnSeekBarChangeListener(seekBarChangeListener)
        green_seekbar.setOnSeekBarChangeListener(seekBarChangeListener)
        blue_seekbar.setOnSeekBarChangeListener(seekBarChangeListener)
    }


}
