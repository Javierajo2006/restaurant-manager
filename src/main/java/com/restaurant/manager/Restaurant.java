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
}
