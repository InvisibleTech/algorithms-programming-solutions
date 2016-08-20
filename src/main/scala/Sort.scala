package org.invisibletech.grokking 

import scala.math.Numeric._

import scala.collection.mutable.Buffer
import scala.reflect.ClassTag

object Sort {
    def selectionSort[T](array: Array[T])(implicit n: Ordering[T], c: ClassTag[T]): Array[T] = {
        def findIndexOfSmallest[T](start: Int, buffer: Buffer[T])(implicit cmp: Ordering[T]) = {
            buffer.zipWithIndex.slice(start, buffer.length).min._2
        }

        val buffer = array.toBuffer
        println(buffer)


        var i:Int = 0
        while (i < buffer.length) {
            val from = findIndexOfSmallest(i, buffer)
            val was = buffer(i)
            val is = buffer(from)

            buffer(i) = is
            buffer(from) = was
            println(buffer)

            i += 1
        }

        buffer.toArray
    }
}