package Q4.IIS.w2;

import java.util.List;

public interface Container {
    void addToContents(Contained content);

    List<Contained> getContents();

}
