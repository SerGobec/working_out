package content;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException{
        int menu = 0;
        Scanner scanner;
        // меню з вибором програми.
        while (true) {
            try {
                System.out.print("\n      MENU\n" +
                        "1.Завдання 5\n" +
                        "2.Завдання 8\n" +
                        "3.Завдання 9\n" +
                        "4.Завдання 17\n" +
                        "5.Завдання 19\n" +
                        "0.Вихід з програми\n       |_->");
                scanner = new Scanner(System.in);
                menu = scanner.nextInt();
            } catch (InputMismatchException exception){
                System.out.print("Введено символ.");
                continue;
            }
            /*
            task5();  //WORK!!!
            task8();  //WORK!!!
            task9(); //WORK!!!
            task17(); //WORK!!!
            task19(); //WORK!!!
            */
            switch (menu){
                case 0:
                    System.exit(0);
                case 1:
                    task5();
                    break;
                case 2:
                    task8();
                    break;
                case 3:
                    task9();
                    break;
                case 4:
                    task17();
                    break;
                case 5:
                    task19();
                    break;
                    default:
                        System.out.println("Введено невірне число.");
            }
        }

    }

        // Функція виведення масиву визначена в кінці класу!!!

    static void task5() {

        //У заданій послідовності цілих чисел знайти максимально довгу підпослідовність
        // чисел таку, що кожний наступний елемент підпослідовності ділився без остатку на попередній.

            int size;  // Розмір послідовності
            while (true) {      // Введення розміру масиву
                try {
                    System.out.println("Введіть довжину числової послідовності:");
                    Scanner scanner = new Scanner(System.in);
                    size = scanner.nextInt();
                } catch (InputMismatchException exception) {
                    System.out.println("Помилка.Спробуйте ще раз");
                    continue;
                }
                break;
            };
            if(size < 0){
                size = Math.abs(size);
        } else if(size == 0){
                System.out.println("Шутнічки) Нехай розмір буде 20");
             size = 20;
                }
            int[] mas = new int[size];  // Створення масиву
            for(int i = 0;i < size;i++){
            mas[i] = (int)(Math.random()*50+1);   // Заповнення масиву випадковими цислами Від 1 до 51
        };
            vivodmat(size, mas);        // Виведення масиву
            int ind_start = -1;
            int size_posl = 0;      // Змінні для алгоритму
            //--- Algoritm:
            for(int i = 1;i < size;i++){
                int max = 0;
              if(mas[i]%mas[i-1] == 0){
                max++;
                for(int j = i+1;j < size;j++){
                if(mas[j]%mas[j-1] == 0) {
                    max++;
                } else break;
                };
                if(max > size_posl){
                    size_posl = max;
                    ind_start = i - 1;
                }
              }
            };
            //---
        // Виведення результату
            if(ind_start == -1) {
                System.out.print("Послідовностей немає.");
            } else {
                System.out.println("Членів в послідовності: " + (size_posl+1) + ". Перший елемент " + (ind_start + 1) + "-ий");
                for(int i = ind_start;i <= ind_start+size_posl;i++){
                    System.out.print(mas[i]+" ");
                }
            }
    };

        ///

    static void task8(){

       // У музеї реєструється протягом дня час приходу і відходу
        // кожного відвідувача. Таким чином за день отримані N пар
        // значень, де перше значення у парі показує час приходу
        // відвідувача і друге значення - час його відходу. Знайти
        // проміжок часу, протягом якого в музеї одночасно перебувало
        // максимальне число відвідувачів.

        int kst_people = 0;  // Змінна для отримання кількості відвідувачів
        while (true) {  // Введення кількості відвідувачів
            try {

                System.out.print("Введіть кількість відвідувачів");
                Scanner scanner = new Scanner(System.in);
                kst_people = (int) (scanner.nextInt());
            } catch (InputMismatchException exception) {
            continue;
            }
            break;
        };
        if(kst_people == 0){
            System.out.print("ВІдвідувачів не було.");
        } else {
            if(kst_people < 0){ // В разі введеня від'ємного числа ми беремо модуль
                kst_people = Math.abs(kst_people);
            }
            int[] time_come = new int[kst_people];  // Час приходу відв.
            int[] time_back = new int[kst_people];  // Час виходу
            for (int i = 0; i < kst_people; i++) {  // Задання випадкогового часу приходу та покидання музею
                time_come[i] = (int)(Math.random()*23);
                time_back[i] = (int)(Math.random()*(23-time_come[i])+time_come[i]+1);
            };      // Час покидання не може бути < за час приходу.
            System.out.println("Часи приходу та відходу");
            for(int i = 0;i < kst_people;i++){
              System.out.println("Прийшов:" + time_come[i] + ". Пішов: " + time_back[i]);
            };  // Виведення часів
            int hour_max = -1, max_people = 0; //Змінні для кінцевого результату
            for(int i = 0;i < 24;i++){  // Алгоритм перевірки
              int men = 0;
              for(int j = 0;j < kst_people;j++){
                if((time_come[j] <= i)&&(time_back[j] >= i+1)){
                  men++;
                }
              };
              if(men > max_people){
                  hour_max = i;
                  max_people = men;
              };
            };
            // Виведення результату
            System.out.print("Найбільше людей було між " + hour_max + " та " + (hour_max+1) + " годинами. В цей час в музеї було " + max_people +" людей.");
        }
    }

        ///

    static void task9() throws IOException {

        //Дан масив X [1..N]. Необхідно циклічно зрушити його
        // на k елементів вправо (тобто елемент X [i] після
        // зсуву повинен стояти на місці X [i + k]; тут ми
        // вважаємо що за X [N] слід X [1]). Додаткового
        // масиву заводити не можна!

        int size, k;    // Змінні для розміру та ходу
        while (true) {      // Заповнення змінних
            try {
                System.out.print("Введіть розмір масиву: ");
                Scanner scanner = new Scanner(System.in);
                size = scanner.nextInt();
                System.out.print("Введіть крок циклічного зміщення");
                k = scanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("eror");
                continue;
            }
            break;
        }

        if(size == 0){  // Якщо ввели нуль, то нехай розмір по дефолту буде 10
            size = 10;
        } else if(size < 0){
            size = Math.abs(size);
        }
        int[] mas = new int[size];      // Створення масиву
        for(int i = 0;i < size;i++){
          mas[i] = (int)(Math.random()*20+1);   // Заповнення масиву випадковими числами від 1 до 21
        };
        vivodmat(size,mas); // Вивід матриці

        // Спосіб 1. Використовуючи FileReader and FileWriter (Адже в умові сказан ощо не можна створювати лише іншого масиву:)))
        // Я так розумію, що я мав створити алгоритм, тому він під цим способом
        /*
        FileWriter writer = new FileWriter("task9.txt");
        for(int i = 0;i < size;i++){
            writer.write(mas[i] + " ");
        };
        writer.close();
        FileReader reader = new FileReader("task9.txt");
        Scanner scanner1 = new Scanner(reader);
        for(int i = 0;i < size;i++){
            if(i + k >= size){
                mas[i + k - size] = scanner1.nextInt();
                continue;
            }
            mas[i + k] = scanner1.nextInt();
        }
        reader.close();
        vivodmat(size,mas);
        */
        //Спосіб 2. Алгоритм.
        int prox,prox2;     // Змінні для алгоритму
        for(int i = 0;i < k;i++){   //  Алгоритм
prox = mas[0];
mas[0] = mas[size - 1];
            for(int j = 1;j < size;j++){
            prox2 = mas[j];
            mas[j] = prox;
            prox = prox2;
            };
        };
        System.out.println("Матриця після зсуву.");
        vivodmat(size,mas);     //Виведення зсунутої матриці.
    };

    ///

    static void task17(){

        //Вводиться послідовність з n натуральних чисел.
        // Необхідно визначити найменше натуральне число,
        // якого немає у послідовності.

        int n;  //  Кількість членів в послідовності
        Scanner scanner;
        while (true) {
            try {
                System.out.print("Введіть кількість чисел ");
                scanner = new Scanner(System.in);
                n = scanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.print("error...");
                continue;
            }
            break;
        };
        if(n < 0){
            n = Math.abs(n);
        } else if(n == 0){
            n = (int)(Math.random()*9+1);
            System.out.print("Кількість цисел в ряді: " + n);
        };
        int[] mas = new int[n];
        for(int i = 0;i < n;i++){   //Введення всіх членів послідовності
            System.out.println("Введіть " + (i+1) + "-е натуральне число.");
            try {
                scanner = new Scanner(System.in);
                mas[i] = scanner.nextInt();
            } catch (InputMismatchException exception){
              System.out.println("error...");
                i--;
                continue;
            };

            if(mas[i] < 0){
                mas[i] = Math.abs(mas[i]);
            }  else if(mas[i] == 0){
              System.out.println("0 це не натуральне число)");
              i--;
            };

        };
        int nat_chislo = 0; //Змінна для кінцевого результату
        boolean exit = true;
        do{ //Алгоритм пошуку
        nat_chislo++;
            for(int i = 0; i < n;i++){
                if(nat_chislo == mas[i]){
                    break;
                }
                if(i == n - 1){
                  exit = false;
                };
            }
        } while (exit);
        // Виведення результату
        System.out.println("Найменше натуральне число якого нема в ряді: " + nat_chislo);
    };

    ///

    static void task19(){

        //Написати програму визначення кількості шестизначних
        // 'щасливих' квитків, у яких сума перших 3 десяткових
        // цифр дорівнює сумі 3 останніх десяткових цифр.

        int num = 0, num_luc = 0;   //Змінні для кількості квитків та кількості щастливих квитків
        Scanner scanner;
        while (true) {  //Введення кількості квитків
            try {
                System.out.print("Введіть кількість квитків:");
                scanner = new Scanner(System.in);
                num = scanner.nextInt();
                int prov = 1/num;   // Перевірка на нуль

            } catch (InputMismatchException exception) {
                System.out.println("\nerror...");
                continue;
            } catch (ArithmeticException e){    //Дія якщо число квитків 0
              System.out.print("З 0 квитків 0 буде щастливими)");
              System.exit(0);
            };
            break;

        };

        if(num < 0){
          num = Math.abs(num);
        };

        for(int i = 0;i < num;i++){ //Введення номерів квитків та знаходження щастливиз
          int kvt;
            while (true) {  //Перевірка щоб не ввели символ
                try {
                    System.out.print("Введіть номер " + (i+1) + "-го квитка.");
                    scanner = new Scanner(System.in);
                    kvt = scanner.nextInt();

                } catch (InputMismatchException exception) {
                    System.out.println("\nerror...");
                    continue;
                }
                break;
            };

            if(kvt <= 0){
                kvt = Math.abs(kvt);
            };
            if((kvt/100000 > 9)||(kvt/100000 < 1)){ // Перевірка на шестизначність
                System.out.print("Ви ввели не шестизначне число. Спробуйте ще раз.");
                i--;
                continue;
            };
            if((kvt/100000)+(kvt/10000%10)+(kvt/1000%10) == (kvt/100%10)+(kvt/10%10)+(kvt%10)){
                num_luc++;
            };
        };
        //  Виведення кількості щастливих квитків
        System.out.print("З " + num + " квитків " + num_luc + " виявилися щастливими.");

    };

    ///
    static void vivodmat(int s,int[] ma){
        // Фкнкція для виводу масиву.
        for(int i = 0;i < s;i++){
            System.out.print(ma[i] + " ");
        }
        System.out.println(" ");
    }

    ///
};

