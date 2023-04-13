package com.example.rpa_tcc.Entity;

import lombok.Data;

@Data
public class Form {

    private int qtdColab = 0;
    private double custoColab = 0.0;
    private double custoProcesso = 0.0;

    private Boolean devProp = false;
    private Boolean devContra = false;
    private double custoDev = 0.0;
    private int tempoDev = 0;

    private Boolean supProp = false;
    private int qtdColabSub = 0;
    private double custoColabSup = 0.0;
    private Boolean supContra = false;
    private double custoContraSup = 0.0;
    private int tempoContraSup = 0;

    private Boolean maqPropSC= false;
    private Boolean maqPropCC=false;
    private Boolean maqVirt=false;
    private double custoMaq=0.0;
    private int qtdMaq=0;

    private Boolean checkOrchestrator=false;
    private Boolean checkApi=false;
    private Boolean checkCaptcha=false;
    private Boolean checkAws=false;
    private Boolean checkCloud=false;
}
