plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.atlasregen.app"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.atlasregen.app"
        minSdk = 31
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")

    // LibGDX Core
    implementation("com.badlogicgames.gdx:gdx:1.12.0")

    // LibGDX Backend for Android
    implementation("com.badlogicgames.gdx:gdx-backend-android:1.12.0")

    // LibGDX Native dependencies for Android
    implementation("com.badlogicgames.gdx:gdx-platform:1.12.0:natives-armeabi")
    implementation("com.badlogicgames.gdx:gdx-platform:1.12.0:natives-armeabi-v7a")
    implementation("com.badlogicgames.gdx:gdx-platform:1.12.0:natives-arm64-v8a")
    implementation("com.badlogicgames.gdx:gdx-platform:1.12.0:natives-x86")
    implementation("com.badlogicgames.gdx:gdx-platform:1.12.0:natives-x86_64")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("org.eclipse.jgit:org.eclipse.jgit:5.13.0.202109080827-r")

}

