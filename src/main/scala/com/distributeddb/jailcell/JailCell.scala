package com.distributeddb.jailcell

import com.distributeddb.jailcell.errors._

import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.{Server, Request}

import java.io.InputStream
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import javax.servlet.ServletException

import net.liftweb.json._

import scala.io.Source

/**
 * @author Tim Hostetler
 */
object JailCell {
    val PORT = 8090
  
    def main(args: Array[String]) {
        val server = new Server(PORT)
        server.setHandler(new JailCellHandler())

        server.start()
        server.join()
    }
}

class JailCellHandler extends AbstractHandler {
    def handle(target: String, baseRequest: Request, request: HttpServletRequest, response: HttpServletResponse) {
        val jailCellRequest = extractRequest(request)
        var jailCellResponse: JailCellResponse = null

        try {
            jailCellResponse = Dispatcher.dispatch(jailCellRequest)
        } catch {
            case e: JailCellError => response.sendError(e.errorCode, e.errorMessage)
            case _: Throwable => response.sendError(500)
        }

        response.setStatus(HttpServletResponse.SC_OK)
        baseRequest.setHandled(true)
    }

    def extractRequest(request: HttpServletRequest) : JailCellRequest = {
        implicit val formats = DefaultFormats
        val stream: InputStream = request.getInputStream()
        val jsonString: String = Source.fromInputStream(stream).mkString
        val json = parse(jsonString)
        val jailCellRequest = json.extract[JailCellRequest]

        return jailCellRequest
    }
}
