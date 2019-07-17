package br.programacaodinamica.cromessages


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.programacaodinamica.cromessages.fragments.FavoriteControlFragment
import br.programacaodinamica.cromessages.fragments.SeekBarControlFragment
import br.programacaodinamica.cromessages.fragments.TextControlFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){


    private lateinit var colorViewModel: ColorViewModel
    private val fragmentsMap = mapOf(
        Pair(R.id.text_menu_item, TextControlFragment()),
        Pair(R.id.bars_menu_item, SeekBarControlFragment()),
        Pair(R.id.fav_menu_item, FavoriteControlFragment())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        colorViewModel = ViewModelProviders.of(this).get(ColorViewModel::class.java)
        setUpListeners()
        subscribe()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.save_menu_item -> colorViewModel.syncFavorite()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUpListeners(){
        bottom_navigationview.setOnNavigationItemSelectedListener {
            colorViewModel.selectedFragment.value = it.itemId
            true
        }
    }

    private fun subscribe(){
        colorViewModel.selectedFragment.observe(this, Observer {
            val fragment = fragmentsMap[it]
            fragment?.replaceOn(R.id.control_container)
        })

    }

    private fun Fragment.replaceOn(containerId: Int){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(containerId, this)
        transaction.commit()
    }
}
