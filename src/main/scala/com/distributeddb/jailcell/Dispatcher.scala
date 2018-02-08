package com.distributeddb.jailcell

import com.distributeddb.jailcell.errors._
import com.distributeddb.jailcell.utils.FileUtility

object Dispatcher {
    def dispatch(request: JailCellRequest) : JailCellResponse = {
        val response: JailCellResponse = request.method match {
            case "read" => Processor.read(request)
            case "write" => Processor.write(request)
            case "delete" => Processor.delete(request)
            case _ => throw new BadRequest("Invalid method requested")
        }

        return response 
    } 
}

object Processor {
    def read(request: JailCellRequest) : JailCellResponse = {
        return new JailCellResponse(0, null)
    }

    def write(request: JailCellRequest) : JailCellResponse = {
        var operations: Int = 0
        for ((key: String, block: String) <- (request.keys zip request.blocks)) {
            if (FileUtility.write(key, block.getBytes())) {
                operations += 1
            }
        }
        return new JailCellResponse(operations, null)
    }

    def delete(request: JailCellRequest) : JailCellResponse = {
        var operations: Int = 0
        request.keys.foreach { key =>
            if (FileUtility.delete(key)) {
                operations += 1
            }
        }

        return new JailCellResponse(operations, null)
    }
}
