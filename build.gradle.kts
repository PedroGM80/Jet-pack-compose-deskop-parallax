import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.compose") version "1.0.0"
}

group = "me.pedro"
version = "1.0"

repositories {
    google()
    mavenCentral()
   maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {

    implementation(compose.desktop.currentOs)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "T_Desktop_parallax"
            packageVersion = "1.0.0"
        }
    }
}
