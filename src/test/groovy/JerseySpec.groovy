import org.glassfish.jersey.test.JerseyTest
import spock.lang.Specification

import javax.ws.rs.core.Application

/**
 * Created by amitgupta1202 on 28/10/15.
 */
abstract class JerseySpec extends Specification {

    @Delegate JerseyTest jerseyTest

    def setup() {
        jerseyTest = new JerseyTest(application()) {}
        jerseyTest.setUp()
    }

    def cleanup() {
        jerseyTest.tearDown()
    }

    abstract Application application()
}
