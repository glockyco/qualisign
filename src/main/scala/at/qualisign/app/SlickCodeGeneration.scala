package at.qualisign.app

object SlickCodeGeneration extends App {
  // @TODO: centralize DB configuration

  slick.codegen.SourceCodeGenerator.run(
    "slick.jdbc.PostgresProfile",
    "org.postgresql.Driver",
    "jdbc:postgresql://localhost:9301/postgres",
    "src/main/scala/",
    "at.qualisign.persistence",
    Some("postgres"),
    Some("postgres"),
    true,
    false
  )
}
