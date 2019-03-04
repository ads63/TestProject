package com.UI;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertTrue;


@Test
public class Test_UI {

    @Test
    public void testGoogleSearch() {
        Configuration.browser = UITestData.browser;
        Configuration.startMaximized = true;
        open(EndPoints.url);
        new GooglePage().searchFor(UITestData.searchText);
        SearchResultsPage results = new SearchResultsPage();
        assertTrue("Invalid results size",results.checkResultsSizeAboveExpected(UITestData.atLeastResult));
    }

}
