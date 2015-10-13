package tabulate.scalaz

import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.typelevel.discipline.scalatest.Discipline
import tabulate.laws.discipline.{RowCodecTests, CellCodecTests}

import _root_.scalaz.\/
import _root_.scalaz.scalacheck.ScalazArbitrary._

class EitherTests extends FunSuite with GeneratorDrivenPropertyChecks with Discipline {
  checkAll("Int \\/ Boolean", CellCodecTests[Int \/ Boolean].cellCodec[Byte, Float])
  checkAll("(Int, Int, Int) \\/ (Boolean, Float)", RowCodecTests[(Int, Int, Int) \/ (Boolean, Float)].rowCodec[Byte, String])
}