package com.example.soepaytest

import com.example.soepaytest.pojos.Credential
import com.example.soepaytest.pojos.TransactionRequest
import com.example.soepaytest.pojos.enums.PreferredInstrument
import android.content.Intent
import android.icu.math.BigDecimal
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.soepaytest.pojos.enums.TranType
import com.example.soepaytest.databinding.ActivityMainBinding
import com.google.gson.Gson
import java.util.*

class MainActivity : AppCompatActivity() {

    private val paymentLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val extras = result.data?.extras
        val ecrResult = extras?.getString("ECR_TRANSACTION_RESULT")

        //val gson = GsonBuilder().setPrettyPrinting().create()
        //val jsonObject: JsonObject = JsonParser().parse(ecrResult).asJsonObject
        //val resultText = "code:${result.resultCode}\nResult: ${gson.toJson(jsonObject)}"
        //val lastTranResult = gson.fromJson(ecrResult, TransactionModel::class.java)

        Log.d("Test_tag", "$ecrResult")

    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        sendIntent()
    }

    private fun sendIntent() {
        val dummyCredential = Credential(
            env = "DEMO",
            name = "Sample credential",
            shop = "POS Integration Test",
            apiKey = "b6cac1ed6a06a7f85c331e09022b3c14118005790644376c31f3f7f3738685ef",
            apiToken = "13a4088da4f10d2d88863afa624a803b63fcf470c1fef44098b0b79dda1f4764"
        )

        val transactionRequest = TransactionRequest(
            messageId = UUID.randomUUID().toString(),
            tranType = TranType.SALE.name,
            requestAmount = java.math.BigDecimal(20.0),
            preferredInstrument = PreferredInstrument.CARD
        )

        Intent("com.spectratech.soepay.action.payment")
            .apply {
                    putExtra("ECR_TRANSACTION_REQUEST", Gson().toJson(transactionRequest))
                    putExtra("API_KEY", dummyCredential.apiKey)
                    putExtra("API_TOKEN", dummyCredential.apiToken)
            }
            .also {
                try {
                    paymentLauncher.launch(it)
                } catch (ex: Exception) {
                    Toast.makeText(this@MainActivity, "Cannot start activity", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Test_tag","destroy")
    }
}