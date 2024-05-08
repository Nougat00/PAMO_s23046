package pl.edu.pjatk.fitKing

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShoppingListActivity : AppCompatActivity() {
    private lateinit var shoppingAdapter: ShoppingListAdapter
    private lateinit var recyclerView: RecyclerView // Inicjalizacja recyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shoppingList = mutableListOf(
            ShoppingItems("Mleko"),
            ShoppingItems("Chleb"),
            ShoppingItems("Jajka"),
        )
        setContentView(R.layout.shopping_list_items) // Ustawienie layoutu
        shoppingAdapter = ShoppingListAdapter(shoppingList)
        recyclerView.adapter = shoppingAdapter

        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
