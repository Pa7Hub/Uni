package Q4.IIS.GroupProject;

public class Leaf extends Component {
    private Integer _size;

    public Leaf(Integer size, String name) {
        super(name, "Leaf");
        this._size = size;
    }

    public Integer getSize() {
        return this._size;
    }
}
