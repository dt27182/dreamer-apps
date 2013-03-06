package Dreamer_Apps

import Chisel._

object Dreamer_Apps {
	def main(args: Array[String]): Unit = {
		chiselMain(args, () => new Mat_Vec_Multiplier(32))
	}
}
