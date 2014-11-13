package de.codecentric.rfselenium.advanced;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragDropTest {

	private static final String ACTIVE_TAB_HEADER_SELECTOR = ".navigation .rf-tab-hdr-act";
	private static final String DRAG_AND_DROP_MENU_ITEM_ID = "j_idt83";
	private WebDriver driver;
	private static final String BASE_URL = "http://localhost:8080/showcase";
	@ Before
	public void initDriver(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(BASE_URL);
	}
	
	@Test
	public void dragFromSourceAndDropToPHPFrameworks(){
		openDragAndDropSection();
		dragAndDropFirstElementToPHPFrameworks();
		Assert.assertThat(phpFrameworkList().size(), is(1));
	}

	private List<WebElement> phpFrameworkList() {
		return phpFrameworksArea().findElements(By.tagName("tr"));
	}

	private void dragAndDropFirstElementToPHPFrameworks() {
		WebElement firstFramework = getFrameworkList().get(0);
		WebElement phpFrameworksArea = phpFrameworksArea();
		
		dragAndDrop(firstFramework, phpFrameworksArea);
		
	}

	private WebElement phpFrameworksArea() {
		WebElement phpFrameworksArea = driver.findElement(By.id("form:phptable"));
		return phpFrameworksArea;
	}

	private void dragAndDrop(WebElement draggableElement, WebElement target) {
		Actions actionBuilder = new Actions(driver);
		Action dragAndDrop = actionBuilder.clickAndHold(draggableElement).moveToElement(target).
		release(target).build();
		dragAndDrop.perform();
	}

	private List<WebElement> getFrameworkList() {
		List<WebElement> frameworks = driver.findElements(By.className("ui-draggable"));
		Assert.assertThat(frameworks.size(), greaterThanOrEqualTo(1));
		return frameworks;
		
	}

	private void openDragAndDropSection() {
		openDragAndDropMenuItem().click();
		String activeTagHeaderText = driver.findElement(By.cssSelector(ACTIVE_TAB_HEADER_SELECTOR)).getText();
		Assert.assertThat(activeTagHeaderText, equalTo("Drag and Drop usage example"));
	}

	private WebElement openDragAndDropMenuItem() {
		clickOnDragAndDropMainMenuItem();
		WebElement dragAndDropMenuItem = driver.findElement(By.id(DRAG_AND_DROP_MENU_ITEM_ID));
		Assert.assertThat(dragAndDropMenuItem.getText(), equalTo("Drag and Drop"));
		return dragAndDropMenuItem;
	}

	private void clickOnDragAndDropMainMenuItem() {
		driver.findElement(By.id("j_idt82")).click();
	}

}
