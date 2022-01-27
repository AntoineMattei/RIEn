package esimed.amattei.examen.rien

import retrofit2.Callback
import esimed.amattei.examen.rien.model.Result
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.Call

class EntrepriseService {
    private val apiUrl = "https://entreprise.data.gouv.fr/"

    fun query(query: String, callback: Callback<Result>) {
        val retrofit: Retrofit = Retrofit
            .Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api: EntrepriseAPI = retrofit.create(EntrepriseAPI::class.java)

        val call: Call<Result> = api.search(query)
        call.enqueue(callback)
    }

    fun queryByActivite(query: String, activite: String, callback: Callback<Result>) {
        val retrofit: Retrofit = Retrofit
            .Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api: EntrepriseAPI = retrofit.create(EntrepriseAPI::class.java)

        val call: Call<Result> = api.searchByActivite(query, activite)
        call.enqueue(callback)
    }

    fun queryByCodeNaf(query: String, codeNaf: String, callback: Callback<Result>) {
        val retrofit: Retrofit = Retrofit
            .Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api: EntrepriseAPI = retrofit.create(EntrepriseAPI::class.java)

        val call: Call<Result> = api.searchByCodeNaf(query, codeNaf)
        call.enqueue(callback)
    }

    fun queryByDepartement(query: String, departement: String, callback: Callback<Result>) {
        val retrofit: Retrofit = Retrofit
            .Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api: EntrepriseAPI = retrofit.create(EntrepriseAPI::class.java)

        val call: Call<Result> = api.searchByDepartement(query, departement)
        call.enqueue(callback)
    }

    fun queryByCodePostal(query: String, codePostal: String, callback: Callback<Result>) {
        val retrofit: Retrofit = Retrofit
            .Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api: EntrepriseAPI = retrofit.create(EntrepriseAPI::class.java)

        val call: Call<Result> = api.searchByCodePostal(query, codePostal)
        call.enqueue(callback)
    }
}