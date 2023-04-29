package com.qe.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LoggingTestNGListener implements ITestListener {
    private static final Logger log = LoggerFactory.getLogger(LoggingTestNGListener.class);
    private static final String TEST_BOUND = "===================================================================================";
    private static final double TEST_MILES = 1000.0;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String testClass = iTestResult.getTestClass().getRealClass().getSimpleName();
        log.info("START Class {} : test {}", testClass, iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("{} COMPLETED SUCCESSFULLY", iTestResult.getName());
        this.testEnd(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("{} FAILURE", iTestResult.getName());
        this.testEnd(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("{} SKIPPED", iTestResult.getName());
        this.testEnd(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }


    public void testEnd(ITestResult iTestResult) {
        log.info("Took {} sec", (iTestResult.getEndMillis() - iTestResult.getStartMillis()) / TEST_MILES);
    }
}
