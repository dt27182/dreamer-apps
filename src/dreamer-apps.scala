package Dreamer_Apps

import Chisel._

object Dreamer_Apps {
	def main(args: Array[String]): Unit = {
		chiselMainTest(args, () => new MatVecMul(16)){
			c => new MatVecMulTests(c,32,16)
		}
	}
}
/*
object Dreamer_Apps {
	def main(args: Array[String]): Unit = {
		chiselMainTest(args, () => new Sort(32,32)){
			c => new SortTests(c,32,32)
		}
	}
}*/
