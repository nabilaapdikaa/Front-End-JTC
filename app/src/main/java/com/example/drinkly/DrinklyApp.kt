package com.example.drinkly

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.drinkly.navigation.NavigationItem
import com.example.drinkly.navigation.Route
import com.example.drinkly.ui.theme.Background
import com.example.drinkly.ui.theme.DrinklyTheme
import com.example.drinkly.ui.theme.Primary

@Composable
fun DrinklyApp(
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val title = when (currentRoute) {
        Route.HOME -> "Beranda"
        Route.KATEGORI -> "Kategori"
        Route.PROFILE -> "Profil"
        "detail/{itemType}/{itemId}" -> "Detail"
        else -> "Drinkly"
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars),
        topBar = {
            TopBar(
                title = title,
                showBackButton = currentRoute?.startsWith("detail") == true,
                onBackPressed = { navController.popBackStack() }
            )
        },
        bottomBar = {
            if (currentRoute != null && currentRoute != "detail/{itemType}/{itemId}") {
                BottomBar(navController)
            }
        },
        containerColor = Primary
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(Background)
        ) {
            NavHost(
                navController = navController,
                startDestination = Route.HOME,
                modifier = Modifier
            ) {
                composable(Route.HOME) {
                    HomeScreen(
                        onRecommendationClick = { recommendation ->
                            navController.navigate(
                                Route.detailRoute(
                                    "recommendation",
                                    recommendation.id
                                )
                            )
                        },
                        onDateClick = { date ->
                            navController.navigate(Route.detailRoute("date", date.id))
                        }
                    )
                }

                composable(Route.KATEGORI) {
                    KategoriScreen(
                        onCategoryClick = { category ->
                            navController.navigate(Route.detailRoute("category", category.id))
                        }
                    )
                }

                composable(Route.PROFILE) {
                    ProfileScreen()
                }

                composable(
                    route = Route.DETAIL,
                    arguments = listOf(
                        navArgument("itemType") { type = NavType.StringType },
                        navArgument("itemId") { type = NavType.IntType }
                    )
                ) { backStackEntry ->
                    val itemType = backStackEntry.arguments?.getString("itemType")
                    val itemId = backStackEntry.arguments?.getInt("itemId")

                    if (itemId != null && itemType != null) {
                        DetailScreen(
                            id = itemId,
                            itemType = itemType,
                            onNavigateToRecommendation = { recommendationId ->
                                navController.navigate(
                                    Route.detailRoute(
                                        "recommendation",
                                        recommendationId
                                    )
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TopBar(
    title: String,
    showBackButton: Boolean = false,
    onBackPressed: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Primary),
        contentAlignment = Alignment.Center
    ) {
        if (showBackButton) {
            IconButton(
                onClick = { onBackPressed() },
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Kembali",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navigationItems = listOf(
        NavigationItem(
            title = "Beranda",
            image = R.drawable.home,
            screen = Route.HOME
        ),
        NavigationItem(
            title = "Kategori",
            image = R.drawable.kategori,
            screen = Route.KATEGORI
        ),
        NavigationItem(
            title = "Profil",
            image = R.drawable.profil,
            screen = Route.PROFILE
        )
    )

    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .height(65.dp),
        containerColor = Primary,
        tonalElevation = 4.dp
    ) {
        navigationItems.forEach { item ->
            val isSelected = currentRoute == item.screen

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navController.navigate(item.screen) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.image),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp),
                        tint = if (isSelected) Color.White else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) Color.White else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DrinklyAppPreview() {
    DrinklyTheme {
        DrinklyApp()
    }
}