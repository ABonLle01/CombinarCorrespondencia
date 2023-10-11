package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Procesado {



    public static void leerArchivo(File f){

        try(BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line = null;
            ArrayList lista = new ArrayList();
            String[] linea;

            while((line = br.readLine())!=null){
                System.out.println(line = br.readLine());
                linea=line.split(";");
                lista.add(linea[3]);
            }
            System.out.println(lista);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





}
