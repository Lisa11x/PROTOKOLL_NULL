package com.protokollnull

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapInitOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.Style

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mapbox Init mit deinem echten Token
        val mapInitOptions = MapInitOptions(this, resourceOptions = com.mapbox.maps.ResourceOptionsManager
            .getDefault(this, "pk.eyJ1IjoiYjGlzYWExMXgiLCJhIjoiY21mMGkwcWxwMDI4MjNrcjFj eGRpbzBxbjJ9.UhfvbHkY5PwCPOr-xKuA")
            .resourceOptions)

        setContent {
            MapboxScreen(mapInitOptions)
        }
    }
}

@Composable
fun MapboxScreen(mapInitOptions: MapInitOptions) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            MapView(context, mapInitOptions).apply {
                getMapboxMap().loadStyleUri(Style.SATELLITE_STREETS)
                getMapboxMap().setCamera(
                    CameraOptions.Builder()
                        .center(Point.fromLngLat(8.3, 46.8)) // Schweiz
                        .zoom(7.5)
                        .build()
                )
            }
        }
    )
}
