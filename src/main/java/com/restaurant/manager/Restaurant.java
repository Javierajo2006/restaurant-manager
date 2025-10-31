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
    private List<String> reservations;

    /**
     * Constructor del restaurante
     * @param name Nombre del restaurante
     */
    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
        this.totalRevenue = 0.0;
        this.reservations = new ArrayList<>();
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

    
    public void makeReservation(String customerName, int partySize, String dateTime) {
    if (customerName == null || customerName.trim().isEmpty()) {
        throw new IllegalArgumentException("El nombre del cliente es requerido");
    }
     if (partySize <= 0) {
        throw new IllegalArgumentException("El tamaño del grupo debe ser positivo");
    }
    if (dateTime == null || dateTime.trim().isEmpty()) {
        throw new IllegalArgumentException("La fecha y hora son requeridas");
    }
     String reservation = String.format("%s - %d personas - %s",
            customerName.trim(), partySize, dateTime.trim());
    reservations.add(reservation);
}
public List<String> getReservations() {
    return new ArrayList<>(reservations);
}

public int getReservationCount() {
    return reservations.size();
}
public boolean cancelReservation(String customerName) {
    if (customerName == null || customerName.trim().isEmpty()) {
        return false;
    }
    return reservations.removeIf(res -> res.startsWith(customerName.trim()));
}


    /**
     * Agrega un item al menú con su precio
     * @param item Nombre del item
     * @param price Precio del item
     * @throws IllegalArgumentException si el item está vacio o el precio es negativo
     */
    public void addMenuItem(String item, double price) {
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del item no puede estar vacío");
        }
        if (price < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        String menuItem = item + " - $" + String.format(java.util.Locale.US, "%.2f", price);
        menu.add(menuItem);
    }
    /**
     * Remueve un item del menú por nombre
     * @param item Nombre del item a remover
     * @return true si el item fue removido, false si no existía
     */
    public boolean removeMenuItem(String item) {
        if (item == null || item.trim().isEmpty()) {
            return false;
        }
        return menu.removeIf(menuItem -> menuItem.startsWith(item.trim()));
    }
    /**
     * Obtiene el número de items en el menú
     * @return cantidad de items
     */
    public int getMenuSize() {
        return menu.size();
    }

}

