package com.protokollnull

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.protokollnull.api.ApiClient
import com.protokollnull.api.MindatLocation

@Composable
fun SearchBar(onResult: (List<MindatLocation>) -> Unit) {
    var query by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Mineral / Ort suchen") },
            modifier = Modifier.weight(1f)
        )
        Button(onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val resp = ApiClient.mindat.searchLocalities(
                        apiKey = "Token $MINDAT_API_KEY",
                        query = query
                    )
                    onResult(resp.results)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }) {
            Text("Suche")
        }
    }
}
