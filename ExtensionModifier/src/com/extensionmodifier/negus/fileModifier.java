package com.extensionmodifier.negus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class fileModifier extends UserInterface{
    String filePath2 = filePath;
    File directory = new File(filePath);
    String newFileExtension = extension;
    String error = null;
    /*
     *fileExtensionChanger is a method that gets the folder,
     *list its contents and renames the file to the new extension 
     * */
   public void fileExtensionChanger() throws Exception
   {   
       if(directory.isDirectory())
       {
           if(directory.list().length>0)
           {
               int index;
               for(File fileName : directory.listFiles())
               {
                   
                       index = fileName.getName().indexOf('.')+1;
                       File file = new File(filePath+"/"+fileName.getName().substring(0,index)+newFileExtension);
                       fileName.renameTo(file);
                   
                   
               }
           }
               else 
                   throw new FileNotFoundException("No file in chosen directory");
           
       }
       else
           throw new IOException("Path is not a directory") ;
           
       
   }
  

}