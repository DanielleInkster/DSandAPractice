plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "DSandAPractice"
include("src:main:Arra")
findProject(":src:main:Arra")?.name = "Arra"
