/**
 * This pretty implementation of stack for everyday usage is designed
 * for people's convenience, peace on the Earth and the Russian World's propagation.
 * It defines methods for pushing, popping, reversing and printing the stuff.
 * @param <T>   the type of data that the stack is meant to store and operate with.
 */
public class Колода<T> {

    /**
     * The node lying on the top of the pack.
     */
    private Элемент<T> верх;

    /**
     * The node modelling the items being stored.
     * @param <T> the type of srored data.
     */
    protected class Элемент<T> {

        /**
         * The matter to be stored.
         */
        T значение;

        /**
         * The previous item been put in the pack,
         * thus lying under the given one.
         */
        Элемент<T> следующий;

        /**
         * A new item containing the value and lying over the another.
         * @param значение  a value this item holds.
         * @param следующий another item this item lies over.
         */
        public Элемент(T значение, Элемент<T> следующий) {
            this.значение = значение;
            this.следующий = следующий;
        }
    }

    /**
     * Puts a new value on the top of the stack.
     * A former top value becomes 'previous (next in the pack)' for the new been put.
     * @param значение the value being put on the pack.
     */
    public void положить(T значение) {

        верх = new Элемент<>(значение, верх);

    }

    /**
     * Takes off and returns the value from the top of the stack.
     * The length of the stack gets reduced by one (if not empty already),
     * and the previous (next in the pack) item having been lying below turns to be the top one.
     * @return the value situated on the top of the pack, or {@code null} if the stack is empty.
     */
    public T взять() {

        if (верх == null)
            return null;

        T отдаваемое = верх.значение;

        верх = верх.следующий;

        return отдаваемое;
    }

    /**
     * Returns a new Колода containing all items of the stack in reversed order.
     * @return the inversed copy of the stack, or an empty stack if the original one is empty.
     */
    public Колода<T> перевернуть() {
        Колода<T> перевёрнутая = new Колода<>();
//        Колода<T> копия = (Колода<T>) this.clone();
        while (true) {
            T очередное = взять();
            if (очередное == null) break;
            else перевёрнутая.положить(очередное);
        }
        return перевёрнутая;
    }

    /**
     * Prints out an arrowed chain-like representation of the stack's content,
     * bordered by curly braces for better distinguishably.
     * If there's no items inside, reports it explicitly.
     */
    public void напечатать() {
        StringBuilder sb = new StringBuilder();
        if (верх != null) {
            Элемент<T> очередной = верх;
            while (true) {
                sb.append(очередной.значение);
                if (очередной.следующий != null) sb.append(" → ");
                else break;
                очередной = очередной.следующий;
            }
        } else {
            sb.append("пусто");
        }
        System.out.printf("{ %s }%n", sb);
    }

}
