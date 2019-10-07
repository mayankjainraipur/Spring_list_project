import java.util.Comparator;

public class MakeInOrder implements Comparator<Human> {

    @Override
    public int compare(Human t1, Human t2) {
        return t1.getComparingValue().compareTo(t2.getComparingValue());
    }

}
