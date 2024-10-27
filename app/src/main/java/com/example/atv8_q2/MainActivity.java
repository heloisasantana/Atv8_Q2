package com.example.atv8_q2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/*
 *@author:Heloísa Santana da Silva
 */

public class MainActivity extends AppCompatActivity {

    private EditText editTextCpf, editTextNome;
    private TextView textViewResultado;
    private Button buttonEnviar, buttonLimpar;
    private LinearLayout layoutFormulario, layoutResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Elementos do layout
        editTextCpf = findViewById(R.id.editTextCpf);
        editTextNome = findViewById(R.id.editTextNome);
        textViewResultado = findViewById(R.id.textViewResultado);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        buttonLimpar = findViewById(R.id.buttonLimpar);
        layoutFormulario = findViewById(R.id.layoutFormulario);
        layoutResultado = findViewById(R.id.layoutResultado);

        // Oculta a área de resultado ao iniciar
        layoutResultado.setVisibility(View.GONE);

        // Ação do botão de enviar
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cpf = editTextCpf.getText().toString();
                String nome = editTextNome.getText().toString();

                // Validação do CPF e exibição do local de registro
                if (cpf.length() == 11) {
                    Pessoa pessoa = new Pessoa(cpf, nome);
                    textViewResultado.setText("Nome: " + pessoa.getNome() + "\nLocal de registro: " + pessoa.getLocalRegistro());

                    // Alterna para o layout de resultado
                    layoutFormulario.setVisibility(View.GONE);
                    layoutResultado.setVisibility(View.VISIBLE);
                } else {
                    editTextCpf.setError("Insira um CPF válido com 11 dígitos");
                }
            }
        });

        // Ação do botão de limpar
        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextCpf.setText("");
                editTextNome.setText("");
                layoutFormulario.setVisibility(View.VISIBLE);
                layoutResultado.setVisibility(View.GONE);
            }
        });
    }
}
