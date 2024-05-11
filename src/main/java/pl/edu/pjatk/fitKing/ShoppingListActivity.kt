package pl.edu.pjatk.fitKing

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.apache.commons.lang3.StringUtils
import pl.edu.pjatk.fitKing.R.id.itemList

class ShoppingListActivity : AppCompatActivity() {

    private var items: ArrayList<Item> = ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_list_activity)
        findViewById<TextView>(R.id.recipeName).setText(getString(R.string.ShoppingListItemsRecipe1Name))

        for (itemName in StringUtils.split(getString(R.string.ShoppingListItemsRecipe1), ", ")){
            items.add(Item(itemName))
        }

        val itemList = findViewById<RecyclerView>(itemList)
        val recipeAdapter = ShoppingListAdapter(items)
        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = recipeAdapter
        openMainActivity()
    }

    private fun openMainActivity() {
        val backButton = findViewById<ImageButton>(R.id.imageButton)
        backButton.setOnClickListener {
            startActivity(Intent(this@ShoppingListActivity, MainActivity::class.java))
        }
    }

}
