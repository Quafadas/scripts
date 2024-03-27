import viz.*
import viz.extensions.*
import viz.PlotTargets.publishToPort

@main def run =
  given i: Int = 8085


  // write a csv reader with these headers name,mfr,type,calories,protein,fat,sodium,fiber,carbo,sugars,potass,vitamins,shelf,weight,cups,rating
  


  val r = new scala.util.Random(42)

  val data = List(
    BarData(r.nextDouble(), "A"),
    BarData(r.nextDouble(), "B"),
    BarData(r.nextDouble(), "C"),
    BarData(r.nextDouble(), "D"),
    BarData(r.nextDouble(), "E")
  )

  // http://localhost:8085/view/bar
  data.plotBarChart(identity)(
    List((spec: ujson.Value) => spec("description") = "bar")
  )

  // http://localhost:8085/view/pie
  data
    .plotPieChart(e => PieData(e.amount, e.category))(
      List((spec: ujson.Value) => spec("description") = "pie")
    )

end run
