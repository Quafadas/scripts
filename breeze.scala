import jdk.incubator.vector.DoubleVector;
import jdk.incubator.vector.VectorSpecies;


def vecMe(v1: Array[Double], v2: Array[Double]): Array[Double] =
  var i = 0
  var out = new Array[Double](v1.length)
  val SPECIES = DoubleVector.SPECIES_PREFERRED

  while (i < v1.length) {
    var m = SPECIES.indexInRange(i, v1.length);

    var va = DoubleVector.fromArray(SPECIES, v1, i, m);
    var vb = DoubleVector.fromArray(SPECIES, v2, i, m);
    var vc = va.mul(va).
            add(vb.mul(vb)).
            neg();
    vc.intoArray(out, i, m);
    i += SPECIES.length()
  }

  out

@main def run =
  println(vecMe(Array(1.0, 2.0, 3.0), Array(4.0, 5.0, 6.0)).mkString(","))