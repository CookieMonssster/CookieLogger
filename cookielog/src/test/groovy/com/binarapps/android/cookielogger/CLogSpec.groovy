package com.binarapps.android.cookielogger

import com.binarapps.android.cookielogger.interfaces.CLogInterface
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import pl.polidea.robospock.RoboSpecification

@Config(manifest = Config.NONE, constants = BuildConfig, sdk = 19)
public class CLogSpec extends RoboSpecification {

    def send;

    def setup() {
        send = Mock(CLogInterface) {

        }
    }

    def "Check that initialization is made correctly #1"() {
        when:
            AppContext.getInstance();
        then:
            thrown NullPointerException
    }

    def "Check that initialization is made correctly #2"() {
        given:
            CLog.initialize(RuntimeEnvironment.application, send)
        when:
            def appContext = AppContext.getInstance()
        then:
            appContext != null
    }

    def "Check that initialization is made correctly #3"() {
        given:
            CLog.initialize(RuntimeEnvironment.application, send, "klop")
        when:
            def appContext = AppContext.getInstance()
        then:
            appContext != null
    }

    def "Check that initialization is made correctly #4"() {
        given:
            CLog.initialize(RuntimeEnvironment.application, send, true)
        when:
            def appContext = AppContext.getInstance()
        then:
            appContext != null
    }

}