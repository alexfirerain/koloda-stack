public class Колода<T> {

    private Элемент<T> верх;

    protected class Элемент<T> {
        T значение;
        Элемент<T> следующий;

        public Элемент(T значение, Элемент<T> следующий) {
            this.значение = значение;
            this.следующий = следующий;
        }
    }

    public void положить(T значение) {

        верх = new Элемент<>(значение, верх);

    }

    public T взять() {

        if (верх == null)
            return null;

        T отдаваемое = верх.значение;

        верх = верх.следующий;

        return отдаваемое;
    }

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
