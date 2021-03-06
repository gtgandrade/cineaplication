package com.example.gtg.cineaplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.gtg.cineaplication.dao.FilmeDAO;
import com.example.gtg.cineaplication.R;
import com.example.gtg.cineaplication.adapter.FilmeAdapter;
import com.example.gtg.cineaplication.modelo.Filme;

import java.util.List;

public class ConfiguracoesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Filme> filmes;
    private FilmeDAO fimeBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);
        recyclerView = (RecyclerView) findViewById(R.id.configuracoes_rvFilmes);
        fimeBD = new FilmeDAO(this);
        FilmeAdapter filmeAdapter = new FilmeAdapter(this, fimeBD.procurarTodos());
        LinearLayoutManager glm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(glm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(filmeAdapter);
    }

    public void irParaCadastroFilmeActivity(View view) {
        Intent intentCadastroFilme = new Intent(this, CadastroFilmeActivity.class);
        Bundle parametros = new Bundle();
        parametros.putInt("idFilme", 0);
        intentCadastroFilme.putExtras(parametros);
        startActivity(intentCadastroFilme);
    }

    public void irParaCadastroTelaActivity(View view){
        Intent intentTelaCadastro = new Intent(this, CadastroEscolhaActivity2.class);
        //Bundle parametros = new Bundle();
        //intentTelaCadastro.putExtras(parametros);
        startActivity(intentTelaCadastro);
    }

}
