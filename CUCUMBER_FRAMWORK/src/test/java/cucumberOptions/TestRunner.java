package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)                
@CucumberOptions(features="src/test/java/features/PlaceTestcase.feature"
,
glue={"stepDenifitions"})                        
public class TestRunner                
{       

}
