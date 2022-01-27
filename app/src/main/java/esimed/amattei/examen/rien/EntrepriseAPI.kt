package esimed.amattei.examen.rien

import retrofit2.Call
import esimed.amattei.examen.rien.model.Result
import retrofit2.http.*

interface EntrepriseAPI {
    @GET("/api/sirene/v1/full_text/{q}?per_page=100")
    fun search(@Path("q") query: String): Call<Result>
    @GET("/api/sirene/v1/full_text/{q}?per_page=100")
    fun searchByActivite(@Path("q") query: String, @Query("activite_principale") activite: String): Call<Result>
    @GET("/api/sirene/v1/full_text/{q}?per_page=100")
    fun searchByCodeNaf(@Path("q") query: String, @Query("activite_principale") code_naf: String): Call<Result>
    @GET("/api/sirene/v1/full_text/{q}?per_page=100")
    fun searchByCodePostal(@Path("q") query: String, @Query("code_postal") code_postal: String): Call<Result>
    @GET("/api/sirene/v1/full_text/{q}?per_page=100")
    fun searchByDepartement(@Path("q") query: String, @Query("departement") departement: String): Call<Result>
}