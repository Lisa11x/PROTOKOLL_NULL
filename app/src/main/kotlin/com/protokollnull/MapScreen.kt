package com.protokollnull

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mapbox.maps.Style
import com.mapbox.maps.compose.*
import com.mapbox.maps.compose.annotation.*
import com.mapbox.geojson.Point
import com.protokollnull.api.MindatLocation

@Composable
fun MapScreen() {
    var mapStyle by remember { mutableStateOf(Style.MAPBOX_STREETS) }
    var locations by remember { mutableStateOf<List<MindatLocation>>(emptyList()) }

    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar { results ->
            locations = results
        }

        Box(modifier = Modifier.fillMaxSize()) {
            MapboxMap(
                Modifier.fillMaxSize(),
                style = mapStyle
            ) {
                // Marker für Fundorte
                locations.forEach { loc ->
                    if (loc.latitude != null && loc.longitude != null) {
                        PointAnnotation(point = Point.fromLngLat(loc.longitude, loc.latitude)) {
                            Text(loc.name)
                        }
                    }
                }
            }

            // Layer Switcher
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = { mapStyle = Style.MAPBOX_STREETS }) { Text("Standard") }
                Button(onClick = { mapStyle = Style.SATELLITE_STREETS }) { Text("Satellit") }
                Button(onClick = { mapStyle = Style.OUTDOORS }) { Text("Gelände") }
            }
        }
    }
}
