package dev.lubomir.tests;

import dev.lubomir.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

  protected final ApplicationManager applicationManager = new ApplicationManager();

  @BeforeMethod
    public void setup() {
    applicationManager.init();
  }

  @AfterMethod
    public void teardown() {
    applicationManager.stop();
  }
}
