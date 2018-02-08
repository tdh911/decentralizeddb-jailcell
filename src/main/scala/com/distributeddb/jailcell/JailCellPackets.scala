package com.distributeddb.jailcell

case class JailCellRequest(method: String, keys: List[String], blocks: List[String])

case class JailCellResponse(numOperations: Int, blocks: List[String])