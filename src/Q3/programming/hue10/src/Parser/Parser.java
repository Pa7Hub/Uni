package Q3.programming.hue10.src.Parser;

import Q3.programming.hue6.src.Token;

import java.util.List;

public abstract class Parser {
    List<Token> _tokens;

    public Parser(List<Token> tokens) {
        _tokens = tokens;
    };

    public void checkIfTokenListIsEmpty() {
        if (_tokens.isEmpty()) throw new RuntimeException("Unexpected Empty List in " + this.getClass().getSimpleName() + "!");
    }

}
