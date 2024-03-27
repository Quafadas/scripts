import viz.*
import viz.extensions.*
import viz.PlotTargets.publishToPort
import viz.vega.plots.*

@main def run =
  given i: Int = 8086
  

  case class FromFilePlot(path: os.Path, override val mods: Seq[ujson.Value => Unit] = List()) extends WithBaseSpec(mods)  :
    override lazy val baseSpec: ujson.Value = ujson.read(os.read(path))


  case class Cereal(
      name: String,
      mfr: String,
      `type`: String,
      calories: Int,
      protein: Int,
      fat: Int,
      sodium: Int,
      fiber: Double,
      carbo: Double,
      sugars: Int,
      potass: Int,
      vitamins: Int,
      shelf: Int,
      weight: Double,
      cups: Double,
      rating: Double
  )

  val lines = os.read.lines(os.pwd / "cereal.csv")


  val cereals = lines.tail.map { line =>
    val cols = line.split(",")
    Cereal(
      name = cols(0),
      mfr = cols(1),
      `type` = cols(2),
      calories = cols(3).toInt,
      protein = cols(4).toInt,
      fat = cols(5).toInt,
      sodium = cols(6).toInt,
      fiber = cols(7).toDouble,
      carbo = cols(8).toDouble,
      sugars = cols(9).toInt,
      potass = cols(10).toInt,
      vitamins = cols(11).toInt,
      shelf = cols(12).toInt,
      weight = cols(13).toDouble,
      cups = cols(14).toDouble,
      rating = cols(15).toDouble
    )
  }

  // http://localhost:8085/view/sodium
  val sodium = cereals.map(c => ujson.Obj("u" -> c.sodium)) 
  val fiber = cereals.map(c => ujson.Obj("u" -> c.fiber)) 
  val fiberSignals = ujson.read(os.read(os.pwd / "histogram.signals.json"))

  FromFilePlot(
    os.pwd / "histogram.vg.json",    
    List(
      viz.Utils.fillDiv,
      spec => spec("description") = "sodium",
      spec => spec("title") = "sodium",
      (spec: ujson.Value) => spec("data")(0) = ujson.Obj("name" -> "points", "values" -> sodium)
    )
  )
  

  FromFilePlot(
    os.pwd / "histogram.vg.json",    
    List(      
      spec => spec("description") = "fiber",
      spec => spec("title") = "fiber",
      spec => spec("signals") = fiberSignals,
      (spec: ujson.Value) => spec("data")(0) = ujson.Obj("name" -> "points", "values" -> fiber),
      viz.Utils.fillDiv
    )
  )

end run
