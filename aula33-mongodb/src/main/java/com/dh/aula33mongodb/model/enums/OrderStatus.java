package com.dh.aula33mongodb.model.enums;

public enum OrderStatus {

    AGENDADA(1),
    PARA_COMECAR(2),
    AO_VIVO(3),
    ENCERRADA(4);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    private int getCode() {
        return code;
    }

    public static OrderStatus valorOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}


