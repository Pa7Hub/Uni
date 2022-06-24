package Q3.programming.hue13.operations.Search;

import Q3.programming.hue13.operations.IOperation;

public abstract class ASearch<T> implements IOperation {
    private final T _searchTerm;

    public T getSearchTerm() {
        return this._searchTerm;
    }

    public ASearch(T searchTerm) {
        this._searchTerm = searchTerm;
    }
}
