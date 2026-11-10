
package com.example.kneerehab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.kneerehab.ui.theme.KneeRehabTheme
import com.example.kneerehab.navigation.AppNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KneeRehabTheme {
                AppNavigation()
            }
        }
    }
}
