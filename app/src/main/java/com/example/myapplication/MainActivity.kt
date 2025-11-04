import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.auth.AuthViewModel
import com.example.myapplication.auth.authGraph
import com.example.myapplication.navigation.BottomNavigationBar
import com.example.myapplication.navigation.NavigationGraph
import com.example.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val authViewModel: AuthViewModel = hiltViewModel()
                val isAuthenticated by authViewModel.isAuthenticated.collectAsState()
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = if (isAuthenticated) "main_graph" else "login"
                ) {
                    authGraph(navController = navController) {
                        navController.navigate("main_graph") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                    composable("main_graph") {
                        Scaffold(
                            bottomBar = { BottomNavigationBar(navController = navController) }
                        ) { innerPadding ->
                            Box(modifier = Modifier.padding(innerPadding)) {
                                NavigationGraph(navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}