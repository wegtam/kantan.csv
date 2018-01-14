/*
 * Copyright 2015 Nicolas Rinaudo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kantan.csv

import laws.discipline._, arbitrary._
import org.scalacheck.{Arbitrary, Gen}

class SeqCodecTests extends DisciplineSuite {

  implicit val arb: Arbitrary[Seq[Int]] = Arbitrary(Gen.nonEmptyContainerOf[Seq, Int](Arbitrary.arbitrary[Int]))

  checkAll("RowEncoder[Seq[Int]]", SerializableTests[RowEncoder[Seq[Int]]].serializable)
  checkAll("RowDecoder[Seq[Int]]", SerializableTests[RowDecoder[Seq[Int]]].serializable)

  checkAll("RowCodec[Seq[Int]]", RowCodecTests[Seq[Int]].codec[List[String], List[Float]])

}
