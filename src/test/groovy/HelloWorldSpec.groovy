import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.ApplicationContext
import org.springframework.context.support.GenericGroovyApplicationContext

import javax.ws.rs.core.Application

/**
 * Created by amitgupta1202 on 28/10/15.
 */

class HelloWorldSpec extends JerseySpec {

    ApplicationContext appCtx

    Application application() {
        appCtx = new GenericGroovyApplicationContext()
        appCtx.reader.beans {
            helloService(HelloService)
            helloWorld(HelloWorld, helloService)
        }
        appCtx.refresh()

        new ResourceConfig(HelloWorld)
            .property("contextConfig", appCtx)
    }

    def 'test'() {
        expect:
        target("helloWorld/sayHello").request().get(String) == "Hello World!"
    }
}
