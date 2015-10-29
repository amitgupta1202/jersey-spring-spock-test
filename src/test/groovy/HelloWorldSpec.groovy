import org.glassfish.jersey.server.ResourceConfig

/**
 * Created by amitgupta1202 on 28/10/15.
 */
class HelloWorldSpec extends JerseySpec {

    private HelloService helloService = Mock()

    ResourceConfig config() {
        registerSingleton('helloWorld', new HelloWorld(helloService))
        new ResourceConfig(HelloWorld)
    }

    def 'test hello world'() {
        when:
        def response = target('helloWorld/sayHello').request().get(String)

        then:
        1 * helloService.sayHello() >> 'Hello World!'
        response == 'Hello World!'
    }
}
