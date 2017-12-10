package com.decentralizeddatabase.jailcell

import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.{Server, Request}

import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import javax.servlet.ServletException

/**
 * @author Tim Hostetler
 */
object JailCell {
    val PORT = 8090
  
    def main(args : Array[String]) {
        val server = new Server(PORT)
        server.setHandler(new JailCellHandler())

        server.start()
        server.join()
    }
}

class JailCellHandler extends AbstractHandler {
    def handle(target : String, baseRequest : Request, request : HttpServletRequest, response : HttpServletResponse) {
        println("Received")
        baseRequest.setHandled(true)
    }
}
