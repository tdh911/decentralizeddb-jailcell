package com.decentralizeddatabase.jailcell

import javax.servlet.http.HttpServletRequest

case class JailCellRequest(method: String, keys: List[String], blocks: List[String])

class JailCellResponse {
//TODO
}