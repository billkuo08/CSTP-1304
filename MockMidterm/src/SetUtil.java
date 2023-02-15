package src;

public class SetUtil {
    static <T> SetInterface union(SetInterface<T> A, SetInterface<T> B) {
        SetInterface<T> tmp = new SetUsingArray<>();
        T[] aArray = A.toArray();
        T[] bArray = B.toArray();

        for (int i = 0; i < aArray.length; i++) {
            tmp.add(aArray[i]);
        }

        for (int i = 0; i < bArray.length; i++) {
            if (!tmp.contains(bArray[i]))
                tmp.add(bArray[i]);
        }
        return tmp;
    }

    static <T> SetInterface intersect(SetInterface<T> A, SetInterface<T> B) {
        SetInterface<T> tmp = new SetUsingArray<>();
        T[] aArray = A.toArray();
        T[] bArray = B.toArray();

        if (aArray.length > bArray.length) {
            for (int i = 0; i < bArray.length; i++) {
                if (A.contains(bArray[i]))
                    tmp.add(bArray[i]);
            }
        } else {
            for (int i = 0; i < aArray.length; i++) {
                if (B.contains(aArray[i]))
                    tmp.add(aArray[i]);
            }
        }

        return tmp;
    }

    static <T> SetInterface difference(SetInterface<T> A, SetInterface<T> B) {
        SetInterface<T> tmp = new SetUsingArray<>();
        T[] aArray = A.toArray();

        for (int i = 0; i < aArray.length; i++) {
            if (!B.contains(aArray[i]))
                tmp.add(aArray[i]);
        }

        return tmp;
    }

    public static void main(String[] args) {
        SetUsingArray<Integer> A = new SetUsingArray<>();
        SetUsingArray<Integer> B = new SetUsingArray<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        B.add(3);
        B.add(4);
        B.add(5);
        B.add(6);
        B.add(7);
        B.add(8);
        B.add(9);
        B.add(10);
        SetInterface<Integer> C = union(A, B);
        SetInterface<Integer> D = intersect(A, B);
        SetInterface<Integer> E = difference(A, B);
        for (Object i : A.toArray())
            System.out.print(i + " ");
        System.out.println("\n");
        for (Object i : B.toArray())
            System.out.print(i + " ");
        System.out.println("\n");

        for (Object i : C.toArray())
            System.out.print(i + " ");
        System.out.println("\n");

        for (Object i : D.toArray())
            System.out.print(i + " ");
        System.out.println("\n");

        for (Object i : E.toArray())
            System.out.print(i + " ");
        System.out.println("\n");


    }

}
