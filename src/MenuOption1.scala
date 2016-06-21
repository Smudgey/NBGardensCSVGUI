import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 16/06/2016.
  */

object MenuOption1 {

  def printAllOrders(populatedArray: ArrayBuffer[Array[String]]): Unit = {

    var y = 0
    println("This is the list of current order forms available: ")
    //loop through csv lines and print each line in format
    for (line <- populatedArray) {

      print("Order Status:  ")
      println(populatedArray(y)(0))

      print("Order ID:  ")
      println(populatedArray(y)(1))

      println("Customer Name | Date | Address | Payment Info | Product Name: Quantity: Pourus")

      println(s"${populatedArray(y)(2)} | ${populatedArray(y)(3)} | ${populatedArray(y)(4)} | ${populatedArray(y)(5)} | ${populatedArray(y)(6)}")
      println("")
      y += 1
    }
  }
}