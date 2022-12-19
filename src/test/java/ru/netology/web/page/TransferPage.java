package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement transferHead = $("[data-test-id='action-transfer']");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");
    public static SelenideElement refreshButton = $("[data-test-id='action-reload']");
    private SelenideElement canselButton = $("[data-test-id='action-cancel']");
    private SelenideElement amountInput = $("[data-test-id='amount'] input");
    private SelenideElement fromInput = $("[data-test-id='from'] input");
    private SelenideElement errorMessage = $("[data-test-id='error-message']");

    public TransferPage() {
        transferHead.shouldBe(visible);
    }

    public DashboardPage makeValidTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        makeTransfer(amountToTransfer, cardInfo);
        return new DashboardPage();
    }

    public void makeTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(amountToTransfer);
        fromInput.setValue(cardInfo.getCardNumber());
        transferButton.click();
    }

    public void findErrorMessage(String expectedText) {
        errorMessage.shouldHave(ownText(expectedText), Duration.ofSeconds(15)).shouldBe(visible);
    }
}