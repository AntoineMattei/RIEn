package esimed.amattei.examen.rien

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import esimed.amattei.examen.rien.entities.EntrepriseEntity
import esimed.amattei.examen.rien.model.Etablissement
import kotlinx.android.synthetic.main.activity_recherche_par_activite.*
import retrofit2.Callback
import esimed.amattei.examen.rien.model.Result
import retrofit2.Call
import retrofit2.Response
import java.util.*

class RechercheParActiviteActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        var wasHistory = true
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recherche_par_activite)

        val rienDatabase = RIEnDatabaseCodeNafApe.getDatabase(this)

        val codeNAFAPEDAO = rienDatabase.codeNAFAPEDao()
        val rienDatabaseEntreprise = RIEnDatabase.getDatabaseRienDatabase(this)
        val entrepriseDAO = rienDatabaseEntreprise.entrepriseDAO()

        listResultRechercheParActiviteActivity.adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                entrepriseDAO.returnEntreprise().toTypedArray()
            )

        val textViewCodeNaf =
            findViewById<AutoCompleteTextView>(R.id.RechercheParActiviteActivityEditTextCodeNAF)

        val textViewActivites =
            findViewById<AutoCompleteTextView>(R.id.RechercheParActiviteActivityEditTextActivite)

        val codesNaf =
            codeNAFAPEDAO.returnCodeCodeNafApe()
                .toTypedArray()        //stream().collect(Array<out String>)  List<String> -> Array<out String>

        val activites =
            codeNAFAPEDAO.returnDescriptionCodeNafApe()
                .toTypedArray()        //stream().collect(Array<out String>)  List<String> -> Array<out String>

        ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, codesNaf).also { adapter ->
            textViewCodeNaf.setAdapter(adapter)
        }
        ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activites).also { adapter ->
            textViewActivites.setAdapter(adapter)
        }


        RechercheParActiviteActivityAfficherOptionSupplementaires.setOnClickListener {
            if (RadioGroupOptionsSupplementaires.isVisible) {
                RadioGroupOptionsSupplementaires.visibility = View.GONE
                RechercheParActiviteActivityAfficherOptionSupplementaires.text =
                    "Afficher les options supplémentaires"
            } else {
                RadioGroupOptionsSupplementaires.visibility = View.VISIBLE
                RechercheParActiviteActivityAfficherOptionSupplementaires.text =
                    "Masquer les options supplémentaires"
            }
        }

        RechercheParActiviteActivityRadioButtonActivite.setOnClickListener {
            RechercheParActiviteActivityEditTextCodeNAF.visibility = View.GONE
            RechercheParActiviteActivityEditTextActivite.visibility = View.VISIBLE
        }

        RechercheParActiviteActivityRadioButtonCodeNAF.setOnClickListener {
            RechercheParActiviteActivityEditTextActivite.visibility = View.GONE
            RechercheParActiviteActivityEditTextCodeNAF.visibility = View.VISIBLE
        }

        val svc = EntrepriseService()
        buttonRechercheParActiviteButtonSearch.setOnClickListener {
            wasHistory = false
            val query = editTextRechercheParActiviteVilleNomEntreprise.text.toString()
                .lowercase(Locale.getDefault())
                .replace(" ", "_")
                .replace("à", "a")
                .replace("â", "a")
                .replace("æ", "ae")
                .replace("ç", "c")
                .replace("é", "e")
                .replace("è", "e")
                .replace("ê", "e")
                .replace("ë", "e")
                .replace("î", "i")
                .replace("ï", "i")
                .replace("ô", "o")
                .replace("œ", "oe")
                .replace("ù", "u")
                .replace("û", "u")
                .replace("ü", "u")
                .replace("ÿ", "y")
            hideKeyboard()
            Thread(Runnable {
                runOnUiThread {
                    progressBarRechercheParActiviteActivity.visibility = View.VISIBLE
                    listResultRechercheParActiviteActivity.visibility = View.INVISIBLE
                }
                if (RadioGroupOptionsSupplementaires.visibility != View.VISIBLE) {
                    svc.query(query, object : Callback<Result> {
                        override fun onResponse(call: Call<Result>?, response: Response<Result>?) {
                            if (response!!.code() == 200) {                             // Demander au prof
                                runOnUiThread {
                                    listResultRechercheParActiviteActivity.adapter =
                                        ArrayAdapter<Etablissement>(
                                            this@RechercheParActiviteActivity,
                                            android.R.layout.simple_list_item_1,
                                            android.R.id.text1,
                                            response.body()!!.etablissement!!
                                        )
                                    progressBarRechercheParActiviteActivity.visibility = View.GONE
                                    listResultRechercheParActiviteActivity.visibility = View.VISIBLE
                                }
                            }
                        }

                        override fun onFailure(call: Call<Result>?, t: Throwable?) {
                            val builder = AlertDialog.Builder(this@RechercheParActiviteActivity)
                            builder.setMessage("Problème lors de l'appel au service Web")
                            builder.create().show()
                        }
                    })
                } else {
                    if (RechercheParActiviteActivityRadioButtonActivite.isChecked) {

                        svc.queryByActivite(
                            query,
                            codeNAFAPEDAO.returnCodeNafApeOfDescription(RechercheParActiviteActivityEditTextActivite.text.toString()),
                            object : Callback<Result> {
                                override fun onResponse(
                                    call: Call<Result>?,
                                    response: Response<Result>?
                                ) {
                                    if (response!!.code() == 200) {                             // Demander au prof
                                        runOnUiThread {
                                            listResultRechercheParActiviteActivity.adapter =
                                                ArrayAdapter<Etablissement>(
                                                    this@RechercheParActiviteActivity,
                                                    android.R.layout.simple_list_item_1,
                                                    android.R.id.text1,
                                                    response.body()!!.etablissement!!
                                                )
                                            progressBarRechercheParActiviteActivity.visibility =
                                                View.GONE
                                            listResultRechercheParActiviteActivity.visibility =
                                                View.VISIBLE
                                        }
                                    }
                                }

                                override fun onFailure(call: Call<Result>?, t: Throwable?) {
                                    val builder =
                                        AlertDialog.Builder(this@RechercheParActiviteActivity)
                                    builder.setMessage("Problème lors de l'appel au service Web")
                                    builder.create().show()
                                }
                            })
                    } else if (RechercheParActiviteActivityRadioButtonCodeNAF.isChecked) {
                        svc.queryByCodeNaf(
                            query,
                            RechercheParActiviteActivityEditTextCodeNAF.text.toString(),
                            object : Callback<Result> {
                                override fun onResponse(
                                    call: Call<Result>?,
                                    response: Response<Result>?
                                ) {
                                    if (response!!.code() == 200) {                             // Demander au prof
                                        runOnUiThread {
                                            listResultRechercheParActiviteActivity.adapter =
                                                ArrayAdapter<Etablissement>(
                                                    this@RechercheParActiviteActivity,
                                                    android.R.layout.simple_list_item_1,
                                                    android.R.id.text1,
                                                    response.body()!!.etablissement!!
                                                )
                                            progressBarRechercheParActiviteActivity.visibility =
                                                View.GONE
                                            listResultRechercheParActiviteActivity.visibility =
                                                View.VISIBLE
                                        }
                                    }
                                }

                                override fun onFailure(call: Call<Result>?, t: Throwable?) {
                                    val builder =
                                        AlertDialog.Builder(this@RechercheParActiviteActivity)
                                    builder.setMessage("Problème lors de l'appel au service Web")
                                    builder.create().show()
                                }
                            })
                    } else {
                        svc.query(query, object : Callback<Result> {
                            override fun onResponse(
                                call: Call<Result>?,
                                response: Response<Result>?
                            ) {
                                if (response!!.code() == 200) {                             // Demander au prof
                                    runOnUiThread {
                                        listResultRechercheParActiviteActivity.adapter =
                                            ArrayAdapter<Etablissement>(
                                                this@RechercheParActiviteActivity,
                                                android.R.layout.simple_list_item_1,
                                                android.R.id.text1,
                                                response.body()!!.etablissement!!
                                            )
                                        progressBarRechercheParActiviteActivity.visibility =
                                            View.GONE
                                        listResultRechercheParActiviteActivity.visibility =
                                            View.VISIBLE
                                    }
                                }
                            }

                            override fun onFailure(call: Call<Result>?, t: Throwable?) {
                                val builder = AlertDialog.Builder(this@RechercheParActiviteActivity)
                                builder.setMessage("Problème lors de l'appel au service Web")
                                builder.create().show()
                            }
                        })
                    }
                }
            }).start()
        }
        listResultRechercheParActiviteActivity.setOnItemClickListener { parent, view, position, id ->
            if (wasHistory) {
                val itemEntrepriseEntity = listResultRechercheParActiviteActivity
                    .adapter
                    .getItem(position) as EntrepriseEntity
                val intent = Intent(
                    this,
                    EntrepriseEntityActivity::class.java
                )
                intent.putExtra(
                    "entrepriseEntity",
                    itemEntrepriseEntity
                )
                startActivity(intent)
            } else {
                val itemEtablissement = listResultRechercheParActiviteActivity
                    .adapter
                    .getItem(position) as Etablissement
                val intent = Intent(
                    this,
                    EntrepriseActivity::class.java
                )
                intent.putExtra(
                    "entreprise",
                    itemEtablissement
                )
                startActivity(intent)
            }
        }
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val InputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        InputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}