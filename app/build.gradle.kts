plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.protokollnull"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.protokollnull"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui:1.6.0")
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("androidx.navigation:navigation-compose:2.7.0")
    implementation("com.mapbox.maps:android:10.16.0")
}

dependencies {
    // Retrofit + Gson
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Mapbox Compose (bereits drin, nur Reminder)
    implementation("com.mapbox.maps:android:10.16.1")
    implementation("com.mapbox.extension:maps-compose:10.16.1")
}
