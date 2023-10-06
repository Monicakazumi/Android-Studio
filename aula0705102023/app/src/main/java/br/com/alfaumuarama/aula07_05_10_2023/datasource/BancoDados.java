package br.com.alfaumuarama.aula07_05_10_2023.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoDados {
    private SQLiteDatabase _db;

    public SQLiteDatabase getDb() {
        return _db;
    }

    //criando um Singleton para esta classe - garanttindo que essa classe seja criada somente uma vez
    private static final BancoDados bancoDados = new BancoDados();
    public static BancoDados getInstance() {
        return bancoDados;
    }

    public void abrirBanco(Context context) {
        if (_db != null) { //se foi criado na memoria
            if (_db.isOpen() == false) { //se esta com a conexao fechada
                criarConexao(context);
            }
        }
        else { //se o banco nao tiver sido criado
            criarConexao(context);
        }
    }

    private void criarConexao(Context context) {
        //comando para criar e abrir o arquivo de banco de dados
        _db = context.openOrCreateDatabase("bancoDados.db", Context.MODE_PRIVATE, null);
    }

    public void fecharBanco() {
        if (_db != null) {
            _db.close();
        }
    }

    public void executarSQL(String sql) {
        try {
            _db.execSQL(sql);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
