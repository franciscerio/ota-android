import com.android.build.gradle.internal.tasks.databinding.DataBindingGenBaseClassesTask
import org.gradle.configurationcache.extensions.capitalized
import org.jetbrains.kotlin.gradle.tasks.AbstractKotlinCompileTool

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.fcerio.ota.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(libs.gson)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.retrofit.scalars)

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    // Dagger-Hilt
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.android)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
