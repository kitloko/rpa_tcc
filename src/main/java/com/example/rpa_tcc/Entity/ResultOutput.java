package com.example.rpa_tcc.Entity;

import lombok.Data;

@Data
public class ResultOutput {

    private String totalColab;
    private String totalCustoDev;
    private String totalCustoSuporte;
    private String totalCustoMaq;
    private String totalCustoService;

    private String totalColabAno;
    private String totalCustoDevAno;
    private String totalCustoSuporteAno;
    private String totalCustoMaqAno;
    private String totalCustoServiceAno;

    private String totalAnualBase;

    private String totalMensalAntes;
    private String totalMensalDepois;

    private String totalPrimeiroSeleniumMes;
    private String totalSeleniumMes;
    private String totalSeleniumAno;

    private String totalPrimeiroUipathMes;
    private String totalUipathMes;
    private String totalUipathAno;

    private String semAutomatizacao;
    private String mes1S;
    private String mes2S;
    private String mes3S;

    private String mes1U;
    private String mes2U;
    private String mes3U;

    private String reducaoU;
    private String roiU;

    private String reducaoS;
    private String roiS;
}
