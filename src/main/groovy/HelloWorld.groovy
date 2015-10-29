import org.springframework.stereotype.Service

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * Created by amitgupta1202 on 28/10/15.
 */

@Service
@Path('helloWorld')
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class HelloWorld {

    private HelloService helloService

    HelloWorld(HelloService helloService) {
        this.helloService = helloService
    }

    @GET
    @Path('sayHello')
    def hello() {
        helloService.sayHello()
    }
}
