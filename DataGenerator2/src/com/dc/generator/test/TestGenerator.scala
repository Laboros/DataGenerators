package com.dc.generator.test

import com.dc.generator.DataGenerator
import com.dc.generator.DataGeneratorImpl

object TestGenerator {
  def main(args:Array[String]){
    
    new DataGeneratorImpl().loadTemplate("resources/student.meta")
  }
}