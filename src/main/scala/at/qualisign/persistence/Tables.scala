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
  import slick.collection.heterogeneous._
  import slick.collection.heterogeneous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(Clazzes.schema, ClazzMetricsCkjm.schema, ClazzMetricsJhawk.schema, MethodMetricsCkjm.schema, MethodMetricsJhawk.schema, Methods.schema, PakkageMetricsJhawk.schema, Pakkages.schema, PatternInstances.schema, PatternRoles.schema, ProjectLanguages.schema, ProjectMetricsJhawk.schema, Projects.schema).reduceLeft(_ ++ _)
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
   *  @param npm Database column npm SqlType(int4)
   *  @param rfc Database column rfc SqlType(int4)
   *  @param wmc Database column wmc SqlType(int4) */
  case class ClazzMetricsCkjmRow(clazz: String, amc: Double, ca: Int, cam: Double, cbm: Int, cbo: Int, ce: Int, dam: Double, dit: Int, ic: Int, lcom: Int, lcom3: Double, loc: Int, mfa: Double, moa: Int, noc: Int, npm: Int, rfc: Int, wmc: Int)
  /** GetResult implicit for fetching ClazzMetricsCkjmRow objects using plain SQL queries */
  implicit def GetResultClazzMetricsCkjmRow(implicit e0: GR[String], e1: GR[Double], e2: GR[Int]): GR[ClazzMetricsCkjmRow] = GR{
    prs => import prs._
    ClazzMetricsCkjmRow.tupled((<<[String], <<[Double], <<[Int], <<[Double], <<[Int], <<[Int], <<[Int], <<[Double], <<[Int], <<[Int], <<[Int], <<[Double], <<[Int], <<[Double], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table clazz_metrics_ckjm. Objects of this class serve as prototypes for rows in queries. */
  class ClazzMetricsCkjm(_tableTag: Tag) extends profile.api.Table[ClazzMetricsCkjmRow](_tableTag, "clazz_metrics_ckjm") {
    def * = (clazz, amc, ca, cam, cbm, cbo, ce, dam, dit, ic, lcom, lcom3, loc, mfa, moa, noc, npm, rfc, wmc) <> (ClazzMetricsCkjmRow.tupled, ClazzMetricsCkjmRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(clazz), Rep.Some(amc), Rep.Some(ca), Rep.Some(cam), Rep.Some(cbm), Rep.Some(cbo), Rep.Some(ce), Rep.Some(dam), Rep.Some(dit), Rep.Some(ic), Rep.Some(lcom), Rep.Some(lcom3), Rep.Some(loc), Rep.Some(mfa), Rep.Some(moa), Rep.Some(noc), Rep.Some(npm), Rep.Some(rfc), Rep.Some(wmc))).shaped.<>({r=>import r._; _1.map(_=> ClazzMetricsCkjmRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get, _19.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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

  /** Entity class storing rows of table ClazzMetricsJhawk
   *  @param clazz Database column clazz SqlType(varchar), PrimaryKey
   *  @param avcc Database column avcc SqlType(float8)
   *  @param cbo Database column cbo SqlType(int4)
   *  @param coh Database column coh SqlType(float8)
   *  @param cumulativeNumberOfCommentLines Database column cumulative_number_of_comment_lines SqlType(int4)
   *  @param cumulativeNumberOfComments Database column cumulative_number_of_comments SqlType(int4)
   *  @param dit Database column dit SqlType(int4)
   *  @param fanIn Database column fan_in SqlType(int4)
   *  @param fanOut Database column fan_out SqlType(int4)
   *  @param halsteadCumulativeBugs Database column halstead_cumulative_bugs SqlType(float8)
   *  @param halsteadCumulativeLength Database column halstead_cumulative_length SqlType(int4)
   *  @param halsteadCumulativeVolume Database column halstead_cumulative_volume SqlType(float8)
   *  @param halsteadEffort Database column halstead_effort SqlType(float8)
   *  @param lcom Database column lcom SqlType(float8)
   *  @param lcom2 Database column lcom2 SqlType(float8)
   *  @param loc Database column loc SqlType(int4)
   *  @param maintainabilityIndex Database column maintainability_index SqlType(float8)
   *  @param maintainabilityIndexNc Database column maintainability_index_nc SqlType(float8)
   *  @param maxcc Database column maxcc SqlType(int4)
   *  @param messagePassingCoupling Database column message_passing_coupling SqlType(int4)
   *  @param numberOfCommands Database column number_of_commands SqlType(int4)
   *  @param numberOfMethods Database column number_of_methods SqlType(int4)
   *  @param numberOfQueries Database column number_of_queries SqlType(int4)
   *  @param numberOfStatements Database column number_of_statements SqlType(int4)
   *  @param numberOfSubClasses Database column number_of_sub_classes SqlType(int4)
   *  @param numberOfSuperClasses Database column number_of_super_classes SqlType(int4)
   *  @param responseForClass Database column response_for_class SqlType(int4)
   *  @param reuseRation Database column reuse_ration SqlType(float8)
   *  @param revf Database column revf SqlType(float8)
   *  @param six Database column six SqlType(float8)
   *  @param specializationRation Database column specialization_ration SqlType(float8)
   *  @param tcc Database column tcc SqlType(int4)
   *  @param unweightedClassSize Database column unweighted_class_size SqlType(int4) */
  case class ClazzMetricsJhawkRow(clazz: String, avcc: Double, cbo: Int, coh: Double, cumulativeNumberOfCommentLines: Int, cumulativeNumberOfComments: Int, dit: Int, fanIn: Int, fanOut: Int, halsteadCumulativeBugs: Double, halsteadCumulativeLength: Int, halsteadCumulativeVolume: Double, halsteadEffort: Double, lcom: Double, lcom2: Double, loc: Int, maintainabilityIndex: Double, maintainabilityIndexNc: Double, maxcc: Int, messagePassingCoupling: Int, numberOfCommands: Int, numberOfMethods: Int, numberOfQueries: Int, numberOfStatements: Int, numberOfSubClasses: Int, numberOfSuperClasses: Int, responseForClass: Int, reuseRation: Double, revf: Double, six: Double, specializationRation: Double, tcc: Int, unweightedClassSize: Int)
  /** GetResult implicit for fetching ClazzMetricsJhawkRow objects using plain SQL queries */
  implicit def GetResultClazzMetricsJhawkRow(implicit e0: GR[String], e1: GR[Double], e2: GR[Int]): GR[ClazzMetricsJhawkRow] = GR{
    prs => import prs._
    ClazzMetricsJhawkRow(<<[String], <<[Double], <<[Int], <<[Double], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Double], <<[Int], <<[Double], <<[Double], <<[Double], <<[Double], <<[Int], <<[Double], <<[Double], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Double], <<[Double], <<[Double], <<[Double], <<[Int], <<[Int])
  }
  /** Table description of table clazz_metrics_jhawk. Objects of this class serve as prototypes for rows in queries. */
  class ClazzMetricsJhawk(_tableTag: Tag) extends profile.api.Table[ClazzMetricsJhawkRow](_tableTag, "clazz_metrics_jhawk") {
    def * = (clazz :: avcc :: cbo :: coh :: cumulativeNumberOfCommentLines :: cumulativeNumberOfComments :: dit :: fanIn :: fanOut :: halsteadCumulativeBugs :: halsteadCumulativeLength :: halsteadCumulativeVolume :: halsteadEffort :: lcom :: lcom2 :: loc :: maintainabilityIndex :: maintainabilityIndexNc :: maxcc :: messagePassingCoupling :: numberOfCommands :: numberOfMethods :: numberOfQueries :: numberOfStatements :: numberOfSubClasses :: numberOfSuperClasses :: responseForClass :: reuseRation :: revf :: six :: specializationRation :: tcc :: unweightedClassSize :: HNil).mapTo[ClazzMetricsJhawkRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(clazz) :: Rep.Some(avcc) :: Rep.Some(cbo) :: Rep.Some(coh) :: Rep.Some(cumulativeNumberOfCommentLines) :: Rep.Some(cumulativeNumberOfComments) :: Rep.Some(dit) :: Rep.Some(fanIn) :: Rep.Some(fanOut) :: Rep.Some(halsteadCumulativeBugs) :: Rep.Some(halsteadCumulativeLength) :: Rep.Some(halsteadCumulativeVolume) :: Rep.Some(halsteadEffort) :: Rep.Some(lcom) :: Rep.Some(lcom2) :: Rep.Some(loc) :: Rep.Some(maintainabilityIndex) :: Rep.Some(maintainabilityIndexNc) :: Rep.Some(maxcc) :: Rep.Some(messagePassingCoupling) :: Rep.Some(numberOfCommands) :: Rep.Some(numberOfMethods) :: Rep.Some(numberOfQueries) :: Rep.Some(numberOfStatements) :: Rep.Some(numberOfSubClasses) :: Rep.Some(numberOfSuperClasses) :: Rep.Some(responseForClass) :: Rep.Some(reuseRation) :: Rep.Some(revf) :: Rep.Some(six) :: Rep.Some(specializationRation) :: Rep.Some(tcc) :: Rep.Some(unweightedClassSize) :: HNil).shaped.<>(r => ClazzMetricsJhawkRow(r(0).asInstanceOf[Option[String]].get, r(1).asInstanceOf[Option[Double]].get, r(2).asInstanceOf[Option[Int]].get, r(3).asInstanceOf[Option[Double]].get, r(4).asInstanceOf[Option[Int]].get, r(5).asInstanceOf[Option[Int]].get, r(6).asInstanceOf[Option[Int]].get, r(7).asInstanceOf[Option[Int]].get, r(8).asInstanceOf[Option[Int]].get, r(9).asInstanceOf[Option[Double]].get, r(10).asInstanceOf[Option[Int]].get, r(11).asInstanceOf[Option[Double]].get, r(12).asInstanceOf[Option[Double]].get, r(13).asInstanceOf[Option[Double]].get, r(14).asInstanceOf[Option[Double]].get, r(15).asInstanceOf[Option[Int]].get, r(16).asInstanceOf[Option[Double]].get, r(17).asInstanceOf[Option[Double]].get, r(18).asInstanceOf[Option[Int]].get, r(19).asInstanceOf[Option[Int]].get, r(20).asInstanceOf[Option[Int]].get, r(21).asInstanceOf[Option[Int]].get, r(22).asInstanceOf[Option[Int]].get, r(23).asInstanceOf[Option[Int]].get, r(24).asInstanceOf[Option[Int]].get, r(25).asInstanceOf[Option[Int]].get, r(26).asInstanceOf[Option[Int]].get, r(27).asInstanceOf[Option[Double]].get, r(28).asInstanceOf[Option[Double]].get, r(29).asInstanceOf[Option[Double]].get, r(30).asInstanceOf[Option[Double]].get, r(31).asInstanceOf[Option[Int]].get, r(32).asInstanceOf[Option[Int]].get), (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column clazz SqlType(varchar), PrimaryKey */
    val clazz: Rep[String] = column[String]("clazz", O.PrimaryKey)
    /** Database column avcc SqlType(float8) */
    val avcc: Rep[Double] = column[Double]("avcc")
    /** Database column cbo SqlType(int4) */
    val cbo: Rep[Int] = column[Int]("cbo")
    /** Database column coh SqlType(float8) */
    val coh: Rep[Double] = column[Double]("coh")
    /** Database column cumulative_number_of_comment_lines SqlType(int4) */
    val cumulativeNumberOfCommentLines: Rep[Int] = column[Int]("cumulative_number_of_comment_lines")
    /** Database column cumulative_number_of_comments SqlType(int4) */
    val cumulativeNumberOfComments: Rep[Int] = column[Int]("cumulative_number_of_comments")
    /** Database column dit SqlType(int4) */
    val dit: Rep[Int] = column[Int]("dit")
    /** Database column fan_in SqlType(int4) */
    val fanIn: Rep[Int] = column[Int]("fan_in")
    /** Database column fan_out SqlType(int4) */
    val fanOut: Rep[Int] = column[Int]("fan_out")
    /** Database column halstead_cumulative_bugs SqlType(float8) */
    val halsteadCumulativeBugs: Rep[Double] = column[Double]("halstead_cumulative_bugs")
    /** Database column halstead_cumulative_length SqlType(int4) */
    val halsteadCumulativeLength: Rep[Int] = column[Int]("halstead_cumulative_length")
    /** Database column halstead_cumulative_volume SqlType(float8) */
    val halsteadCumulativeVolume: Rep[Double] = column[Double]("halstead_cumulative_volume")
    /** Database column halstead_effort SqlType(float8) */
    val halsteadEffort: Rep[Double] = column[Double]("halstead_effort")
    /** Database column lcom SqlType(float8) */
    val lcom: Rep[Double] = column[Double]("lcom")
    /** Database column lcom2 SqlType(float8) */
    val lcom2: Rep[Double] = column[Double]("lcom2")
    /** Database column loc SqlType(int4) */
    val loc: Rep[Int] = column[Int]("loc")
    /** Database column maintainability_index SqlType(float8) */
    val maintainabilityIndex: Rep[Double] = column[Double]("maintainability_index")
    /** Database column maintainability_index_nc SqlType(float8) */
    val maintainabilityIndexNc: Rep[Double] = column[Double]("maintainability_index_nc")
    /** Database column maxcc SqlType(int4) */
    val maxcc: Rep[Int] = column[Int]("maxcc")
    /** Database column message_passing_coupling SqlType(int4) */
    val messagePassingCoupling: Rep[Int] = column[Int]("message_passing_coupling")
    /** Database column number_of_commands SqlType(int4) */
    val numberOfCommands: Rep[Int] = column[Int]("number_of_commands")
    /** Database column number_of_methods SqlType(int4) */
    val numberOfMethods: Rep[Int] = column[Int]("number_of_methods")
    /** Database column number_of_queries SqlType(int4) */
    val numberOfQueries: Rep[Int] = column[Int]("number_of_queries")
    /** Database column number_of_statements SqlType(int4) */
    val numberOfStatements: Rep[Int] = column[Int]("number_of_statements")
    /** Database column number_of_sub_classes SqlType(int4) */
    val numberOfSubClasses: Rep[Int] = column[Int]("number_of_sub_classes")
    /** Database column number_of_super_classes SqlType(int4) */
    val numberOfSuperClasses: Rep[Int] = column[Int]("number_of_super_classes")
    /** Database column response_for_class SqlType(int4) */
    val responseForClass: Rep[Int] = column[Int]("response_for_class")
    /** Database column reuse_ration SqlType(float8) */
    val reuseRation: Rep[Double] = column[Double]("reuse_ration")
    /** Database column revf SqlType(float8) */
    val revf: Rep[Double] = column[Double]("revf")
    /** Database column six SqlType(float8) */
    val six: Rep[Double] = column[Double]("six")
    /** Database column specialization_ration SqlType(float8) */
    val specializationRation: Rep[Double] = column[Double]("specialization_ration")
    /** Database column tcc SqlType(int4) */
    val tcc: Rep[Int] = column[Int]("tcc")
    /** Database column unweighted_class_size SqlType(int4) */
    val unweightedClassSize: Rep[Int] = column[Int]("unweighted_class_size")

    /** Foreign key referencing Clazzes (database name clazz_metrics_clazz_fkey) */
    lazy val clazzesFk = foreignKey("clazz_metrics_clazz_fkey", clazz :: HNil, Clazzes)(r => r.name :: HNil, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table ClazzMetricsJhawk */
  lazy val ClazzMetricsJhawk = new TableQuery(tag => new ClazzMetricsJhawk(tag))

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

  /** Entity class storing rows of table MethodMetricsJhawk
   *  @param method Database column method SqlType(varchar), PrimaryKey
   *  @param cyclomaticComplexity Database column cyclomatic_complexity SqlType(int4)
   *  @param halsteadBugs Database column halstead_bugs SqlType(float8)
   *  @param halsteadDifficulty Database column halstead_difficulty SqlType(float8)
   *  @param halsteadEffort Database column halstead_effort SqlType(float8)
   *  @param halsteadLength Database column halstead_length SqlType(int4)
   *  @param halsteadVocabulary Database column halstead_vocabulary SqlType(int4)
   *  @param halsteadVolume Database column halstead_volume SqlType(float8)
   *  @param loc Database column loc SqlType(int4)
   *  @param maxDepthOfNesting Database column max_depth_of_nesting SqlType(int4)
   *  @param numberOfArguments Database column number_of_arguments SqlType(int4)
   *  @param numberOfCasts Database column number_of_casts SqlType(int4)
   *  @param numberOfCommentLines Database column number_of_comment_lines SqlType(int4)
   *  @param numberOfComments Database column number_of_comments SqlType(int4)
   *  @param numberOfExpressions Database column number_of_expressions SqlType(int4)
   *  @param numberOfLoops Database column number_of_loops SqlType(int4)
   *  @param numberOfOperands Database column number_of_operands SqlType(int4)
   *  @param numberOfOperators Database column number_of_operators SqlType(int4)
   *  @param numberOfStatements Database column number_of_statements SqlType(int4)
   *  @param numberOfVariableDeclarations Database column number_of_variable_declarations SqlType(int4)
   *  @param numberOfVariableReferences Database column number_of_variable_references SqlType(int4)
   *  @param totalNesting Database column total_nesting SqlType(int4) */
  case class MethodMetricsJhawkRow(method: String, cyclomaticComplexity: Int, halsteadBugs: Double, halsteadDifficulty: Double, halsteadEffort: Double, halsteadLength: Int, halsteadVocabulary: Int, halsteadVolume: Double, loc: Int, maxDepthOfNesting: Int, numberOfArguments: Int, numberOfCasts: Int, numberOfCommentLines: Int, numberOfComments: Int, numberOfExpressions: Int, numberOfLoops: Int, numberOfOperands: Int, numberOfOperators: Int, numberOfStatements: Int, numberOfVariableDeclarations: Int, numberOfVariableReferences: Int, totalNesting: Int)
  /** GetResult implicit for fetching MethodMetricsJhawkRow objects using plain SQL queries */
  implicit def GetResultMethodMetricsJhawkRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Double]): GR[MethodMetricsJhawkRow] = GR{
    prs => import prs._
    MethodMetricsJhawkRow.tupled((<<[String], <<[Int], <<[Double], <<[Double], <<[Double], <<[Int], <<[Int], <<[Double], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table method_metrics_jhawk. Objects of this class serve as prototypes for rows in queries. */
  class MethodMetricsJhawk(_tableTag: Tag) extends profile.api.Table[MethodMetricsJhawkRow](_tableTag, "method_metrics_jhawk") {
    def * = (method, cyclomaticComplexity, halsteadBugs, halsteadDifficulty, halsteadEffort, halsteadLength, halsteadVocabulary, halsteadVolume, loc, maxDepthOfNesting, numberOfArguments, numberOfCasts, numberOfCommentLines, numberOfComments, numberOfExpressions, numberOfLoops, numberOfOperands, numberOfOperators, numberOfStatements, numberOfVariableDeclarations, numberOfVariableReferences, totalNesting) <> (MethodMetricsJhawkRow.tupled, MethodMetricsJhawkRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(method), Rep.Some(cyclomaticComplexity), Rep.Some(halsteadBugs), Rep.Some(halsteadDifficulty), Rep.Some(halsteadEffort), Rep.Some(halsteadLength), Rep.Some(halsteadVocabulary), Rep.Some(halsteadVolume), Rep.Some(loc), Rep.Some(maxDepthOfNesting), Rep.Some(numberOfArguments), Rep.Some(numberOfCasts), Rep.Some(numberOfCommentLines), Rep.Some(numberOfComments), Rep.Some(numberOfExpressions), Rep.Some(numberOfLoops), Rep.Some(numberOfOperands), Rep.Some(numberOfOperators), Rep.Some(numberOfStatements), Rep.Some(numberOfVariableDeclarations), Rep.Some(numberOfVariableReferences), Rep.Some(totalNesting))).shaped.<>({r=>import r._; _1.map(_=> MethodMetricsJhawkRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get, _19.get, _20.get, _21.get, _22.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column method SqlType(varchar), PrimaryKey */
    val method: Rep[String] = column[String]("method", O.PrimaryKey)
    /** Database column cyclomatic_complexity SqlType(int4) */
    val cyclomaticComplexity: Rep[Int] = column[Int]("cyclomatic_complexity")
    /** Database column halstead_bugs SqlType(float8) */
    val halsteadBugs: Rep[Double] = column[Double]("halstead_bugs")
    /** Database column halstead_difficulty SqlType(float8) */
    val halsteadDifficulty: Rep[Double] = column[Double]("halstead_difficulty")
    /** Database column halstead_effort SqlType(float8) */
    val halsteadEffort: Rep[Double] = column[Double]("halstead_effort")
    /** Database column halstead_length SqlType(int4) */
    val halsteadLength: Rep[Int] = column[Int]("halstead_length")
    /** Database column halstead_vocabulary SqlType(int4) */
    val halsteadVocabulary: Rep[Int] = column[Int]("halstead_vocabulary")
    /** Database column halstead_volume SqlType(float8) */
    val halsteadVolume: Rep[Double] = column[Double]("halstead_volume")
    /** Database column loc SqlType(int4) */
    val loc: Rep[Int] = column[Int]("loc")
    /** Database column max_depth_of_nesting SqlType(int4) */
    val maxDepthOfNesting: Rep[Int] = column[Int]("max_depth_of_nesting")
    /** Database column number_of_arguments SqlType(int4) */
    val numberOfArguments: Rep[Int] = column[Int]("number_of_arguments")
    /** Database column number_of_casts SqlType(int4) */
    val numberOfCasts: Rep[Int] = column[Int]("number_of_casts")
    /** Database column number_of_comment_lines SqlType(int4) */
    val numberOfCommentLines: Rep[Int] = column[Int]("number_of_comment_lines")
    /** Database column number_of_comments SqlType(int4) */
    val numberOfComments: Rep[Int] = column[Int]("number_of_comments")
    /** Database column number_of_expressions SqlType(int4) */
    val numberOfExpressions: Rep[Int] = column[Int]("number_of_expressions")
    /** Database column number_of_loops SqlType(int4) */
    val numberOfLoops: Rep[Int] = column[Int]("number_of_loops")
    /** Database column number_of_operands SqlType(int4) */
    val numberOfOperands: Rep[Int] = column[Int]("number_of_operands")
    /** Database column number_of_operators SqlType(int4) */
    val numberOfOperators: Rep[Int] = column[Int]("number_of_operators")
    /** Database column number_of_statements SqlType(int4) */
    val numberOfStatements: Rep[Int] = column[Int]("number_of_statements")
    /** Database column number_of_variable_declarations SqlType(int4) */
    val numberOfVariableDeclarations: Rep[Int] = column[Int]("number_of_variable_declarations")
    /** Database column number_of_variable_references SqlType(int4) */
    val numberOfVariableReferences: Rep[Int] = column[Int]("number_of_variable_references")
    /** Database column total_nesting SqlType(int4) */
    val totalNesting: Rep[Int] = column[Int]("total_nesting")

    /** Foreign key referencing Methods (database name method_metrics_method_fkey) */
    lazy val methodsFk = foreignKey("method_metrics_method_fkey", method, Methods)(r => r.name, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table MethodMetricsJhawk */
  lazy val MethodMetricsJhawk = new TableQuery(tag => new MethodMetricsJhawk(tag))

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

  /** Entity class storing rows of table PakkageMetricsJhawk
   *  @param pakkage Database column pakkage SqlType(varchar), PrimaryKey
   *  @param abstractness Database column abstractness SqlType(float8)
   *  @param avcc Database column avcc SqlType(float8)
   *  @param cumulativeNumberOfCommentLines Database column cumulative_number_of_comment_lines SqlType(int4)
   *  @param cumulativeNumberOfComments Database column cumulative_number_of_comments SqlType(int4)
   *  @param distance Database column distance SqlType(float8)
   *  @param fanin Database column fanin SqlType(int4)
   *  @param fanout Database column fanout SqlType(int4)
   *  @param halsteadCumulativeBugs Database column halstead_cumulative_bugs SqlType(float8)
   *  @param halsteadCumulativeLength Database column halstead_cumulative_length SqlType(int4)
   *  @param halsteadCumulativeVolume Database column halstead_cumulative_volume SqlType(float8)
   *  @param halsteadEffort Database column halstead_effort SqlType(float8)
   *  @param instability Database column instability SqlType(float8)
   *  @param loc Database column loc SqlType(int4)
   *  @param maintainabilityIndex Database column maintainability_index SqlType(float8)
   *  @param maintainabilityIndexNc Database column maintainability_index_nc SqlType(float8)
   *  @param maxcc Database column maxcc SqlType(int4)
   *  @param numberOfClasses Database column number_of_classes SqlType(int4)
   *  @param numberOfMethods Database column number_of_methods SqlType(int4)
   *  @param numberOfStatements Database column number_of_statements SqlType(int4)
   *  @param rvf Database column rvf SqlType(int4)
   *  @param tcc Database column tcc SqlType(int4) */
  case class PakkageMetricsJhawkRow(pakkage: String, abstractness: Double, avcc: Double, cumulativeNumberOfCommentLines: Int, cumulativeNumberOfComments: Int, distance: Double, fanin: Int, fanout: Int, halsteadCumulativeBugs: Double, halsteadCumulativeLength: Int, halsteadCumulativeVolume: Double, halsteadEffort: Double, instability: Double, loc: Int, maintainabilityIndex: Double, maintainabilityIndexNc: Double, maxcc: Int, numberOfClasses: Int, numberOfMethods: Int, numberOfStatements: Int, rvf: Int, tcc: Int)
  /** GetResult implicit for fetching PakkageMetricsJhawkRow objects using plain SQL queries */
  implicit def GetResultPakkageMetricsJhawkRow(implicit e0: GR[String], e1: GR[Double], e2: GR[Int]): GR[PakkageMetricsJhawkRow] = GR{
    prs => import prs._
    PakkageMetricsJhawkRow.tupled((<<[String], <<[Double], <<[Double], <<[Int], <<[Int], <<[Double], <<[Int], <<[Int], <<[Double], <<[Int], <<[Double], <<[Double], <<[Double], <<[Int], <<[Double], <<[Double], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table pakkage_metrics_jhawk. Objects of this class serve as prototypes for rows in queries. */
  class PakkageMetricsJhawk(_tableTag: Tag) extends profile.api.Table[PakkageMetricsJhawkRow](_tableTag, "pakkage_metrics_jhawk") {
    def * = (pakkage, abstractness, avcc, cumulativeNumberOfCommentLines, cumulativeNumberOfComments, distance, fanin, fanout, halsteadCumulativeBugs, halsteadCumulativeLength, halsteadCumulativeVolume, halsteadEffort, instability, loc, maintainabilityIndex, maintainabilityIndexNc, maxcc, numberOfClasses, numberOfMethods, numberOfStatements, rvf, tcc) <> (PakkageMetricsJhawkRow.tupled, PakkageMetricsJhawkRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(pakkage), Rep.Some(abstractness), Rep.Some(avcc), Rep.Some(cumulativeNumberOfCommentLines), Rep.Some(cumulativeNumberOfComments), Rep.Some(distance), Rep.Some(fanin), Rep.Some(fanout), Rep.Some(halsteadCumulativeBugs), Rep.Some(halsteadCumulativeLength), Rep.Some(halsteadCumulativeVolume), Rep.Some(halsteadEffort), Rep.Some(instability), Rep.Some(loc), Rep.Some(maintainabilityIndex), Rep.Some(maintainabilityIndexNc), Rep.Some(maxcc), Rep.Some(numberOfClasses), Rep.Some(numberOfMethods), Rep.Some(numberOfStatements), Rep.Some(rvf), Rep.Some(tcc))).shaped.<>({r=>import r._; _1.map(_=> PakkageMetricsJhawkRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get, _19.get, _20.get, _21.get, _22.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column pakkage SqlType(varchar), PrimaryKey */
    val pakkage: Rep[String] = column[String]("pakkage", O.PrimaryKey)
    /** Database column abstractness SqlType(float8) */
    val abstractness: Rep[Double] = column[Double]("abstractness")
    /** Database column avcc SqlType(float8) */
    val avcc: Rep[Double] = column[Double]("avcc")
    /** Database column cumulative_number_of_comment_lines SqlType(int4) */
    val cumulativeNumberOfCommentLines: Rep[Int] = column[Int]("cumulative_number_of_comment_lines")
    /** Database column cumulative_number_of_comments SqlType(int4) */
    val cumulativeNumberOfComments: Rep[Int] = column[Int]("cumulative_number_of_comments")
    /** Database column distance SqlType(float8) */
    val distance: Rep[Double] = column[Double]("distance")
    /** Database column fanin SqlType(int4) */
    val fanin: Rep[Int] = column[Int]("fanin")
    /** Database column fanout SqlType(int4) */
    val fanout: Rep[Int] = column[Int]("fanout")
    /** Database column halstead_cumulative_bugs SqlType(float8) */
    val halsteadCumulativeBugs: Rep[Double] = column[Double]("halstead_cumulative_bugs")
    /** Database column halstead_cumulative_length SqlType(int4) */
    val halsteadCumulativeLength: Rep[Int] = column[Int]("halstead_cumulative_length")
    /** Database column halstead_cumulative_volume SqlType(float8) */
    val halsteadCumulativeVolume: Rep[Double] = column[Double]("halstead_cumulative_volume")
    /** Database column halstead_effort SqlType(float8) */
    val halsteadEffort: Rep[Double] = column[Double]("halstead_effort")
    /** Database column instability SqlType(float8) */
    val instability: Rep[Double] = column[Double]("instability")
    /** Database column loc SqlType(int4) */
    val loc: Rep[Int] = column[Int]("loc")
    /** Database column maintainability_index SqlType(float8) */
    val maintainabilityIndex: Rep[Double] = column[Double]("maintainability_index")
    /** Database column maintainability_index_nc SqlType(float8) */
    val maintainabilityIndexNc: Rep[Double] = column[Double]("maintainability_index_nc")
    /** Database column maxcc SqlType(int4) */
    val maxcc: Rep[Int] = column[Int]("maxcc")
    /** Database column number_of_classes SqlType(int4) */
    val numberOfClasses: Rep[Int] = column[Int]("number_of_classes")
    /** Database column number_of_methods SqlType(int4) */
    val numberOfMethods: Rep[Int] = column[Int]("number_of_methods")
    /** Database column number_of_statements SqlType(int4) */
    val numberOfStatements: Rep[Int] = column[Int]("number_of_statements")
    /** Database column rvf SqlType(int4) */
    val rvf: Rep[Int] = column[Int]("rvf")
    /** Database column tcc SqlType(int4) */
    val tcc: Rep[Int] = column[Int]("tcc")

    /** Foreign key referencing Pakkages (database name pakkage_metrics_pakkage_fkey) */
    lazy val pakkagesFk = foreignKey("pakkage_metrics_pakkage_fkey", pakkage, Pakkages)(r => r.name, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table PakkageMetricsJhawk */
  lazy val PakkageMetricsJhawk = new TableQuery(tag => new PakkageMetricsJhawk(tag))

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

  /** Entity class storing rows of table ProjectMetricsJhawk
   *  @param project Database column project SqlType(varchar), PrimaryKey
   *  @param tl Database column tl SqlType(int4)
   *  @param bl Database column bl SqlType(int4)
   *  @param ci Database column ci SqlType(int4)
   *  @param co Database column co SqlType(int4) */
  case class ProjectMetricsJhawkRow(project: String, tl: Int, bl: Int, ci: Int, co: Int)
  /** GetResult implicit for fetching ProjectMetricsJhawkRow objects using plain SQL queries */
  implicit def GetResultProjectMetricsJhawkRow(implicit e0: GR[String], e1: GR[Int]): GR[ProjectMetricsJhawkRow] = GR{
    prs => import prs._
    ProjectMetricsJhawkRow.tupled((<<[String], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table project_metrics_jhawk. Objects of this class serve as prototypes for rows in queries. */
  class ProjectMetricsJhawk(_tableTag: Tag) extends profile.api.Table[ProjectMetricsJhawkRow](_tableTag, "project_metrics_jhawk") {
    def * = (project, tl, bl, ci, co) <> (ProjectMetricsJhawkRow.tupled, ProjectMetricsJhawkRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(project), Rep.Some(tl), Rep.Some(bl), Rep.Some(ci), Rep.Some(co))).shaped.<>({r=>import r._; _1.map(_=> ProjectMetricsJhawkRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column project SqlType(varchar), PrimaryKey */
    val project: Rep[String] = column[String]("project", O.PrimaryKey)
    /** Database column tl SqlType(int4) */
    val tl: Rep[Int] = column[Int]("tl")
    /** Database column bl SqlType(int4) */
    val bl: Rep[Int] = column[Int]("bl")
    /** Database column ci SqlType(int4) */
    val ci: Rep[Int] = column[Int]("ci")
    /** Database column co SqlType(int4) */
    val co: Rep[Int] = column[Int]("co")

    /** Foreign key referencing Projects (database name project_metrics_project_fkey) */
    lazy val projectsFk = foreignKey("project_metrics_project_fkey", project, Projects)(r => r.name, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table ProjectMetricsJhawk */
  lazy val ProjectMetricsJhawk = new TableQuery(tag => new ProjectMetricsJhawk(tag))

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
