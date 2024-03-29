package com.example.app_pago.exception;

public class PrestamosReponse<T> {
    
    private final int status;
    private final String mensaje;
    private final T data;

    public PrestamosReponse(int status, String mensaje, T data) {
        this.status = status;
        this.mensaje = mensaje;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public T getData() {
        return data;
    }
}
