package com.ctrip.di;

/**
 * Hello world!
 *
 */
object App {
  def main(args: Array[String]) {
    val a=58
    val b = sign(a)
    val c = sign(a+2)
    println(b.toString+"a"+c.toString);

  }

  def sign(m:Int)={
    m%3  match {
      case 0 => "wrong"
      case 1 => 'A'
      case 2 => '\123'
    }

  }
}
