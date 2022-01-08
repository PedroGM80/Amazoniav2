package gallego.morales.amazoniav2


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import gallego.morales.amazoniav2.R.id
import gallego.morales.amazoniav2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    companion object {
        var asientos: MutableList<String> = mutableListOf("")
        var complementos: MutableList<String> = mutableListOf("")


        var total = 0.0
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        //   setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    @SuppressLint("ResourceType")
    fun addSeat(view: View?) {
        if (view != null) {
            //Toast.makeText(activity, view.id.toString(), Toast.LENGTH_LONG).show()
            val totalId = view.resources.getResourceName(view.id).toString()
            val start = totalId.indexOf('/') + 1
            val my_id = totalId.subSequence(start, totalId.length)
            Toast.makeText(this, my_id, Toast.LENGTH_SHORT).show()
            val my_butoon = view.findViewById(view.id) as Button
            val my_color_violet = ContextCompat.getColor(my_butoon.context, R.color.violet)
            val my_color_yellow = ContextCompat.getColor(my_butoon.context, R.color.yellow)
            val my_color_green = ContextCompat.getColor(my_butoon.context, R.color.green)
            var my_color = my_color_yellow
            if (my_id.contains('H') || my_id.contains('I') || my_id.contains('J') || my_id.contains(
                    'k'
                )
            ) {
                my_color = my_color_yellow
            } else if (my_id.contains('A') || my_id.contains('B') || my_id.contains('C')) {
                my_color = my_color_violet
            } else if (my_id.contains('D') || my_id.contains('E') || my_id.contains('F') || my_id.contains(
                    'G'
                )
            ) {
                my_color = my_color_green
            }
            if (!my_butoon.isSelected) {
                my_butoon.setBackgroundColor(Color.RED)
                asientos.add(my_id.toString())
                my_butoon.isSelected = true
            } else {
                my_butoon.setBackgroundColor(my_color)
                my_butoon.isSelected = false
                asientos.remove(my_id.toString())
            }
        }
    }

}



