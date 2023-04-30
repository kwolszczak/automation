package com.kwolszczak;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class BaseTestPW {
    protected final String seed = "73e29e99-2542-48a1-bffe-fa7f64470be1";
    protected Page page;
    private Playwright server;
    private BrowserContext context;

    @BeforeEach
    void setUp() {


         server = Playwright.create();
        Browser browser = server.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
         context = browser.newContext();
         page = context.newPage();
    }

    @AfterEach
    void tearDown() {
        context.close();
        server.close();
    }
}
