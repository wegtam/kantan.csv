package kantan.csv

import kantan.codecs.laws.CodecValue.LegalValue
import kantan.codecs.laws.{CodecLaws, DecoderLaws, EncoderLaws, CodecValue}

package object laws {
  type CellDecoderLaws[A] = DecoderLaws[String, A, CsvError, CellDecoder]
  type CellEncoderLaws[A] = EncoderLaws[String, A, CellEncoder]
  type CellCodecLaws[A] = CodecLaws[String, A, CsvError, CellDecoder, CellEncoder]
  type RowDecoderLaws[A] = DecoderLaws[Seq[String], A, CsvError, RowDecoder]
  type RowEncoderLaws[A] = EncoderLaws[Seq[String], A, RowEncoder]
  type RowCodecLaws[A] = CodecLaws[Seq[String], A, CsvError, RowDecoder, RowEncoder]
  type CellValue[A] = CodecValue[String, A]
  type LegalCell[A] = LegalValue[String, A]
  type IllegalCell[A] = CodecValue.IllegalValue[String, A]
  type RowValue[A] = CodecValue[Seq[String], A]
  type LegalRow[A] = LegalValue[Seq[String], A]
  type IllegalRow[A] = CodecValue.IllegalValue[Seq[String], A]
}