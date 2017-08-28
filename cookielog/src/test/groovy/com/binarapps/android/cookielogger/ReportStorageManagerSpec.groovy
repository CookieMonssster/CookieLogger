package com.binarapps.android.cookielogger

import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import pl.polidea.robospock.RoboSpecification

@Config(manifest = Config.NONE, constants = BuildConfig, sdk = 19)
public class ReportStorageManagerSpec extends RoboSpecification {

    def context

    def setup() {
        context = RuntimeEnvironment.application
        ReportStorageManager.clearSingleReport(context)
        ReportStorageManager.clearGlobalReport(context)
    }


    def "Check Single and Global Report"() {
        given:
            ReportStorageManager.updateReport(context, "report part 1")
            ReportStorageManager.updateReport(context, "report part 2")
            ReportStorageManager.updateReport(context, "report part 3")
        when:
            def single_report = ReportStorageManager.getSingleReport(context)
            def global_report = ReportStorageManager.getGlobalReport(context)
        then:
            single_report == "\nreport part 1\nreport part 2\nreport part 3"
            global_report == "\nreport part 1\nreport part 2\nreport part 3"
    }

    def "Check clearing Single Report"() {
        given:
            ReportStorageManager.updateReport(context, "report part 1")
            ReportStorageManager.updateReport(context, "report part 2")
            ReportStorageManager.clearSingleReport(context)
            ReportStorageManager.updateReport(context, "report part 3")
        when:
            def single_report = ReportStorageManager.getSingleReport(context)
            def global_report = ReportStorageManager.getGlobalReport(context)
        then:
            single_report == "\nreport part 3"
            global_report == "\nreport part 1\nreport part 2\nreport part 3"
    }

    def "Check clearing Global Report" () {
        given:
            ReportStorageManager.updateReport(context, "report part 1")
            ReportStorageManager.clearGlobalReport(context)
            ReportStorageManager.updateReport(context, "report part 2")
            ReportStorageManager.clearSingleReport(context)
            ReportStorageManager.updateReport(context, "report part 3")
        when:
            def single_report = ReportStorageManager.getSingleReport(context)
            def global_report = ReportStorageManager.getGlobalReport(context)
        then:
            single_report == "\nreport part 3"
            global_report == "\nreport part 2\nreport part 3"
    }
}