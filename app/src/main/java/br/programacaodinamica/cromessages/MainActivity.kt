package br.programacaodinamica.cromessages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.programacaodinamica.cromessages.fragments.SeekBarControlFragment
import br.programacaodinamica.cromessages.fragments.TextControlFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    // falta sincronização dos dados e interface
    private var red = 100
    private var green = 100
    private var blue = 100
    private val fragmentsMap = mapOf(
        Pair(R.id.text_menu_item, TextControlFragment()),
        Pair(R.id.bars_menu_item, SeekBarControlFragment())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpListeners()
    }

    private fun setUpListeners(){

        bottom_navigationview.setOnNavigationItemSelectedListener {
            val fragment = fragmentsMap[it.itemId]
            fragment?.replaceOn(R.id.control_container)
            true
        }
        bottom_navigationview.selectedItemId = R.id.text_menu_item
    }

    private fun Fragment.replaceOn(containerId: Int){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(containerId, this)
        transaction.commit()
    }
}
