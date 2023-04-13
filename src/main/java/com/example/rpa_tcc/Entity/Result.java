package com.example.rpa_tcc.Entity;

import lombok.Data;

@Data
public class Result {

    private double totalColab;
    private double totalCustoDev;
    private double totalCustoSuporte;
    private double totalCustoMaq;
    private double totalCustoService;

    private double totalColabAno;
    private double totalCustoDevAno;
    private double totalCustoSuporteAno;
    private double totalCustoMaqAno;
    private double totalCustoServiceAno;

    private double totalAnualBase;

    private double totalMensalAntes;
    private double totalMensalDepois;

    private double totalPrimeiroSeleniumMes;
    private double totalSeleniumMes;
    private double totalSeleniumAno;

    private double totalPrimeiroUipathMes;
    private double totalUipathMes;
    private double totalUipathAno;

    private double semAutomatizacao;
    private double mes1S;
    private double mes2S;
    private double mes3S;

    private double mes1U;
    private double mes2U;
    private double mes3U;

    private double reducaoU;
    private double roiU;

    private double reducaoS;
    private double roiS;
}
