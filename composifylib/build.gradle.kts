import org.gradle.internal.impldep.org.eclipse.jgit.lib.InflaterCache.release

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.mohanravi.composifylib"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        var versionCode = 1
        var versionName = "0.0.1"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
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
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-geometry-android:1.5.1")
}
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("releaseaar") {
                groupId = "com.github.immohanravi"
                artifactId = "composifylib"
                version = "0.0.1"
                from(components["release"])
                pom {
                    name.set("Composifylib")
                    description.set("Just a library to share all jetpack compose extensions and components. Looking for contributors")
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set("immohanravi")
                            name.set("Mohan Ravi")
                            email.set("immohanravi@gmail.com")
                        }
                    }
                    scm {
                        connection.set("scm:git:github.com/immohanravi/Composify.git")
                        developerConnection.set("scm:git:ssh://github.com/immohanravi/Composify.git")
                        url.set("https://github.com/immohanravi/Composify/")
                    }
                }
            }
        }
    }
}
