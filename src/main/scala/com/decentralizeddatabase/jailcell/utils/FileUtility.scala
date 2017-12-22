package com.decentralizeddatabase.jailcell.utils

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, Paths}

object FileUtility {
    //TODO: Is this threadsafe?
    def write(fileName : String, file : Array[Byte]) : Boolean = {
        val path = Paths.get(fileName)
        Files.write(path, file)

        return true
    }

    def read(fileName : String) : String = {
        val path = Paths.get(fileName)
        val bytes = Files.readAllBytes(path)
        val file = new String(bytes, StandardCharsets.UTF_8)

        return file
    }

    //TODO: Figure out file structure for our files
    def buildFilePath(simpleFileName : String) : String = {
        return null
    }
}