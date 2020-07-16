package dev.lubomir.tests;

import dev.lubomir.appmanager.ApplicationManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

  protected final ApplicationManager applicationManager = new ApplicationManager();
  protected Logger log;

  @BeforeMethod
  public void setup(ITestContext ctx) { applicationManager.init(ctx);
  }

  @AfterMethod
  public void teardown() {
    applicationManager.stop();
  }
}
