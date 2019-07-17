package br.programacaodinamica.cromessages.fragments


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.view.inputmethod.EditorInfo
import br.programacaodinamica.cromessages.ColorViewModel
import br.programacaodinamica.cromessages.R
import br.programacaodinamica.cromessages.isValidHexCode
import br.programacaodinamica.cromessages.on
import kotlinx.android.synthetic.main.fragment_text_control.*




/**
 * A simple [Fragment] subclass.
 *
 */
class TextControlFragment : Fragment() {

    private lateinit var colorViewModel: ColorViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.let { colorViewModel = ViewModelProviders.of(it).get(ColorViewModel::class.java) }
        return inflater.inflate(R.layout.fragment_text_control, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
        subscribe()
    }



    private fun subscribe(){
        colorViewModel.color.observe(this, Observer {colorInt->
            val hexColor = String.format("%06X", 0xFFFFFF and colorInt)
            hex_edittext.setText(hexColor)
        })
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
            colorViewModel.color.value = Color.parseColor("#$colorCode")
        } else {
            hex_edittext.error = getString(R.string.invalid_color_string)
        }
    }

}
