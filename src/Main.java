package SortingJava;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    static int[] lstData=new int[5];
    public static void main(String[] args) {
        int pilihMenu=0;
        while (pilihMenu != 6){
            System.out.print ( "\nSelamat Datang di Program Simulasi \n"
                    + "Menu:\n"
                    + "1. Random Data \n"
                    + "2. Simulasi Bubble Sort - Ascending \n"
                    + "3. Simulasi Selection Sort - Ascending \n"
                    + "4. Simulasi Bubble Sort - Descending \n"
                    + "5. Simulasi Selection Sort - Descending \n"
                    + "6. Keluar \n"
                    + "Masukan Pilihan Anda: \n");

            pilihMenu=in.nextInt();
            switch (pilihMenu){
                case 1:
                    randomData();
                    break;
                case 2:
                    BubbleSort();
                    break;
                case 3:
                    selectionSort();
                    break;
                case 4:
                    BubbleSort(false);
                    break;
                case 5:
                    selectionSort(false);
                    break;
                case 6:
                    break;
            }
        }
    }

    static void randomData(){
        //input batas bawah
        System.out.println();
        System.out.print ( "Batas Bawah = ");
        int batasBawah=in.nextInt();
        //input batas atas
        System.out.print ( "Batas Atas = ");
        int batasAtas=in.nextInt();
        for (int i=1;i<=5;i++){
            lstData[i-1]=(int)(batasBawah + (int) (Math.random() * (batasAtas -
                    batasBawah + 1)));
        }

        //hasil
        printData();
    }

    //BubbleSort Ascending
    static void BubbleSort(){
        BubbleSort(true);
    }

    //BubbleSort Descanding
    static void BubbleSort(boolean asc){
        for (int i=1;i<lstData.length;i++){
            System.out.print("Pass "+ i+ "\n");
            for (int j=0;j<lstData.length-i;j++){
                //pilih & tukar
                selectBySort(asc,j);
                //hasil data
                printData();
            }

            //hasil akhir
            System.out.print("\n Result of Pass "+ i+ "\n");
            printData();
        }
    }

    //Swap method BubbleSort Descanding
    static void selectBySort(
            boolean asc,
            int currentNumber){
        if (asc){
            if (lstData[currentNumber]>lstData[currentNumber+1])
                swap(currentNumber,currentNumber+1);
        }
        else{
            if (lstData[currentNumber]<lstData[currentNumber+1])
                swap(currentNumber,currentNumber+1);
        }

    }

    static void swap(int angka1, int angka2 ){
        int swapPlace;
        swapPlace=lstData[angka1];
        lstData[angka1]=lstData[angka2];
        lstData[angka2]=swapPlace;
    }

    //SelectingSort Ascending
    static void selectionSort(){
        selectionSort(true);
    }

    //SelectingSort Descanding
    static void selectionSort(boolean asc){
        for (int i=0;i<lstData.length-1;i++){
            //Tampilkan pesan
            System.out.print("\n Pass "+ (i+1) + "\n");
            //mencari angka minimum pada list
            int angkaMin=lstData[i];
            int swapAngkaMin=i;
            for (int j=i+1;j<lstData.length;j++){
                if (asc){
                    if (angkaMin>lstData[j]){
                        angkaMin=lstData[j];
                        swapAngkaMin=j;
                    }
                }
                else{
                    if (angkaMin<lstData[j]){
                        angkaMin=lstData[j];
                        swapAngkaMin=j;
                    }
                }
                //print list of Data
                printData();
            }
            //swap list
            if (swapAngkaMin!=i){
                lstData[swapAngkaMin]=lstData[i];
                lstData[i]=angkaMin;
            }
            //display messege
            System.out.print("\n Result of Pass "+ (i+1)+ "\n");
            printData();
        }
    }

    static void printData(){
        for (int i=0;i< lstData.length ;i++){
            //cetak hasil
            System.out.print(lstData[i]+ " ");
        }
        System.out.print("\n");
    }
}

