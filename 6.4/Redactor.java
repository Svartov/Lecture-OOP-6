package Leks6;

import java.io.*;

    public class Redactor implements Runnable {

        private File fileIn;
        private File fileOut;
        private File folderIn;
        private File folderOut;

        public Redactor(File fileIn, File fileOut) {
            this.fileIn = fileIn;
            this.fileOut = fileOut;
        }

        public Redactor() {
            super();
        }

        public static long copyFile(File fileEn, File fileTo) throws IOException{
        try(InputStream is = new FileInputStream(fileEn);
            OutputStream os = new FileOutputStream(fileTo)){
            return is.transferTo(os);
        }
    }


        public static long copyFolder(File folderIn, File folderOut) throws IOException{
            File[] files = folderIn.listFiles(); // Аn array where all our files with this extension will be stored
            long totalBytes  = 0; // Total number of bytes
            if(files != null) { // Checking for files
                for (File file : files) {
                    if(file.isFile()){
                        File fileOut = new File(folderOut, file.getName());
                        totalBytes+= copyFile(file,fileOut);
                    }
                }
            }
            return totalBytes;
        }

        @Override
        public void run() {
            try {
                    long totalBytes = Redactor.copyFolder(fileIn, fileOut);
                    System.out.println("copying: " + totalBytes + " bytes");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
