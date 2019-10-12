/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ejer_parcial_calificaciones;

//Guardar en un vector las notas de N estudiantes, y luego:
//
//a. Mostrar el vector tal como fue ingresado, mostrar las notas de los
//      estudiantes que ganaron ordenados en forma decreciente y las notas de los que
//      perdieron ordenados en forma creciente.
//
//b. Elimine todas las notas del vector original que sean inferiores al promedio de notas.

import java.util.Scanner;


/**
*
* @author Felix Castro y Josue Caipa
*/
public class calificaciones {
   public static void main(String[] args) {
       //ingresamo datos por teclado en consola
       Scanner entrada = new Scanner(System.in);
       
       //Definimos variables
       double [] califiEstu;
       int cantEstu;
       
       System.out.println("CALIFICACIONES DE ESTUDIANTES");
       System.out.println("------------------------------");
       
       //solicitamos la cantidad de estudiante
       System.out.println("Ingrese la cantidad de estudiante");
       cantEstu = entrada.nextInt();
       
       //vector
       califiEstu = new double[cantEstu];
       
       System.out.println("------------------------------");
       
       //ingreamos la notas
       System.out.println("Registro de notas de cada estudiante en orden");
       for (int i = 0; i < cantEstu; i++) {
           System.out.println((i+1)+".Ingrese la nota del estudiante ");
           califiEstu[i] = entrada.nextDouble();
       }
       
       System.out.println("------------------------------");
       
       //imprimimos las notas en el orden ingresado
       System.out.println("Notas de los estudiantes por orden ingresado");
       for (int i = 0; i < cantEstu; i++) {
           System.out.println("El estudiante "+ (i+1)+ ""
                   + " obtuvo una nota de "+ califiEstu[i]);
       }
       
       //ordenamos por metodo insercion
       for (int i = 1; i < cantEstu; i++) {
           //buscamos la posicion correecta del elemento destino
           int j=i;
           double aux = califiEstu[i];
           //localizamos el punto de insercion buscando hacia abajo
           while (j>0 && aux<califiEstu[j-1]) {                
               califiEstu[j] = califiEstu[j-1];
               j--;
           }
           califiEstu[j] = aux;
       }
       
       //definimos promedio como constante
       double promNotas = 3;
       
       System.out.println("------------------------------");
       
       //imprimimos notas de los estudiantes que ganaron en forma decreciente
       System.out.println("Estudiantes que ganaron con promedio igual "
               + "o superior a 3 en orden decreciente");       
       for (int i = (cantEstu-1); i >= 0; i--) {
           if (califiEstu[i]>=promNotas) {
               System.out.println(califiEstu[i]);
           }
       }
       
       System.out.println("------------------------------");
       
       //imprimimos notas de los estudiantes que perdieron en forma creciente
       System.out.println("Estudiantes que perdieron con promedio menor "
               + "a 3 en orden creciente");       
       for (int i = 0; i < cantEstu; i++) {
           if (califiEstu[i]<promNotas) {
               System.out.println(califiEstu[i]);
           }
       }
       
       System.out.println("------------------------------");
       
       // aqui buscamos la nota menor al promedio y se elimina
       System.out.print("El promedio de las notas es :" + promNotas +"\n");
       
       System.out.println("------------------------------");
       
       int posicioneliminar = -1;
       for (int i=0; i < califiEstu.length; i++) {
           if(califiEstu[i] < promNotas){
                  posicioneliminar = i;
                  califiEstu[i] = 0;
                  if(posicioneliminar >= 0){
                       System.out.print("El dato en la posicion "
                               + posicioneliminar +" se eliminó.\n");
                   }else{
                       System.out.print("No se encontro el dato. " +"\n");
                   }
               }
        }       
       
       System.out.println("------------------------------");
       
        System.out.println("notas despues de eliminar");
        for (int i = 0; i < cantEstu; i++) {
            System.out.println(califiEstu[i]);
        }
        
        System.out.println("------------------------------");
        
        //mostramos las notas despues que se elimino
        System.out.println("notas despues de eliminar");
        for (int i = 0; i < cantEstu; i++) {
            System.out.println(califiEstu[i]);
       }
   }
}