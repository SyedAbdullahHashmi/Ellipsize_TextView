plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.example.ellipsizetextview"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

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
    tasks.whenTaskAdded {
        if (name.contains("lint", ignoreCase = true)) {
            enabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

publishing {
    publications {
        create("release", MavenPublication::class) {
            from(components["release"])
            artifact("$buildDir/outputs/aar/ellipsizetextview-release.aar") // Adjust if needed
            groupId = "com.example.ellipsizetextview"
            artifactId = "ellipsizetextview"
            version = "1.0.0"

            pom {
                name.set("LibApp")
                description.set("A custom TextView for Android that ellipsizes each line individually.")
                url.set("https://github.com/SyedAbdullahHashmi/Ellipsize_TextView")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("SyedAbdullahHashmi")
                        name.set("Syed Abdullah Hashmi")
                        email.set("abdullah.hashmi24@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/SyedAbdullahHashmi/Ellipsize_TextView.git")
                    developerConnection.set("scm:git:ssh://github.com:SyedAbdullahHashmi/Ellipsize_TextView.git")
                    url.set("https://github.com/SyedAbdullahHashmi/Ellipsize_TextView")
                }
            }
        }
    }
}