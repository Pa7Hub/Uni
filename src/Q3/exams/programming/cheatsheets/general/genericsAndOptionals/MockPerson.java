package Q3.exams.programming.cheatsheets.general.genericsAndOptionals;

import java.util.Optional;

/**
 * Mock Person class with basic implementation, enough to show examples in Cheatsheets
 */
public class MockPerson {
    private final String _firstName;
    private final String _lastName;
    private final Optional<MockPerson> _partner;

    public MockPerson(String firstName, String lastName, MockPerson person) {
        _firstName = firstName;
        _lastName = lastName;
        _partner = (person != null) ? Optional.of(person) : Optional.empty(); // shorthand für if-else block
    }

    public String getFirstName() {
        return this._firstName;
    }

    public String getLastName() {
        return this._lastName;
    }

    public Optional<MockPerson> getPartner() {
        return this._partner;
    }
}