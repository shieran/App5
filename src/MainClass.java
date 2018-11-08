import java.util.Arrays;
import java.util.Scanner;

public class MainClass extends Print {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println(
                "1)массив из 10 чисел, вывести элементы, посчитать кол-во отрицательных"+"\n"+
                "2)1000 случ чисел в массив, среднее арифментическое частей по 250 элементов"+"\n"+
                "3)дано число N, два массива разных размеров>=N. если в массивах N одинаковых элементов, они похожи"+"\n"+
                "4)оздать исключение при обращении к элементу массива, обработать его, вывести сообщение"+"\n"+
                "5)методы принт с разными сигнатурами, создан суперкласс Print"+"\n"+
                "6)привести конструкцию if/else if/else к switch/case"+"\n"+
                "7)дано число N, вывести его цифры по одной в обратном порядке"+"\n"+
                "8)дано число N, вычислить сумму его цифр"+"\n"+"\n"+
                "ВВЕДИТЕ НОМЕР ЗАДАНИЯ");
        int menu;
        while(true) {
            try {
                menu = Integer.valueOf(sc.next());
            }catch (NumberFormatException e){
                System.out.println("вы ввели не число");
                continue;
            }
            if (menu < 1 || menu > 8) {
                System.out.println("число не от 1 до 8");
                continue;
            }
            break;
        }


        switch (menu) {
            case 1:
                Massive(sc);
                break;

            case 2:
                Average();
                break;

            case 3:
                SameMas(3, 0, 20);
                break;

            case 4:
                ArrExc();
                break;

            case 5:
                PrintRandom("string");
                PrintRandom(43, "string");
                PrintRandom(23);
                PrintRandom(34.34);
                PrintRandom(12.12, 4);
                break;

            case 6:
                SwCase();
                break;

            case 7:
                int number = 153426436;
                System.out.println(number);
                System.out.println(RekNumbers(number, 10));
                break;

            case 8:
                int num8=12345591;
                System.out.println(num8);
                System.out.println(RekSum(num8, 10, 0));
                break;
        }


    }


    //массив чисел, могут быть одинаковые
    static int[] getMassive(int n, int min, int max){
        int[] array= new int[n];
        min=Math.abs(min);
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.round(Math.random() * (min+max) - min));
            if(array[i]<min){
                array[i]=min;
            }
    }return array;
    }




    //массив разных чисел
       public static int[] RandomMassive(int n, int min, int max){
        while(true){
            int[] arr1=getMassive(n,min,max);
            int same=0;
            for (int i = 0; i <arr1.length-1 ; i++) {
                for (int j = i+1; j <arr1.length ; j++) {
                    if (arr1[i]==arr1[j]){
                        same++;
                    }
                }
            }
            if (same==0){
                return arr1;
            }
        }
    }



//    Создать массив на 10 чисел, ввести все элементы через консоль.
//    Посчитать количество отрицательных чисел, вывести его на экран.
    public static void Massive(Scanner scanner){
        int[] arr=new int[10];
        System.out.println("необходимо ввести 10 чисел");
        int i=0;
        int negative=0;
        while (i!=10){
            try{
                System.out.println("введите "+(i+1)+"й элемент");
                arr[i]=Integer.valueOf(scanner.next());
                i++;
            }catch (NumberFormatException e){
                System.out.println("вы ввели не число");
            }
        }
        //если нужно вывести массив на экран
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j <arr.length ; j++) {
            if (arr[j]<0){
                negative++;
            }
        }
        System.out.println("количество введённых отрицательных чисел: "+negative);
    }



//    Проинициализировать массив на 1000 случайных чисел.
// Вычислить среднее арифметическое первых 250 чисел, вторых 250 чисел и т.д.
// Вывести на экран средние арифметические всех четырех диапазонов.
// Найти наибольший из них и вывести на экран.
    public static void Average(){
        int[] arr=getMassive(1000,5,300);
        double[] arrAver=new double[4];
        int num=250;
        double maxArrAver=0;
//        считаем средние арифметические 4 частей массива
        for (int i = 0; i < arrAver.length ; i++) {
            double sum=0;
            for (int j = (num-250); j<num; j++) {
                sum+=arr[j];
            }
            num+=250;
            System.out.println(sum);
            arrAver[i]=sum/250;
            if (arrAver[i]>maxArrAver){
                maxArrAver=arrAver[i];
            }
        }
        System.out.println(Arrays.toString(arrAver));
        System.out.println("Наибольшее среднее арифметическое: "+maxArrAver);
    }



