package tabulate.laws

import tabulate.CsvReader
import tabulate.engine.ReaderEngine
import tabulate.ops._

trait ReaderEngineLaws extends RfcReaderLaws with SpectrumReaderLaws with KnownFormatsReaderLaws {
  private def asReader(csv: List[List[Cell]]): CsvReader[List[Cell]] =
    csv.asCsv(',').asUnsafeCsvReader[List[Cell]](',', false)

  def drop(csv: List[List[Cell]], i: Int): Boolean =
    asReader(csv).drop(i).toList == csv.drop(i)

  def dropWhile(csv: List[List[Cell]], f: List[Cell] => Boolean): Boolean =
    asReader(csv).dropWhile(f).toList == csv.dropWhile(f)

  def take(csv: List[List[Cell]], i: Int): Boolean =
    asReader(csv).take(i).toList == csv.take(i)

  def forall(csv: List[List[Cell]], f: List[Cell] => Boolean): Boolean =
    asReader(csv).forall(f) == csv.forall(f)

  def find(csv: List[List[Cell]], f: List[Cell] => Boolean): Boolean =
    asReader(csv).find(f) == csv.find(f)

  def exists(csv: List[List[Cell]], f: List[Cell] => Boolean): Boolean =
    asReader(csv).exists(f) == csv.exists(f)

  def filter(csv: List[List[Cell]], f: List[Cell] => Boolean): Boolean =
    asReader(csv).filter(f).toList == csv.filter(f)

  def withFilter(csv: List[List[Cell]], f: List[Cell] => Boolean): Boolean =
    asReader(csv).withFilter(f).toList == asReader(csv).filter(f).toList

  def toStream(csv: List[List[Cell]]): Boolean =
    asReader(csv).toStream == csv.toStream

  def toTraversable(csv: List[List[Cell]]): Boolean =
    asReader(csv).toTraversable == csv.toTraversable

  def toIterator(csv: List[List[Cell]]): Boolean =
    asReader(csv).toIterator.sameElements(csv.toIterator)

  def isTraversableAgain(csv: List[List[Cell]]): Boolean =
    !asReader(csv).isTraversableAgain

  def hasDefiniteSize(csv: List[List[Cell]]): Boolean = {
    def loop[A](data: CsvReader[A]): Boolean =
      if(data.hasNext) !data.hasDefiniteSize && {data.next(); loop(data)}
      else data.hasDefiniteSize

    loop(asReader(csv))
  }

  def isEmpty(csv: List[List[Cell]]): Boolean = {
    def loop[A](data: CsvReader[A]): Boolean =
      if(data.hasNext) !data.isEmpty && {data.next(); loop(data)}
      else data.isEmpty

    loop(asReader(csv))
  }
}

object ReaderEngineLaws {
  def apply(e: ReaderEngine): ReaderEngineLaws = new ReaderEngineLaws {
    override implicit val engine = e
  }
}