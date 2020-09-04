package compare;

public interface CustomList {

    void add(int item);
    int size();
    int get(int index);

    default void forEach() {
        for (int i = 0; i < size() ; i++) {

        }
    }
}
