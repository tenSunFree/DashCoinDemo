import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.core_network"
    compileSdk = com.example.buildsrc.Configuration.compileSdk

    defaultConfig {
        minSdk = com.example.buildsrc.Configuration.minSdk
        targetSdk = com.example.buildsrc.Configuration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //consumerProguardFiles = "consumer-rules.pro"


        // val properties = java.util.Properties()
        // properties.load(project.rootProject.file("local.properties").inputStream())

        // buildConfigField("String", "API_KEY", "\"${properties.getProperty("API_KEY")}\"")
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(project(":core"))
    implementation(project(":core-domain"))


    implementation(com.example.buildsrc.Deps.AndroidX.Core.coreKtx)
    implementation(com.example.buildsrc.Deps.AndroidX.AppCompat.appcompat)
    implementation(com.example.buildsrc.Deps.Google.AndroidMaterial.material)
    testImplementation(com.example.buildsrc.Deps.Junit.junit4)

    //retrofit
    implementation(com.example.buildsrc.Deps.SquareUp.Retrofit2.retrofit)
    implementation(com.example.buildsrc.Deps.SquareUp.Retrofit2.convertorGson)
    implementation(com.example.buildsrc.Deps.SquareUp.Okhhtp3.okhttp)
    implementation(com.example.buildsrc.Deps.SquareUp.Okhhtp3.loggingInterceptor)

    // Dagger hilt
    implementation(com.example.buildsrc.Deps.Google.DaggerHilt.android)
    kapt(com.example.buildsrc.Deps.Google.DaggerHilt.compiler)
    kapt(com.example.buildsrc.Deps.AndroidX.Hilt.compiler)


}