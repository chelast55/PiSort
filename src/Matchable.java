public class Matchable implements Comparable<Matchable> {

    private final String pattern;
    private int index = 0;

    public Matchable(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int i) {
        index = i;
    }

    @Override
    public int compareTo(Matchable m) {
        return Integer.compare(index, m.getIndex());
    }
}
