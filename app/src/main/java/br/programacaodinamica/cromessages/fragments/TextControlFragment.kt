package br.programacaodinamica.cromessages.fragments


import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.programacaodinamica.cromessages.ColorViewModel

import br.programacaodinamica.cromessages.R
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
//        setUpListeners()
//        subscribe()
    }

    private fun setUpListeners(){
        val listener = object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    if (it.length == 6 || it.length == 8){
                        //hex_edittext.setText(it.delete(8, it.length))
                        colorViewModel.color.value = Color.parseColor("#$it")
                    }
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        }
        hex_edittext.addTextChangedListener(listener)
    }

    private fun subscribe(){
        colorViewModel.color.observe(this, Observer {
            val hexColor = String.format("%06X", 0xFFFFFF and it)
            hex_edittext.setText(hexColor)
        })
    }


}
