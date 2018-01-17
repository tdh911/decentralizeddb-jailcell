package com.decentralizeddatabase.jailcell.errors

abstract class JailCellError extends Throwable {
    def errorCode: Int
    def errorMessage: String
} 

case class BadRequest(errorMessage: String) extends JailCellError {
    override val errorCode: Int = 500
} 