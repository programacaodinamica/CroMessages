package br.programacaodinamica.cromessages.fragments


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.cardview.widget.CardView

import br.programacaodinamica.cromessages.R
import br.programacaodinamica.cromessages.isValidHexCode
import br.programacaodinamica.cromessages.on
import kotlinx.android.synthetic.main.fragment_text_control.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TextControlFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text_control, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }


    private fun setUpListeners(){
        fill_button.setOnClickListener {
            setColor()
        }
        hex_edittext.on(EditorInfo.IME_ACTION_DONE) {
            setColor()
        }
    }

    private fun setColor(){
        val colorCode = hex_edittext.text.toString()
        if (isValidHexCode(colorCode)){
            activity?.findViewById<CardView>(R.id.color_card)?.setBackgroundColor(
                Color.parseColor("#$colorCode"))
        } else {
            hex_edittext.error = getString(R.string.invalid_color_string)
        }
    }

}
