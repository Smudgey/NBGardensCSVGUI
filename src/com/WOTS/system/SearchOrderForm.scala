package com.WOTS.system

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn._

object SearchOrderForm {

  def searchOrder(populatedArray: ArrayBuffer[Array[String]]): Array[String] = {

    println("Which order would you like to search for? (Name(N)/ID)")
    //store information for the user they were searching for
    var userFound: Array[String] = new Array[String](8)

    Menu.userInput().toLowerCase() match {
      case "name" | "n" => //search by customer name

        println("Please enter the name you would like to search for: ")
        //holds name of customer to search for
        val inputName = readLine()

        println("Here is the order form for: " + inputName.toLowerCase().split(' ').map(_.trim).map(_.capitalize).mkString(" "))

        //find the order by the customers name
        def findOrderByName(populatedArray: ArrayBuffer[Array[String]]) {
          //while the CSV is not empty
          if (populatedArray.nonEmpty) {
            //if the name of the csv matches the user inputted name, print out the order information formatted
            if (populatedArray.head(2) == inputName.toLowerCase().split(' ').map(_.trim).map(_.capitalize).mkString(" ")) {
              print("com.WOTS.system.Order Status:  ")
              println(populatedArray.head(0))

              print("com.WOTS.system.Order ID:  ")
              println(populatedArray.head(1))

              println("Customer Name | Date | Address | Payment Info | com.WOTS.system.Product Name: Quantity")

              println(s"${populatedArray.head(2)} | ${populatedArray.head(3)} | ${populatedArray.head(4)} | ${populatedArray.head(5)} | ${populatedArray.head(6)}")
              println("")

              //hold information on the user they were searching for
              userFound = populatedArray.head
              //recursively call the function again to keep searching
              findOrderByName(populatedArray.tail)
            }
            else
              findOrderByName(populatedArray.tail)
          }
        }

        findOrderByName(populatedArray)

      case "id" => //search by customer form id

        println("Please enter the customer form ID you would like to search for: ")
        //users inputted customer ID to search for
        val inputID = readLine()

        println("Here is the order form for order of ID: " + inputID.toUpperCase())

        //find the order by the customers ID
        def findOrderByID(populatedArray: ArrayBuffer[Array[String]]) {
          //while the CSV is not empty
          if (populatedArray.nonEmpty) {
            //if the ID from the CSV matches the user inputted ID, print out the customers order information formatted
            if (populatedArray.head(1) == inputID.toUpperCase()) {
              print("com.WOTS.system.Order Status:  ")
              println(populatedArray.head(0))

              print("com.WOTS.system.Order ID:  ")
              println(populatedArray.head(1))

              println("Customer Name | Date | Address | Payment Info | com.WOTS.system.Product Name: Quantity")

              println(s"${populatedArray.head(2)} | ${populatedArray.head(3)} | ${populatedArray.head(4)} | ${populatedArray.head(5)} | ${populatedArray.head(6)}")
              println("")

              //store user order information
              userFound = populatedArray.head
              //recursively call function with remaining CSV lines
              findOrderByID(populatedArray.tail)
            }
            else
              findOrderByID(populatedArray.tail)
          }
        }

        findOrderByID(populatedArray)
    }
    //return customer order information
    userFound
  }
}