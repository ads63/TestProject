package com.UI;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage {
    private SelenideElement resultStats = ($(By.id("resultStats")).exists() ? $(By.id("resultStats")) : null);

    public boolean checkResultsSizeAboveExpected(int expectedSize) {
        int actualSize;
        if (resultStats != null) {
            String stat = resultStats.text();
            stat = stat.replaceAll("\\(.*\\)", "").replaceAll("[^0-9]+", "");
            try {
                actualSize = new Integer(stat);
                return actualSize > expectedSize; // found,  numeric value
            } catch (NumberFormatException e) {
                return false; // found, isn't numeric value
            }
        }
        return 0 > expectedSize; // result statistic element not found
    }

}