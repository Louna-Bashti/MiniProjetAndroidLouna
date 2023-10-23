package com.example.tp1android

data class AffichageMovie(
    var page: Int,
    val results: List<MovieResult>,
)

data class MovieResult(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val media_type: String,
    val original_language: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

data class AffichageSeries(
    val page: Int,
    val results: List<SeriesResult>,
)

data class SeriesResult(
    val adult: Boolean,
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val media_type: String,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int
)

data class AffichageActors(
    val page: Int,
    val results: List<ActorResult>,
)

data class ActorResult(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for: List<KnownFor>,
    val known_for_department: String,
    val media_type: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)

data class KnownFor(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val media_type: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

data class MovieDetails(
    val backdrop_path: String = "",
    val credits: Credits = Credits(),
    val genres: List<Genre> = listOf(),
    val homepage: String = "",
    val id: Int = 0,
    val overview: String = "",
    val poster_path: String = "",
    val production_companies: List<ProductionCompany> = listOf(),
    val production_countries: List<ProductionCountry> = listOf(),
    val release_date: String = "",
    val revenue: Int = 0,
    val runtime: Int = 0,
    val spoken_languages: List<SpokenLanguage> = listOf(),
    val title: String = "",
    val video: Boolean = false,
)

data class Credits(
    val cast: List<Cast> = listOf(),
    val crew: List<Crew> = listOf()
)

data class Genre(
    val id: Int = 0,
    val name: String = ""
)

data class ProductionCompany(
    val id: Int = 0,
    val logo_path: String = "",
    val name: String = "",
    val origin_country: String = ""
)

data class ProductionCountry(
    val iso_3166_1: String = "",
    val name: String = ""
)

data class SpokenLanguage(
    val english_name: String = "",
    val iso_639_1: String = "",
    val name: String = ""
)

data class Cast(
    val adult: Boolean = false,
    val cast_id: Int = 0,
    val character: String = "",
    val credit_id: String = "",
    val gender: Int = 0,
    val id: Int = 0,
    val known_for_department: String = "",
    val name: String = "",
    val order: Int = 0,
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)

data class Crew(
    val adult: Boolean = false,
    val credit_id: String = "",
    val department: String = "",
    val gender: Int = 0,
    val id: Int = 0,
    val job: String = "",
    val known_for_department: String = "",
    val name: String = "",
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)

data class SerieDetails(
    val backdrop_path: String = "",
    val created_by: List<CreatedBy> = listOf(),
    val credits: Credits = Credits(),
    val episode_run_time: List<Int> = listOf(),
    val first_air_date: String ="",
    val genres: List<Genre> = listOf(),
    val id: Int = 0,
    val in_production: Boolean = false,
    val languages: List<String> = listOf(),
    val last_air_date: String ="",
    val last_episode_to_air: LastEpisodeToAir=LastEpisodeToAir(),
    val name: String="",
    val networks: List<Network> = listOf(),
    val next_episode_to_air: NextEpisodeToAir = NextEpisodeToAir(),
    val number_of_episodes: Int = 0,
    val number_of_seasons: Int = 0,
    val origin_country: List<String> = listOf(),
    val original_language: String = "",
    val original_name: String ="",
    val overview: String ="",
    val popularity: Double =0.0,
    val poster_path: String ="",
    val production_companies: List<ProductionCompany> = listOf(),
    val production_countries: List<ProductionCountry> = listOf(),
    val seasons: List<Season> = listOf(),
    val spoken_languages: List<SpokenLanguage> = listOf(),
    val status: String ="",
    val tagline: String="",
    val type: String="",
    val vote_average: Double=0.0,
    val vote_count: Int=0
)

data class CreatedBy(
    val credit_id: String ="",
    val gender: Int=0,
    val id: Int=0,
    val name: String="",
    val profile_path: String=""
)

data class LastEpisodeToAir(
    val air_date: String="",
    val episode_number: Int=0,
    val episode_type: String="",
    val id: Int=0,
    val name: String="",
    val overview: String="",
    val production_code: String="",
    val runtime: Int=0,
    val season_number: Int=0,
    val show_id: Int=0,
    val still_path: String="",
    val vote_average: Double=0.0,
    val vote_count: Int=0
)

data class Network(
    val id: Int=0,
    val logo_path: String="",
    val name: String="",
    val origin_country: String=""
)

data class NextEpisodeToAir(
    val air_date: String="",
    val episode_number: Int=0,
    val episode_type: String="",
    val id: Int=0,
    val name: String="",
    val overview: String="",
    val production_code: String="",
    val runtime: Any="",
    val season_number: Int=0,
    val show_id: Int=0,
    val still_path: String="",
    val vote_average: Double=0.0,
    val vote_count: Int=0
)

data class Season(
    val air_date: String="",
    val episode_count: Int=0,
    val id: Int=0,
    val name: String="",
    val overview: String="",
    val poster_path: String="",
    val season_number: Int=0,
    val vote_average: Double=0.0
)

