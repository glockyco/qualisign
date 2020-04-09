package at.qualisign.domain.extensions

import java.io.File

import at.qualisign.domain.Project

object ProjectExtensions {
  private val base_path: String = "data/projects/"

  implicit class ProjectPaths(project: Project) {
    def rootDirectory: File = {
      new File(base_path + project.name)
    }

    def jarsDirectory: File = {
      new File(rootDirectory, "jars")
    }

    def sourcesJarFile: File = {
      new File(jarsDirectory, "sources.jar")
    }

    def binariesJarFile: File = {
      new File(jarsDirectory, "binaries.jar")
    }

    def sourcesDirectory: File = {
      new File(rootDirectory, "sources")
    }

    def binariesDirectory: File = {
      new File(rootDirectory, "binaries")
    }

    def javaVersionFile: File = {
      new File(rootDirectory, "java_version.txt")
    }

    def languagesDirectory: File = {
      new File(rootDirectory, "languages")
    }

    def languagesFile: File = {
      new File(languagesDirectory, "enry.tsv")
    }

    def metricsDirectory: File = {
      new File(rootDirectory, "metrics")
    }

    def jHawkMetricsFile: File = {
      new File(metricsDirectory, "jhawk.xml")
    }

    def ckjmMetricsFile: File = {
      new File(metricsDirectory, "ckjm.xml")
    }

    def ckjmErrorFile: File = {
      new File(metricsDirectory, "ckjm.errors.txt")
    }

    def patternsDirectory: File = {
      new File(rootDirectory, "patterns")
    }

    def patternsFile: File = {
      new File(patternsDirectory, "ssa.xml")
    }
  }
}
