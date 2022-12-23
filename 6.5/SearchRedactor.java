package Leks6;

import java.io.File;
import java.io.IOException;

public class SearchRedactor implements Runnable{

    private File folderIn;
    private File folderOut;

    public SearchRedactor(File folderIn, File folderOut) {
        super();
        this.folderIn = folderIn;
        this.folderOut = folderOut;
    }

    public SearchRedactor(){
        super();
    }

    public static void searchFile(File folderIn, File folderOut) throws IOException {
        File[] files = folderIn.listFiles();
        File[] fileOut = folderOut.listFiles();
        if(files != null){
            if(files.length > fileOut.length){
                System.out.println("Больше");
                Redactor.copyFolder(folderIn, folderOut);
            }else if(files.length < fileOut.length){
                System.out.println("Меньше");
                fileOut[0].delete(); // Удаляем первый элемент массива папки копирования
                // Так как не сказано что должны быть индентичные файлы
            }else{
                System.out.println("ok");
            }
        }
    }

    @Override
    public void run(){
        try {
            SearchRedactor.searchFile(folderIn, folderOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
