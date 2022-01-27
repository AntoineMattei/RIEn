package esimed.amattei.examen.rien

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.annotation.NonNull
import androidx.core.view.isVisible
import esimed.amattei.examen.rien.entities.EntrepriseEntity
import esimed.amattei.examen.rien.model.Etablissement
import esimed.amattei.examen.rien.model.Result
import kotlinx.android.synthetic.main.activity_recherche_par_entreprise.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class RechercheParEntrepriseActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        var wasHistory: Boolean = true

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recherche_par_entreprise)

        val rienDatabase = RIEnDatabase.getDatabaseRienDatabase(this)
        val entrepriseDAO = rienDatabase.entrepriseDAO()

        listResultRechercheParEntrepriseActivity.adapter =
            ArrayAdapter(
                this@RechercheParEntrepriseActivity,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                entrepriseDAO.returnEntreprise().toTypedArray()
            )

        RechercheParEntrepriseActivityAfficherOptionSupplementaires.setOnClickListener {
            if (RadioGroupOptionsSupplementaires.isVisible) {
                RadioGroupOptionsSupplementaires.visibility = View.GONE
                RechercheParEntrepriseActivityAfficherOptionSupplementaires.text =
                    "Afficher les options supplémentaires"
            } else {
                RadioGroupOptionsSupplementaires.visibility = View.VISIBLE
                RechercheParEntrepriseActivityAfficherOptionSupplementaires.text =
                    "Masquer les options supplémentaires"
            }
        }

        RechercheParEntrepriseActivityRadioButtonCodePostal.setOnClickListener {
            RechercheParEntrepriseActivityEditTextDepartement.visibility = View.GONE
            RechercheParEntrepriseActivityEditTextCodePostal.visibility = View.VISIBLE
        }

        RechercheParEntrepriseActivityRadioButtonDepartement.setOnClickListener {
            RechercheParEntrepriseActivityEditTextCodePostal.visibility = View.GONE
            RechercheParEntrepriseActivityEditTextDepartement.visibility = View.VISIBLE
        }

        val svc = EntrepriseService()
        buttonRechercheParEntrepriseButtonSearch.setOnClickListener {
            wasHistory = false
            val query = editTextRechercheParEntrepriseVilleNomEntreprise.text.toString()
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
                    progressBarRechercheParEntrepriseActivity.visibility = View.VISIBLE
                    listResultRechercheParEntrepriseActivity.visibility = View.INVISIBLE
                }
                if (RadioGroupOptionsSupplementaires.visibility != View.VISIBLE) {
                    svc.query(query, object : Callback<Result> {
                        override fun onResponse(call: Call<Result>?, response: Response<Result>?) {
                            if (response!!.code() == 200) {                             // Demander au prof
                                runOnUiThread {
                                    listResultRechercheParEntrepriseActivity.adapter =
                                        ArrayAdapter<Etablissement>(
                                            this@RechercheParEntrepriseActivity,
                                            android.R.layout.simple_list_item_1,
                                            android.R.id.text1,
                                            response.body()!!.etablissement!!
                                        )
                                    progressBarRechercheParEntrepriseActivity.visibility = View.GONE
                                    listResultRechercheParEntrepriseActivity.visibility =
                                        View.VISIBLE
                                }
                            }
                        }

                        override fun onFailure(call: Call<Result>?, t: Throwable?) {
                            val builder = AlertDialog.Builder(this@RechercheParEntrepriseActivity)
                            builder.setMessage("Problème lors de l'appel au service Web")
                            builder.create().show()
                        }
                    })
                } else {
                    if (RechercheParEntrepriseActivityRadioButtonCodePostal.isChecked) {
                        svc.queryByCodePostal(
                            query,
                            RechercheParEntrepriseActivityEditTextCodePostal.text.toString(),
                            object : Callback<Result> {
                                override fun onResponse(
                                    call: Call<Result>?,
                                    response: Response<Result>?
                                ) {
                                    if (response!!.code() == 200) {                             // Demander au prof
                                        runOnUiThread {
                                            listResultRechercheParEntrepriseActivity.adapter =
                                                ArrayAdapter<Etablissement>(
                                                    this@RechercheParEntrepriseActivity,
                                                    android.R.layout.simple_list_item_1,
                                                    android.R.id.text1,
                                                    response.body()!!.etablissement!!
                                                )
                                            progressBarRechercheParEntrepriseActivity.visibility =
                                                View.GONE
                                            listResultRechercheParEntrepriseActivity.visibility =
                                                View.VISIBLE
                                        }
                                    }
                                }

                                override fun onFailure(call: Call<Result>?, t: Throwable?) {
                                    val builder =
                                        AlertDialog.Builder(this@RechercheParEntrepriseActivity)
                                    builder.setMessage("Problème lors de l'appel au service Web")
                                    builder.create().show()
                                }
                            })
                    } else if (RechercheParEntrepriseActivityRadioButtonDepartement.isChecked) {
                        svc.queryByDepartement(
                            query,
                            RechercheParEntrepriseActivityEditTextDepartement.text.toString(),
                            object : Callback<Result> {
                                override fun onResponse(
                                    call: Call<Result>?,
                                    response: Response<Result>?
                                ) {
                                    if (response!!.code() == 200) {                             // Demander au prof
                                        runOnUiThread {
                                            listResultRechercheParEntrepriseActivity.adapter =
                                                ArrayAdapter<Etablissement>(
                                                    this@RechercheParEntrepriseActivity,
                                                    android.R.layout.simple_list_item_1,
                                                    android.R.id.text1,
                                                    response.body()!!.etablissement!!
                                                )
                                            progressBarRechercheParEntrepriseActivity.visibility =
                                                View.GONE
                                            listResultRechercheParEntrepriseActivity.visibility =
                                                View.VISIBLE
                                        }
                                    }
                                }

                                override fun onFailure(call: Call<Result>?, t: Throwable?) {
                                    val builder =
                                        AlertDialog.Builder(this@RechercheParEntrepriseActivity)
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
                                if (response!!.code() == 200) {
                                    runOnUiThread {
                                        listResultRechercheParEntrepriseActivity.adapter =
                                            ArrayAdapter<Etablissement>(
                                                this@RechercheParEntrepriseActivity,
                                                android.R.layout.simple_list_item_1,
                                                android.R.id.text1,
                                                response.body()!!.etablissement!!
                                            )
                                        progressBarRechercheParEntrepriseActivity.visibility =
                                            View.GONE
                                        listResultRechercheParEntrepriseActivity.visibility =
                                            View.VISIBLE
                                    }
                                }
                            }

                            override fun onFailure(call: Call<Result>?, t: Throwable?) {
                                val builder =
                                    AlertDialog.Builder(this@RechercheParEntrepriseActivity)
                                builder.setMessage("Problème lors de l'appel au service Web")
                                builder.create().show()
                            }
                        })
                    }
                }
            }).start()
        }

        listResultRechercheParEntrepriseActivity.setOnItemClickListener { parent, view, position, id ->
            if (wasHistory) {
                val itemEntrepriseEntity = listResultRechercheParEntrepriseActivity
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
                val itemEtablissement = listResultRechercheParEntrepriseActivity
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