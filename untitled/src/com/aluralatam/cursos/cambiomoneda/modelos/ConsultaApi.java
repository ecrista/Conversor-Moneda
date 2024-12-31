package com.aluralatam.cursos.cambiomoneda.modelos;

import com.aluralatam.cursos.cambiomoneda.records.ConvertirDivisa;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ConsultaApi {
    private static final String archivoRegistro = "api_divisas_log.txt"; // Ruta del archivo de registro
    private ArrayList<String> historial=new ArrayList<>();
    private void guardarRegistro(String respuesta){
        // Obtener la fecha y hora actual
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);

        // Crear el mensaje de registro
        String registroHistorico = String.format("[%s] Respuesta de la API: %s%n", timestamp, respuesta);
        historial.add(registroHistorico);
        // Escribir en el archivo
        try (FileWriter writer = new FileWriter(archivoRegistro, true)) {
            writer.write(registroHistorico);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public double convertirDivisa(double cantidad, String origen, String destino) {
        //var url = "https://v6.exchangerate-api.com/v6/83d5f17628e378f0e03e528a/pair/" + origen + "/" + destino + "/" + cantidad + "/"; //URL api ExchangeRate para obtener el cambio directo
        var url = "https://v6.exchangerate-api.com/v6/83d5f17628e378f0e03e528a/latest/" + origen + "/"; //URL api ExchangeRate para obtener el valor para convertir la divisa
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();


        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            ConvertirDivisa convertirDivisa = gson.fromJson(json, ConvertirDivisa.class);
            double convertirDivisaFinal=cantidad*convertirDivisa.conversion_rates().get(destino).getAsDouble();

            //Funcion para ir guardando el registro de cada consulta en un archivo
            guardarRegistro("Se realizo una consulta de cambio de divisas de "+cantidad+" "+origen+" a "+convertirDivisa.conversion_result()+" "+destino);

            //return convertirDivisa.conversion_result();//Funciona con la url que regresa el cambio directo
            return convertirDivisaFinal;

        } catch (IOException e) {
            guardarRegistro("Error de IOIOException "+ e);
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            guardarRegistro("Error de InterruptedException "+ e);
            throw new RuntimeException(e);
        }


    }
    public void verHistorial(){
        for (String item:historial){
            System.out.println(item);
        }
    };


}
