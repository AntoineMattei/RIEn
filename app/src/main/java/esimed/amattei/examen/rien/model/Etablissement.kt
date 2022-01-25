package esimed.amattei.examen.rien.model

import java.io.Serializable
import com.google.gson.annotations.SerializedName

class Etablissement : Serializable {
    @SerializedName("id")
    val id: String? = null

    @SerializedName("siren")
    val siren: String? = null

    @SerializedName("siret")
    val siret: String? = null

    @SerializedName("nic")
    val nic: String? = null

    @SerializedName("l1_normalisee")
    val l1_normalisee: String? = null

    @SerializedName("l2_normalisee")
    val l2_normalisee: String? = null

    @SerializedName("l3_normalisee")
    val l3_normalisee: String? = null

    @SerializedName("l4_normalisee")
    val l4_normalisee: String? = null

    @SerializedName("l5_normalisee")
    val l5_normalisee: String? = null

    @SerializedName("l6_normalisee")
    val l6_normalisee: String? = null

    @SerializedName("l7_normalisee")
    val l7_normalisee: String? = null

    @SerializedName("l1_declaree")
    val l1_declaree: String? = null

    @SerializedName("l2_declaree")
    val l2_declaree: String? = null

    @SerializedName("l3_declaree")
    val l3_declaree: String? = null

    @SerializedName("l4_declaree")
    val l4_declaree: String? = null

    @SerializedName("l5_declaree")
    val l5_declaree: String? = null

    @SerializedName("l6_declaree")
    val l6_declaree: String? = null

    @SerializedName("l7_declaree")
    val l7_declaree: String? = null

    @SerializedName("numero_voie")
    val numero_voie: Int? = null

    @SerializedName("indice_repetition")
    val indice_repetition: String? = null

    @SerializedName("type_voie")
    val type_voie: String? = null

    @SerializedName("libelle_voie")
    val libelle_voie: String? = null

    @SerializedName("code_postal")
    val code_postal: Int? = null

    @SerializedName("cedex")
    val cedex: String? = null

    @SerializedName("region")
    val region: Int? = null

    @SerializedName("libelle_region")
    val libelle_region: String? = null

    @SerializedName("departement")
    val departement: Int? = null

    @SerializedName("arrondissement")
    val arrondissement: Int? = null

    @SerializedName("canton")
    val canton: Int? = null

    @SerializedName("commune")
    val commune: Int? = null

    @SerializedName("libelle_commune")
    val libelle_commune: String? = null

    @SerializedName("departement_unite_urbaine")
    val departement_unite_urbaine: Int? = null

    @SerializedName("taille_unite_urbaine")
    val taille_unite_urbaine: Int? = null

    @SerializedName("numero_unite_urbaine")
    val numero_unite_urbaine: Int? = null

    @SerializedName("etablissement_public_cooperation_intercommunale")
    val etablissement_public_cooperation_intercommunale: Int? = null

    @SerializedName("tranche_commune_detaillee")
    val tranche_commune_detaillee: Int? = null

    @SerializedName("zone_emploi")
    val zone_emploi: Int? = null

    @SerializedName("is_siege")
    val is_siege: Int? = null

    @SerializedName("enseigne")
    val enseigne: String? = null

    @SerializedName("indicateur_champ_publipostage")
    val indicateur_champ_publipostage: String? = null

    @SerializedName("statut_prospection")
    val statut_prospection: String? = null

    @SerializedName("date_introduction_base_diffusion")
    val date_introduction_base_diffusion: Int? = null

    @SerializedName("nature_entrepreneur_individuel")
    val nature_entrepreneur_individuel: String? = null

    @SerializedName("libelle_nature_entrepreneur_individuel")
    val libelle_nature_entrepreneur_individuel: String? = null

    @SerializedName("activite_principale")
    val activite_principale: String? = null

    @SerializedName("libelle_activite_principale")
    val libelle_activite_principale: String? = null

    @SerializedName("date_validite_activite_principale")
    val date_validite_activite_principale: String? = null

    @SerializedName("tranche_effectif_salarie")
    val tranche_effectif_salarie: String? = null

    @SerializedName("libelle_tranche_effectif_salarie")
    val libelle_tranche_effectif_salarie: String? = null

    @SerializedName("tranche_effectif_salarie_centaine_pret")
    val tranche_effectif_salarie_centaine_pret: String? = null

    @SerializedName("date_validite_effectif_salarie")
    val date_validite_effectif_salarie: Int? = null

    @SerializedName("origine_creation")
    val origine_creation: String? = null

    @SerializedName("date_creation")
    val date_creation: Int? = null

    @SerializedName("date_debut_activite")
    val date_debut_activite: Int? = null

    @SerializedName("nature_activite")
    val nature_activite: String? = null

    @SerializedName("lieu_activite")
    val lieu_activite: String? = null

    @SerializedName("type_magasin")
    val type_magasin: String? = null

    @SerializedName("is_saisonnier")
    val is_saisonnier: String? = null

    @SerializedName("modalite_activite_principale")
    val modalite_activite_principale: String? = null

    @SerializedName("caractere_productif")
    val caractere_productif: String? = null

    @SerializedName("participation_particuliere_production")
    val participation_particuliere_production: String? = null

    @SerializedName("caractere_auxiliaire")
    val caractere_auxiliaire: String? = null

    @SerializedName("nom_raison_sociale")
    val nom_raison_sociale: String? = null

