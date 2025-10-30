package com.restaurant.manager;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal para gestionar un restaurante
 * @author Samuel Manrique, Miguel Acuña, Camila Beltran, Diego Negro y Javier Jaimes
 */
public class Restaurant {
    private String name;
    private List<String> menu;
    private double totalRevenue;

    /**
     * Constructor del restaurante
     *
     * @param name Nombre del restaurante
     */
    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
        this.totalRevenue = 0.0;
    }

    /**
     * Obtiene el nombre del restaurante
     *
     * @return nombre del restaurante
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene una copia del menú
     *
     * @return lista de items del menú
     */
    public List<String> getMenu() {
        return new ArrayList<>(menu);
    }

    /**
     * Obtiene los ingresos totales
     *
     * @return ingresos acumulados
     */
    public double getTotalRevenue() {
        return totalRevenue;
    }

    // TODO: Agregar métodos para gestionar menú y órdenes
    // Estos serán implementados por los developers en diferentes branches

    /**
     * Procesa una orden y actualiza los ingresos
     *
     * @param item  Nombre del item ordenado
     * @param price Precio de la orden
     * @throws IllegalArgumentException si el precio no es válido
     */
    public void processOrder(String item, double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo");
        }
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("El item no puede estar vacío");
        }
        totalRevenue += price;
    }

    /**
     * Obtiene el número aproximado de órdenes procesadas
     *
     * @return cantidad estimada de órdenes
     */
    public int getOrderCount() {
        // Simplificación: asumimos promedio de $10 por orden
        return (int) (totalRevenue / 10);
    }

    /**
     * Resetea los ingresos totales (para testing o nuevo período)
     */
    public void resetRevenue() {
        totalRevenue = 0.0;
    }
}
