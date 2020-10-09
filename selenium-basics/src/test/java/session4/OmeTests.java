package session4;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses({ ParameterizedTests.class, AssertionExamples.class, SeleniumParameters.class })
public class OmeTests {

}
