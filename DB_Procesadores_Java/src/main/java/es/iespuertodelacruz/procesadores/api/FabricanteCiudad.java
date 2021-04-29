package es.iespuertodelacruz.procesadores.api;

public class FabricanteCiudad {
    int codigoPostalFabricante;
    String ciudad;

    /**
     * 
     * @param codigoPostalFabricante
     * @param ciudad
     */
    public FabricanteCiudad(int codigoPostalFabricante, String ciudad) {
        this.codigoPostalFabricante = codigoPostalFabricante;
        this.ciudad = ciudad;
    }

    /**
     * Constructor vacio
     */
    public FabricanteCiudad() {
    }
}
