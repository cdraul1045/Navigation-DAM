package pe.upeu.navigationjpc.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

internal val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

internal val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

internal val sBluelightScheme = lightColorScheme(
    primary = blue_primaryLight,
    onPrimary = blue_onPrimaryLight,
    primaryContainer = blue_primaryContainerLight,
    onPrimaryContainer = blue_onPrimaryContainerLight,
    secondary = blue_secondaryLight,
    onSecondary = blue_onSecondaryLight,
    secondaryContainer = blue_secondaryContainerLight,
    onSecondaryContainer = blue_onSecondaryContainerLight,
    tertiary = blue_tertiaryLight,
    onTertiary = blue_onTertiaryLight,
    tertiaryContainer = blue_tertiaryContainerLight,
    onTertiaryContainer = blue_onTertiaryContainerLight,
    error = blue_errorLight,
    onError = blue_onErrorLight,
    errorContainer = blue_errorContainerLight,
    onErrorContainer = blue_onErrorContainerLight,
    background = blue_backgroundLight,
    onBackground = blue_onBackgroundLight,
    surface = blue_surfaceLight,
    onSurface = blue_onSurfaceLight,
    surfaceVariant = blue_surfaceVariantLight,
    onSurfaceVariant = blue_onSurfaceVariantLight,
    outline = blue_outlineLight,
    outlineVariant = blue_outlineVariantLight,
    scrim = blue_scrimLight,
    inverseSurface = blue_inverseSurfaceLight,
    inverseOnSurface = blue_inverseOnSurfaceLight,
    inversePrimary = blue_inversePrimaryLight,
    surfaceDim = blue_surfaceDimLight,
    surfaceBright = blue_surfaceBrightLight,
    surfaceContainerLowest = blue_surfaceContainerLowestLight,
    surfaceContainerLow = blue_surfaceContainerLowLight,
    surfaceContainer = blue_surfaceContainerLight,
    surfaceContainerHigh = blue_surfaceContainerHighLight,
    surfaceContainerHighest = blue_surfaceContainerHighestLight,
)

internal val sBluedarkScheme = darkColorScheme(
    primary = blue_primaryDark,
    onPrimary = blue_onPrimaryDark,
    primaryContainer = blue_primaryContainerDark,
    onPrimaryContainer = blue_onPrimaryContainerDark,
    secondary = blue_secondaryDark,
    onSecondary = blue_onSecondaryDark,
    secondaryContainer = blue_secondaryContainerDark,
    onSecondaryContainer = blue_onSecondaryContainerDark,
    tertiary = blue_tertiaryDark,
    onTertiary = blue_onTertiaryDark,
    tertiaryContainer = blue_tertiaryContainerDark,
    onTertiaryContainer = blue_onTertiaryContainerDark,
    error = blue_errorDark,
    onError = blue_onErrorDark,
    errorContainer = blue_errorContainerDark,
    onErrorContainer = blue_onErrorContainerDark,
    background = blue_backgroundDark,
    onBackground = blue_onBackgroundDark,
    surface = blue_surfaceDark,
    onSurface = blue_onSurfaceDark,
    surfaceVariant = blue_surfaceVariantDark,
    onSurfaceVariant = blue_onSurfaceVariantDark,
    outline = blue_outlineDark,
    outlineVariant = blue_outlineVariantDark,
    scrim = blue_scrimDark,
    inverseSurface = blue_inverseSurfaceDark,
    inverseOnSurface = blue_inverseOnSurfaceDark,
    inversePrimary = blue_inversePrimaryDark,
    surfaceDim = blue_surfaceDimDark,
    surfaceBright = blue_surfaceBrightDark,
    surfaceContainerLowest = blue_surfaceContainerLowestDark,
    surfaceContainerLow = blue_surfaceContainerLowDark,
    surfaceContainer = blue_surfaceContainerDark,
    surfaceContainerHigh = blue_surfaceContainerHighDark,
    surfaceContainerHighest = blue_surfaceContainerHighestDark,
)

enum class ThemeType{RED, BLUE}

@Composable
fun NavigationJPCTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    colorScheme: ColorScheme,
    content: @Composable () -> Unit
) {
    /*
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }*/

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
