package com.elena.trello.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import static com.elena.trello.tests.TestBase.app;


public class Listener implements ITestListener {


    Logger logger = LoggerFactory.getLogger(Listener.class);


    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getName() + "Passed Successful");

    }

    @Override
    public void onTestFailure( ITestResult result) {
        logger.error(result.getName() + "\n FAILED\n");
                logger.error(result.getName() + "\n !!! FAILED !!!\n"
                        + result.getThrowable().toString());
        app.takeScreenshot();

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        logger.error(result.getName() + "\nFAILED by Timeout");



    }


}
