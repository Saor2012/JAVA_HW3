public class Main {
    public static void main(String[] args) {
        //testOOPClasses();
        patternTest();
    }
    public static void testOOPClasses () {
        abstract class BaseArray {
            int[] arr = null;
            int index;
            protected
            abstract void add(int value);
            abstract int remove(int index);
            abstract int size();
            abstract String newToString();
        }
        class MyClass extends BaseArray {
            MyClass() {
                init();
                for (int i = 0; i < 10; i++) {
                    addInit(i + 1);
                }
            }
            void init() {
                this.arr = new int[10];
            }
            @Override
            public void add(int value) {
                int []arr2 = new int[arr.length];
                int i;
                for (i = 0; i < arr.length; i++) {
                    arr2[i] = arr[i];
                    arr[i] = 0;
                }
                arr = null;
                index++;
                arr = new int[index];
                //System.out.println(index + " " + arr.length);
                for (i = 0; i < index; i++) {
                    if (i < arr2.length)
                        arr[i] = arr2[i];
                    if (i == index - 1)
                        arr[i] = value;
                    //System.out.print(arr[i] + " ");
                }

            }
            public void addInit(int value) {
                arr[index++] = value;
            }
            @Override
            public int remove(int id) {
                id--;
                if (id > arr.length || id < 0) {
                    System.out.println("Error: NO_ARRAY_INDEX_ELEMENT");
                    return 0;
                }
                int i, j, length = arr.length;
                j = arr[id];
                arr[id] = 0;
                int []arr2 = new int[length - 1];
                for (i = 0; i < length; i++) {
                    //System.out.print(i + " ");
                    if (i == id) {
                        continue;
                    } else if (i > id) {
                        arr2[i - 1] = arr[i];
                    } else
                        arr2[i] = arr[i];
                    //System.out.println("New[" + j + "] = " + newArr[j] + ", main arr index = " + i);
                }
                for (i = 0; i < length; i++)
                    arr[i] = 0;
                arr = null;
                index--;
                arr = new int[index];
                for (i = 0; i < index; i++)
                    arr[i] = arr2[i];
                return j;
                //int []newArr = new int[length - 1];
                //System.out.println(newArr.length);
                //System.out.println(arr.length);
                /*for (i = 0; i < arr.length - 1; i++) {
                    // System.out.print(i + " " + j + " ");
                    if (i == id) {
                        j--;
                        continue;
                    } else {
                        if (i <= id)
                            newArr[i] = arr[i];
                        else if (j >= id)
                            newArr[j] = arr[i];
                        //System.out.println("New[" + j + "] = " + newArr[j] + ", main arr index = " + i);
                    }
                }*/
                //System.out.println("Size " + index);
                //arr = null;
                //this.index -= 1;
                //System.out.println("Size " + index);
                //arr = new int[index];
                //System.out.println(" " + index);
                //System.out.println("Array: ");
                /*for (i = 0; i < index; i++) {
                    if (i < newArr.length)
                        arr[i] = newArr[i];
                    else arr[i] = 0;
                    //System.out.println("New[" + i + "] = " + arr[i] + "(" + newArr[i] + ") ");
                }*/
            }
            @Override
            public int size() {
                return arr.length;
            }
            @Override
            public String newToString() {
                //String str = new String[];
                String str = "";
                for (int i = 0; i < index; i++) {
                    str += "Array[" + i + "] = " + this.arr[i] + " \n";
                }
                return str;
            }
            public void showArray() {
                System.out.println("Array: ");
                for (int i = 0; i < arr.length; i++)
                    if (arr[i] != 0)
                        System.out.print(arr[i] + " ");
                // System.out.println(arr[i]);
                //System.out.println(index);
                System.out.println();
            }
        }
        /*int i, n = 10;
        int []arr = new int[n], arr2;
        for (i = 0; i < n; i++)
            arr[i] = i;
        for (i = 0; i < n; i++)
            System.out.println(arr[i]);
        for (i = 0; i < n; i++)
            arr[i] = 0;
        arr = null;
        n += 5;
        arr = new int[n];
        for (i = 0; i < n; i++)
            arr[i] = i;
        for (i = 0; i < n; i++)
            System.out.println(arr[i]);
        // arr2 = new int[n];*/

        MyClass arr = new MyClass();
        arr.showArray();
        //System.out.println(arr.size() + ", index = " + arr.index);
        arr.add(11);
        arr.showArray();
        arr.remove(15);
        arr.showArray();
        System.out.println(arr.size());
        System.out.println("Array element list: ");
        System.out.println(arr.newToString());
    }
    public static void patternTest() {
        class Duck {
            private Duck instance;
            private String name;
            private Duck() {

            }
            public synchronized Duck getInstance() {
                if (instance == null)
                    instance = new Duck();
                return instance;
            }
        }
    }
}
