package at.qualisign.domain

case class ClazzMetrics(
  clazz: String,
  avcc: Double,
  cbo: Int,
  coh: Double,
  cumulativeNumberOfCommentLines: Int,
  cumulativeNumberOfComments: Int,
  dit: Int,
  fanIn: Int,
  fanOut: Int,
  halsteadCumulativeBugs: Double,
  halsteadCumulativeLength: Int,
  halsteadCumulativeVolume: Double,
  halsteadEffort: Double,
  lcom: Double,
  lcom2: Double,
  loc: Int,
  maintainabilityIndex: Double,
  maintainabilityIndexNC: Double,
  maxcc: Int,
  messagePassingCoupling: Int,
  numberOfCommands: Int,
  numberOfMethods: Int,
  numberOfQueries: Int,
  numberOfStatements: Int,
  numberOfSubClasses: Int,
  numberOfSuperClasses: Int,
  responseForClass: Int,
  reuseRation: Double,
  revf: Double,
  six: Double,
  specializationRation: Double,
  tcc: Int,
  unweightedClassSize: Int,
)
