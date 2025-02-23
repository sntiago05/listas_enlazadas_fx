package org.sntiago.java.listasenlazdasfx.listas_enlazadas_fx;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.sntiago.java.listasenlazdasfx.listas_enlazadas_fx.model.Direccion;
import org.sntiago.java.listasenlazdasfx.listas_enlazadas_fx.model.ListaEnlazada;
import org.sntiago.java.listasenlazdasfx.listas_enlazadas_fx.model.Nodo;

public class HelloController {
    @FXML
    Canvas canvas;
    @FXML
    TextField elementoTxt;
    @FXML
    Button buttonAgregar;
    private ListaEnlazada<Integer> lista;
    @FXML
    ScrollPane scrollPane;

    @FXML
    ComboBox<Direccion> comboDireccion;

    @FXML
    public void initialize() {
        lista = new ListaEnlazada<>();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        comboDireccion.getItems().addAll(Direccion.values());
    }

    @FXML
    protected void agregar() {
        agregarNodo();
    }

    @FXML
    protected void limpiarLista() {
        lista.limpiar();
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }


    private void agregarNodo() {
        lista.ingresar(new Nodo<>(Integer.parseInt(elementoTxt.getText())), comboDireccion.getValue());
        ajustarCanvas();
    }

    private void dibujar() {
        GraphicsContext graphicContext = canvas.getGraphicsContext2D();
        graphicContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        double x = 50;
        double y = canvas.getHeight() / 2;
        Nodo<Integer> auxiliar = lista.ptr;

        if (lista.noEstaVacia()) {
            graphicContext.setFill(Color.GREEN);
            graphicContext.fillText("PTR", 30, y - 30);
            graphicContext.strokeLine(30, y - 25, 50, y - 5);
        }

        while (auxiliar != null) {
            int valor = auxiliar.getComponente();


            graphicContext.setFill(Color.web("#333399"));
            graphicContext.fillOval(x, y - 30, 60, 60);  // Aumentar el tamaño del óvalo
            graphicContext.setStroke(Color.BLACK);
            graphicContext.strokeOval(x, y - 30, 60, 60);  // Aumentar el tamaño del óvalo

            // Dibujar valor en el nodo
            graphicContext.setFill(Color.WHITE);
            graphicContext.fillText(String.valueOf(valor), x + 25, y + 5);  // Ajustar la posición del texto


            if (auxiliar.siguiente != null) {
                graphicContext.strokeLine(x + 60, y, x + 100, y);  // Ajustar la posición de la flecha
                graphicContext.strokeLine(x + 90, y - 5, x + 100, y);  // Ajustar la posición de la flecha
                graphicContext.strokeLine(x + 90, y + 5, x + 100, y);  // Ajustar la posición de la flecha
            } else {

                graphicContext.setFill(Color.RED);
                graphicContext.fillText("T", x + 90, y - 30);  // Ajustar la posición del texto "Fin"
                graphicContext.strokeLine(x + 60, y - 5, x + 90, y - 25);  // Ajustar la posición de la flecha
            }

            // Moverse al siguiente nodo
            x += 100;
            auxiliar = auxiliar.siguiente;
        }
    }

    private void ajustarCanvas() {
        double nuevoAncho = lista.getTotal() * 150;
        canvas.setWidth(nuevoAncho);
        dibujar();
    }
}