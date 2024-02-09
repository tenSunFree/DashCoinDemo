plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = com.example.buildsrc.Configuration.compileSdk
    namespace = "com.example.dashcoindemo"

    defaultConfig {
        applicationId = com.example.buildsrc.Configuration.applicationId
        minSdk = com.example.buildsrc.Configuration.minSdk
        targetSdk = com.example.buildsrc.Configuration.targetSdk
        versionCode = com.example.buildsrc.Configuration.versionCode
        versionName = com.example.buildsrc.Configuration.versionName
        testInstrumentationRunner = "com.mathroda.dashcoin.CustomTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isDebuggable = true
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
    implementation(project(":feat-photo"))
    implementation("com.google.android.engage:engage-core:1.3.1")

    with(com.example.buildsrc.Deps.AndroidX.Core) {
        implementation(com.example.buildsrc.Deps.AndroidX.Core.coreKtx)
        implementation(com.example.buildsrc.Deps.AndroidX.Core.splashScreen)
    }
    with(com.example.buildsrc.Deps.AndroidX.Compose) {
        implementation(com.example.buildsrc.Deps.AndroidX.Compose.ui)
        implementation(com.example.buildsrc.Deps.AndroidX.Compose.material)
        implementation(com.example.buildsrc.Deps.AndroidX.Compose.toolingPreview)
        implementation(com.example.buildsrc.Deps.AndroidX.Compose.materialIconsExtended)
        implementation(com.example.buildsrc.Deps.AndroidX.Compose.runtime)
    }
    // Coroutine Lifecycle Scopes
    with(com.example.buildsrc.Deps.AndroidX.Lifecycle) {
        implementation(com.example.buildsrc.Deps.AndroidX.Lifecycle.viewModelKtx)
        implementation(com.example.buildsrc.Deps.AndroidX.Lifecycle.runtimeKtx)
        implementation(com.example.buildsrc.Deps.AndroidX.Lifecycle.viewModelCompose)
        implementation(com.example.buildsrc.Deps.AndroidX.Lifecycle.runtime)
    }
    implementation(com.example.buildsrc.Deps.AndroidX.Activity.compose)

    // Compose dependencies
    implementation(com.example.buildsrc.Deps.AndroidX.Navigation.compose)
    implementation(com.example.buildsrc.Deps.AndroidX.ConstraintLayout.compose)

    // Accompanist insets UI
    with(com.example.buildsrc.Deps.Google.Accompanist) {
        implementation(com.example.buildsrc.Deps.Google.Accompanist.insetsUi)
        implementation(com.example.buildsrc.Deps.Google.Accompanist.flowLayout)
        implementation(com.example.buildsrc.Deps.Google.Accompanist.navigationAnimation)
    }

    // Coroutines
    with(com.example.buildsrc.Deps.Org.Jetbrains.Kotlinx) {
        implementation(com.example.buildsrc.Deps.Org.Jetbrains.Kotlinx.coroutineCore)
        implementation(com.example.buildsrc.Deps.Org.Jetbrains.Kotlinx.coroutineAndroid)
        implementation(com.example.buildsrc.Deps.Org.Jetbrains.Kotlinx.coroutinePlayServices)
    }

    // Dagger hilt
    with(com.example.buildsrc.Deps.Google.DaggerHilt) {
        implementation(com.example.buildsrc.Deps.Google.DaggerHilt.android)
        kapt(com.example.buildsrc.Deps.Google.DaggerHilt.compiler)
    }

    with(com.example.buildsrc.Deps.AndroidX.Hilt) {
        implementation(com.example.buildsrc.Deps.AndroidX.Hilt.navigationCompose)
        implementation(com.example.buildsrc.Deps.AndroidX.Hilt.work)
        kapt(com.example.buildsrc.Deps.AndroidX.Hilt.compiler)
    }
}