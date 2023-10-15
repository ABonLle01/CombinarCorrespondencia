package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Procesado {

    /**
     * Lee un archivo CSV y devuelve los datos en una lista.
     *
     * @param f Archivo CSV a leer.
     * @return Una lista de arrays de cadenas que representan los datos del archivo CSV.
     */
    public static List<String[]> leerArchivo(File f){

        List<String[]> datos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] linea = line.split(",");
                datos.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos;
    }

    /**
     * Lee el contenido de un archivo de texto y lo devuelve como una cadena.
     *
     * @param f Archivo de texto a leer.
     * @return El contenido del archivo como una cadena.
     */
    public static String leerContenidoArchivo(File f) {
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                contenido.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contenido.toString();
    }

    /**
     * Escribe un contenido en un archivo.
     *
     * @param nombreArchivo Nombre del archivo de salida.
     * @param contenido  Contenido a escribir en el archivo.
     */
    public static void escribirArchivo(String nombreArchivo, String contenido) {
        try (FileWriter w = new FileWriter(nombreArchivo)) {
            w.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Vacia una carpeta eliminando su contenido.
     *
     * @param carpeta Carpeta a vaciar.
     */
    public static void vaciarCarpeta(File carpeta) {
        File[] archivos = carpeta.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    vaciarCarpeta(archivo);
                } else {
                    archivo.delete();
                }
            }
        }
    }

}
