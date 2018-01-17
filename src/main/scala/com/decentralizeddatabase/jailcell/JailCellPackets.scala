package com.decentralizeddatabase.jailcell

case class JailCellRequest(method: String, keys: List[String], blocks: List[String])

case class JailCellResponse(blocks: List[String])