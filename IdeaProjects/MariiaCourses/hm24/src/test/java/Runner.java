import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import pages.Download;
import pages.DynamicLoading;
import pages.Upload;

import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Runner {

    @Test
    public void uploadFile() {
        Selenide.open("https://the-internet.herokuapp.com/upload");

        Upload upload = new Upload();
        upload.fileUpload("MyTest.TXT");
        upload.clickSubmit();

        assertEquals(upload.getResultText(), "File Uploaded!\n" +
                "MyTest.TXT");
    }

    @Test
   public void downloadsFiles() {
        Selenide.open("https://the-internet.herokuapp.com/download");

        Download download = new Download();
        SelenideElement selenideElement = download.findElement("MyTest.TXT");
        File downloadedFile = download.download(selenideElement);

        System.out.println("getText "+selenideElement.getText());

        assertTrue(downloadedFile.getName().matches("MyTest.*\\.TXT"));

    }

    @Test
    public void dynamicallyLoadedFirst() {
        Selenide.open("https://the-internet.herokuapp.com/dynamic_loading");

        DynamicLoading dynamicLoading = new DynamicLoading();
        dynamicLoading.getFirstExample().click();
        dynamicLoading.getStart().click();
        String finishText = dynamicLoading.getFinish().getText();

        assertTrue(finishText.matches("Hello World!"));
    }


    @Test
    public void dynamicallyLoadSecond() {
        Selenide.open("https://the-internet.herokuapp.com/dynamic_loading");

        DynamicLoading dynamicLoading = new DynamicLoading();
        dynamicLoading.getSecondExample().click();
        dynamicLoading.getStart().click();
        String finishText = dynamicLoading.getFinish().getText();

        assertTrue(finishText.matches("Hello World!"));
    }
}
