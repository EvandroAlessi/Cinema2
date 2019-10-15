///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Views;
//
//import Controllers.SessaoController;
//import Models.Filme;
//import Models.Sala;
//import Models.Sessao;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.event.ActionEvent;
//import javafx.geometry.HPos;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.geometry.VPos;
//import javafx.scene.control.Button;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableCell;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.ColumnConstraints;
//import javafx.scene.layout.GridPane;
//import static javafx.scene.layout.GridPane.setConstraints;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Priority;
//import javafx.scene.layout.RowConstraints;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//import javafx.util.Callback;
//
///**
// * View responsável pela apresentação de um relátorio das últimas e futuras movimentações.
// * Apresentação com TableView.
// * Diretamente ligada ao Stage provido pela MainFX.
// * Utiliza o controlador de Movimentações.
// * @author Evandro Alessi
// * @author Eric Ueta
// * @see Sessao
// * @see SessaoController
// * @see MainFX
// */
//public class RelatorioFX extends GridPane {
//
//    private Label lbTitulo;
//    //Button btnCadastrar, btnEditar;
//    private TableView<Sessao> table;
//    private TableColumn tcIngressos, tcData, tcValorIngresso, tcFilme, tcSala;
//    private final SessaoController sessaoController;
//    private final Stage mainStage;
//    private DatePicker dpBeginDate;
//    private DatePicker dpEndDate;
//    private Button btnPesquisar;
//    
//    /** @param stage Recebe o stage principal de mainFX
//    */
//    public RelatorioFX(Stage stage) {
//        mainStage = stage;
//        sessaoController = new SessaoController();
//    }
//    
//    public RelatorioFX(Stage stage, String title) {
//        mainStage = stage;
//        sessaoController = new SessaoController();
//        lbTitulo = new Label(title);
//        dpEndDate = new DatePicker();
//        btnPesquisar = new Button("Pesquisar");
//        showTable();
//        
////        if (!untilNow) {
////            dpBeginDate = new DatePicker(LocalDate.now().plusDays(1));
////            dpBeginDate.setDisable(true);
////            dpBeginDate.disarm();
////        }
////        else{
//            dpBeginDate = new DatePicker();
//        //}
//        
//        HBox h = new HBox(new Label("De "), dpBeginDate, new Label(" Até "), dpEndDate, btnPesquisar);
//        h.setAlignment(Pos.CENTER);
//        h.setSpacing(10);
//        
//        btnPesquisar.setOnAction((event) -> {
//            List<Sessao> Sessoes = null;
//            
//            sessaoController.getAll();
//            
//            if (Sessoes != null) {
//                this.table.setItems(FXCollections.observableArrayList(Sessoes));
//                this.table.refresh();
//            }
//        });
//        
//        
//        
//        add(lbTitulo, 0, 0);
//        add(h, 1, 0);
//        add(table, 0, 1);
//        
//        lbTitulo.setFont(new Font("Arial", 24));
//        lbTitulo.setPadding(new Insets(15, 15, 15, 5));
//        ColumnConstraints c1 = new ColumnConstraints();
//        c1.setHgrow(Priority.ALWAYS);
//
//        RowConstraints r1 = new RowConstraints();
//        RowConstraints r2 = new RowConstraints();
//        r2.setVgrow(Priority.ALWAYS);
//        getColumnConstraints().add(c1);
//        getRowConstraints().addAll(r1, r2);
//        setConstraints(lbTitulo, 0, 0, 1, 1, HPos.LEFT, VPos.BASELINE);
//        GridPane.setColumnSpan(table, 2);
//    }
//    
//    public TableView<Sessao> showTable(){
//        table = new TableView();
//        tcData = new TableColumn("Ocorrência");
//        tcIngressos = new TableColumn("Descrição");
//        tcValorIngresso = new TableColumn("Valor");
//        tcFilme = new TableColumn("Forma de Pagamento");
//        tcSala = new TableColumn("Categoria");
//        
////        tcTipo.prefWidthProperty().bind(table.widthProperty()
////                .multiply(0.06));
////        tcSubCategoria.prefWidthProperty().bind(table.widthProperty()
////                .multiply(0.15));
////        tcCategoria.prefWidthProperty().bind(table.widthProperty()
////                .multiply(0.15));
////        tcData.prefWidthProperty().bind(table.widthProperty()
////                .multiply(0.06));
////        tcDescricao.prefWidthProperty().bind(table.widthProperty()
////                .multiply(0.378));
////        tcValor.prefWidthProperty().bind(table.widthProperty()
////                .multiply(0.10));
////        tcPagamento.prefWidthProperty().bind(table.widthProperty()
////                .multiply(0.10));
//
////        tcTipo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
////            @Override
////            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sessao, String> param) {
////                if (param.getValue().getSubCategoria().getCategoriaConta().isPositiva()) {
////                    return new SimpleStringProperty("Receita");
////                } else {
////                    return new SimpleStringProperty("Despesa");
////                }
////            }
////        });, , , , ;
//        
//        tcData.setCellValueFactory(new PropertyValueFactory<>("Data"));
//        tcIngressos.setCellValueFactory(new PropertyValueFactory<>("Ingressos"));
//        tcValorIngresso.setCellValueFactory(new PropertyValueFactory<>("ValorIngresso"));
//        tcFilme.setCellValueFactory(new PropertyValueFactory<>("Filme"));
//        tcSala.setCellValueFactory(new PropertyValueFactory<>("Sala"));
//        
////        tcPagamento.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
////            @Override
////            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sessao, String> param) {
////                switch (param.getValue().getFormaPagamento()) {
////                    case 1:
////                        return new SimpleStringProperty("Crédito");
////                    case 2:
////                        return new SimpleStringProperty("Dinheiro");
////                    case 3:
////                        return new SimpleStringProperty("Boleto");
////                    case 4:
////                        return new SimpleStringProperty("Depósito");
////                    case 5:
////                        return new SimpleStringProperty("Convênio");
////                }
////                return new SimpleStringProperty("Indefinido");
////            }
////        });
//        
//        tcFilme.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
//            @Override
//            // obtem a descrição da categoria e converte para Observable
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sessao, String> param) {
//                return new SimpleStringProperty(param.getValue().getFilme().getTitulo());
//            }
//        });
//        
//        tcSala.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
//            @Override
//            // obtem a descrição da subcategoria e converte para Observable
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sessao, String> param) {
//                return new SimpleStringProperty( String.valueOf(param.getValue().getSala().getNumero()));
//            }
//        });
//
//        Callback<TableColumn<Sessao, Void>, TableCell<Sessao, Void>> cellFactory = new Callback<TableColumn<Sessao, Void>, TableCell<Sessao, Void>>() {
//            @Override
//            public TableCell<Sessao, Void> call(final TableColumn<Sessao, Void> param) {
//                final TableCell<Sessao, Void> cell = new TableCell<Sessao, Void>() {
//
//                    private final Button btn = new Button("Remover");
//
//                    {
//                        btn.setOnAction((ActionEvent event) -> {
//                            Sessao data = getTableView().getItems().get(getIndex());
//                            sessaoController.delete(data.getSessaoID());
//                            table.getItems().remove(data);
//                            table.refresh();
//                        });
//                    }
//
//                    @Override
//                    public void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(btn);
//                        }
//                    }
//                };
//
//                cell.setAlignment(Pos.CENTER);
//                return cell;
//            }
//        };
//        
//        this.setPadding(new Insets(5));
//        table.getColumns().addAll(tcIngressos, tcData, tcValorIngresso, tcFilme, tcSala);
//        table.setTableMenuButtonVisible(true);
//        tcFilme.setVisible(false);
//        tcSala.setVisible(false);
//       //table.getVisibleLeafColumns().setAll(tcTipo, tcData, tcDescricao, tcPagamento, tcValor, tcCategoria, tcSubCategoria);
//        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        
//        List<Sessao> Sessoes = sessaoController.getAll();
//
//        this.table.setItems(FXCollections.observableArrayList(Sessoes));
//        
//        return this.table;
//    }
//    
////    public TableView<Sessao> showTinyTable(boolean untilNow){
////        table = new TableView();
////        tcData = new TableColumn("Ocorrência");
////        tcDescricao = new TableColumn("Descrição");
////        tcValor = new TableColumn("Valor");
////        tcPagamento = new TableColumn("Forma de Pagamento");
////        tcTipo = new TableColumn("Tipo");
////
////        tcTipo.prefWidthProperty().bind(table.widthProperty()
////                .multiply(0.06));
////        tcData.prefWidthProperty().bind(table.widthProperty()
////                .multiply(0.06));
////        tcDescricao.prefWidthProperty().bind(table.widthProperty()
////                .multiply(0.3478));
////        tcValor.prefWidthProperty().bind(table.widthProperty()
////                .multiply(0.15));
////        tcPagamento.prefWidthProperty().bind(table.widthProperty()
////                .multiply(0.15));
////
////        tcTipo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
////            @Override
////            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sessao, String> param) {
////                if (param.getValue().getSubCategoria().getCategoriaConta().isPositiva()) {
////                    return new SimpleStringProperty("Receita");
////                } else {
////                    return new SimpleStringProperty("Despesa");
////                }
////            }
////        });
////        
////        tcData.setCellValueFactory(new PropertyValueFactory<>("dataOcorrencia"));
////        tcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
////        tcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
////        
////        tcPagamento.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
////            @Override
////            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sessao, String> param) {
////                switch (param.getValue().getFormaPagamento()) {
////                    case 1:
////                        return new SimpleStringProperty("Crédito");
////                    case 2:
////                        return new SimpleStringProperty("Dinheiro");
////                    case 3:
////                        return new SimpleStringProperty("Boleto");
////                    case 4:
////                        return new SimpleStringProperty("Depósito");
////                    case 5:
////                        return new SimpleStringProperty("Convênio");
////                }
////                return new SimpleStringProperty("Indefinido");
////            }
////        });
////
////        Callback<TableColumn<Sessao, Void>, TableCell<Sessao, Void>> cellFactory = new Callback<TableColumn<Sessao, Void>, TableCell<Sessao, Void>>() {
////            @Override
////            public TableCell<Sessao, Void> call(final TableColumn<Sessao, Void> param) {
////                final TableCell<Sessao, Void> cell = new TableCell<Sessao, Void>() {
////
////                    private final Button btn = new Button("Remover");
////
////                    {
////                        btn.setOnAction((ActionEvent event) -> {
////                            Sessao data = getTableView().getItems().get(getIndex());
////                            sessaoController.delete(data.getSessaoID());
////                            table.getItems().remove(data);
////                            table.refresh();
////                        });
////                    }
////
////                    @Override
////                    public void updateItem(Void item, boolean empty) {
////                        super.updateItem(item, empty);
////                        if (empty) {
////                            setGraphic(null);
////                        } else {
////                            setGraphic(btn);
////                        }
////                    }
////                };
////
////                cell.setAlignment(Pos.CENTER);
////                return cell;
////            }
////        };
////        
////        this.setPadding(new Insets(5));
////        table.getColumns().addAll(tcTipo, tcData, tcDescricao, tcPagamento, tcValor);
////        List<Sessao> Sessoes = sessaoController.getAll(untilNow);
////
////        this.table.setItems(FXCollections.observableArrayList(Sessoes));
////        
////        return this.table;
////    }
//}
