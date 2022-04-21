package winkhanh.com.finalprojet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import winkhanh.com.finalprojet.fragments.MapsFragment
import winkhanh.com.finalprojet.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    val fragmentManager: FragmentManager = supportFragmentManager

    val fragmentM : Fragment = ProfileFragment()
    val fragmentN : Fragment = ProfileFragment() //replace this for the Note Fragment
    val fragmentP : Fragment = ProfileFragment() //replace this for the Profile Fragment
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment : Fragment = MapsFragment()
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
        bottomNav = findViewById(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.action_map -> {
                    fragment = fragmentM
                    Log.d("Main","Pick Map")
                }
                R.id.action_note -> {
                    fragment = fragmentN
                    Log.d("Main","Pick Note")
                }
                R.id.action_profile -> {
                    fragment = fragmentP
                    Log.d("Main","Pick Profile")
                }
                else -> fragment = fragmentM
            }
            fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
            true
        }
        bottomNav.selectedItemId = R.id.action_map
    }
}