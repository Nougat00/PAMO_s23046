package pl.edu.pjatk.fitKing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingListAdapter(private val shoppingList: MutableList<ShoppingItems>) :
    RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.item_name)
        val itemCheckbox: CheckBox = itemView.findViewById(R.id.item_checkbox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.shopping_list_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = shoppingList[position]
        holder.itemName.text = item.name
        holder.itemCheckbox.isChecked = item.isPurchased

        holder.itemCheckbox.setOnCheckedChangeListener { _, isChecked ->
            item.isPurchased = isChecked
        }
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }
}