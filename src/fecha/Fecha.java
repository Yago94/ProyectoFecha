/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author 203p21
 */
public class Fecha {

    private int dia;
    private int mes;
    private int anno;
    private static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] nombresMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public Fecha(int dias, int mes, int anno) {
        this.dia = dias;
        this.mes = mes;
        this.anno = anno;

    }

    public Fecha() {
        Calendar c = new GregorianCalendar();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH) + 1;
        anno = c.get(Calendar.YEAR);
    }

    public void bisiesto() {
        if (anno % 4 == 0 && anno % 100 == 0 || anno % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    public void bisiesto(int anno) {
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    public boolean comprobarFecha(int a, int m, int d) {//comprueba que me ha introducido una fecha
        boolean resultado = false;
        if (a >= 1900 && a <= 2100) {
            bisiesto(a);
            if (m >= 1 && m <= 12) {
                if (d >= 1 && d <= diasMes[m - 1]) {
                    resultado = true;
                    dia = d;
                    mes = m;
                    anno = a;
                }
            }
        }
        return resultado;
    }

    public int compararFecha(Fecha f) {
        int resultado;
        if (anno > f.getAnno()) {
            resultado = 1;
        } else {
            if (anno < f.getAnno()) {
                resultado = -1;
            } else {
                if (mes > f.getMes()) {
                    resultado = 1;
                } else {
                    if (mes < f.getMes()) {
                        resultado = -1;
                    } else {
                        if (dia > f.getDia()) {
                            resultado = 1;
                        } else {
                            if (dia < f.getDia()) {
                                resultado = -1;
                            } else {
                                resultado = 0;
                            }
                        }
                    }
                }
            }
        }
        return resultado;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnno() {
        return anno;
    }

}
