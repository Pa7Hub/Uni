package Q3.programming.hue7.src;

import Q3.programming.hue6.src.*;
import Q3.programming.hue7.src.Exceptions.EmptyTokenStringException;
import Q3.programming.hue7.src.Exceptions.InvalidCharacterException;

import java.util.ArrayList;
import java.util.List;

public class Scanner {

    public List<Token> toTokenSequence(String expr) throws EmptyTokenStringException, InvalidCharacterException {
        if (expr.length() == 0) {
            throw new EmptyTokenStringException("Cannot form Token Sequence from empty string");
        } else {
            List<Token> tokens = new ArrayList<>();
            char[] chars = expr.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '(') { //OpeningBracketToken
                    tokens.add(new BracketOpeningToken());
                } else if (c == ')') { //ClosingBracket
                    tokens.add(new BracketClosingToken());
                } else if (c == '+') { //SumToken
                    tokens.add(new OperatorSumToken());
                } else if (c == '*') { //ProductToken
                    tokens.add(new OperatorProductToken());
                } else if (Character.isDigit(c)) {
                    String number = "" + c;
                    while (i+1 < chars.length && Character.isDigit(chars[i+1])) {
                        i++;
                        number += (chars[i]);
                    }
                    tokens.add(new NatNumToken(Integer.parseInt(number)));
                } else {
                    throw new InvalidCharacterException("Invalid Character in scanner: " + c);
                }
            }
            return tokens;
        }
    }
}