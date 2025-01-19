// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    id("maven-publish")
}
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            pom {
                name = "EllipsizeTextView"
                description = "A custom TextView for Android that ellipsizes each line individually."
                url = "https://github.com/SyedAbdullahHashmi/Ellipsize_TextView"

                licenses {
                    license {
                        name = "MIT License"
                    }
                }
                developers {
                    developer {
                        id = "SyedAbdullahHashmi"
                        name = "Syed Abdullah Hashmi"
                        email = "abdullah.hashmi24@gmail.com"
                    }
                }
                scm {
                    url = "https://github.com/SyedAbdullahHashmi/Ellipsize_TextView"
                }
            }
        }
    }
}