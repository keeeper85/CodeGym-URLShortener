package com.codegym.task.task33.task3310.strategy;

import com.codegym.task.task33.task3310.Helper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(Helper.generateRandomString(),".txt");
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
//            throw new RuntimeException(e);
        }
    }

    public long getFileSize() {

        long fileSize = 0;
        try {
            fileSize = Files.size(path);
        } catch (IOException e) {
//            throw new RuntimeException(e);
        }

        return fileSize;
    }

    public void putEntry(Entry entry){

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))){
            oos.writeObject(entry);
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
        } catch (IOException e) {
//            throw new RuntimeException(e);
        }

    }

    public Entry getEntry(){
        if (getFileSize() == 0) return null;
        Entry entry = null;

        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(path))){
            entry = (Entry) inputStream.readObject();
        } catch (IOException e) {
//            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
        }
        return entry;
    }

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
//            throw new RuntimeException(e);
        }
    }
}
