import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.test.JerseyTest
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.support.GenericApplicationContext
import spock.lang.Specification


/**
 * Created by amitgupta1202 on 28/10/15.
 */
abstract class JerseySpec extends Specification {

    private ApplicationContext appCtx

    protected GroovyBeanDefinitionReader app

    @Delegate private JerseyTest jerseyTest
    @Delegate private ConfigurableListableBeanFactory factory

    def setup() {
        factory = new DefaultListableBeanFactory()
        appCtx = new GenericApplicationContext(factory)
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
