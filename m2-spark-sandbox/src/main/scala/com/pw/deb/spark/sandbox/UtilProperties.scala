package com.pw.deb.spark.sandbox

import java.util.Properties
import java.io.FileInputStream

class UtilProperties() {

  def getProperties(filePath:String ): Properties = {

    // Create a Properties object to store the key-value pairs
    val properties = new Properties()

    try {
      // Load the properties from the file
      val fileInput = new FileInputStream(filePath)
      properties.load(fileInput)
      fileInput.close()


      /* // Retrieve and print values by keys
     val dbUrl = properties.getProperty("source.dbUrl")
     val dbUsername = properties.getProperty("source.dbUser")
     val dbPassword = properties.getProperty("source.dbPassword")

     println(s"Database URL: $dbUrl")
     println(s"Database Username: $dbUsername")
     println(s"Database Password: $dbPassword")*/

    } catch {
      case e: Exception =>
        println(s"Error reading properties file: ${e.getMessage}")
    }

    properties
  }


}
