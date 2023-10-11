package org.example;

import java.io.File;

public class Main extends Procesado{
    public static void main(String[] args) {

        leerArchivo(new File("archivos"+File.separator+"data.csv"));

    }
}