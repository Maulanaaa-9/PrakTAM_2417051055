package com.example.praktam_2417051055.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = AnimePrimary,
    secondary = AnimeSecondary,
    tertiary = AnimeTertiary,
    background = BackgroundDark,
    surface = SurfaceDark,
    onPrimary = OnPrimary,
    onSurface = OnSurface,
    onBackground = OnBackground
)

private val LightColorScheme = lightColorScheme(
    primary = AnimePrimary,
    secondary = AnimeSecondary,
    tertiary = AnimeTertiary,
    background = Color.White,
    surface = Color(0xFFF5F5F5),
    onPrimary = OnPrimary,
    onSurface = Color.Black,
    onBackground = Color.Black
)

@Composable
fun PrakTAM_2417051055Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
