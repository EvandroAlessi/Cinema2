/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.SessaoController;
import java.util.HashMap;
import java.util.List;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * View responsável pela apresentação de um resumo geral das movimentações.
 * Apresentação com TableView e BarChart. Diretamente ligada ao Stage provido
 * pela MainFX. Utiliza o controlador de Movimentações.
 *
 * @author Evandro Alessi
 * @author Eric Ueta
 * @see Movimentacao
 * @see MovimentacaoController
 * @see MainFX
 */
public class ResumoFX extends GridPane {

    private TableView table;
    private TableColumn c1;
    private TableColumn c2;
    private SessaoController sessaoController;

    /**
     * @param stage Recebe o stage principal de mainFX
     */
    public ResumoFX(Stage stage) {
        sessaoController = new SessaoController();
        setTable(new TableView());
        
        Label lbLast = new Label("Últimos Lançamentos");
        Label lbFut = new Label("Lançamentos Futuros");
        lbFut.setFont(new Font("Arial", 18));
        lbLast.setFont(new Font("Arial", 18));

        this.add(lbLast, 0, 1);
        this.add(lbFut, 1, 1);
        this.add(new SessaoFX(stage), 0, 2);
        //this.add(new RelatorioFX(stage).showTable(), 1, 2);

        this.setPadding(new Insets(5));
        this.setHgap(5);
        this.setVgap(5);
        ColumnConstraints c1 = new ColumnConstraints();
        c1.setHgrow(Priority.ALWAYS);
        c1.setHalignment(HPos.CENTER);
        c1.setPercentWidth(50);

        ColumnConstraints c2 = new ColumnConstraints();
        c2.setHgrow(Priority.ALWAYS);
        c2.setHalignment(HPos.CENTER);
        c2.setPercentWidth(50);

        RowConstraints r1 = new RowConstraints();
        r1.setVgrow(Priority.ALWAYS);
        r1.setValignment(VPos.CENTER);

        RowConstraints r2 = new RowConstraints();
        r2.setVgrow(Priority.ALWAYS);
        r2.setValignment(VPos.CENTER);

        RowConstraints r3 = new RowConstraints();
        r3.setVgrow(Priority.ALWAYS);
        r3.setValignment(VPos.CENTER);

        getColumnConstraints().addAll(c1, c2);
        getRowConstraints().addAll(r1, r2, r3);
    }

    /**
     * @return the table
     */
    public TableView getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(TableView table) {
        this.table = table;
    }

    /**
     * @return the c1
     */
    public TableColumn getC1() {
        return c1;
    }

    /**
     * @param c1 the c1 to set
     */
    public void setC1(TableColumn c1) {
        this.c1 = c1;
    }

    /**
     * @return the c2
     */
    public TableColumn getC2() {
        return c2;
    }

    /**
     * @param c2 the c2 to set
     */
    public void setC2(TableColumn c2) {
        this.c2 = c2;
    }
}
