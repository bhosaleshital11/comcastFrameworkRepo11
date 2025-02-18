package com.ClientName.AppName.GenericUtility.FiLeUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
public String getDataFromProperties(String key) throws Throwable
{
FileInputStream fis=new FileInputStream("./TestData/commonData.properties");
Properties pObj=new Properties();
pObj.load(fis);
String data=pObj.getProperty(key);
return data;
}
}