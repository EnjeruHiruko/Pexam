package Pexam.data.utility.Misc;

import java.util.Scanner;

public class GetCommand {
    public static String gc(String i){
        System.out.printf("%n%s",i);
        Scanner sc = new Scanner(System.in);
        String read = sc.nextLine();
        if("exit".equals(read)){
            sc.close();
            System.exit(1);
        }
        sc.close();
        return read;
    }
    public static void cs() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
