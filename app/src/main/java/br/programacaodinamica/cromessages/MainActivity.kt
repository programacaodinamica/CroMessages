package br.programacaodinamica.cromessages

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // falta sincronização dos dados e interface
    private var red = 100
    private var green = 100
    private var blue = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
                    color_card.setCardBackgroundColor(Color.rgb(red, green, blue))
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
