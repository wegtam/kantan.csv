package tabulate

import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.typelevel.discipline.scalatest.Discipline
import tabulate.laws.discipline.CellCodecTests

class IntTests extends FunSuite with GeneratorDrivenPropertyChecks with Discipline {
  checkAll("Int", CellCodecTests[Int].cellCodec[String, Float])
}