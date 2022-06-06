package com.lcons.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextView porcentagem;
    private TextInputEditText valorConta;
    private EditText valorGorjeta, valorTotal;
    private SeekBar seekbar;
    private double porcentagemFinal = 0;
    private double gorjetaFinal, valorFinal, contaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

        //Listener no SeekBar
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagemFinal = seekBar.getProgress();
                porcentagem.setText(Math.round(porcentagemFinal) + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void calcular() {
        String valorRecuperado = valorConta.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")) {
            Toast.makeText(this,
                    "Digite um Valor", Toast.LENGTH_SHORT).show();
        } else {
            contaFinal = Double.parseDouble(valorRecuperado);
            gorjetaFinal = Double.parseDouble(valorRecuperado) * (porcentagemFinal / 100);
            valorGorjeta.setText("R$ " + Math.round(gorjetaFinal));
            valorFinal = gorjetaFinal + contaFinal;
            valorTotal.setText("R$ " + Math.round(valorFinal));
        }
    }

    private void inicializarComponentes() {

        porcentagem = findViewById(R.id.txt_porcentagem);
        valorConta = findViewById(R.id.edt_valorConta);
        valorGorjeta = findViewById(R.id.edt_gorjeta);
        valorTotal = findViewById(R.id.edt_valorTotal);
        seekbar = findViewById(R.id.seekGorjeta);
    }
}