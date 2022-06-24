package Q3.exams.programming.cheatsheets.general.genericsAndOptionals;

import java.util.ArrayList;
import java.util.List;

//                         V Defintion eines Generics "T". T wird dann bei erstellen des Stacks definiert und folgend für alle Typen T angenommen.
public class DynamicStack <T>{
    private List<T> _contents;

    public DynamicStack() {
        _contents = new ArrayList<T>();
    }

    // Alle folgenden Funktionen haben den Return Typ "T".
    public T pop() {
        return this._contents.remove(0);
    }

    public T peek() {
        return this._contents.get(0);
    }

    public void push(T element) {
        this._contents.add(element);
    }
}
