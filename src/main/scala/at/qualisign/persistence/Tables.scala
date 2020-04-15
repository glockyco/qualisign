package at.qualisign.persistence
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(Clazzes.schema, ClazzMetricsCkjm.schema, MethodMetricsCkjm.schema, Methods.schema, Pakkages.schema, PatternInstances.schema, PatternRoles.schema, ProjectLanguages.schema, Projects.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Clazzes
   *  @param pakkage Database column pakkage SqlType(varchar)
   *  @param name Database column name SqlType(varchar), PrimaryKey */
  case class ClazzesRow(pakkage: String, name: String)
  /** GetResult implicit for fetching ClazzesRow objects using plain SQL queries */
  implicit def GetResultClazzesRow(implicit e0: GR[String]): GR[ClazzesRow] = GR{
    prs => import prs._
    ClazzesRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table clazzes. Objects of this class serve as prototypes for rows in queries. */
  class Clazzes(_tableTag: Tag) extends profile.api.Table[ClazzesRow](_tableTag, "clazzes") {
    def * = (pakkage, name) <> (ClazzesRow.tupled, ClazzesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(pakkage), Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> ClazzesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column pakkage SqlType(varchar) */
    val pakkage: Rep[String] = column[String]("pakkage")
    /** Database column name SqlType(varchar), PrimaryKey */
    val name: Rep[String] = column[String]("name", O.PrimaryKey)

    /** Foreign key referencing Pakkages (database name clazzes_pakkage_fkey) */
    lazy val pakkagesFk = foreignKey("clazzes_pakkage_fkey", pakkage, Pakkages)(r => r.name, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table Clazzes */
  lazy val Clazzes = new TableQuery(tag => new Clazzes(tag))

  /** Entity class storing rows of table ClazzMetricsCkjm
   *  @param clazz Database column clazz SqlType(varchar), PrimaryKey
   *  @param amc Database column amc SqlType(float8)
   *  @param ca Database column ca SqlType(int4)
   *  @param cam Database column cam SqlType(float8)
   *  @param cbm Database column cbm SqlType(int4)
   *  @param cbo Database column cbo SqlType(int4)
   *  @param cc Database column cc SqlType(int4)
   *  @param ce Database column ce SqlType(int4)
   *  @param dam Database column dam SqlType(float8)
   *  @param dit Database column dit SqlType(int4)
   *  @param ic Database column ic SqlType(int4)
   *  @param lcom Database column lcom SqlType(int4)
   *  @param lcom3 Database column lcom3 SqlType(float8)
   *  @param loc Database column loc SqlType(int4)
   *  @param mfa Database column mfa SqlType(float8)
   *  @param moa Database column moa SqlType(int4)
   *  @param noc Database column noc SqlType(int4)
   *  @param nom Database column nom SqlType(int4)
   *  @param nop Database column nop SqlType(int4)
   *  @param npm Database column npm SqlType(int4)
   *  @param rfc Database column rfc SqlType(int4)
   *  @param wmc Database column wmc SqlType(int4) */
  case class ClazzMetricsCkjmRow(clazz: String, amc: Double, ca: Int, cam: Double, cbm: Int, cbo: Int, cc: Int, ce: Int, dam: Double, dit: Int, ic: Int, lcom: Int, lcom3: Double, loc: Int, mfa: Double, moa: Int, noc: Int, nom: Int, nop: Int, npm: Int, rfc: Int, wmc: Int)
  /** GetResult implicit for fetching ClazzMetricsCkjmRow objects using plain SQL queries */
  implicit def GetResultClazzMetricsCkjmRow(implicit e0: GR[String], e1: GR[Double], e2: GR[Int]): GR[ClazzMetricsCkjmRow] = GR{
    prs => import prs._
    ClazzMetricsCkjmRow.tupled((<<[String], <<[Double], <<[Int], <<[Double], <<[Int], <<[Int], <<[Int], <<[Int], <<[Double], <<[Int], <<[Int], <<[Int], <<[Double], <<[Int], <<[Double], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table clazz_metrics_ckjm. Objects of this class serve as prototypes for rows in queries. */
  class ClazzMetricsCkjm(_tableTag: Tag) extends profile.api.Table[ClazzMetricsCkjmRow](_tableTag, "clazz_metrics_ckjm") {
    def * = (clazz, amc, ca, cam, cbm, cbo, cc, ce, dam, dit, ic, lcom, lcom3, loc, mfa, moa, noc, nom, nop, npm, rfc, wmc) <> (ClazzMetricsCkjmRow.tupled, ClazzMetricsCkjmRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(clazz), Rep.Some(amc), Rep.Some(ca), Rep.Some(cam), Rep.Some(cbm), Rep.Some(cbo), Rep.Some(cc), Rep.Some(ce), Rep.Some(dam), Rep.Some(dit), Rep.Some(ic), Rep.Some(lcom), Rep.Some(lcom3), Rep.Some(loc), Rep.Some(mfa), Rep.Some(moa), Rep.Some(noc), Rep.Some(nom), Rep.Some(nop), Rep.Some(npm), Rep.Some(rfc), Rep.Some(wmc))).shaped.<>({r=>import r._; _1.map(_=> ClazzMetricsCkjmRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get, _19.get, _20.get, _21.get, _22.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column clazz SqlType(varchar), PrimaryKey */
    val clazz: Rep[String] = column[String]("clazz", O.PrimaryKey)
    /** Database column amc SqlType(float8) */
    val amc: Rep[Double] = column[Double]("amc")
    /** Database column ca SqlType(int4) */
    val ca: Rep[Int] = column[Int]("ca")
    /** Database column cam SqlType(float8) */
    val cam: Rep[Double] = column[Double]("cam")
    /** Database column cbm SqlType(int4) */
    val cbm: Rep[Int] = column[Int]("cbm")
    /** Database column cbo SqlType(int4) */
    val cbo: Rep[Int] = column[Int]("cbo")
    /** Database column cc SqlType(int4) */
    val cc: Rep[Int] = column[Int]("cc")
    /** Database column ce SqlType(int4) */
    val ce: Rep[Int] = column[Int]("ce")
    /** Database column dam SqlType(float8) */
    val dam: Rep[Double] = column[Double]("dam")
    /** Database column dit SqlType(int4) */
    val dit: Rep[Int] = column[Int]("dit")
    /** Database column ic SqlType(int4) */
    val ic: Rep[Int] = column[Int]("ic")
    /** Database column lcom SqlType(int4) */
    val lcom: Rep[Int] = column[Int]("lcom")
    /** Database column lcom3 SqlType(float8) */
    val lcom3: Rep[Double] = column[Double]("lcom3")
    /** Database column loc SqlType(int4) */
    val loc: Rep[Int] = column[Int]("loc")
    /** Database column mfa SqlType(float8) */
    val mfa: Rep[Double] = column[Double]("mfa")
    /** Database column moa SqlType(int4) */
    val moa: Rep[Int] = column[Int]("moa")
    /** Database column noc SqlType(int4) */
    val noc: Rep[Int] = column[Int]("noc")
    /** Database column nom SqlType(int4) */
    val nom: Rep[Int] = column[Int]("nom")
    /** Database column nop SqlType(int4) */
    val nop: Rep[Int] = column[Int]("nop")
    /** Database column npm SqlType(int4) */
    val npm: Rep[Int] = column[Int]("npm")
    /** Database column rfc SqlType(int4) */
    val rfc: Rep[Int] = column[Int]("rfc")
    /** Database column wmc SqlType(int4) */
    val wmc: Rep[Int] = column[Int]("wmc")

    /** Foreign key referencing Clazzes (database name clazz_metrics_ckjm_clazz_fkey) */
    lazy val clazzesFk = foreignKey("clazz_metrics_ckjm_clazz_fkey", clazz, Clazzes)(r => r.name, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table ClazzMetricsCkjm */
  lazy val ClazzMetricsCkjm = new TableQuery(tag => new ClazzMetricsCkjm(tag))

  /** Entity class storing rows of table MethodMetricsCkjm
   *  @param method Database column method SqlType(varchar), PrimaryKey
   *  @param cc Database column cc SqlType(int4) */
  case class MethodMetricsCkjmRow(method: String, cc: Int)
  /** GetResult implicit for fetching MethodMetricsCkjmRow objects using plain SQL queries */
  implicit def GetResultMethodMetricsCkjmRow(implicit e0: GR[String], e1: GR[Int]): GR[MethodMetricsCkjmRow] = GR{
    prs => import prs._
    MethodMetricsCkjmRow.tupled((<<[String], <<[Int]))
  }
  /** Table description of table method_metrics_ckjm. Objects of this class serve as prototypes for rows in queries. */
  class MethodMetricsCkjm(_tableTag: Tag) extends profile.api.Table[MethodMetricsCkjmRow](_tableTag, "method_metrics_ckjm") {
    def * = (method, cc) <> (MethodMetricsCkjmRow.tupled, MethodMetricsCkjmRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(method), Rep.Some(cc))).shaped.<>({r=>import r._; _1.map(_=> MethodMetricsCkjmRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column method SqlType(varchar), PrimaryKey */
    val method: Rep[String] = column[String]("method", O.PrimaryKey)
    /** Database column cc SqlType(int4) */
    val cc: Rep[Int] = column[Int]("cc")

    /** Foreign key referencing Methods (database name method_metrics_ckjm_method_fkey) */
    lazy val methodsFk = foreignKey("method_metrics_ckjm_method_fkey", method, Methods)(r => r.name, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table MethodMetricsCkjm */
  lazy val MethodMetricsCkjm = new TableQuery(tag => new MethodMetricsCkjm(tag))

  /** Entity class storing rows of table Methods
   *  @param clazz Database column clazz SqlType(varchar)
   *  @param name Database column name SqlType(varchar), PrimaryKey
   *  @param accessModifier Database column access_modifier SqlType(varchar) */
  case class MethodsRow(clazz: String, name: String, accessModifier: String)
  /** GetResult implicit for fetching MethodsRow objects using plain SQL queries */
  implicit def GetResultMethodsRow(implicit e0: GR[String]): GR[MethodsRow] = GR{
    prs => import prs._
    MethodsRow.tupled((<<[String], <<[String], <<[String]))
  }
  /** Table description of table methods. Objects of this class serve as prototypes for rows in queries. */
  class Methods(_tableTag: Tag) extends profile.api.Table[MethodsRow](_tableTag, "methods") {
    def * = (clazz, name, accessModifier) <> (MethodsRow.tupled, MethodsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(clazz), Rep.Some(name), Rep.Some(accessModifier))).shaped.<>({r=>import r._; _1.map(_=> MethodsRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column clazz SqlType(varchar) */
    val clazz: Rep[String] = column[String]("clazz")
    /** Database column name SqlType(varchar), PrimaryKey */
    val name: Rep[String] = column[String]("name", O.PrimaryKey)
    /** Database column access_modifier SqlType(varchar) */
    val accessModifier: Rep[String] = column[String]("access_modifier")

    /** Foreign key referencing Clazzes (database name methods_clazz_fkey) */
    lazy val clazzesFk = foreignKey("methods_clazz_fkey", clazz, Clazzes)(r => r.name, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table Methods */
  lazy val Methods = new TableQuery(tag => new Methods(tag))

  /** Entity class storing rows of table Pakkages
   *  @param project Database column project SqlType(varchar)
   *  @param name Database column name SqlType(varchar), PrimaryKey */
  case class PakkagesRow(project: String, name: String)
  /** GetResult implicit for fetching PakkagesRow objects using plain SQL queries */
  implicit def GetResultPakkagesRow(implicit e0: GR[String]): GR[PakkagesRow] = GR{
    prs => import prs._
    PakkagesRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table pakkages. Objects of this class serve as prototypes for rows in queries. */
  class Pakkages(_tableTag: Tag) extends profile.api.Table[PakkagesRow](_tableTag, "pakkages") {
    def * = (project, name) <> (PakkagesRow.tupled, PakkagesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(project), Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> PakkagesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column project SqlType(varchar) */
    val project: Rep[String] = column[String]("project")
    /** Database column name SqlType(varchar), PrimaryKey */
    val name: Rep[String] = column[String]("name", O.PrimaryKey)

    /** Foreign key referencing Projects (database name pakkages_project_fkey) */
    lazy val projectsFk = foreignKey("pakkages_project_fkey", project, Projects)(r => r.name, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table Pakkages */
  lazy val Pakkages = new TableQuery(tag => new Pakkages(tag))

  /** Entity class storing rows of table PatternInstances
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param project Database column project SqlType(varchar)
   *  @param pattern Database column pattern SqlType(varchar) */
  case class PatternInstancesRow(id: java.util.UUID, project: String, pattern: String)
  /** GetResult implicit for fetching PatternInstancesRow objects using plain SQL queries */
  implicit def GetResultPatternInstancesRow(implicit e0: GR[java.util.UUID], e1: GR[String]): GR[PatternInstancesRow] = GR{
    prs => import prs._
    PatternInstancesRow.tupled((<<[java.util.UUID], <<[String], <<[String]))
  }
  /** Table description of table pattern_instances. Objects of this class serve as prototypes for rows in queries. */
  class PatternInstances(_tableTag: Tag) extends profile.api.Table[PatternInstancesRow](_tableTag, "pattern_instances") {
    def * = (id, project, pattern) <> (PatternInstancesRow.tupled, PatternInstancesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(project), Rep.Some(pattern))).shaped.<>({r=>import r._; _1.map(_=> PatternInstancesRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column project SqlType(varchar) */
    val project: Rep[String] = column[String]("project")
    /** Database column pattern SqlType(varchar) */
    val pattern: Rep[String] = column[String]("pattern")

    /** Foreign key referencing Projects (database name pattern_instances_pattern) */
    lazy val projectsFk = foreignKey("pattern_instances_pattern", project, Projects)(r => r.name, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table PatternInstances */
  lazy val PatternInstances = new TableQuery(tag => new PatternInstances(tag))

  /** Entity class storing rows of table PatternRoles
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param instanceId Database column instance_id SqlType(uuid)
   *  @param role Database column role SqlType(varchar)
   *  @param element Database column element SqlType(varchar) */
  case class PatternRolesRow(id: java.util.UUID, instanceId: java.util.UUID, role: String, element: String)
  /** GetResult implicit for fetching PatternRolesRow objects using plain SQL queries */
  implicit def GetResultPatternRolesRow(implicit e0: GR[java.util.UUID], e1: GR[String]): GR[PatternRolesRow] = GR{
    prs => import prs._
    PatternRolesRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[String], <<[String]))
  }
  /** Table description of table pattern_roles. Objects of this class serve as prototypes for rows in queries. */
  class PatternRoles(_tableTag: Tag) extends profile.api.Table[PatternRolesRow](_tableTag, "pattern_roles") {
    def * = (id, instanceId, role, element) <> (PatternRolesRow.tupled, PatternRolesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(instanceId), Rep.Some(role), Rep.Some(element))).shaped.<>({r=>import r._; _1.map(_=> PatternRolesRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column instance_id SqlType(uuid) */
    val instanceId: Rep[java.util.UUID] = column[java.util.UUID]("instance_id")
    /** Database column role SqlType(varchar) */
    val role: Rep[String] = column[String]("role")
    /** Database column element SqlType(varchar) */
    val element: Rep[String] = column[String]("element")

    /** Foreign key referencing PatternInstances (database name pattern_roles_instance_id) */
    lazy val patternInstancesFk = foreignKey("pattern_roles_instance_id", instanceId, PatternInstances)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table PatternRoles */
  lazy val PatternRoles = new TableQuery(tag => new PatternRoles(tag))

  /** Entity class storing rows of table ProjectLanguages
   *  @param project Database column project SqlType(varchar)
   *  @param name Database column name SqlType(varchar)
   *  @param fraction Database column fraction SqlType(float8) */
  case class ProjectLanguagesRow(project: String, name: String, fraction: Double)
  /** GetResult implicit for fetching ProjectLanguagesRow objects using plain SQL queries */
  implicit def GetResultProjectLanguagesRow(implicit e0: GR[String], e1: GR[Double]): GR[ProjectLanguagesRow] = GR{
    prs => import prs._
    ProjectLanguagesRow.tupled((<<[String], <<[String], <<[Double]))
  }
  /** Table description of table project_languages. Objects of this class serve as prototypes for rows in queries. */
  class ProjectLanguages(_tableTag: Tag) extends profile.api.Table[ProjectLanguagesRow](_tableTag, "project_languages") {
    def * = (project, name, fraction) <> (ProjectLanguagesRow.tupled, ProjectLanguagesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(project), Rep.Some(name), Rep.Some(fraction))).shaped.<>({r=>import r._; _1.map(_=> ProjectLanguagesRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column project SqlType(varchar) */
    val project: Rep[String] = column[String]("project")
    /** Database column name SqlType(varchar) */
    val name: Rep[String] = column[String]("name")
    /** Database column fraction SqlType(float8) */
    val fraction: Rep[Double] = column[Double]("fraction")

    /** Primary key of ProjectLanguages (database name project_languages_pkey) */
    val pk = primaryKey("project_languages_pkey", (project, name))

    /** Foreign key referencing Projects (database name project_languages_project_fkey) */
    lazy val projectsFk = foreignKey("project_languages_project_fkey", project, Projects)(r => r.name, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table ProjectLanguages */
  lazy val ProjectLanguages = new TableQuery(tag => new ProjectLanguages(tag))

  /** Entity class storing rows of table Projects
   *  @param name Database column name SqlType(varchar), PrimaryKey
   *  @param groupId Database column group_id SqlType(varchar)
   *  @param artifactId Database column artifact_id SqlType(varchar)
   *  @param version Database column version SqlType(varchar)
   *  @param hasSources Database column has_sources SqlType(bool)
   *  @param jarsDownloadStatus Database column jars_download_status SqlType(int4)
   *  @param jarsUnpackingStatus Database column jars_unpacking_status SqlType(int4)
   *  @param languageDetectionStatus Database column language_detection_status SqlType(int4)
   *  @param languagePersistenceStatus Database column language_persistence_status SqlType(int4)
   *  @param metricsCalculationStatus Database column metrics_calculation_status SqlType(int4)
   *  @param metricsPersistenceStatus Database column metrics_persistence_status SqlType(int4)
   *  @param patternDetectionStatus Database column pattern_detection_status SqlType(int4)
   *  @param patternPersistenceStatus Database column pattern_persistence_status SqlType(int4)
   *  @param javaVersionDetectionStatus Database column java_version_detection_status SqlType(int4)
   *  @param javaVersionPersistenceStatus Database column java_version_persistence_status SqlType(int4)
   *  @param javaVersion Database column java_version SqlType(int4), Default(None) */
  case class ProjectsRow(name: String, groupId: String, artifactId: String, version: String, hasSources: Boolean, jarsDownloadStatus: Int, jarsUnpackingStatus: Int, languageDetectionStatus: Int, languagePersistenceStatus: Int, metricsCalculationStatus: Int, metricsPersistenceStatus: Int, patternDetectionStatus: Int, patternPersistenceStatus: Int, javaVersionDetectionStatus: Int, javaVersionPersistenceStatus: Int, javaVersion: Option[Int] = None)
  /** GetResult implicit for fetching ProjectsRow objects using plain SQL queries */
  implicit def GetResultProjectsRow(implicit e0: GR[String], e1: GR[Boolean], e2: GR[Int], e3: GR[Option[Int]]): GR[ProjectsRow] = GR{
    prs => import prs._
    ProjectsRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[Boolean], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<?[Int]))
  }
  /** Table description of table projects. Objects of this class serve as prototypes for rows in queries. */
  class Projects(_tableTag: Tag) extends profile.api.Table[ProjectsRow](_tableTag, "projects") {
    def * = (name, groupId, artifactId, version, hasSources, jarsDownloadStatus, jarsUnpackingStatus, languageDetectionStatus, languagePersistenceStatus, metricsCalculationStatus, metricsPersistenceStatus, patternDetectionStatus, patternPersistenceStatus, javaVersionDetectionStatus, javaVersionPersistenceStatus, javaVersion) <> (ProjectsRow.tupled, ProjectsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(name), Rep.Some(groupId), Rep.Some(artifactId), Rep.Some(version), Rep.Some(hasSources), Rep.Some(jarsDownloadStatus), Rep.Some(jarsUnpackingStatus), Rep.Some(languageDetectionStatus), Rep.Some(languagePersistenceStatus), Rep.Some(metricsCalculationStatus), Rep.Some(metricsPersistenceStatus), Rep.Some(patternDetectionStatus), Rep.Some(patternPersistenceStatus), Rep.Some(javaVersionDetectionStatus), Rep.Some(javaVersionPersistenceStatus), javaVersion)).shaped.<>({r=>import r._; _1.map(_=> ProjectsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(varchar), PrimaryKey */
    val name: Rep[String] = column[String]("name", O.PrimaryKey)
    /** Database column group_id SqlType(varchar) */
    val groupId: Rep[String] = column[String]("group_id")
    /** Database column artifact_id SqlType(varchar) */
    val artifactId: Rep[String] = column[String]("artifact_id")
    /** Database column version SqlType(varchar) */
    val version: Rep[String] = column[String]("version")
    /** Database column has_sources SqlType(bool) */
    val hasSources: Rep[Boolean] = column[Boolean]("has_sources")
    /** Database column jars_download_status SqlType(int4) */
    val jarsDownloadStatus: Rep[Int] = column[Int]("jars_download_status")
    /** Database column jars_unpacking_status SqlType(int4) */
    val jarsUnpackingStatus: Rep[Int] = column[Int]("jars_unpacking_status")
    /** Database column language_detection_status SqlType(int4) */
    val languageDetectionStatus: Rep[Int] = column[Int]("language_detection_status")
    /** Database column language_persistence_status SqlType(int4) */
    val languagePersistenceStatus: Rep[Int] = column[Int]("language_persistence_status")
    /** Database column metrics_calculation_status SqlType(int4) */
    val metricsCalculationStatus: Rep[Int] = column[Int]("metrics_calculation_status")
    /** Database column metrics_persistence_status SqlType(int4) */
    val metricsPersistenceStatus: Rep[Int] = column[Int]("metrics_persistence_status")
    /** Database column pattern_detection_status SqlType(int4) */
    val patternDetectionStatus: Rep[Int] = column[Int]("pattern_detection_status")
    /** Database column pattern_persistence_status SqlType(int4) */
    val patternPersistenceStatus: Rep[Int] = column[Int]("pattern_persistence_status")
    /** Database column java_version_detection_status SqlType(int4) */
    val javaVersionDetectionStatus: Rep[Int] = column[Int]("java_version_detection_status")
    /** Database column java_version_persistence_status SqlType(int4) */
    val javaVersionPersistenceStatus: Rep[Int] = column[Int]("java_version_persistence_status")
    /** Database column java_version SqlType(int4), Default(None) */
    val javaVersion: Rep[Option[Int]] = column[Option[Int]]("java_version", O.Default(None))
  }
  /** Collection-like TableQuery object for table Projects */
  lazy val Projects = new TableQuery(tag => new Projects(tag))
}
