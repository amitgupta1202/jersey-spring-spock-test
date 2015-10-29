import org.glassfish.jersey.server.ResourceConfig

/**
 * Created by amitgupta1202 on 28/10/15.
 */

class HelloWorldSpec extends JerseySpec {

    ResourceConfig config() {
        app.beans {
            helloService(HelloService)
            helloWorld(HelloWorld, helloService)
        }
        new ResourceConfig(HelloWorld)
    }

    def 'test'() {
        expect:
        target("helloWorld/sayHello").request().get(String) == "Hello World!"
    }
}
