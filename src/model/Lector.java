package model;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static java.lang.System.in;

public class Lector {

/*
    public void lectorArchivo() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:\\comandos\\comandos.sql"));

            String str;

            while ((str = in.readLine()) != null) {
                str = in.readLine();
            }

            // Cerrar los archivos
            in.close();
        } catch (IOException e) {
            String mensaje = "Error al leer el archivo \n" + e.getMessage();
            System.out.println(mensaje);
        }

    }
 */

    public void lectorArchivo() {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;


        try {
            archivo = new File ("C:/comandos/comandos.sql");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            File file = new File("C:\\Users\\papog\\OneDrive\\Escritorio\\Interfaces Graficas\\t2Apo\\doc\\archivos\\comandos.sql");
            FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int readBytes = 0;
            byte[] buffer = new byte[128];
            while ((readBytes = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, readBytes);
            }
            fis.close();
            baos.close();

            String text = baos.toString(StandardCharsets.UTF_8);
            System.out.println(text);
            //JSON


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
