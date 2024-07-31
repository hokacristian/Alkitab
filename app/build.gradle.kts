plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "apps.alquran"
    compileSdk = 34

    defaultConfig {
        applicationId = "apps.alquran"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    //room
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0")
    implementation("androidx.room:room-runtime:2.5.0-alpha02")
    implementation("androidx.room:room-ktx:2.5.0-alpha02")
    annotationProcessor("androidx.room:room-compiler:2.5.0-alpha02")

    //hilt
    implementation("com.google.dagger:hilt-android:2.44")
    annotationProcessor("com.google.dagger:hilt-android-compiler:2.44")


}