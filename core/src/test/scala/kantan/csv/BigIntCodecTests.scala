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

class BigIntCodecTests extends DisciplineSuite {

  checkAll("CellEncoder[BigInt]", SerializableTests[CellEncoder[BigInt]].serializable)
  checkAll("CellDecoder[BigInt]", SerializableTests[CellDecoder[BigInt]].serializable)

  checkAll("RowEncoder[BigInt]", SerializableTests[RowEncoder[BigInt]].serializable)
  checkAll("RowDecoder[BigInt]", SerializableTests[RowDecoder[BigInt]].serializable)

  checkAll("CellCodec[BigInt]", CellCodecTests[BigInt].codec[String, Float])
  checkAll("RowCodec[BigInt]", RowCodecTests[BigInt].codec[String, Float])

}
