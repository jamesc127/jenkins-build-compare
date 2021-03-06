#!/usr/bin/env groovy
package com.datastax.jenkins
import com.datastax.BuildCompare

class DseBuildCompare {
    def runStDevCheck(startTime,endTime,baseline,tolerance,dseHost,grafanaHost) {
        sh "(java -Dconfig.file=./BuildCheck.json -Djenkins.xmlfilepath=. -Dgrafana.start-time=${startTime} -Dgrafana.end-time=${endTime} -Djenkins.build=${BUILD_ID} -Djenkins.baseline=${baseline} -Djenkins.stdevtolerance=${tolerance} -Ddse.host=${dseHost} -Dgrafana.host=${grafanaHost} -jar ./stdevcheck) || true"
    }

    def collectJUnit(){
        junit './*.xml'
    }

    def runBuildCompare(){
        BuildCompare.main()
    }
}
