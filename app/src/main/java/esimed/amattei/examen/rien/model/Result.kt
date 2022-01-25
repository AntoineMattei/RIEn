package esimed.amattei.examen.rien.model

import com.google.gson.annotations.SerializedName

class Result {
    @SerializedName("total_results")
    val total_results: Int? = null

    @SerializedName("total_pages")
    val total_pages: Int? = null

    @SerializedName("per_page")
    val per_page: Int? = null

    @SerializedName("page")
    val page: Int? = null

    @SerializedName("etablissement")
    val etablissement: List<Etablissement>? = null

    @SerializedName("spellcheck")
    val spellcheck: String? = null

    @SerializedName("suggestions")
    val suggestions: List<String>? = null
}