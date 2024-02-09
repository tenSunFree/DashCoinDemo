plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = com.example.buildsrc.Configuration.compileSdk
    namespace = "com.example.feat_photo"

    defaultConfig {
        minSdk = com.example.buildsrc.Configuration.minSdk
        targetSdk = com.example.buildsrc.Configuration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //consumerProguardFiles "consumer-rules.pro"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = com.example.buildsrc.Version.compose_version
    }
    packaging {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
            add("META-INF/gradle/incremental.annotation.processors")
        }
    }
}

dependencies {

    implementation(project(":core"))
    implementation(project(":core-domain"))
    implementation(project(":core-datasource"))
    implementation(project(":feat-common"))
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    with(com.example.buildsrc.Deps.AndroidX.Compose) {
        implementation(com.example.buildsrc.Deps.AndroidX.Compose.ui)
        implementation(com.example.buildsrc.Deps.AndroidX.Compose.material)
        implementation(com.example.buildsrc.Deps.AndroidX.Compose.toolingPreview)
        implementation(com.example.buildsrc.Deps.AndroidX.Compose.materialIconsExtended)
        implementation(com.example.buildsrc.Deps.AndroidX.Compose.runtime)
    }

    //implementation androidx.activity:activity-compose:1.7.0
    implementation(com.example.buildsrc.Deps.AndroidX.Core.coreKtx)
    implementation(com.example.buildsrc.Deps.AndroidX.Lifecycle.runtime)


    // Compose dependencies
    implementation(com.example.buildsrc.Deps.Google.Accompanist.flowLayout)
    implementation(com.example.buildsrc.Deps.AndroidX.Navigation.compose)
    implementation(com.example.buildsrc.Deps.AndroidX.ConstraintLayout.compose)
    //implementation "androidx.constraintlayout:constraintlayout-compose:1.0.1"


    //coil
    implementation(com.example.buildsrc.Deps.IO.Coil.compose)


    // Dagger hilt
    with(com.example.buildsrc.Deps.Google.DaggerHilt) {
        implementation(com.example.buildsrc.Deps.Google.DaggerHilt.android)
        kapt(com.example.buildsrc.Deps.Google.DaggerHilt.compiler)
    }
    kapt(com.example.buildsrc.Deps.AndroidX.Hilt.compiler)
    implementation(com.example.buildsrc.Deps.AndroidX.Hilt.navigationCompose)

    //lottie
    implementation(com.example.buildsrc.Deps.Airbnb.Android.lottieCompose)

    // Coroutine Lifecycle Scopes
    with(com.example.buildsrc.Deps.AndroidX.Lifecycle) {
        implementation(com.example.buildsrc.Deps.AndroidX.Lifecycle.viewModelKtx)
        implementation(com.example.buildsrc.Deps.AndroidX.Lifecycle.runtimeKtx)
        implementation(com.example.buildsrc.Deps.AndroidX.Lifecycle.viewModelCompose)
    }

    //SweetToast
    implementation(com.example.buildsrc.Deps.Github.Tfaki.composableSweetToast)

    //SwipeToRefresh
    implementation(com.example.buildsrc.Deps.Google.Accompanist.swipeRefresh)

    //Local unit tests
    testImplementation(com.example.buildsrc.Deps.AndroidX.Test.core)
    testImplementation(com.example.buildsrc.Deps.Junit.junit4)
    testImplementation(com.example.buildsrc.Deps.AndroidX.Arch.coreTest)
    testImplementation(com.example.buildsrc.Deps.Org.Jetbrains.Kotlinx.coroutineTest)
    testImplementation(com.example.buildsrc.Deps.Google.Truth.truth)
    testImplementation(com.example.buildsrc.Deps.SquareUp.Okhhtp3.mockwebserver)

    testImplementation(com.example.buildsrc.Deps.IO.Mockk.mockk)
}