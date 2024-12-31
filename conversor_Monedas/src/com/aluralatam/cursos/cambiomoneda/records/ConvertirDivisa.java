package com.aluralatam.cursos.cambiomoneda.records;

import com.google.gson.JsonObject;

public record ConvertirDivisa (String base_code, String target_code, double conversion_rate, double conversion_result,
                               JsonObject conversion_rates,String result) {

}
