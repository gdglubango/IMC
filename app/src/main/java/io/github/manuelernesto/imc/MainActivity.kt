package io.github.manuelernesto.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun resultado(view: View) {


        if (validar()) {
            resultado_tv.text = null
            Toast.makeText(this, "Campos obrigatórios!", Toast.LENGTH_SHORT).show()
        } else {
            val peso = peso_et.text.toString().toDouble()
            val altura = altura_et.text.toString().toDouble()
            val nome = nome_et.text.toString()
            var res = ""


            val imc = calcular(peso, altura)

            condicao(imc, res)

            resultado_tv.text = "$nome o seu IMC = $imc, estas $res"

            limpar()
        }
    }

    private fun limpar() {
        nome_et.text = null
        peso_et.text = null
        altura_et.text = null
    }

    private fun condicao(imc: Double, res: String) {
        var res = res
        if (imc < 16)
            res = "Abaixo do peso"
        else if (imc > 18 && imc < 25)
            res = "Saudavel"
        else
            res = "Acima do peso"

    }

    private fun calcular(peso: Double, altura: Double): Double {
        return peso / (altura * altura)
    }

    private fun validar(): Boolean {
        if (nome_et.text.isEmpty() || peso_et.text.isEmpty() || altura_et.text.isEmpty()) {
            return true
        }
        return false
    }
}
