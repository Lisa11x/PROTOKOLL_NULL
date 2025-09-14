package com.protokollnull

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.Plugin
import com.mapbox.maps.plugin.gestures.gestures
import com.mapbox.maps.plugin.locationcomponent.location
import com.mapbox.maps.plugin.scalebar.scalebar
import com.mapbox.maps.compose.*
import com.mapbox.maps.compose.annotation.*
import com.mapbox.maps.compose.ui.*

@Composable
fun MapScreen() {
    var mapStyle by remember { mutableStateOf(Style.MAPBOX_STREETS) }
    var markerPosition by remember { mutableStateOf<Pair<Double, Double>?>(null) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // 🔍 Suchleiste
        SearchBar { query ->
            // Dummy: egal was eingegeben wird -> Marker in Zürich
            markerPosition = Pair(47.3769, 8.5417)
        }

        Box(modifier = Modifier.fillMaxSize()) {
            MapboxMap(
                Modifier.fillMaxSize(),
                style = mapStyle
            ) {
                // Marker anzeigen, falls gesetzt
                markerPosition?.let { (lat, lon) ->
                    PointAnnotation(point = com.mapbox.geojson.Point.fromLngLat(lon, lat)) {
                        Text("Fundstelle")
                    }
                }
            }

            // Buttons für Kartenstile
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
}
