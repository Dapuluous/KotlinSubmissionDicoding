package com.dapuluous.cookingrecipe

object RecipesData {
    private val recipeNames = arrayOf("Patty Burger",
    "Udang Goreng",
    "Mie Goreng",
    "Pisang Goreng",
    "Telur Goreng",
    "Rendang",
    "Empek-Empek",
    "Mie Pangsit",
    "Onde-Onde",
    "Soto Makassar")

    private val recipeAuthors = arrayOf("By Dapuluous",
        "By Netamaru",
        "By Chroneko",
        "By Avoya",
        "By Emilia-Satella",
        "By Dika312",
        "By LeWind",
        "By Madoka Ayukawa",
        "By Arunaka",
        "By CamXDanna")

    private val recipeDetails = arrayOf("Bahan-bahan:\n" +
            "- 300 gr daging giling sapi\n" +
            "- 50 gr tepung roti\n" +
            "- 1 butir telur\n" +
            "- 1 buah bawang bombay, potong kecil\n" +
            "- Daun seledri, iris tipis\n" +
            "- 1/2 sdt bawang putih bubuk\n" +
            "- 1/2 sdt pala bubuk\n" +
            "- Lada secukupnya\n" +
            "- Garam secukupnya\n" +
            "- Minyak zaitun/minyak sayur untuk memanaskan beef\n" +
            "\n" +
            "Cara membuat:\n" +
            "1. Dalam wadah campurkan semua bahan, aduk rata\n" +
            "2. Ambil sekitar 55 gr adonan beef atau sesuai selera, kemudian bulatkan\n" +
            "3. Setelah itu bisa langsung dipanaskan di teflon atau bisa dibekukan di dalam freezer",

        "Bahan:\n" +
                "- 300 gr udang peci, ukuran sedang\n" +
                "- 1 sdm ketumbar bubuk\n" +
                "- 1 sdm bawang putih bubuk\n" +
                "- 1 sdt garam\n" +
                "- 1/2 sdt lada putih\n" +
                "- 8 siung bawang putih, cincang\n" +
                "- Minyak sayur secukupnya\n" +
                "\n" +
                "Cara membuat:\n" +
                "1. Bersihkan udang, beri perasan jeruk nipis dan potong sungutnya.\n" +
                "2. Marinasi udang dengan ketumbar bubuk, bawang putih bubuk, garam dan lada bubuk selama 30 menit.\n" +
                "3. Goreng udang yang sudah dimarinasi hingga kecokelatan dengan api sedang, angkat dan sisihkan.\n" +
                "4. Goreng bawang putih cincang dengan minyak bekas menggoreng udang hingga harum dan kekuningan. Tiriskan.\n" +
                "5. Panaskan 1 sdm minyak goreng dengan api kecil, masukkan udang dan bawang putih yang sudah digoreng tadi. Aduk hingga tercampur rata.\n" +
                "6. Sajikan dengan nasi hangat.",

        "Bahan-bahan:\n" +
                "- 1 bungkus mie telur\n" +
                "- 2 butir telur kocok lepas\n" +
                "- 1 batang daun bawang iris\n" +
                "- 100 gr sawi\n" +
                "- 100 gr kol\n" +
                "- 2 sdm kecap manis\n" +
                "- 1 sdt kecap asin\n" +
                "- 2 sdm saus tiram\n" +
                "- 1 sdm minyak wijen\n" +
                "- 3 sdm minyak goreng\n" +
                "- 1/2 sdm kaldu jamur\n" +
                "- 1/4 sdt garam\n" +
                "\n" +
                "Bumbu halus:\n" +
                "- 5 siung bawang merah\n" +
                "- 3 siung bawang putih\n" +
                "- 2 butir kemiri\n" +
                "\n" +
                "Cara membuat:\n" +
                "1. Rebus mie telur sampai lunak. Jangan terlalu lama biar nggak lembek, kemudian tiriskan.\n" +
                "2. Panaskan wajan, goreng telur kocok, buat orak arik, sisihkan di pinggir wajan.\n" +
                "3. Masukkan bumbu halus. Tumis bumbu sampai harum, masukkan semua bahan. Beri air sedikit biar bumbu meresap.\n" +
                "4. Aduk rata hingga air habis, koreksi rasa.\n" +
                "5. Sajikan dengan taburkan bawang goreng.",

        "Bahan-bahan:\n" +
                "- 10 buah pisang kepok, belah sebagian tidak sampai putus\n" +
                "- 5 sdm terigu\n" +
                "- 1 sdm tepung beras\n" +
                "- 1/4 sdt vanilli bubuk\n" +
                "- 1 sdm gula pasir\n" +
                "- Sejumput garam\n" +
                "- Air secukupnya\n" +
                "- Tepung panir secukupnya\n" +
                "\n" +
                "Cara membuat:\n" +
                "1. Campur terigu, tepung beras, vanili, gula pasir, dan garam. Tuang air sedikit demi sedikit, aduk rata adonan sampai dengan kekentalan yang pas. Celupkan pisang ke dalam adonan, lalu gulingkan ke tepung panir.\n" +
                "2. Panaskan minyak di dalam wajan dengan api sedang, goreng adonan pisang sampai matang kuning keemasan. Angkat dan tiriskan, pisang goreng pasir siap disajikan.\n",

        "Bahan :\n" +
                "\n" +
                "- 4 butir telur ayam atau bebek\n" +
                "- 1 sdm tepung beras\n" +
                "- 2 sdm penuh daun bawang iris halus\n" +
                "- 1/2 sdt merica bubuk\n" +
                "- 1 sdt garam.\n" +
                "- 10 buah cabai rawit iris kasar\n" +
                "- 1 sdt kecap manis.\n" +
                "\n" +
                "Cara Membuat :\n" +
                "\n" +
                "1. Kocok telur hingga berbuih halus.\n" +
                "2. Tambahkan daun bawang, tepung beras, merica dan garam. Kocok hingga benar-benar rata.\n" +
                "3. Panaskan minyak banyak dalam wajan besi atau aluminium yang cekung hingga panas benar. Jika ingin rasa lebih gurih bisa saja dipakai minyak jelantah bersih. Sebaiknya gunakan wajan cekung agar bentuk dadar bundar dan tebal.\n" +
                "4. Tuangkan sebagian telur kocok, dengan mengangkat wadah agak tinggi agar bisa terbentuk 'renda' di keliling telur. Masak hingga kecokelatan dan keriting pinggirnya.\n" +
                "5. Balikkan telur dan masak hingga kedua sisinya kuning kecokelatan. Angkat dan tiriskan.\n",

        "Bahan:\n" +
                "- kg daging sapi\n" +
                "- butir kelapa, diambil santan kental dan santan encernya\n" +
                "- lembar daun jeruk\n" +
                "- batang serai, memarkan\n" +
                "- butir asam kandis\n" +
                "- 100ml minyak goreng\n" +
                "- 5 gram garam\n" +
                "\n" +
                "Bumbu rendang daging sapi 1 Kg:\n" +
                "60 gram bawang merah\n" +
                "50 gram bawangputih\n" +
                "250 gram cabai merah besar\n" +
                "100 gram lengkuas\n" +
                "50 gram kemiri\n" +
                "2 gram cengkeh\n" +
                "\n" +
                "Cara Membuat rendang sapi:\n" +
                "1. Haluskan semua bahan Bumbu dengan diulek atau diblender.\n" +
                "2. Tumis bumbu dengan sedikit minyak goreng hingga wangi.\n" +
                "3. Masukkan batang serai, daun jeruk, asam kandis dan garam, aduk rata.\n" +
                "4. Tuangi santan dan dididihkan, masukkan daging.\n" +
                "5. Masak dengan api kecil selama beberapa jam sampai daging empuk dan bumbu kecoklatan sesuai selera.\n",

        "Bahan:\n" +
                "- 1 kg tepung sagu (kualitas baik)\n" +
                "- 1 kg daging ikan tenggiri (giling halus)\n" +
                "- 250 ml air es\n" +
                "- Secukupnya air bersih (rebus)\n" +
                "- 1 sdt garam halus\n" +
                "- 1 1/2 sdt penyedap rasa\n" +
                "- Secukupnya minyak (untuk menggoreng)\n" +
                "\n" +
                "Bahan kuah:\n" +
                "- 3/4 liter air bersih\n" +
                "- 150 gr bawang putih ( cincang halus )\n" +
                "- 60 gr air asam jawa\n" +
                "- 250 gr gula merah ( sisir halus )\n" +
                "- 1 sdm ebi kering bubuk\n" +
                "- 100 gr cabe rawit ( haluskan )\n" +
                "\n" +
                "Cara membuat kuah empek empek Palembang:\n" +
                "\n" +
                "1. Siapkan wadah, lalu masukkan air, air asam jawa dan gula merah, rebus sampai mendidih\n" +
                "2. Masukkan cabe rawit, bawang putih, ebi dan garam, lalu aduk sampai tercampur merata.\n" +
                "3. Angkat dari kompor, lalu biarkan hingga menjadi hangat.\n" +
                "\n" +
                "Cara membuat empek empek:\n" +
                "\n" +
                "1. Siapkan wadah, lalu masukkan ikan, garam, penyedap rasa dan air es, campur dengan daging ikan (sudah digiling), lalu aduk sampai merata.\n" +
                "2. Masukkan tepung sedikit demi sedikit, uleni hingga adonan menjadi pas dan kalis.\n" +
                "3. Ambil secukupnya adonan pempek, lalu bentuklah dengan sesuai dengan ukuran (selera)\n" +
                "4. Masukkan adonan pempek yang sudah selesai dibentuk kedalam air yang mendidih, tunggu hingga matang (mengapung), lalu angkat dan tiriskan.\n" +
                "5. Siapkan wajan, panaskan minyak goreng, lalu goreng adonan pempek hingga matang (cirinya: bagian kulitnya berwarna kecoklatan).\n" +
                "6. Angkat, lalu tiriskan.\n" +
                "7. Lalu potong-potong pempek goreng tersebut.\n" +
                "8. Empek empek palembang siap disajikan.\n",

        "Bahan\n" +
                "\n" +
                "    mie pangsit 250 gr \n" +
                "    bawang putih 3 butir \n" +
                "    serre 4 batang \n" +
                "    daun bawang 200 gr \n" +
                "    krupuk pangsit\n" +
                "    sawi hijau\n" +
                "    air setengah liter\n" +
                "    pala 1 buah \n" +
                "    ayam potong kecil 250 gr \n" +
                "    minyak wijen 2 sdt \n" +
                "    garam, gula merah secukupnya \n" +
                "    jari jahe 2 ruas \n" +
                "    bawang merah 3 butir \n" +
                "    ketumbar 1 sdt \n" +
                "    merica 1/2 sdt \n" +
                "    daun salam 3 lembar \n" +
                "    kaldu ayam\n" +
                "    daun jeruk 3 lembar \n" +
                "    kemiri 4 butir \n" +
                "\n" +
                "Cara membuat mie ayam pangsit khas Jawa yang enak\n" +
                "\n" +
                "    Ambil daging ayamnya\n" +
                "    Cuci sampai bersih\n" +
                "    Lalu potong kecil-kecil\n" +
                "    Setelah itu potong juga daun bawangnya\n" +
                "    Lalu haluskan bumbu bawang putih, merah, pala, merica, kemiri dan juga jahe\n" +
                "    Kemudian tumis sampai harum\n" +
                "    Setelah itu tambahkan sedikit air\n" +
                "    Lalu tambahkan juga ayam, daun salam, daun bawang, serei, garam, dan juga jeruk masak\n" +
                "    Pastikan proses ini samapi arinya berkurang\n" +
                "    Masak mienya lalu sawinya juga, setelah itu angkat dan tiriskan\n" +
                "    Setelah itu tuangkan mienya kedalam mangkok\n" +
                "    Kasih minyak wijen dan aduk sampai merata\n" +
                "    Kasih kuahnya / kaldu ayam, \n" +
                "    Kasih juga kerupuk\n" +
                "    Mie ayam jawa siap disantap.\n",

        "Bahan kulit:\n" +
                "- 250 gr tepung ketan\n" +
                "- 35 gr tepung beras\n" +
                "- 75 gr gula pasir\n" +
                "- 125 gr kentang kukus, haluskan\n" +
                "- 1 sdt garam\n" +
                "- 200 ml air\n" +
                "- wijen secukupnya\n" +
                "\n" +
                "Bahan isi:\n" +
                "- 100 gr kacang hijau, rendam 1 jam buang kulitnya\n" +
                "- 50 ml santan kental\n" +
                "- 50 ml air\n" +
                "- 60 gr gula pasir\n" +
                "- 1 lembar daun pandan\n" +
                "- 1/4 sdt garam\n" +
                "- 1/2 sdt bubuk vanili\n" +
                "\n" +
                "Cara membuat:\n" +
                "1. Buat bahan isi, kukus kacang hijau hingga lunak, angkat.\n" +
                "Blender bersama air santan.\n" +
                "2. Tambahkan gula pasir, garam dan daun pandan, masak hingga kalis.\n" +
                "3. Dinginkan bagi dan bulatkan masing-masing 15 gr, sisihkan.\n" +
                "4. Buat kulit onde, campurkan semua bahan jadi satu hingga kalis.\n" +
                "5. Lalu timbang bahan kulit per biji 30 gr dan isi 15 gr.\n" +
                "6. Sewaktu mengisi basahi tangan agar adonan mulus tidak pecah.\n" +
                "7. Kemudian celupkan ke air, lalu celup ke biji wijen. Goreng hingga kecokelatan dengan api kecil sekali. ",

        "\n" +
                "Bahan-bahan\n" +
                "\n" +
                "    1.500 gr daging dan jeroan siap pakai\n" +
                "    2,5 lt air tajin, cucian ketiga\n" +
                "    1½ sdt garam\n" +
                "    6 sdm minyak goreng\n" +
                "\n" +
                "Bumbu halus:\n" +
                "\n" +
                "    1 sdm ketumbar\n" +
                "    ½ sdt jintan\n" +
                "    ½ buah pala\n" +
                "    1 sdt merica\n" +
                "    5 batang serai\n" +
                "    3 cm lengkuas\n" +
                "    8 butir bawang merah\n" +
                "    4 siung bawang putih\n" +
                "    2½ sdt garam\n" +
                "    100 g kacang tanah kupas, sangrai\n" +
                "\n" +
                "Sambal taoco:\n" +
                "\n" +
                "    4 buah cabai merah\n" +
                "    8 buah cabai rawit\n" +
                "    6 butir bawang merah\n" +
                "    6 sdm taoco\n" +
                "    150 ml air\n" +
                "    2 sdm gula pasir\n" +
                "\n" +
                "Pelengkap:\n" +
                "\n" +
                "    Cuka\n" +
                "    Bawang goreng\n" +
                "    2 sdm daun bawang iris\n" +
                "    2 sdm seledri iris\n" +
                "    Jeruk nipis iris\n" +
                "    6 - 8 buah burasa\n" +
                "\n" +
                "Cara membuat:\n" +
                "\n" +
                "    Masak daging, jeroan, air tajin, dan garam hingga empuk. Angkat daging dan jeroan, potong-potong sesuai selera.Bumbu Halus: Haluskan ketumbar, jintan, merica,serai, lengkuas, bawang putih, garam dan kacang tanah, sisihkan.Panaskan minyak, tumis bumbu halus sampai harum, angkat, masukkan dalam panci kaldu. Teruskan memasak di atas api kecil hingga kuah sedikit menyusut.Sambal taoco: Gerus halus cabai, bawang merah, dan taoco. Tumis campuran cabai dalam wajan hingga harum. Masukkan air dan gula pasir, didihkan, angkat.Penyajian: Sendokan coto dalam mangkuk saji, tambahkan bahan pelengkap sesuai selera. Sajikan coto dengan sambal taoco dan burasa.\n" +
                "\n")

    private val recipePhotos = intArrayOf(R.drawable.beef_burger,
        R.drawable.udang_goreng_cover,
        R.drawable.mie_goreng,
        R.drawable.pisang_goreng,
        R.drawable.telur_goreng,
        R.drawable.rendang,
        R.drawable.empek_empek,
        R.drawable.mie_pangsit,
        R.drawable.onde_onde,
        R.drawable.soto_makasar
    )

    val listData: ArrayList<Recipe> get() {
        val list = arrayListOf<Recipe>()

        for (x in recipeNames.indices) {
            val objRecipe = Recipe()

            objRecipe.recipeName = recipeNames[x]
            objRecipe.recipeDetail = recipeDetails[x]
            objRecipe.recipePhoto = recipePhotos[x]
            objRecipe.recipeAuthor = recipeAuthors[x]

            list.add(objRecipe)
        }
        return list
    }
}