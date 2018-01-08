package com.decentralizeddatabase.jailcell.utils

import org.scalatest._

class FileUtilityTest extends FlatSpec with Matchers {
    val FILENAME: String = "TEST_FILE"
    val FILE: String = "THIS IS A TEST"

    "write" should "write the file and return true" in {
        val fileBytes: Array[Byte] = FILE.getBytes()

        assert(FileUtility.write(FILENAME, fileBytes) == true)
    }

    "read" should "read the file and return the string" in {
        assert(FileUtility.read(FILENAME) == FILE)
    }
}