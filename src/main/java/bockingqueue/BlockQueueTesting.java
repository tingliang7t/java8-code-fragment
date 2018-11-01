package bockingqueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueueTesting {

    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {

        try(Scanner in = new Scanner(System.in)){

            System.out.print("Enter base directory (e.g. /opt/jdk1.8.0/src): ");
            String directory = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile): ");
            String keyword = in.nextLine();

                Runnable enumerator = () -> {
                    try{
                        enumerate(new File(directory));
                        queue.put(DUMMY);
                    }catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                };

                new Thread(enumerator).start();

            for(int i = 0; i<SEARCH_THREADS; i++) {
                Runnable searcher = () -> {
                    try {

                        boolean done = false;
                        while(!done){
                            File file = queue.take();

                            if (DUMMY.equals(file)){
                                queue.put(file);
                                done = true;
                            }else {
                                search(file, keyword);
                            }
                        }
                    }catch (IOException | InterruptedException e){
                        System.out.println(e.getLocalizedMessage());
                    }
                };

                new Thread(searcher).start();
            }
        }
    }

    private static void enumerate(File dir) throws InterruptedException{

        File[] files = dir.listFiles();

        if (files == null) {
            return;
        }

        for(File file : files) {

            if (file.isDirectory()){
                enumerate(file);
            }else {
                queue.put(file);
            }
        }
    }

    private static void search(File file, String keyWord) throws IOException{

        try(Scanner in = new Scanner(file, "UTF-8")){

            int lineNumber = 0;
            while(in.hasNextLine()){
                lineNumber ++;
                String line = in.nextLine();
                if (line.contains(keyWord)){
                    System.out.println(file.getPath());
                }
            }
        }
    }
}
