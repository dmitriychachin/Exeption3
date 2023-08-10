import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        String[] input = parsing(input());
        surname(input);
        name(input);
        midName(input);
        birthDay(input);
        phone(input);
        gender(input);
        writeToFile(input);
    }

    public static  String input(){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите строку с данными\n (Строка должна быть:Фамилия Имя Отчество дата рождения номер телефона пол.\n Пример:Иванов Иван Иванович 10.01.1999 89751426578 m");
        String input = iScanner.nextLine();

        return input;

    }

    public static String[] parsing(String input) {
        StringBuilder temp = new StringBuilder();
        String[] res = new String[6];
        int k = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                temp.append(input.charAt(i));
            } else {
                res[k] = temp.toString();
                k++;
                i++;
            }
        }
        res[5] = temp.toString();


        return res;
    }

    public static void writeToFile(String[] input) throws IOException {
        String path = "D:/Android dev/Java_exites/" + input[0] + ".txt";
        File myFile = new File(path);
        FileOutputStream outputStream = new FileOutputStream(myFile);
        String res = "";
        for (int i = 0; i < input.length; i++){
            res =  res + "<" + input[i] + ">";
        }
        byte[] buffer = res.getBytes();
        outputStream.write(buffer);
        outputStream.close();
    }

    public static void surname(String[] input){
        String surname;
        if(input[0].matches("[а-яА-Я]+")){
            surname = input[0];
        }else{
            input[0] = chaek("Введите фамилию только буквами русского языка");
            surname(input);
        }

    }

    public static void name(String[] input){
        String name;
        if(input[1].matches("[а-яА-Я]+")){
            name = input[1];
        }else{
            input[1] = chaek("Введите имя только буквами русского языка");
            name(input);
        }


    }

    public static void midName(String[] input){
        String midName;
        if(input[2].matches("[а-яА-Я]+")){
            midName = input[2];
        }else{
            input[2] = chaek("Введите отчество только буквами русского языка");
            midName(input);
        }

    }

    public static void birthDay(String[] input) {
        String cal;
        if(input[3].matches("[01-31.01-12.0001-2023]")){
            cal =input[3];
        }else{
            input[3] = chaek("Вы не правильно ввели дату");
            birthDay(input);
        }
    }

    public static void phone(String[] input){
        String phone;
        if(input[4].length() == 11 && input[4].matches("[0-9]+")){
            phone = input[4];
        }else{
            input[4] = chaek("Вы неверно ввели номер телефона");
            phone(input);
        }

    }

    public static void gender(String[] input){
        String gender;
        if (input[5].equals("m")|| input[5].equals("f")){
            gender = input[5];
        }else{
            input[5] = chaek("Вы некорректоно ввели пол");
            gender(input);
        }

    }

    public static String chaek(String mes){
        Scanner iScanner = new Scanner(System.in);
        System.out.println(mes);
        String newValue = iScanner.nextLine();

        return newValue;
    }
}