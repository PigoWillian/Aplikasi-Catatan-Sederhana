class PengelolaCatatan {
    private val daftarCatatan = mutableListOf<Catatan>()

    fun tambahCatatan(catatan: Catatan) {
        daftarCatatan.add(catatan)
    }

    fun tampilkanDaftarCatatan() {
        println("Daftar Catatan:")
        for ((index, catatan) in daftarCatatan.withIndex()) {
            println("${index + 1}. ${catatan.judul}")
        }
    }

    suspend fun menampilkanDaftarCatatan() {
        println("Daftar Catatan:")
        Catatan.forEach { catatan ->
            println("Judul: ${catatan.title}, Isi: ${catatan.content}")
        }
    }
     runBlocking {
        daftarCatatan.menampilkanDaftarCatatan()
    }
}

fun main() {

    val pengelolaCatatan = PengelolaCatatan()

    pengelolaCatatan.tambahCatatan(Catatan("Catatan 1", "Isi catatan 1"))
    pengelolaCatatan.tambahCatatan(Catatan("Catatan 2", "Isi catatan 2"))

    runBlocking {
        menampilkanDaftarCatatan(pengelolaCatatan)
    }
}
