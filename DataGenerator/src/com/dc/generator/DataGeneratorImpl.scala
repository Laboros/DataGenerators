package com.dc.generator

import scala.io.Source
import org.json.JSONArray
import org.json.JSONString
import org.codehaus.jackson.map.ObjectMapper
import com.sun.xml.internal.ws.developer.Serialization


class DataGeneratorImpl extends DataGenerator {
  def parseGenerator(fileLine : String) :  Map[String, Any]={
   // println("parse");
   var dataPairs= fileLine.split(",");
  // var stringValueList= List(0,dataPairs.size);
   var stringValueList= Nil;
 //  var floatValueList=List(0,dataPairs.size);
    var floatValueList=Nil;
 //  var dateValueList=List(0,dataPairs.size);
      var dateValueList=Nil;
  // var intValueList=List(0,dataPairs.size);
       var intValueList=Nil;
  // var doubleValueList=List(0,dataPairs.size);
        var doubleValueList=Nil;
   var studentData = Map[String, Any]();

   for(pair<-dataPairs){
    var key= pair.split("@").apply(1);
    println("key :"+key)
    
     if(key.equals("String")){
       pair.split("@").apply(2) :: stringValueList;
     }
     if(key.equals("float")){
       pair.split("@").apply(2) :: floatValueList;
     }
      if(key.equals("Date")){
       pair.split("@").apply(2) :: dateValueList;
     }
       if(key.equals("int")){
       pair.split("@").apply(2) :: intValueList;
     }
        if(key.equals("double")){
       pair.split("@").apply(2) :: doubleValueList;
     }
        
   }
   studentData +=("String" ->stringValueList); 
   studentData +=("float" ->floatValueList); 
   studentData +=("Date" ->dateValueList); 
   studentData +=("int" ->intValueList); 
   studentData +=("double" ->doubleValueList); 
   studentData;
    
  }
  def loadTemplate(fileName :String){
    var studentDataMap = Map[String, Any]();
    for(line<-Source.fromFile(fileName).getLines){
      
     var studentData= parseGenerator(line);
     studentDataMap += (studentData);
      println(line)
    }
    
  }
  
  /*def convertStringKeyListToStringDataList(keyList: List){
    ???
  }*/
  def generateData(templateName:String , formatName:String) : Any={
     for(line<-Source.fromFile(templateName).getLines){
     var kayMap : Map[String, Any] = parseGenerator(line);
     
     val studentDataMap= kayMap map(case (key,value));
     if(formatName.equals("json")){
     
   var stringList=  kayMap.get("String");
   var floatList=kayMap.get("float");
   var intList=kayMap.get("int");
   var doubleList=kayMap.get("double");
   var dateList=kayMap.get("Date");
   var i=0;
   var keyDataMap = Map[String, String]();
   
   val map =for( key <-stringList) {
     i=i+1;
     val k=key+"";
 keyDataMap+=(k -> "dummy");
     
   }
  // var mapper=new ObjectMapper();
   Serialization.format
   }
   
  // scala.util.parsing
    /* kayMap foreach { case(key ,value) =>
     
       if(key.equals("String"))
         
     
     }*/
     }
   // println("generated");
  }
  
}