package pl.wsb;

import pl.wsb.model.Panel;

import java.util.List;

public interface Storage {
    List<Panel> load();
    void save(List<Panel> set);
}
