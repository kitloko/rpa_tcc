package com.example.rpa_tcc.Service;

import com.example.rpa_tcc.Entity.Form;
import com.example.rpa_tcc.Entity.Result;
import com.example.rpa_tcc.Entity.ResultOutput;
import com.example.rpa_tcc.Entity.Variables;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;

@Service
public class Calculate {

    public ResultOutput calculate(Form form) {
        Result result = new Result();

        result.setTotalColab(colaboradoresProcesso(form));
        result.setTotalCustoDev(devProcesso(form));
        result.setTotalCustoSuporte(suporteManutencao(form));
        result.setTotalCustoMaq(deploy(form));
        result.setTotalCustoService(servicos(form));

        ResultOutput resultOutput = ganhos(result);

        return resultOutput;

    }

    private double colaboradoresProcesso(Form form) {
        int qtoColab = form.getQtdColab();
        double custoColab = form.getCustoColab();

        return qtoColab * custoColab;

    }

    private double devProcesso(Form form) {
        boolean devProp = form.getDevProp();
        boolean devContra = form.getDevContra();
        double custoDev = form.getCustoDev();
        int tempoDev = form.getTempoDev();

        return custoDev * tempoDev;

    }

    private double suporteManutencao(Form form) {
        boolean supProp = form.getSupProp();
        boolean supContra = form.getSupContra();

        double totalCustoSuporte = 0;
        if (supProp) {
            int qtdColabSub = form.getQtdColabSub();
            double custoColabSup = form.getCustoColabSup();
            return qtdColabSub * custoColabSup;
        } else if (supContra) {
            int tempoContraSup = form.getTempoContraSup();
            double custoContrabSup = form.getCustoContraSup();
            return tempoContraSup * custoContrabSup;
        }

        return totalCustoSuporte;

    }

    private double deploy(Form form) {
        boolean maqPropCC = form.getMaqPropCC();
        boolean maqPropSC = form.getMaqPropSC();
        boolean maqVirt = form.getMaqVirt();
        double custoMaq = form.getCustoMaq();
        int qtdMaq = form.getQtdMaq();

        return custoMaq * qtdMaq;

    }

    private double servicos(Form form) {
        boolean checkApi = form.getCheckApi();
        boolean checkaWs = form.getCheckAws();
        boolean checkCaptcha = form.getCheckCaptcha();
        boolean checkOrchestrator = form.getCheckOrchestrator();
        boolean checkCloud = form.getCheckCloud();

        return 0.0;

    }

    private void comparar() {

    }

    private ResultOutput ganhos(Result result) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        double totalColab = result.getTotalColab();
        double totalCustoDev = result.getTotalCustoDev();
        double totalCustoMaq = result.getTotalCustoMaq();
        double totalCustoService = result.getTotalCustoService();
        double totalCustoSuporte = result.getTotalCustoSuporte();

        result.setTotalColabAno(totalColab * 12);
        result.setTotalMensalAntes((totalCustoDev + totalColab));
        result.setTotalMensalDepois(totalCustoMaq + totalCustoService + totalCustoSuporte);

        ResultOutput resultOutput = new ResultOutput();

        resultOutput.setTotalColab(formatter.format(result.getTotalColab()));
        resultOutput.setTotalCustoDev(formatter.format(result.getTotalCustoDev()));
        resultOutput.setTotalCustoMaq(formatter.format(result.getTotalCustoMaq()));
        resultOutput.setTotalCustoService(formatter.format(result.getTotalCustoService()));
        resultOutput.setTotalCustoSuporte(formatter.format(result.getTotalCustoSuporte()));

        resultOutput.setTotalColabAno(formatter.format(result.getTotalColabAno()));
//        result.setTotalCustoDevAno(totalCustoDev * 12);
        resultOutput.setTotalCustoMaqAno(formatter.format(totalCustoMaq * 12));
        resultOutput.setTotalCustoServiceAno(formatter.format(totalCustoService * 12));
        resultOutput.setTotalCustoSuporteAno(formatter.format(totalCustoSuporte * 12));

        resultOutput.setTotalMensalAntes(formatter.format(result.getTotalMensalAntes()));
        resultOutput.setTotalMensalDepois(formatter.format(result.getTotalMensalDepois()));

        resultOutput.setTotalAnualBase(formatter.format((totalColab * 12) - ((totalCustoDev + totalColab) + (totalCustoMaq * 12) + (totalCustoService * 12) + totalCustoSuporte * 12)));

        Variables variables = new Variables();

        resultOutput.setTotalPrimeiroUipathMes(formatter.format(variables.getUiPathMensailidade() + result.getTotalMensalAntes()));
        resultOutput.setTotalUipathMes(formatter.format(variables.getUiPathMensailidade() + result.getTotalMensalDepois()));
        result.setTotalUipathAno((variables.getUiPathMensailidade() * 12) + result.getTotalMensalAntes() + (result.getTotalMensalDepois() * 12));
        resultOutput.setTotalUipathAno(formatter.format((variables.getUiPathMensailidade() * 12) + result.getTotalMensalAntes() + (result.getTotalMensalDepois() * 12)));

        resultOutput.setTotalPrimeiroSeleniumMes(formatter.format(result.getTotalMensalAntes()));
        resultOutput.setTotalSeleniumMes(formatter.format(result.getTotalMensalDepois()));
        result.setTotalSeleniumAno(result.getTotalMensalAntes() + (result.getTotalMensalDepois() * 12));
        resultOutput.setTotalSeleniumAno(formatter.format(result.getTotalMensalAntes() + (result.getTotalMensalDepois() * 12)));

        result.setReducaoS(result.getTotalColabAno() - result.getTotalSeleniumAno());
        resultOutput.setReducaoS(formatter.format(result.getTotalColabAno() - result.getTotalSeleniumAno()));
        resultOutput.setRoiS(String.format("%.2f%%", ((result.getReducaoS() - result.getTotalSeleniumAno()) / result.getTotalSeleniumAno()) * 100));

        result.setReducaoU(result.getTotalColabAno() - result.getTotalUipathAno());
        resultOutput.setReducaoU(formatter.format(result.getTotalColabAno() - result.getTotalUipathAno()));
        resultOutput.setRoiU(String.format("%.2f%%", ((result.getReducaoU() - result.getTotalUipathAno()) / result.getTotalUipathAno()) * 100));


        return resultOutput;

    }

    private Result tabela(Result result) {
//        result.setSemAutomatizacao();
//        result.setMes1S();
//        result.setMes2S();
//        result.setMes3S();
//
//        result.setMes1U();
//        result.setMes2U();
//        result.setMes3U();

        return result;
    }


}
