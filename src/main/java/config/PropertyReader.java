package config;


import browser.BrowserType;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader  implements Config {
     private Properties pro;
     private FileInputStream fis;
    public PropertyReader(){
        try{
            fis=new FileInputStream("C:\\Users\\coevy\\IdeaProjects\\FrondEndBuyMeAutomation\\configs\\data.properties");
            pro=new Properties();
            pro.load(fis);


        }catch (Exception e){
            e.printStackTrace();
        }


    }
    @Override
    public int getImplicitTime() {
        return  Integer.valueOf(pro.getProperty("implicitWait"));
    }

    @Override
    public int getPageLoadTime() {
        return Integer.valueOf(pro.getProperty("pageLoadTime"));
    }

    @Override
    public int getExplicitWait() {
        return Integer.valueOf(pro.getProperty("explicitWait"));
    }

    @Override
    public String getBrowserType() {
        return pro.getProperty("browserType");
    }

    public static void main(String[] args) {
        PropertyReader pr=new PropertyReader();
        System.out.println(pr.getBrowserType());
    }

}
