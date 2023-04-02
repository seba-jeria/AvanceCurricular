/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avancecurricular;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ufo
 */
public class csv {
        public  void leerAlumno() {
      String ruta = "alumnos.csv";
      try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
         String linea;
         while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            for (String dato : datos) {
               System.out.print(dato + "\t"); // \t para separar las columnas
            }
            System.out.println(); // salto de línea para la siguiente fila
         }
      } catch (IOException e) {
         System.out.println("Error");
      }
   }
        public  void leerAsignatura() {
      String ruta = "asignaturas.csv";
      try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
         String linea;
         while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            for (String dato : datos) {
               System.out.print(dato+ "\t"); // \t para separar las columnas
            }
            System.out.println(); // salto de linea para la siguiente fila
        }
      } catch (IOException e) {
         System.out.println("Error");
      }
   }
}