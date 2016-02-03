package br.edu.ifpb.asynctask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.ifpb.util.HttpService;
import br.edu.ifpb.util.Response;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class CalcularIMCAsynctask extends AsyncTask <JSONObject, Void, Response>{
	
	Context context;
	
	public CalcularIMCAsynctask(Context context){
		
		this.context = context;
		
	}

	@Override
	protected Response doInBackground(JSONObject... valores) {
		
		Response response = null;
		
		try {

            response = HttpService.sendJSONPostResquest("calcularIMC", valores[0]); // Esse método esta recebendo dois parametros: o nome do serviço e o json.

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
			
	}
	
	 @Override
	    protected void onPostExecute(Response response) {

	        try {

	            int status = response.getStatusCodeHttp();

	            if (status == 202) {

	                JSONObject json = new JSONObject(response.getContentValue());

	                String valor = json.getString("valor");
	                Log.i("NotificationWearApp", "Nome: " + valor);
	                Toast.makeText(context, valor, Toast.LENGTH_LONG).show();
	            }

	        } catch (JSONException e) {

	            Log.e("NotificationWearApp", "JSONException: " + e);
	        }
	    }

}
