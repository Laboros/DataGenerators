package com.dc.generator

import scala.reflect.io.File


trait DataGenerator {
  def parseGenerator(file : String) :Map[String, Any];
  def loadTemplate(fileName :String);
  def generateData(templateName:String,formatName:String) : Any;
  
  //
}