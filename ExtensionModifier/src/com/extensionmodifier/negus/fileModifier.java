package com.extensionmodifier.negus;

import java.io.File;

public class fileModifier extends UserInterface{
    String filePath2 = filePath;
    File directory = new File(filePath);
    String newFileExtension = extension;
    /*
     *fileExtensionChanger is a method that gets the folder,
     *list its contents and renames the file to the new extension 
     * */
   public void fileExtensionChanger()
   {   int index;
       for(File fileName : directory.listFiles()){
           index = fileName.getName().indexOf('.')+1;
           File file = new File(filePath+"/"+fileName.getName().substring(0,index)+newFileExtension);
           fileName.renameTo(file);
       }
   }
  

}