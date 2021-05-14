package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static javafx.application.Platform.exit;

public class Main extends Application {
    ArrayList<DefaultMember> dm_list = new ArrayList<>();
    int count =0;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Gym Management");
        Scanner s = new Scanner(new File("output.txt"));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNext()){
            list.add(s.nextLine());
        }
        s.close();
        TableView tableView = new TableView();
        TextField textField = new TextField();
        Button button = new Button("Search");

        TableColumn<String, DefaultMember> column1 = new TableColumn<>("Member NO");
        TableColumn<String, DefaultMember> column2 = new TableColumn<>("Name");
        TableColumn<String, DefaultMember> column3 = new TableColumn<>("Date");
        TableColumn<String, DefaultMember> column4 = new TableColumn<>("Member type");
        column1.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));
        column2.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        column3.setCellValueFactory(new PropertyValueFactory<>("startMembershipDate"));
        column4.setCellValueFactory(new PropertyValueFactory<>("type"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);

        System.out.println(list);
        for(  int i =0;i<list.size();i++) {
            String[] str = list.get(i).split(" ");
            String[] dat = str[2].split("/");
            System.out.println(Arrays.toString(str));

            Date date = new Date(Integer.valueOf(dat[0]), Integer.valueOf(dat[1]), Integer.valueOf(dat[2]));
            DefaultMember defaultMember = new DefaultMember(str[0], str[1], date, str[3]);
            tableView.getItems().add(new DefaultMember(str[0], str[1], date, str[3]));
            dm_list.add(defaultMember);

        }

        button.setOnAction(event -> {
            String text = textField.getText();
            for(int i=0;i<dm_list.size();i++){
                if(text.equals(dm_list.get(i).getMembershipNumber())) {
                    count=1;
                    tableView.getItems().setAll(new DefaultMember(dm_list.get(i).getMembershipNumber(), dm_list.get(i).getMemberName(), dm_list.get(i).getStartMembershipDate(), dm_list.get(i).getType()));
                    i=dm_list.size(); //for loop break
                }
                if(text.equals("") && count == 1){
                        tableView.getItems().remove(new DefaultMember(dm_list.get(i).getMembershipNumber(), dm_list.get(i).getMemberName(), dm_list.get(i).getStartMembershipDate(), dm_list.get(i).getType()));
                    }

                }

            if(text.equals("") && count == 1){
                for( int j =0;j<list.size();j++) {
                    String[] str = list.get(j).split(" ");
                    String[] dat = str[2].split("/");
                    Date date = new Date(Integer.valueOf(dat[0]), Integer.valueOf(dat[1]), Integer.valueOf(dat[2]));
                    DefaultMember defaultMember = new DefaultMember(str[0], str[1], date, str[3]);
                    tableView.getItems().add(j,new DefaultMember(str[0], str[1], date, str[3]));
                    count=0;

                }
            }

        });
        HBox hBox = new HBox(button, textField);//Add choiceBox and textField to hBox
        VBox vbox = new VBox(tableView,hBox);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }


    public static void main(String[] args) throws IOException {

        int option;
        do {

            MyGymManager mgm = new MyGymManager();
            Scanner input = new Scanner(System.in);
            System.out.println("\t"+"\t"+"GYM MANAGER ADDMISSION");
            System.out.println("\t"+"\t"+"**********************"+"\n");
            System.out.println("1 - Add Members");
            System.out.println("2 - Delete Members");
            System.out.println("3 - Print Members List");
            System.out.println("4 - Sort Members List");
            System.out.println("5 - Save Members List");
            System.out.println("6 - Open Gui");
            System.out.println("7 - Exit");
            System.out.println("-------------------------------------------");
            System.out.print("Enter The Number : ");
            while (!input.hasNextInt()) {
                System.out.println("\n"+"----Your Input is Wrong----- ");
                System.out.print("\n"+"Please Enter the Number Again :");
                input.next();
            }


            option = input.nextInt();

            switch (option) {
                case 1:
                    mgm.addMember();
                    break;
                case 2:
                    mgm.deleteMember();
                    break;
                case 3:
                    mgm.printDetails();
                    break;
                case 4:
                    mgm.sort();
                    break;
                case 5:
                    mgm.writeAndSave();
                    break;
                case 6:
                    launch(args);
                    break;

                case 7:
                    exit();
                    break;

                default:
                    System.out.println("Invalid Input");
                    main(args);
            }
        }while (option >=1 && option <= 6);
    }
}
