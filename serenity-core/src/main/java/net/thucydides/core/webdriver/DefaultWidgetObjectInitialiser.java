package net.thucydides.core.webdriver;

import net.serenitybdd.core.di.*;
import net.serenitybdd.core.pages.*;
import org.openqa.selenium.*;

/**
 * Initializes the {@link WebElementFacade} members of a {@link WidgetObject}.
 * @author Joe Nasca
 */
public class DefaultWidgetObjectInitialiser extends AbstractObjectInitialiser<WidgetObject> {

	private final WidgetProxyCreator widgetProxyCreator;
	
    public DefaultWidgetObjectInitialiser(WebDriver driver, int ajaxTimeoutInMilliseconds) {
        super(driver, ajaxTimeoutInMilliseconds);
        this.widgetProxyCreator = WebDriverInjectors.getInjector().getInstance(WidgetProxyCreator.class);
    }

    public boolean apply(WidgetObject widget) {
        widgetProxyCreator.proxyElements(widget, driver, ajaxTimeoutInSecondsWithAtLeast1Second());
        return true;
    }
}
