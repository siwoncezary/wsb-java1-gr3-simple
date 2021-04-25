package pl.wsb.inner;

import pl.wsb.Storage;
import pl.wsb.model.Panel;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class AnonymousClassDemo {
    public static void main(String[] args) {
        //Storage textFileStorage = new class XXXX implements Storage{
        Storage textFileStorage = new Storage() {
            Path file = Paths.get("c:\\data\\data.txt");
            @Override
            public List<Panel> load() {
                List<Panel> panels = new ArrayList<>();
                try {
                    final List<String> list = Files.readAllLines(file);
                    for(String line: list){
                        final String[] tokens = line.split("\t");
                        double a = Double.parseDouble(tokens[0]);
                        double b = Double.parseDouble(tokens[1]);
                        final Panel panel = new Panel(a, b, 0, "");
                        panels.add(panel);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return panels;
            }

            @Override
            public void save(List<Panel> set) {
                for(Panel p: set){
                    try {
                        Files.writeString(file, p.getSideA() +"\t"+p.getSideB()+"\n", StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        System.out.println("Bład zapisu");;
                    }
                }
            }
        };

        textFileStorage.save(List.of(new Panel(2,2,0,""),new Panel(5,6,0,"")));
        final List<Panel> panels = textFileStorage.load();
        for(Panel p: panels){
            System.out.println(p);
        }
    }
}
