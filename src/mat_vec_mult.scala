package Dreamer_Apps
import Chisel._
import Node._
import scala.collection.mutable.HashMap
import util.Random

class MatVecMul(n: Int) extends Component {
  val io = new Bundle {
    val vec_in  = Vec(n){ UFix(width = 32).asInput }
    val mat_in  = Vec(n){ Vec(n){ UFix(width = 32).asInput } }
    val vec_out = Vec(n){ UFix(width = 32).asOutput }
  }
  val vec_in_pass = Vec(n){ Vec(n){ UFix(width = 32) } }
  val sums        = Vec(n){ Vec(n){ UFix(width = 32) } }
  val mul_adds    = Array.fill(n,n)(new MulAdd())
  for (k <- 0 until n) {
    vec_in_pass(0)(k) := io.vec_in(k)
    sums(k)(0)        := UFix(0)
  }
  for (i <- 0 until n) {
    for (j <- 0 until n) {
      mul_adds(i)(j).io.mat     := io.mat_in(i)(j)
      mul_adds(i)(j).io.vec_in  := vec_in_pass(i)(j)
      mul_adds(i)(j).io.sums_in := sums(i)(j)
    }
  }
  for (i <- 1 until n)
    for (j <- 0 until n)
      vec_in_pass(i)(j) := mul_adds(i-1)(j).io.vec_in_pass
  for (i <- 0 until n)
    for (j <- 1 until n)
      sums(i)(j) := mul_adds(i)(j-1).io.sums_out
  for(k <- 0 until n)
    io.vec_out(k) := mul_adds(k)(n-1).io.sums_out
}

class MulAdd() extends Component {
  val io = new Bundle {
    val mat         = UFix(width = 32).asInput
    val vec_in      = UFix(width = 32).asInput
    val sums_in     = UFix(width = 32).asInput
    val vec_in_pass = UFix(width = 32).asOutput
    val sums_out    = UFix(width = 32).asOutput
  }
  // println("MAT " + io.mat + " VEC-IN " + io.vec_in + " & " + (UFix(width = 32) & UFix(width = 32)))
  io.sums_out    := io.vec_in * io.mat + io.sums_in
  io.vec_in_pass := io.vec_in
}

class MatVecMulTests(c: MatVecMul, w: Int, n: Int) extends Tester(c, Array(c.io)) {
	defTests{
		var success = true
		val vars = new HashMap[Node, Node] ()
		val randGenerator = new Random()
		for ( t <- 0 until 16){
			val d = Array.fill(n,n)(0)
			val a = Array.fill(n)(0)
			val b = Array.fill(n)(0)
			for (j <- 0 until n) {
				a(j) = randGenerator.nextInt(16)
				vars(c.io.vec_in(j)) = UFix(a(j))
				for (i <- 0 until n) {
					d(j)(i) = randGenerator.nextInt(16)
					vars(c.io.mat_in(j)(i)) = UFix(d(j)(i))
				}
			}
			for (j <- 0 until n) {
				for (i <- 0 until n) {
					b(j) = b(j) + d(j)(i)*a(i)
				}
				vars(c.io.vec_out(j)) = UFix(b(j))
			}
			val vec_in = Vec(n){UFix(width = w)}
			val mat_in = Vec(n){Vec(n){UFix(width = w)}}
			val vec_out = Vec(n){UFix(width = w)}
			for (j <- 0 until n) {
				vec_in(j) = UFix(a(j))
				vec_out(j) = UFix(b(j))
				for (i <- 0 until n) {
					mat_in(j)(i) = UFix(d(j)(i))
				}
			}
			success = step(vars) && success
		}
		success
	}
}
