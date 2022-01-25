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
}