package br.com.alfaumuarama.aula04_31_08_2023.datasource;

//thread assíncrona
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class DownloadImagem extends AsyncTask<String, Void, Bitmap> {

    ImageView imagem;

    public DownloadImagem(ImageView imagem){
        this.imagem = imagem;
    }

    @Override
    //parametro da imagem
    protected Bitmap doInBackground(String... strings) {
        String urlImagem = strings[0];
        Bitmap bitmap = null;

        try {
            //criando a url e buscando os dados da imagem e salvando no stream(dados em memória sem tipagem)
            InputStream stream = new URL(urlImagem).openStream();

            //transformando os dados da memoria stram em uma imagem
            bitmap = BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        //adicionando no objeto da imagem o bitmap baixado do link - fica em cache
        imagem.setImageBitmap(bitmap);
    }
}
