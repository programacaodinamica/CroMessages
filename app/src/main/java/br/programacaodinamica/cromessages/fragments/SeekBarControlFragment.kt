package br.programacaodinamica.cromessages.fragments


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar

import br.programacaodinamica.cromessages.R
import kotlinx.android.synthetic.main.fragment_color_selection.*
import kotlinx.android.synthetic.main.fragment_seek_bar_control.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SeekBarControlFragment : Fragment() {

    private var red = 100
    private var green = 100
    private var blue = 100

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seek_bar_control, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners(){
        val seekBarChangeListener = object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, value: Int, fromUser: Boolean) {
                if(fromUser){
                    when(seekBar?.id){
                        red_seekbar.id -> red = value
                        green_seekbar.id -> green = value
                        blue_seekbar.id -> blue = value
                    }
                    // atualizar a interface; apropriado?
                    dec_code_textview.text = "($red, $green, $blue)"
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
