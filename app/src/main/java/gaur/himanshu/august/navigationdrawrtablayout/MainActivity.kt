package gaur.himanshu.august.navigationdrawrtablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawrLayout: DrawerLayout
    private lateinit var navController: NavController
    private lateinit var navigationView: NavigationView

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawrLayout = findViewById(R.id.main_root)
        navController = findNavController(R.id.frag_container)
        navigationView = findViewById(R.id.navigation_view)

        appBarConfiguration = AppBarConfiguration(navController.graph, drawrLayout)

        navigationView.setupWithNavController(navController)

       navigationView.inflateHeaderView(R.layout.header_layout)

        setupActionBarWithNavController(navController, drawrLayout)

    }


    override fun onSupportNavigateUp(): Boolean {
        navController = findNavController(R.id.frag_container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}