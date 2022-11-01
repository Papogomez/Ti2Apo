package ui;


import model.Conectar;
import model.Lector;
import model.Metodos;
import model.Pais;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    private Conectar control;

    private Metodos metodos;
    private Scanner sc;
    private Scanner sc1;

    private Lector lector;

    public Main() {
        control = new Conectar();
        sc = new Scanner(System.in);
        sc1 = new Scanner(System.in);
        metodos = new Metodos();
        lector = new Lector();
    }

    public static void main(String[] args) {

        System.out.println("Starting app");

        Main ppal = new Main();

        int option = 0;

        do {
            option = ppal.showMenu();
            ppal.executeOperationCommand(option);


        } while (option != 0);

    }

    public int showMenu() {
        int option = 0;

        System.out.println(
                "Select an option to start\n" +
                        "(1) Insert command\n" +
                        "(2) Import data from file .SQL\n" +
                        "(3) Exit\n" +
                        "Enter option"
        );
        option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public void executeOperationCommand(int operation) {

        switch (operation) {
            case 1:
                insertCommand();
                break;

            case 2:
                cargarArchivo();
                break;

            case 3:

                break;
            default:
                System.out.println("Error, optionn invalid");
        }

    }

    public void cargarArchivo(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        Path path = Paths.get("");

        try {
            archivo = new File ("doc/archivos/comandos.sql");
            fr = new FileReader (archivo);

            FileInputStream fis = new FileInputStream(archivo);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(fis)
            );
            String line;
            while(( line = reader.readLine()) != null){
                System.out.println(line);
                insertCommand(line);
            }
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertCommand() {

        System.out.println("Insert command");
        String insertCommand = sc.nextLine();

        if (insertCommand.toLowerCase().contains("insert")) {
            executeComandInsert(insertCommand);
        } else if (insertCommand.toLowerCase().contains("select")) {
            executeCommandSelect(insertCommand);
        } else if (insertCommand.toLowerCase().contains("delete")) {
            executeCommandDelete(insertCommand);
        }
    }

    public void insertCommand(String command) {

        if (command.toLowerCase().contains("insert")) {
            executeComandInsert(command);
        } else if (command.toLowerCase().contains("select")) {
            executeCommandSelect(command);
        } else if (command.toLowerCase().contains("delete")) {
            executeCommandDelete(command);
        }
        }
    public void executeCommandDelete(String command) {
        Connection connect;
        connect = control.getConexion();
        try {
            PreparedStatement pstmt = connect.prepareStatement(command);
            pstmt.executeUpdate();
            connect.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el registro: " + ex.getMessage());
        }
    }

    public void executeComandInsert(String command) {
        Connection connect;
        connect = control.getConexion();
        try {
            PreparedStatement pstmt = connect.prepareStatement(command);
            pstmt.executeUpdate();
            connect.close();
            System.out.println("Registro completado");
        } catch (SQLException ex) {
            System.out.println("Error al ingresar comando: " + ex.getMessage());
        }
    }

    public void executeCommandInsert(String command) {
        Connection connect;
        connect = control.getConexion();
        String id;
        String name;
        double population = 0.0;
        String countryCode;
        String citiesId;
        String p;

        Pais pais = new Pais();

        try {
            PreparedStatement pstmt = connect.prepareStatement(command);
            if (command.toLowerCase().contains("countries")) {
                id = metodos.getUUID();
                System.out.println("Id: " + id);
                System.out.println("ingrese el nombre: ");
                name = sc.nextLine();
                System.out.println("ingrese el population");
                p = sc.next();
                System.out.println("ingrese el country code");
                countryCode = sc.nextLine();


                try {
                    population = DecimalFormat.getNumberInstance().parse(p).doubleValue();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                pais.setId(id);
                pais.setName(name);
                pais.setPopulation(population);
                pais.setCountryCode(countryCode);
                metodos.insertarPaises(pais);


            } else if (command.toLowerCase().contains("cities")) {
                id = metodos.getUUID();
                System.out.println("Id: " + id);
                System.out.println("ingrese el nombre: ");
                name = sc.nextLine();
                System.out.println("ingrese el population");
                p = sc.next();
                System.out.println("ingrese el cities id");
                citiesId = sc.next();


                try {
                    population = DecimalFormat.getNumberInstance().parse(p).doubleValue();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                pais.setId(id);
                pais.setName(name);
                pais.setPopulation(population);
                pais.setCountryCode(citiesId);
                metodos.insertarPaises(pais);

            }


        } catch (SQLException ex) {
            System.out.println("Error al insertar el registro: " + ex.getMessage());
        }

    }

    public void executeCommandSelect(String command) {
        Connection connect;
        connect = control.getConexion();
        try {
            PreparedStatement pstmt = connect.prepareStatement(command);
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                if (command.toLowerCase().contains("countries")) {
                    System.out.println("ID: " + rs.getString("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Pupulation: " + rs.getDouble("population"));
                    System.out.println("Country Code: " + rs.getString("countrycode"));
                    System.out.println("-----------------------");

                } else if (command.toLowerCase().contains("cities")) {
                    System.out.println("ID: " + rs.getString("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Country ID: " + rs.getString("countryid"));
                    System.out.println("Population: " + rs.getDouble("population"));
                    System.out.println("-----------------------");

                }else{
                    System.out.println("No se encontro registro");
                }
            }
            connect.close();
        } catch (SQLException ex) {
            System.out.println("Error al ingresar comando: " + ex.getMessage());
        }

    }
}
