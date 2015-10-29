import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.test.JerseyTest
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.context.ApplicationContext
import org.springframework.context.support.GenericGroovyApplicationContext
import spock.lang.Specification


/**
 * Created by amitgupta1202 on 28/10/15.
 */
abstract class JerseySpec extends Specification {

    private ApplicationContext appCtx

    protected GroovyBeanDefinitionReader app

    @Delegate private JerseyTest jerseyTest

    def setup() {
        appCtx = new GenericGroovyApplicationContext()
        app = appCtx.reader

        def application = config()

        appCtx.refresh()
        jerseyTest = new JerseyTest(application.property("contextConfig", appCtx)) {}
        jerseyTest.setUp()
    }

    def cleanup() {
        jerseyTest.tearDown()
    }

    abstract ResourceConfig config()
}
