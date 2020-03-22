public class Person extends Matchable {

    private final String name;

    public Person(String name, String number) {
        super(number);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ", " + getIndex() + "\n";
    }
}
