package com.distributeddb.jailcell.utils

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, Paths}

object FileUtility {
    //TODO: Is this threadsafe?
    def write(fileName: String, file: Array[Byte]) : Boolean = {
        val filePath: String = buildFilePath(fileName)
        val path: Path = Paths.get(filePath)
        Files.write(path, file)

        return true
    }

    def read(fileName: String) : String = {
        val filePath: String = buildFilePath(fileName)
        val path: Path = Paths.get(filePath)
        val bytes = Files.readAllBytes(path)
        val file = new String(bytes, StandardCharsets.UTF_8)

        return file
    }

    def delete(fileName: String) : Boolean = {
        val filePath: String = buildFilePath(fileName)
        val file: File = new File(filePath)
        return file.delete()
    }

    //TODO: Build a better file system for blocks?
    private def buildFilePath(simpleFileName : String) : String = {
        return "blocks/" + simpleFileName
    }
}