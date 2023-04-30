package com.kwolszczak;

import org.junit.jupiter.api.*;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Paths;

public class BaseTestPW {
    protected final String seed = "73e29e99-2542-48a1-bffe-fa7f64470be1";
    protected Page page;
    private static Playwright server;
    private BrowserContext context;
    private static Browser browser;

    @BeforeAll
     static void init(){
        server = Playwright.create();
         browser = server.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setChannel("chrome"));

    }

    @BeforeEach
    void setUp() {
        context = browser.newContext();
         page = context.newPage();
    }

    @AfterEach
    void tearDown() {
        context.close();
        page.close();
    }

    @AfterAll
    static void initDown(){

        server.close();

    }
}
