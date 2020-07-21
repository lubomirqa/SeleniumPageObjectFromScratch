package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

  int count = 0;
  int limit = 2;

  @Override
  public boolean retry(ITestResult result) {
    if (count < limit) {
      count++;
      System.out.println("Test " + result.getMethod().getMethodName() + " failed! \n This is retry # " + count);
      return true;
    }
    return false;
  }
}
