package com.bdd.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE, features = { "src/test/resources/feature/Search.feature" }, glue = {
		"com.bdd.stepdefinition" }, tags = { "@smoke" })

public class Runner {

}
