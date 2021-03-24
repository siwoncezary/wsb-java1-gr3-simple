package pl.wsb;

import pl.wsb.model.Panel;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileObjectStorage implements Storage{
    private final String pathToFile;

    public FileObjectStorage(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public List<Panel> load() {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(pathToFile))) {
            return (List<Panel>) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void save(List<Panel> set) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(pathToFile))) {
            stream.writeObject(set);
        } catch (FileNotFoundException e) {
            System.out.println("Nieznana klasa");
        } catch (IOException e) {
            System.out.println("Niezmożliwy zapis do pliku");
        }
    }
}
