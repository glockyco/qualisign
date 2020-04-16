package at.qualisign.app

object SlickCodeGeneration extends App {
  // @TODO: centralize DB configuration

  slick.codegen.SourceCodeGenerator.run(
    "slick.jdbc.PostgresProfile",
    "org.postgresql.Driver",
    "jdbc:postgresql://localhost:5432/postgres",
    "src/main/scala/",
    "at.qualisign.persistence",
    Some("postgres"),
    Some("postgres"),
    ignoreInvalidDefaults = true,
    outputToMultipleFiles = false,
  )
}
