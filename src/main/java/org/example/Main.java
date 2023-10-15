package org.example;

import java.io.File;
import java.util.List;

public class Main extends Procesado{
    public static void main(String[] args) {
        List<String[]> datos = leerArchivo(new File("data.csv"));

        String plantilla = Procesado.leerContenidoArchivo(new File("template.txt"));

        File carpetaSalida = new File("salida");
        if (carpetaSalida.exists()) {
            vaciarCarpeta(carpetaSalida);
            System.out.println("Carpeta vaciada");
        } else {
            carpetaSalida.mkdir();
            System.out.println("Carpeta creada");
        }

        reemplazarDatos(datos, plantilla);

    }

    /**
     * Reemplaza los datos en una plantilla y crea archivos de salida basados en una lista de datos y una plantilla dada.
     *
     * @param datos     La lista de datos que se utilizaran para reemplazar en la plantilla.
     * @param plantilla La plantilla que contiene marcadores a reemplazar.
     */
    private static void reemplazarDatos(List<String[]> datos, String plantilla) {
        int lineaActual = 1;
        for (String[] campo : datos) {
            if (campo.length < 5) {
                mostrarErrorDatos(lineaActual);
            } else {
                int id = Integer.parseInt(campo[0]);
                String nombreEmpresa = campo[1];
                String ciudad = campo[2];
                String correo = campo[3];
                String nombreContacto = campo[4];

                if (marcadoresIncorrectos(plantilla)) {
                    mostrarErrorPlantilla();
                } else {
                    String contenido = reemplazarMarcadores(plantilla, id, nombreEmpresa, ciudad, correo, nombreContacto);
                    String nuevoArchivo = "salida/template-" + id + ".txt";
                    escribirArchivo(nuevoArchivo, contenido);
                }
            }
            lineaActual++;
        }
        System.out.println("Cambios realizados");
    }

    /**
     * Muestra un mensaje de error cuando faltan datos en una línea del archivo CSV.
     *
     * @param linea El numero de línea en la que se encontro el error.
     */
    private static void mostrarErrorDatos(int linea) {
        System.err.println("Error en la línea " + linea + " del archivo CSV: Faltan datos.");
    }

    /**
     * Verifica si la plantilla contiene marcadores incorrectos.
     *
     * @param plantilla La plantilla de texto a verificar.
     * @return true si la plantilla contiene marcadores incorrectos, de lo contrario, false.
     */
    private static boolean marcadoresIncorrectos(String plantilla) {
        return !plantilla.contains("%%2%%") || !plantilla.contains("%%4%%") ||
                !plantilla.contains("%%3%%") || !plantilla.contains("%%5%%");
    }

    /**
     * Muestra un mensaje de error cuando la plantilla contiene marcadores incorrectos.
     */
    private static void mostrarErrorPlantilla() {
        System.err.println("Error: La plantilla contiene marcadores incorrectos.");
    }

    /**
     * Reemplaza los marcadores en la plantilla con los datos y devuelve el contenido resultante.
     *
     * @param plantilla        La plantilla de texto que contiene los marcadores.
     * @param id               El ID a reemplazar en la plantilla.
     * @param nombreEmpresa    El nombre de la empresa a reemplazar en la plantilla.
     * @param ciudad           La ciudad a reemplazar en la plantilla.
     * @param correo           El correo a reemplazar en la plantilla.
     * @param nombreContacto   El nombre de contacto a reemplazar en la plantilla.
     * @return El contenido de la plantilla con los marcadores reemplazados por los datos.
     */
    private static String reemplazarMarcadores(String plantilla, int id, String nombreEmpresa, String ciudad, String correo, String nombreContacto) {
        return plantilla.replace("%%1%%", String.valueOf(id))
                .replace("%%2%%", nombreEmpresa)
                .replace("%%4%%", ciudad)
                .replace("%%3%%", correo)
                .replace("%%5%%", nombreContacto);
    }


}