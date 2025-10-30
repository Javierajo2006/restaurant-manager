package com.restaurant.manager;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal para gestionar un restaurante
 * @author Samuel Manrique, Miguel Acuña, Camila Beltran, Diego Negro y Javier Jaimes
 */
public class    Restaurant {
    private String name;
    private List<String> menu;
    private double totalRevenue;

    /**
     * Constructor del restaurante
     * @param name Nombre del restaurante
     */
    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
        this.totalRevenue = 0.0;
    }

    /**
     * Obtiene el nombre del restaurante
     * @return nombre del restaurante
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene una copia del menú
     * @return lista de items del menú
     */
    public List<String> getMenu() {
        return new ArrayList<>(menu);
    }

    /**
     * Obtiene los ingresos totales
     * @return ingresos acumulados
     */
    public double getTotalRevenue() {
        return totalRevenue;
    }

    // TODO: Agregar métodos para gestionar menú y órdenes
    // Estos serán implementados por los developers en diferentes branches

    /**
     * Calcula el valor promedio de las órdenes
     * @return promedio de ingresos por orden
     */
    public double getAverageOrderValue() {
        int orderCount = getOrderCount();
        if (orderCount == 0) {
            return 0.0;
        }
        return totalRevenue / orderCount;
    }

    /**
     * Verifica si el restaurante está generando buenos ingresos
     * @param threshold Umbral mínimo de ingresos
     * @return true si los ingresos superan el umbral
     */
    public boolean isPerformingWell(double threshold) {
        return totalRevenue >= threshold;
    }

    /**
     * Obtiene un resumen del estado del restaurante
     * @return String con estadísticas
     */
    public String getStatisticsSummary() {
        return String.format(
                "Restaurant: %s%n" +
                        "Items en menú: %d%n" +
                        "Reservas activas: %d%n" +
                        "Órdenes procesadas: %d%n" +
                        "Ingresos totales: $%.2f%n" +
                        "Valor promedio por orden: $%.2f",
                name,
                menu.size(),
                reservations.size(),
                getOrderCount(),
                totalRevenue,
                getAverageOrderValue()
        );
    }

}
