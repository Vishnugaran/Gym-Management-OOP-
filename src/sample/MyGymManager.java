package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MyGymManager implements GymManager, Comparator<DefaultMember> {
    File file = new File("output.txt");
    int day,month,year;

    @Override
    public void addMember() {
        int option,age;
        String memberShipNumber;
        String name;
        String schoolName;

        Scanner sc = new Scanner(System.in);
        if (members.size() <= 100){
            System.out.println("\n"+"\t"+(100-members.size())+ "Members Can be Added");
            System.out.println("\t"+"------------------------");
            System.out.println("1 - Add Default Members ");
            System.out.println("2 - Add Student Members ");
            System.out.println("3 - Add Over60 Members ");
            System.out.println("------------------------------------------");
            System.out.print("Enter The Number : ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input");
                System.out.print("Please re enter...");
                System.out.print(">");
                sc.next();
            }

            option = sc.nextInt();

            switch (option) {

                case 1:
                    System.out.print("\n"+"Enter Membership Number : ");
                    memberShipNumber = sc.next();
                    System.out.print("Enter Membership Name : ");
                    name = sc.next();
                    for(int i=0;i<=1;i++) {
                        System.out.print("Enter Day : ");
                        day = sc.nextInt();
                        if (day >= 1 && day <= 31) {
                            i=2;
                        }else{
                            System.out.println("Invalid day re-enter");
                            i=0;
                        }
                    }
                    for(int i=0;i<=1;i++) {
                        System.out.print("Enter Month : ");
                        month = sc.nextInt();
                        if (month >= 1 && month <= 12) {
                            i=2;
                        }else{
                            System.out.println("Invalid Month re-enter");
                            i=0;
                        }
                    }
                    for(int i=0;i<=1;i++) {
                        System.out.print("Enter Year : ");
                        year = sc.nextInt();
                        if (year >= 1000 && year <= 9999) {
                            i=2;
                        }else{
                            System.out.println("Invalid Year re-enter");
                            i=0;
                        }
                    }

                    Date date = new Date(day,month,year);
                    DefaultMember dm = new DefaultMember(memberShipNumber,name,date);
                    members.add(dm);
                    System.out.println(members+"\n");
                    break;

                case  2:
                    System.out.print("\n"+"Enter Membership Number : ");
                    memberShipNumber = sc.next();
                    System.out.print("Enter Membership Name : ");
                    name = sc.next();
                    for(int i=0;i<=1;i++) {
                        System.out.print("Enter Day : ");
                        day = sc.nextInt();
                        if (day >= 1 && day <= 30) {
                            i=2;
                        }else{
                            System.out.println("Invalid day re-enter");
                            i=0;
                        }
                    }
                    for(int j=0;j<=1;j++) {
                        System.out.print("Enter Month : ");
                        month = sc.nextInt();
                        if (month >= 1 && month <= 12) {
                            j=2;
                        }else{
                            System.out.println("Invalid Month re-enter");
                            j=0;
                        }
                    }
                    for(int k=0;k<=1;k++) {
                        System.out.print("Enter Year : ");
                        year = sc.nextInt();
                        if (year >= 1000 && year<= 9999) {
                            k=2;
                        }else{
                            System.out.println("Invalid Year re-enter");
                            k=0;
                        }
                    }
                    System.out.print("School  Name : ");
                    schoolName = sc.next();

                    Date date1 = new Date(day,month,year);
                    DefaultMember dm1 = new StudentMember(memberShipNumber,name,date1,schoolName);
                    members.add(dm1);
                    System.out.println(members+"\n");
                    break;

                case 3:
                    System.out.print("\n"+"Enter Membership Number : ");
                    memberShipNumber = sc.next();
                    System.out.print("Enter Membership Name : ");
                    name = sc.next();
                    for(int i=0;i<=1;i++) {
                        System.out.print("Enter Day : ");
                        day = sc.nextInt();
                        if (day >= 1 && day <= 30) {
                            i=2;
                        }else{
                            System.out.println("Invalid day re-enter");
                            i=0;
                        }
                    }
                    for(int j=0;j<=1;j++) {
                        System.out.print("Enter Month : ");
                        year = sc.nextInt();
                        if (year >= 1 && year <= 12) {
                            j=2;
                        }else{
                            System.out.println("Invalid Month re-enter");
                            j=0;
                        }
                    }
                    for(int k=0;k<=1;k++) {
                        System.out.print("Enter Year : ");
                        month = sc.nextInt();
                        if (month >= 1000 && month <= 9999) {
                            k=2;
                        }else{
                            System.out.println("Invalid Year re-enter");
                            k=0;
                        }
                    }
                    System.out.print("Age : ");
                    age = sc.nextInt();



                    Date date2 = new Date(day,month,year);
                    DefaultMember dm2 = new Over60Member(memberShipNumber,name,date2,age);
                    members.add(dm2);
                    System.out.println(members+"\n");

                default:
                    System.out.println("Invalid Input");

            }
        }
        else{
            System.out.println("No More Spaces");
        }


    }

    @Override
    public void deleteMember() {
        System.out.println("\t"+"Delete Members Details");
        System.out.println("\t"+"----------------------");
        String memNo;
        Scanner sc = new Scanner(System.in);
        System.out.print("\n"+ "Enter the Membership No : ");
        memNo = sc.next();

        int count =0;
        for (int i = 0; i<members.size();i++){
            if (members.get(i).getMembershipNumber().equals(memNo)) {
                System.out.println("Delelted member " + members.get(i).getClass().getSimpleName());
                members.remove(i);
                System.out.println("Number of free spaces " + (100 - members.size())+"\n");
                i = members.size();
                count = 1;
            }
        }
        if(count==0){
            System.out.println("No membership found"+"\n");
        }
    }

    @Override
    public void printDetails() {
        System.out.println("\n"+"\t"+"Members List");
        System.out.println("\t"+"------------"+"\n");
        for (int i =0;i<members.size();i++){
            System.out.println(members.get(i).getMembershipNumber()+" "+members.get(i).getMemberName()+" "+members.get(i).getStartMembershipDate()+" "+members.get(i).getClass().getSimpleName()+"\n" );
        }
    }

    @Override
    public void sort() {
        System.out.println("\n"+"\t"+"Sort Out List");
        System.out.println("\t"+"--------------"+"\n");
        Collections.sort(members,new MyGymManager());
       // for (int i =0;i<members.size();i++){
         //   System.out.println(members.get(i).getMembershipNumber()+" "+members.get(i).getMemberName()+" "+members.get(i).getStartMembershipDate()+" "+members.get(i).getClass().getSimpleName()+"\" );
        //}
    }

    @Override
    public void writeAndSave() throws IOException {
        System.out.println("----------------------------------------"+"\n");
        FileWriter fileWriter = new FileWriter("output.txt",true);
        for (int i =0;i<members.size();i++){
            fileWriter.append(members.get(i).getMembershipNumber()+" "+members.get(i).getMemberName()+" "+members.get(i).getStartMembershipDate()+" "+members.get(i).getClass().getSimpleName()+"\n" );
        }
        fileWriter.close();

    }

    @Override
    public int compare(DefaultMember o1, DefaultMember o2) {
        return o1.getMemberName().compareTo(o2.getMemberName());
    }

}
