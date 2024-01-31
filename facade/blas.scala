//> using platform js

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.Float64Array
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.Float64Array
import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom
import com.raquo.airstream.core.Signal

@js.native
@JSImport("@stdlib/blas", JSImport.Default)
object blas extends js.Object {
  val base: BlasArrayOps = js.native
}

@js.native
trait BlasArrayOps extends js.Object  :

  def daxpy(
      N: Int,
      alpha: Double,
      x: Float64Array,
      strideX: Int,
      y: Float64Array,
      strideY: Int
  ): Unit =
    js.native

  def ddot(
      N: Int,
      x: Float64Array,
      strideX: Int,
      y: Float64Array,
      strideY: Int): Unit = js.native

  def dscal(N: Int, alpha: Double, x: Float64Array, strideX: Int): Unit = js.native

  def dnrm2(N: Int, x: Float64Array, strideX: Int): Double = js.native
end BlasArrayOps

object Foo {
  def main(args: Array[String]): Unit =
    val zipValue = Var(5.0)
    val arr1: Signal[Float64Array] = zipValue.signal.map(x => linspace(0, x, 5))
    // val waaa : Signal[Float64Array] = arr1.signal
    // val arr2 : Signal[Double] = arr1.signal .map { (arrr: Float64Array) =>
    //   blas.base.dnrm2(5, arrr, 1)
    // }
    renderOnDomContentLoaded(
      dom.document.getElementById("app"),
      div(
        h1("Hello Laminar!"),
        div(
          className := "card",
          input(
            placeholder := "Linspace from 0 to ",
            idAttr := "input",
            tpe := "number",
            controlled(
              value <-- zipValue.signal.map(_.toString),
              onInput.mapToValue.map(
                _.filter(Character.isDigit)
              ) --> zipValue.writer.contramap{(s: String) => s.toDouble}
            )
          )
        ),
        p(
          "Find a linearly spaced array from 0 to ",
          p(
            idAttr := "arr",
            child.text <-- arr1.signal.map(_.mkString("[", ",", "]"))
          ),
          p(
            "Uselesslly, it's norm is:",
            p(
              idAttr := "norm",
              child.text <-- arr1.signal.map( arr => blas.base.dnrm2(5, Float64Array.from(arr), 1).toString())
            ),
            "but now we have two facades..."
          )
        )
      )
    )
}

@js.native
@JSImport("@stdlib/linspace", JSImport.Default)
object linspace extends js.Object {
  def apply(start: Double, stop: Double, num: Int): Float64Array = js.native
}
