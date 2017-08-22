package com.pbl.cucumber.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Steven Satelle on 09/08/2017.
 */
@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources")
@CucumberOptions(monochrome = true, features = "classpath:talend")
public class CucumberTest {
}

