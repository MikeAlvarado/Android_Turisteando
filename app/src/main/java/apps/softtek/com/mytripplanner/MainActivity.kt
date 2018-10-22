package apps.softtek.com.mytripplanner

import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import apps.softtek.com.mytripplanner.fragments.AgendaFragment
import apps.softtek.com.mytripplanner.fragments.DestinationsFragment
import apps.softtek.com.mytripplanner.fragments.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var content: FrameLayout? = null

    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.navigation_destinations -> {
                    val fragment = DestinationsFragment.Companion.newInstance()
                    addFragment(fragment)

                    return true
                }
                R.id.navigation_agenda -> {
                    val fragment = AgendaFragment()
                    addFragment(fragment)
                    return true
                }
                R.id.navigation_notifications -> {
                    var fragment = NotificationsFragment()
                    addFragment(fragment)
                    return true
                }
            }
            return false
        }

    }

    /**
     * add/replace fragment in container
     */
    private fun addFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        content = findViewById(R.id.content) as FrameLayout
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        val fragment = DestinationsFragment.newInstance()
        addFragment(fragment)
    }

}