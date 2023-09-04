package com.example.myapplication;

public class Ave {
    private String especie;
    private int temperatura;
    private int periodoIncubacionDias;

    public Ave(String especie,int temperatura, int periodoIncubacionDias) {
        this.especie = especie;
        this.temperatura=temperatura;
        this.periodoIncubacionDias = periodoIncubacionDias;
    }
    public String getEspecie() {
        return especie;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getPeriodoIncubacionDias() {
        return periodoIncubacionDias;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public void setPeriodoIncubacionDias(int periodoIncubacionDias) {
        this.periodoIncubacionDias = periodoIncubacionDias;
    }


}
