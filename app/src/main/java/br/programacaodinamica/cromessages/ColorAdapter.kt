package br.programacaodinamica.cromessages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.programacaodinamica.cromessages.models.NamedColor

class ColorAdapter(var items:List<NamedColor> = listOf()):
                RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = items.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.color_element_card, parent, false)
        return ColorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val namedColor = items[position]
        if (holder is ColorViewHolder){
            holder.colorCard.setCardBackgroundColor(namedColor.colorRepr)
            holder.colorNameTextView.text = namedColor.name
        }
    }

    fun setData(newData: List<NamedColor>){
        items = newData
        notifyDataSetChanged()
    }

    class ColorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val colorCard: CardView = itemView.findViewById(R.id.color_element)
        val colorNameTextView: TextView = itemView.findViewById(R.id.color_name_textview)
    }
}