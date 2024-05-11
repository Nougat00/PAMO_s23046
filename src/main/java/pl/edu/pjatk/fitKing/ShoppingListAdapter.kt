package pl.edu.pjatk.fitKing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingListAdapter(private var items: List<Item>) : RecyclerView.Adapter<ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.shopping_list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, i: Int) {
        val item = items[i]
        holder.bind(item.title)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val itemText: TextView = itemView.findViewById(R.id.ItemText)
    private val itemCheckbox: CheckBox = itemView.findViewById(R.id.ItemCheckbox)

    fun bind(item: String) {
        itemText.text = item
        itemCheckbox.isChecked = false
    }
}

data class Item(val title: String)