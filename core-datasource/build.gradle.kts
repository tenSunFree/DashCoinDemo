plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    // id("com.google.gms.google-services")
}

android {
    namespace = "com.example.core_datasource"
    compileSdk = com.example.buildsrc.Configuration.compileSdk

    defaultConfig {
        minSdk = com.example.buildsrc.Configuration.minSdk
        targetSdk = com.example.buildsrc.Configuration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //consumerProguardFiles = "consumer-rules.pro"
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
    implementation(project(":core-network"))

    implementation(com.example.buildsrc.Deps.AndroidX.Core.coreKtx)
    implementation(com.example.buildsrc.Deps.AndroidX.AppCompat.appcompat)

    //data store
    implementation(com.example.buildsrc.Deps.AndroidX.DataStore.preferences)

    // Dagger hilt
    with(com.example.buildsrc.Deps.Google.DaggerHilt) {
        implementation(com.example.buildsrc.Deps.Google.DaggerHilt.android)
        implementation(com.example.buildsrc.Deps.Google.DaggerHilt.compiler)
    }
    kapt(com.example.buildsrc.Deps.AndroidX.Hilt.compiler)
    kapt(com.example.buildsrc.Deps.Google.DaggerHilt.compiler)

    //Firebase
    with(com.example.buildsrc.Deps.Google.Firebase) {
        implementation(platform(com.example.buildsrc.Deps.Google.Firebase.bom))
        implementation(com.example.buildsrc.Deps.Google.Firebase.authKtx)
        implementation(com.example.buildsrc.Deps.Google.Firebase.fireStoreKtx)
        implementation(com.example.buildsrc.Deps.Google.Firebase.storage)
    }
    //Play Services
    implementation(com.example.buildsrc.Deps.Org.Jetbrains.Kotlinx.coroutinePlayServices)
    //Play Services Auth
    implementation(com.example.buildsrc.Deps.Google.AndroidGms.playServicesAuth)


    // Coroutines
    with(com.example.buildsrc.Deps.Org.Jetbrains.Kotlinx) {
        implementation(com.example.buildsrc.Deps.Org.Jetbrains.Kotlinx.coroutineCore)
        implementation(com.example.buildsrc.Deps.Org.Jetbrains.Kotlinx.coroutineAndroid)
        implementation(com.example.buildsrc.Deps.Org.Jetbrains.Kotlinx.coroutinePlayServices)
    }

    //Work Manger
    implementation(com.example.buildsrc.Deps.AndroidX.Work.runtime)

    //coil
    implementation(com.example.buildsrc.Deps.IO.Coil.compose)

    //Local unit tests
    testImplementation(com.example.buildsrc.Deps.AndroidX.Test.core)
    testImplementation(com.example.buildsrc.Deps.Junit.junit4)
    testImplementation(com.example.buildsrc.Deps.AndroidX.Arch.coreTest)
    testImplementation(com.example.buildsrc.Deps.Org.Jetbrains.Kotlinx.coroutineTest)
    testImplementation(com.example.buildsrc.Deps.Google.Truth.truth)
    testImplementation(com.example.buildsrc.Deps.SquareUp.Okhhtp3.mockwebserver)

    testImplementation(com.example.buildsrc.Deps.IO.Mockk.mockk)

}