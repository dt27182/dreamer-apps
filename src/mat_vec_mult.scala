package Dreamer_Apps
import Chisel._
import Node._
import scala.collection.mutable.HashMap
import util.Random

class Mat_Vec_Multiplier(w: Int) extends Component {
	val io = new Bundle {
		val vec_in = Vec(4){UFix(width = w, dir = INPUT)}
		val mat_in = Vec(4){Vec(4){UFix(width = w, dir = INPUT)}}
		val vec_out = Vec(4){UFix(width = w, dir = OUTPUT)}
	}
	val vec_in_pass_through = Vec(4){Vec(4){UFix(width = w)}}
	val vec_out_immed = Vec(4){Vec(4){UFix(width = w)}}
	val add_nodes = Array.fill(4,4)(new Add_Node(w))
	for (k <- 0 until 4) {
		vec_in_pass_through(0)(k) := io.vec_in(k)
		vec_out_immed(0)(k) := UFix(0)
	}
	for (j <- 0 until 4) {
		for (i <- 0 until 4) {
			add_nodes(j)(i).io.mat_comp := io.mat_in(j)(i)
			add_nodes(j)(i).io.vec_in_comp := vec_in_pass_through(i)(j)
			add_nodes(j)(i).io.vec_out_immed_in := vec_out_immed(j)(i)
		}
	}
	for (j <- 0 until 2) {
		for (i <- 0 until 2) {
			vec_in_pass_through(i+1)(j) := add_nodes(j)(i).io.vec_in_pass_through
			vec_out_immed(j+1)(i) := add_nodes(j)(i).io.vec_out_immed_out
		}
	}
	for(k <- 0 until 4) {
		io.vec_out(k) := add_nodes(3)(k).io.vec_out_immed_out
	}
}

class Add_Node(w: Int) extends Component {
	val io = new Bundle {
		val mat_comp = UFix(width = w, dir = INPUT)
		val vec_in_comp = UFix(width = w, dir = INPUT)
		val vec_out_immed_in = UFix(width = w, dir = INPUT)
		val vec_in_pass_through = UFix(width = w, dir = OUTPUT)
		val vec_out_immed_out = UFix(width = w, dir = OUTPUT)
	}
	io.vec_out_immed_out := io.vec_in_comp*io.mat_comp + io.vec_out_immed_in
	io.vec_in_pass_through := io.vec_in_comp
}

/*class Mat_Vec_Multiplier_Tests(c: Mat_Vec_Multiplier, w: Int) extends Tester(c, Array(c.io)) {
	defTests{
		var success = true
		val vars = new HashMap[Node, Node] ()
		val randGenerator = new Random()
		for ( t <- 0 until 16){
			val c = Array.fill(4,4)(randGenerator.nextInt(16))
			val a = Array.fill(4)(randGenerator.nextInt(16))
			val b = Array.fill(4)(0)
			for (j <- 0 until 4) {
				for (i <- 0 until 4) {
					b(j) = b(j) + c(j)(i)*a(i)
				}
			}
			val vec_in = Vec(4){UFix(width = w)}
			val mat_in = Vec(4){Vec(4){UFix(width = w)}}
			val vec_out = Vec(4){UFix(width = w)}
			for (j <- 0 until 4) {
				vec_in(j) = UFix(a(j))
				vec_out(j) = UFix(b(j))
				for (i <- 0 until 4) {
					mat_in(j)(i) = UFix(c(j)(i))
				}
			}
			//vars(c.io.mat_in) = mat_in
			vars(c.io.vec_in) = vec_in
			vars(c.io.vec_out) = vec_out
			success = step(vars) && success
		}
		success
	}
}*/
