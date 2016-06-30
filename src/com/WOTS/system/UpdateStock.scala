//package com.WOTS.system
//
///**
//  * Created by Administrator on 17/06/2016.
//  */
//
//import java.io.{File, PrintWriter}
//
//import scala.collection._
//import scala.collection.mutable.ArrayBuffer
//import scala.io.StdIn._
//
//object UpdateStock {
//  //specify which item and quantity of that item to decrement in stock
//  def removeItemFromStock(products: Array[Product]): Unit = {
//
//    val itemToRemove: ArrayBuffer[String] = new ArrayBuffer[String]
//    val itemQuantity: ArrayBuffer[Int] = new ArrayBuffer[Int]
//    var input = "Y"
//    var update: Boolean = false
//
//    while (input == "y" || input == "Y") {
//      println("What is the name of the item you would like to update?")
//      //ask user what item they would like to remove
//      itemToRemove += readLine()
//
//      println(s"How many items would you like to remove of item: $itemToRemove?")
//      //ask user how many items they would like to remove of the item given
//      itemQuantity += readInt()
//
//      //double check they want to remove these items
//      println(s"Are you sure you would like to remove $itemQuantity of $itemToRemove? (Y/N)")
//      input = Initialization.userInput()
//
//      if (input == "Y" || input == "y") {
//        //ask if they would like to update any other items
//        println("Would you like to update any other items in inventory? (Y/N)")
//        input = Initialization.userInput()
//        update = true
//      }
//      else {
//        println("No changes will be made. The program will now exit.")
//        update = false
//        sys.exit
//      }
//    }
//
//    if(update) {
//      //recursive function to find item and decrement its stock
//      updateStock(stockLevels, itemToRemove, itemQuantity)
//    }
//  }
//
//  //remove items given from stock
//  def updateStock(stockLevels: ArrayBuffer[Array[String]], itemToRemove: ArrayBuffer[String], itemQuantity: ArrayBuffer[Int]): Unit = {
//
//    val file = new PrintWriter(new File("src\\stock.csv"))
////    var productNames: ArrayBuffer[String] = new ArrayBuffer[String]
////    var productQuantity: ArrayBuffer[Int] = new ArrayBuffer[Int]
////    var temp: Array[String] = new Array[String](2)
//
//    def findItemAndRemove(products: Array[Product], itemToRemove: ArrayBuffer[String], itemQuantity: ArrayBuffer[Int]): Unit = {
//
//      //make sure the stock map is not empty
//      if (itemToRemove.nonEmpty) {
//
//        //look for the key the the user would like to update
//        if (stock.head(2).contains(itemToRemove.head)) {
//
//          //if the user wants to remove more than there is in stock, print a message
//          if (stock.head(3).toInt < itemQuantity.head) {
//            println(s"There is not enough of ${itemToRemove.head} in stock to decrement its value.")
//            findItemAndRemove(stock, itemToRemove.tail, itemQuantity.tail)
//          }
//
//          //otherwise decrement the stock
//          else {
//            //decrement that value by the amount that the customer would like to purchase
//            stock(itemToRemove.head) = stock(itemToRemove.head) - itemQuantity.head
//            findItemAndRemove(stock, itemToRemove.tail, itemQuantity.tail)
//          }
//        }
//
//        else {
//          findItemAndRemove(stock, itemToRemove.tail, itemQuantity.tail)
//        }
//      }
//
//      for ((element, quantity) <- stock) {
//        file.write(element + ": " + stock(element) + "\n")
//      }
//      file.close()
//
//    }
//    findItemAndRemove(stockLevels, itemToRemove, itemQuantity)
//  }
//
//  //decrements stock from customer order
//  def decrementStock(userFound: Array[String], stockLevels: ArrayBuffer[Array[String]]): Unit = {
//
//    //holds name of customer requested items
//    val itemName: ArrayBuffer[String] = new ArrayBuffer[String]
//    //holds amount of items of that name
//    val itemQuantity: ArrayBuffer[Int] = new ArrayBuffer[Int]
//    //holds information on whether that item requires porous
//    //val requirePorous: ArrayBuffer[String] = new ArrayBuffer[String]
//    //two temporary arrays for splitting
//    var temp: Array[String] = new Array[String](25)
//    var temp1: Array[String] = new Array[String](3)
//
//    //temp holds string that was split
//    //each position in temp holds com.WOTS.system.Product Name: com.WOTS.system.Product Quantity: Requires Porous
//    temp = userFound(6).split('|').map(_.trim)
//
//    for (element <- temp) {
//      temp1 = element.split(':').map(_.trim)
//      itemName.append(temp1(0))
//      itemQuantity.append(temp1(1).toInt)
//      //requirePorous.append(temp1(2))
//    }
//
//    updateStock(stockLevels, itemName, itemQuantity)
//  }
//
//  def stockPurchased(stockLevels: mutable.HashMap[String, Int]): Unit ={
//
//    println("What item in stock would you like to update?")
//    //PrintCSV.printStockLevels(stockLevels)
//
//  }
//}
//
//