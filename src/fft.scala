package Dreamer_Apps
import Chisel._
import Node._
import scala.collection.mutable.HashMap
import util.Random

class ComplexNumber() extends Bundle {
  val real = Flo()
  val imag = Flo()
}

object ComplexAdd{
  def apply(a: ComplexNumber, b: ComplexNumber, c: ComplexNumber) = {
    c.real := a.real + b.real
    c.imag := a.imag + b.imag
    c
  }
}

object ComplexMult{
  def apply(a: ComplexNumber, b: ComplexNumber, c: ComplexNumber) = {
    c.real := (a.real * b.real) - (a.imag * b.imag)
    c.imag := (a.real * b.imag) + (a.imag * b.real)
    c
  }
}

object ComplexMinus{
  def apply(a: ComplexNumber, b: ComplexNumber, c: ComplexNumber) = {
    c.real := a.real - b.real
    c.imag := a.imag - b.imag
    c
  }
}

object TwiddleFactor{
  def apply(kn: Int, N: Int) = {
    val angle = -2*scala.math.Pi*kn/N
    var c = new ComplexNumber()
    c.real := Flo(scala.math.cos(angle))
    c.imag := Flo(scala.math.sin(angle))
    c
  }
}

class ButterflyNode() extends Bundle {
  val io = new Bundle {
    val in0 = new ComplexNumber().asInput
    val in1 = new ComplexNumber().asInput
    val twiddle = new ComplexNumber().asInput
    val out0 = new ComplexNumber().asOutput
    val out1 = new ComplexNumber().asOutput
  }
  val multOut = new ComplexNumber()
  ComplexAdd(io.in0, multOut, io.out0)
  ComplexMinus(io.in0, multOut, io.out1)
  ComplexMult(io.in1, io.twiddle, multOut)
}

object genFFT{
  def apply(n: Int): (Vec[ComplexNumber], Vec[ComplexNumber]) = {
    val inputs = Vec(n){new ComplexNumber()}
    val outputs = Vec(n){new ComplexNumber()}
    if(n == 2){
      val butterfly = new ButterflyNode()      
      butterfly.io.in0 := inputs(0)
      butterfly.io.in1 := inputs(1)
      outputs(0) := butterfly.io.out0
      outputs(1) := butterfly.io.out1
    } else {
      val subFFT0 = genFFT(n/2)
      val subFFT1 = genFFT(n/2)
      val butterflies = Vec(n/2){new ButterflyNode()}
      for(i <- 0 until n){
        if(i%2 ==0){
          subFFT0._1(i/2) := inputs(i)
        } else {
          subFFT1._1(i/2) := inputs(i)
        }
      }
      for(i <- 0 until n/2){
        butterflies(i).io.in0 := subFFT0._2(i)
        butterflies(i).io.in1 := subFFT1._2(i)
        butterflies(i).io.twiddle := TwiddleFactor(i,n)
      }
      for(i <- 0 until n/2){
        outputs(i) := butterflies(i).io.out0
        outputs(i + n/2) := butterflies(i).io.out1
      }
    }
    (inputs, outputs)
  }
}

class FFT(n:Int) extends Component {
  val io = new Bundle {
    val vecIn = Vec(n){new ComplexNumber()}
    val vecOut = Vec(n){new ComplexNumber()}
  }
  val fft = genFFT(n)
  for(i <- 0 until n){
    fft._1(i) := io.vecIn(i)
    io.vecOut(i) := fft._2(i)
  }
}

class FFTTests(c: FFT, n: Int) extends Tester(c, Array(c.io)) {
	defTests{
		var success = true
		val vars = new HashMap[Node, Node] ()
		val randGenerator = new Random()
		for ( t <- 0 until 16){
			val testVector = new Array[ComplexTest](n)
			val vec_in = Vec(n){new ComplexNumber()}
			val vec_out = Vec(n){new ComplexNumber()}
			for (i <- 0 until n){
				testVector(i) = new ComplexTest(randGenerator.nextInt(16), randGenerator.nextInt(16))
				var input = new ComplexNumber()
				input.real := Flo(testVector(i).real)
				input.imag := Flo(testVector(i).imag)
				vars(c.io.vecIn(i)) = input
			}
			val twiddleFactors = new Array[Array[ComplexTest]](n)
			val expectedOutput = new Array[ComplexTest](n)
			for(i <- 0 until n){
			  twiddleFactors(i) = new Array[ComplexTest](n)
			  for(j <- 0 until n){
			    twiddleFactors(i)(j) = TwiddleFactorTest(i*j,n)
			  }
			}
			for(i <- 0 until n){
			  expectedOutput(i) = new ComplexTest(0,0)
			  for(j <- 0 until n){
			    expectedOutput(i) = ComplexTestAdd(expectedOutput(i), ComplexTestMult(twiddleFactors(i)(j), testVector(i)))
			  }
			}
			for (i <- 0 until n){
				var output = new ComplexNumber()
				output.real := Flo(expectedOutput(i).real)
				output.imag := Flo(expectedOutput(i).imag)
				vars(c.io.vecOut(i)) = output
			}
			success = step(vars) && success
		}
		success
	}
}

class ComplexTest(r: Float, i: Float) {
  var real = r
  var imag = i
}

object ComplexTestAdd{
  def apply(a: ComplexTest, b: ComplexTest) = {
    new ComplexTest(a.real + b.real, a.imag + b.imag)
  }
}

object ComplexTestMult{
  def apply(a: ComplexTest, b: ComplexTest) = {
    new ComplexTest((a.real * b.real) - (a.imag * b.imag), (a.real * b.imag) + (a.imag * b.real))
  }
}

object ComplexTestMinus{
  def apply(a: ComplexTest, b: ComplexTest) = {
    new ComplexTest(a.real - b.real, a.imag - b.imag)
  }
}

object TwiddleFactorTest{
  def apply(kn: Int, N: Int) = {
    val angle = -2*scala.math.Pi*kn/N
    new ComplexTest(scala.math.cos(angle).asInstanceOf[Float], scala.math.sin(angle).asInstanceOf[Float])
  }
}
