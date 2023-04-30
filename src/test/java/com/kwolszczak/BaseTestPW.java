package com.kwolszczak;

import com.microsoft.playwright.*;
import org.testng.annotations.*;


public class BaseTestPW {
    protected final String seed = "73e29e99-2542-48a1-bffe-fa7f64470be1";
    protected Page page;
    private static Playwright server;
    private BrowserContext context;
    private static Browser browser;

    @BeforeTest
      public void init(){
        server = Playwright.create();
         browser = server.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setChannel("chrome"));
    }

    @BeforeMethod
    public void setUp() {
        context = browser.newContext();
         page = context.newPage();
    }

    @AfterMethod
    public void tearDown() {
        context.close();
        page.close();
    }

    @AfterTest
     public void initDown(){

        server.close();

    }
}
