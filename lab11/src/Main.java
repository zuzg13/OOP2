import java.util.*;

public class Main {
    public static void main(String[] args){

        int n = 0, m = 0;


        if(args.length != 0)
        {
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);
        }
        else
        {
            System.out.print("Nie podano parametrow wejsciowych");
            System.exit(1);
        }

        String[] t1, t2, t3;
        Random r2 = new Random();
        double start, stop;

        // wypełnianie tablic

        t1 = new String[n];
        t2 = new String[m];
        t3 = new String[m];


        for(int i=0;i<n;i++)
        {
            t1[i] = getRandomString(r2.nextInt(16) + 5);
        }

        for(int i=0;i<m;i++)
        {
            t2[i] = t1[r2.nextInt(n-1)];
            t3[i] = getRandomString(r2.nextInt(16) + 5);
        }

        System.out.println("Losowanie " + n + " lancuchow.");
        System.out.println("Testowanie dla " + n + " lancuchow.");


        // tworzenie i wypelnianie odpowiednich kolekcji

        ArrayList<String> arrayList= new ArrayList<>();
        LinkedList<String> linkedList= new LinkedList<>();
        TreeMap<String, String> treeMap = new TreeMap<>();
        HashMap<String, String> hashMap  = new HashMap<>();

        System.out.print("Generate: ");

        start = System.nanoTime();
        Collections.addAll(arrayList, t1);
        stop = System.nanoTime();

        System.out.print("ArrayList(" + (stop-start)*1e-6 + " ms), ");


        start = System.nanoTime();
        Collections.addAll(linkedList, t1);
        stop = System.nanoTime();

        System.out.print("LinkedList(" + (stop-start)*1e-6 + " ms), ");

        start = System.nanoTime();
        for(String el: t1)
            treeMap.put(el, null);
        stop = System.nanoTime();

        System.out.print("TreeMap(" + (stop-start)*1e-6 + " ms), ");


        start = System.nanoTime();
        for(String el: t1)
            hashMap.put(el, null);
        stop = System.nanoTime();

        System.out.println("HashMap(" + (stop-start)*1e-6 + " ms)\n");

        System.out.print("Poczatek, rozmiary:  ");
        System.out.print(arrayList.size() + ", ");
        System.out.print(linkedList.size() + ", ");
        System.out.print(treeMap.size() + ", ");
        System.out.println(hashMap.size());
        System.out.println();

        // mierzenia czasu dla Search

        System.out.print("Search:\t");

        System.out.print("ArrayList(" + timeCounterSearchArray(arrayList, t2, m)+ " ms), ");
        System.out.print("LinkedList(" + timeCounterSearchArray(linkedList, t2, m) + " ms), ");
        System.out.print("TreeMap(" + timeCounterSearchMap(treeMap, t2, m) + " ms), ");
        System.out.println("HashMap(" + timeCounterSearchMap(hashMap, t2, m) + " ms)");

        // mierzenia czasu dla SearchNOT

        System.out.print("\nSearchNOT:\t");

        System.out.print("ArrayList(" + timeCounterSearchArray(arrayList, t3, m) + " ms), ");
        System.out.print("LinkedList(" + timeCounterSearchArray(linkedList, t3, m)  + " ms), ");
        System.out.print("TreeMap(" + timeCounterSearchMap(treeMap, t3, m)+ " ms), ");
        System.out.println("HashMap(" + timeCounterSearchMap(hashMap, t3, m) + " ms)");

        // mierzenie czasu dla list

        System.out.print("\tjava.util.ArrayList: ");
        timeCounterForList(arrayList);

        System.out.print("\tjava.util.LinkedList: ");
        timeCounterForList(linkedList);

        // mierzenie czasu dla usuwania zawartosci kolekcji

        System.out.print("\nRemove:\t");

        System.out.print("ArrayList(" + timeCounterRemoveList(arrayList) + " ms), ");
        System.out.print("LinkedList(" + timeCounterRemoveList(linkedList) + " ms), ");
        System.out.print("TreeMap(" + timeCounterRemoveMap(treeMap) + " ms), ");
        System.out.println("HashMap(" + timeCounterRemoveMap(hashMap)+ " ms)");

        System.out.print("\nKoniec, rozmiary:  ");
        System.out.print(arrayList.size() + ", ");
        System.out.print(linkedList.size() + ", ");
        System.out.print(treeMap.size() + ", ");
        System.out.println(hashMap.size());
        System.out.println();

    }

    public static String getRandomAlphabet()
    {
        Random r = new Random();
        return String.valueOf((char)(r.nextInt(26)+'a'));
    }

    public static String getRandomString(int len)
    {
        StringBuilder str = new StringBuilder(len);

        for(int j=0;j<len;j++)
        {
            str.append(getRandomAlphabet());
        }

        return str.toString();
    }

    public static double timeCounterSearchArray(List<String> list, String[] tab, int size)
    {
        double start, stop;
        start = System.nanoTime();
        for(int i=0;i<size;i++)
        {
            list.indexOf(tab[i]);
        }
        stop = System.nanoTime();

        return (stop-start)*1e-6;
    }

    public static double timeCounterSearchMap(Map<String, String> map, String[] tab, int size)
    {
        double start, stop;
        start = System.nanoTime();
        for(int i=0;i<size;i++)
        {
            map.containsKey(tab[i]);
        }
        stop = System.nanoTime();

        return (stop-start)*1e-6;
    }

    public static void timeCounterForList(List<String> list)
    {
        double start, stop;
        Iterator<String> iter;

        start = System.nanoTime();
        for(int i=0;i<list.size();i++) list.get(i);
        stop = System.nanoTime();

        System.out.print("for("+(stop-start)*1e-6 +" ms), ");

        start = System.nanoTime();
        for(String el : list);
        stop = System.nanoTime();

        System.out.print("for-each("+(stop-start)*1e-6 +" ms), ");

        iter = list.iterator();

        start = System.nanoTime();
        while(iter.hasNext()){iter.next();}
        stop = System.nanoTime();

        System.out.println("iterator("+(stop-start)*1e-6 +" ms)");
    }

    public static double timeCounterRemoveList(List<String> list)
    {
        double start, stop;

        start = System.nanoTime();
        list.clear();
        stop = System.nanoTime();

        return (stop-start)*1e-6;

    }

    public static double timeCounterRemoveMap(Map<String, String> map)
    {
        double start, stop;

        start = System.nanoTime();
        map.clear();
        stop = System.nanoTime();

        return (stop-start)*1e-6;

    }
}
