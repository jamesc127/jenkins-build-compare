#!/usr/bin/env groovy

import com.lesfurets.jenkins.unit.global.lib.Library

@Library('nextlayerci-example@master') _

import com.datastax.jenkins.DseBuildCompare

def execute() {
    node() {
        stage("First") {
            echo "Something"
            sayHello "Traveller"
        }
        stage("Middle") {
            DseBuildCompare util = new DseBuildCompare()
            echo util.doSomething()
        }
        stage("Last") {
            echo "We're done"
        }
    }
}

return this