package config;

import browser.BrowserType;

public interface Config {
   public int getImplicitTime();
   public int getPageLoadTime();
   public int getExplicitWait();
   public String getBrowserType();
}
