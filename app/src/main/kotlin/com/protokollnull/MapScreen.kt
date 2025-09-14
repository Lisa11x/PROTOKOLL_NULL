package com.protokollnull

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.compass.compass

@Composable
fun MapScreen() {
    var mapStyle by remember { mutableStateOf(Style.MAPBOX_STREETS) }

    Box(Modifier.fillMaxSize()) {
        AndroidView(
            factory = { context ->
                MapView(context).apply {
                    getMapboxMap().loadStyleUri(mapStyle)
                    compass.updateSettings { isEnabled = true }
                }
            },
            modifier = Modifier.fillMaxSize(),
            update = { it.getMapboxMap().loadStyleUri(mapStyle) }
        )

        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { mapStyle = Style.MAPBOX_STREETS }) {
                Text("Standard")
            }
            Button(onClick = { mapStyle = Style.SATELLITE_STREETS }) {
                Text("Satellit")
            }
            Button(onClick = { mapStyle = Style.OUTDOORS }) {
                Text("Gelände")
            }
        }
    }
}