//    Дано число N и два массива разных размеров (размер каждого массива больше либо равен N).
// Массивы считаются похожими, если содержат N одинаковых элементов.
// Написать программу, которая на основании двух массивов сообщает, похожи ли они..
    public static void SameMas(int same, int minElem, int maxElem){
        int alike=0;
        //генерируем случайным образом число элементов каждого массива
        int num1=same+(int)((Math.round(Math.random() * 4+2)));
        int num2=same+(int)((Math.round(Math.random() * 4+2)));
        //заполняем оба массива исходя из полученых чисел элементов,
        //минимум и максимум передаём сами
        int[] mas1=RandomMassive(num1, minElem, maxElem);
        int[] mas2=RandomMassive(num2, minElem, maxElem);
        System.out.println("Массивы будут считаться похожими, если у них имеется "+same+" одинаковых элемента(ов)");
        System.out.println(Arrays.toString(mas1));
        System.out.println(Arrays.toString(mas2));
        //узнаем, длина какого массива больше
        //сверяем элементы меньшего массива с элементами большего
        if (mas1.length<=mas2.length){
            for (int i = 0; i <mas1.length ; i++) {
                for (int j = 0; j <mas2.length ; j++) {
                    if (mas1[i]==mas2[j]){
                        alike++;
                    }
                }
            }
        }else{
            for (int i = 0; i <mas2.length ; i++) {
                for (int j = 0; j <mas1.length ; j++) {
                    if (mas2[i]==mas1[j]){
                        alike++;
                    }
                }
            }

        }
        //сверяем количество одинаковых элементов с заданным параметром
        if (alike>=same){
            System.out.println("Массивы похожи");
        }else {
            System.out.println("Массивы не похожи");
        }
    }




//    Создать массив размерностью в 1 элемент.
// Намеренно вызвать элемент по индексу за пределами массива.
// Обработать исключение ArrayOutOfBoundsException при помощи try/catch,
// в блоке catch вывести сообщение о выходе за границы массива.
    public static void ArrExc(){
        int[] arr=new int[1];
        try {
            System.out.println(arr[arr.length+1]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("вы ссылаетесь на элемент за границами массива");
        }
    }



//    Есть конструкция вида
// if (intValue == 3) { print(“first”); }
// else if (intValue == 4) { print(“second”); }
// else { print(“third”); }
// Привести ее к оператору switch/case.
    public static void SwCase(){
        int[] intValue=getMassive(1,0,4);
        switch (intValue[0]){
            case 3:
                System.out.println("first");
                break;
            case 4:
                System.out.println("second");
                break;
            default:
                System.out.println("third");
        }
    }

//    Дано натуральное число N. Выведите все его цифры по одной, в обратном порядке,
// разделяя их пробелами или новыми строками.
//При решении этой задачи нельзя использовать строки, списки, массивы
// (ну и циклы, разумеется). Разрешена только рекурсия и целочисленная арифметика.
public static String RekNumbers(int n, int del){
    if(n>0){
        System.out.print((n%del)/(del/10)+" ");
        n-=n%del;
        del*=10;
        RekNumbers(n,del);
    }
    return "\n"+"все цифры выведены";
}


//    Сумма цифр числа
//Дано натуральное число N. Вычислите сумму его цифр.
//При решении этой задачи нельзя использовать строки,
// списки, массивы (ну и циклы, разумеется).
    public static String RekSum(int n, int del, int sum){
            if(n>0){
            sum+=(n%del)/(del/10);
            n-=n%del;
            del*=10;
            RekSum(n,del, sum);
        }else{
            System.out.println("сумма числа: "+sum);//добавлен блок else без вызова метода RekSum,
                                                    //чтобы сразу вывести сумму на печать, а возвращем строку.
                                                    //Так не будет проблем с рекурсией при возврате суммы.
        }
        return "сумма посчитана";
    }
}
