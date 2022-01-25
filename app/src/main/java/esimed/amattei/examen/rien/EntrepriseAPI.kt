package esimed.amattei.examen.rien

import retrofit2.Call
import esimed.amattei.examen.rien.model.Result
import retrofit2.http.GET
import retrofit2.http.Path

interface EntrepriseAPI {
    @GET("/api/sirene/v1/full_text/{q}?per_page=100")
    fun search(@Path("q") query: String): Call<Result>
}