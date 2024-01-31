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

// @JSGlobal
// @js.native
// object blas extends BlasArrayOps

// @js.native
// trait BlasArrayOps extends js.Object:
//   def daxpy(
//       N: Int,
//       alpha: Double,
//       x: Float64Array,
//       strideX: Int,
//       y: Float64Array,
//       strideY: Int
//   ): Unit =
//     js.native

//   def dscal(N: Int, alpha: Double, x: Float64Array, strideX: Int): Unit =
//     js.native
//   def dnrm2(N: Int, x: Float64Array, strideX: Int): Double = js.native
// end BlasArrayOps

object Foo {
  def main(args: Array[String]): Unit =
    renderOnDomContentLoaded(
      dom.document.getElementById("app"),
      div(

        h1("Hello Laminar!"),
        div(
          className := "card",
          button(
            tpe := "button",
            "Click me for extreme linear algebra!"
          )
        ),
        p(
          "Click on the button logo to do do some linear algebra!",
          child.text <-- EventStream.fromValue("Hello World!")
        )
      )
    )
}

@js.native
@JSImport("@stdlib/linspace", JSImport.Default)
object linspace extends js.Object {
  def apply(start: Double, stop: Double, num: Int): Float64Array = js.native
}