    @SerializedName("sigle")
    val sigle: String? = null

    @SerializedName("nom")
    val nom: String? = null

    @SerializedName("prenom")
    val prenom: String? = null

    @SerializedName("civilite")
    val civilite: String? = null

    @SerializedName("numero_rna")
    val numero_rna: String? = null

    @SerializedName("nic_siege")
    val nic_siege: Int? = null

    @SerializedName("region_siege")
    val region_siege: Int? = null

    @SerializedName("departement_commune_siege")
    val departement_commune_siege: Int? = null

    @SerializedName("email")
    val email: String? = null

    @SerializedName("nature_juridique_entreprise")
    val nature_juridique_entreprise: Int? = null

    @SerializedName("libelle_nature_juridique_entreprise")
    val libelle_nature_juridique_entreprise: String? = null

    @SerializedName("activite_principale_entreprise")
    val activite_principale_entreprise: String? = null

    @SerializedName("libelle_activite_principale_entreprise")
    val libelle_activite_principale_entreprise: String? = null

    @SerializedName("date_validite_activite_principale_entreprise")
    val date_validite_activite_principale_entreprise: String? = null

    @SerializedName("activite_principale_registre_metier")
    val activite_principale_registre_metier: String? = null

    @SerializedName("is_ess")
    val is_ess: String? = null

    @SerializedName("date_ess")
    val date_ess: String? = null

    @SerializedName("tranche_effectif_salarie_entreprise")
    val tranche_effectif_salarie_entreprise: String? = null

    @SerializedName("libelle_tranche_effectif_salarie_entreprise")
    val libelle_tranche_effectif_salarie_entreprise: String? = null

    @SerializedName("tranche_effectif_salarie_entreprise_centaine_pret")
    val tranche_effectif_salarie_entreprise_centaine_pret: String? = null

    @SerializedName("date_validite_effectif_salarie_entreprise")
    val date_validite_effectif_salarie_entreprise: Int? = null

    @SerializedName("categorie_entreprise")
    val categorie_entreprise: String? = null

    @SerializedName("date_creation_entreprise")
    val date_creation_entreprise: String? = null

    @SerializedName("date_introduction_base_diffusion_entreprise")
    val date_introduction_base_diffusion_entreprise: Int? = null

    @SerializedName("indice_monoactivite_entreprise")
    val indice_monoactivite_entreprise: String? = null

    @SerializedName("modalite_activite_principale_entreprise")
    val modalite_activite_principale_entreprise: String? = null

    @SerializedName("caractere_productif_entreprise")
    val caractere_productif_entreprise: String? = null

    @SerializedName("date_validite_rubrique_niveau_entreprise_esa")
    val date_validite_rubrique_niveau_entreprise_esa: String? = null

    @SerializedName("tranche_chiffre_affaire_entreprise_esa")
    val tranche_chiffre_affaire_entreprise_esa: String? = null

    @SerializedName("activite_principale_entreprise_esa")
    val activite_principale_entreprise_esa: String? = null

    @SerializedName("premiere_activite_secondaire_entreprise_esa")
    val premiere_activite_secondaire_entreprise_esa: String? = null

    @SerializedName("deuxieme_activite_secondaire_entreprise_esa")
    val deuxieme_activite_secondaire_entreprise_esa: String? = null

    @SerializedName("troisieme_activite_secondaire_entreprise_esa")
    val troisieme_activite_secondaire_entreprise_esa: String? = null

    @SerializedName("quatrieme_activite_secondaire_entreprise_esa")
    val quatrieme_activite_secondaire_entreprise_esa: String? = null

    @SerializedName("nature_mise_a_jour")
    val nature_mise_a_jour: String? = null

    @SerializedName("indicateur_mise_a_jour_1")
    val indicateur_mise_a_jour_1: String? = null

    @SerializedName("indicateur_mise_a_jour_2")
    val indicateur_mise_a_jour_2: String? = null

    @SerializedName("indicateur_mise_a_jour_3")
    val indicateur_mise_a_jour_3: String? = null

    @SerializedName("date_mise_a_jour")
    val date_mise_a_jour: String? = null

    @SerializedName("created_at")
    val created_at: String? = null

    @SerializedName("updated_at")
    val updated_at: String? = null

    @SerializedName("longitude")
    val longitude: Double? = null

    @SerializedName("latitude")
    val latitude: Double? = null

    @SerializedName("geo_score")
    val geo_score: Double? = null

    @SerializedName("geo_type")
    val geo_type: String? = null

    @SerializedName("geo_adresse")
    val geo_adresse: String? = null

    @SerializedName("geo_id")
    val geo_id: String? = null

    @SerializedName("geo_ligne")
    val geo_ligne: String? = null

    @SerializedName("geo_l4")
    val geo_l4: String? = null

    @SerializedName("geo_l5")
    val geo_l5: String? = null

    override fun toString(): String {
        if (indicateur_champ_publipostage == "A") {
            return "$nom_raison_sociale ($geo_adresse) : $libelle_activite_principale_entreprise (code NAF : $activite_principale_entreprise).\n" +
                    "Cette entreprise est active."
        } else {
            return "$nom_raison_sociale ($geo_adresse) : $libelle_activite_principale_entreprise (code NAF : $activite_principale_entreprise).\n" +
                    "Cette entreprise n'est pas active."
        }
    }
}