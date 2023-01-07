import java.util.Scanner;
import java.io.*;
import java. io. BufferedReader;
import java.io. BufferedWriter;
import java.io.File;
import java.io. FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class Main {
    public static void add() {

        File file = new File("test.txt"); //behet hapja e file nese nuk egziston krijohet
        try {
            FileWriter fw = new FileWriter(file,true); //vendoset append "true" qe te shtojm ne file jo te mbivendosim

            Scanner input = new Scanner(System.in);
            String emri = null;
            String mbiemri = null;
            String emriSkuadres = null;

            // marrim te dhenat nga perdoruesi
            System.out.println("Vendos emrin e lojtarit te ri: ");
            emri = input.next();

            System.out.println("Vendos mbiemrrin e lojtarit te ri: ");
            mbiemri = input.next();

            System.out.println("Vendos emrin e skuadres se lojtarit te ri e lojtarit te ri: ");
            emriSkuadres = input.next();

            // i vendosim te dhenat ne file duke i ndare me " "
            fw.write(emri+" "+mbiemri+" "+emriSkuadres + "\n");

            fw.close();  // mbyllim file
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    public static void remove(String filename, String emri,int pozicioni, String ndarja) {

        int position = pozicioni - 1;  // lehtesi per perdoruesin pasi programi e nis numerimin nga 0

        // hapim nje file temp ku do te hidhen te dhenat pa infot qe duam te fshijm
        String tempFile = "temp.txt";
        File oldFile = new File(filename);
        File newFile = new File(tempFile);
        String currentLine;
        String data[];
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);


            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(" ");
                //bejm kontrollin per gjetjen e emrit
                // nese emri nuk gjendet e printojm ate rresht ne file temp
                if (!(data[position].equalsIgnoreCase(emri)))
                    pw.println(currentLine);
            }

            // bejm mbylljen e file
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            //fshijm file e vjeter dhe file "temp" e riemertojm
            oldFile.delete();
            File dump = new File(filename);
            newFile.renameTo(dump);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void rename(String filename, String emri,int pozicioni, String ndarja) {
        Scanner input = new Scanner(System.in);
        int position = pozicioni - 1;  // lehtesi per perdoruesin pasi programi e nis numerimin nga 0

        // hapim nje file temp ku do te hidhen te dhenat pa infot qe duam te fshijm
        String tempFile = "temp.txt";
        File oldFile = new File(filename);
        File newFile = new File(tempFile);
        String currentLine;
        String data[];
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            //bejm kontrollin per gjetjen e emrit
            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(" ");

                // nese emri nuk gjendet e printojm ate rresht ne file temp
                if (data[position].equalsIgnoreCase(emri)) {
                    System.out.println("Vendos emrin e ri");
                    data[position] = input.next();
                    pw.println(data[position] +" "+ data[position + 1] +" "+ data[position + 2]);
                }
                else if (!(data[position].equalsIgnoreCase(emri)))
                    pw.println(currentLine);


            }
            // bejm mbylljen e file
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            //fshijm file e vjeter dhe file "temp" e riemertojm
            oldFile.delete();
            File dump = new File(filename);
            newFile.renameTo(dump);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Zgjidh veprimin:");
        int n=input.nextInt();
        if(n==1){
            add();}
        else if (n==2) {
            System.out.println("Vendos lojtarin qe do fshihet");
            String emri_fshihet = input.next();
            remove("test.txt", emri_fshihet, 1, " ");
        }
        else if (n==3) {
            System.out.println("Vendos lojtarin qe do zevendesohet");
            String emri_zevendesohet = input.next();
            remove("test.txt", emri_zevendesohet, 1, " ");
        }
    }
}