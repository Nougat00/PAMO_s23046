package pl.edu.pjatk.fitKing

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openBMICalculator(view: View?) {
        startActivity(Intent(this, BMICalculator::class.java))
    }

    fun openCaloriesToEat(view: View?) {
        startActivity(Intent(this, CaloriesToEat::class.java))
    }

    fun openRecipes(view: View?) {
        startActivity(Intent(this, RecipesActivity::class.java))
    }

    fun openShoppingList(view: View?) {
        startActivity(Intent(this, ShoppingListActivity::class.java))
    }
}