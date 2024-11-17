package com.example.drinkly.data

import androidx.compose.ui.graphics.Color
import com.example.drinkly.R
import com.example.drinkly.model.Kategori
import com.example.drinkly.model.Rekomendasi
import com.example.drinkly.model.Tanggal

object DummyData {
    val rekomendasiList = listOf(
        Rekomendasi(
            id = 1,
            title = "Air Lemon Mint",
            description = "Kombinasi segar antara lemon dan mint.",
            imageRes = R.drawable.lemon_mint,
            ingredients = listOf("1 Lemon", "10 Daun Mint", "1 Liter Air"),
            benefits = "Membantu pencernaan, menyegarkan nafas, dan menghidrasi tubuh.",
            preparationSteps = listOf(
                "Iris lemon menjadi potongan tipis.",
                "Masukkan irisan lemon dan daun mint ke dalam toples.",
                "Tambahkan 1 liter air ke dalam toples.",
                "Dinginkan di kulkas selama minimal 2 jam sebelum disajikan."
            )
        ),
        Rekomendasi(
            id = 2,
            title = "Air Jeruk Kayu Manis",
            description = "Kombinasi jeruk dengan rasa hangat dari kayu manis.",
            imageRes = R.drawable.orange_cinamon,
            ingredients = listOf("1 Jeruk", "1 Batang Kayu Manis", "1 Liter Air"),
            benefits = "Kaya antioksidan, meningkatkan metabolisme, dan membantu penurunan berat badan.",
            preparationSteps = listOf(
                "Iris jeruk menjadi potongan bulat.",
                "Masukkan irisan jeruk dan batang kayu manis ke dalam toples.",
                "Isi toples dengan 1 liter air.",
                "Diamkan di kulkas selama 3–4 jam untuk hasil terbaik."
            )
        ),
        Rekomendasi(
            id = 3,
            title = "Air Stroberi Basil",
            description = "Perpaduan manis stroberi dengan kesegaran daun basil.",
            imageRes = R.drawable.strawberry_basil,
            ingredients = listOf("5 Stroberi", "5 Daun Basil", "1 Liter Air"),
            benefits = "Kaya vitamin C, meningkatkan kesehatan kulit, dan memberikan rasa segar.",
            preparationSteps = listOf(
                "Potong stroberi menjadi dua bagian.",
                "Masukkan stroberi dan daun basil ke dalam toples.",
                "Tambahkan 1 liter air ke dalam toples.",
                "Dinginkan di kulkas selama 2 jam sebelum disajikan."
            )
        ),
        Rekomendasi(
            id = 4,
            title = "Air Apel Kayu Manis",
            description = "Rasa hangat dari apel dan kayu manis.",
            imageRes = R.drawable.apple_cinamon,
            ingredients = listOf("1 Apel", "1 Batang Kayu Manis", "1 Liter Air"),
            benefits = "Meningkatkan energi, membantu menurunkan gula darah, dan kaya antioksidan.",
            preparationSteps = listOf(
                "Iris apel menjadi potongan tipis.",
                "Masukkan apel dan batang kayu manis ke dalam toples.",
                "Tambahkan 1 liter air.",
                "Biarkan di kulkas selama 4 jam sebelum disajikan."
            )
        ),
        Rekomendasi(
            id = 5,
            title = "Air Semangka Mint",
            description = "Segarnya semangka dengan daun mint.",
            imageRes = R.drawable.watermelon_mint,
            ingredients = listOf("5 Potongan Semangka", "10 Daun Mint", "1 Liter Air"),
            benefits = "Menghidrasi tubuh dengan baik dan membantu pencernaan.",
            preparationSteps = listOf(
                "Potong semangka menjadi potongan kecil.",
                "Masukkan potongan semangka dan daun mint ke dalam toples.",
                "Tambahkan 1 liter air.",
                "Dinginkan selama 2–3 jam sebelum dinikmati."
            )
        ),
        Rekomendasi(
            id = 6,
            title = "Air Nanas Mint",
            description = "Manis segar nanas berpadu dengan aroma mint.",
            imageRes = R.drawable.pineapple_mint,
            ingredients = listOf("5 Potongan Nanas", "10 Daun Mint", "1 Liter Air"),
            benefits = "Meningkatkan kekebalan tubuh dan membantu pencernaan.",
            preparationSteps = listOf(
                "Potong nanas menjadi potongan kecil.",
                "Masukkan nanas dan daun mint ke dalam toples.",
                "Tambahkan 1 liter air.",
                "Biarkan di kulkas selama 3–4 jam sebelum disajikan."
            )
        ),
        Rekomendasi(
            id = 7,
            title = "Air Mentimun Lemon",
            description = "Kesegaran mentimun yang dipadukan dengan asam lemon.",
            imageRes = R.drawable.cucumber_lemon,
            ingredients = listOf("1 Mentimun", "1 Lemon", "1 Liter Air"),
            benefits = "Menghidrasi tubuh, membantu detoksifikasi, dan menyejukkan kulit.",
            preparationSteps = listOf(
                "Iris mentimun dan lemon menjadi potongan tipis.",
                "Masukkan irisan ke dalam toples.",
                "Tambahkan 1 liter air.",
                "Dinginkan di kulkas selama 2 jam sebelum diminum."
            )
        ),
        Rekomendasi(
            id = 8,
            title = "Air Kiwi Stroberi",
            description = "Perpaduan manis stroberi dan asam kiwi.",
            imageRes = R.drawable.kiwi_strawberry,
            ingredients = listOf("2 Kiwi", "5 Stroberi", "1 Liter Air"),
            benefits = "Kaya vitamin C dan membantu kesehatan kulit.",
            preparationSteps = listOf(
                "Kupas kiwi dan iris tipis.",
                "Potong stroberi menjadi dua bagian.",
                "Masukkan kiwi dan stroberi ke dalam toples.",
                "Tambahkan 1 liter air dan biarkan dingin selama 3 jam."
            )
        ),
        Rekomendasi(
            id = 9,
            title = "Air Mangga Jeruk Nipis",
            description = "Perpaduan manis mangga dan asam jeruk nipis.",
            imageRes = R.drawable.mango_lime,
            ingredients = listOf("1 Mangga", "1 Jeruk Nipis", "1 Liter Air"),
            benefits = "Meningkatkan energi dan membantu metabolisme.",
            preparationSteps = listOf(
                "Kupas mangga dan potong kecil-kecil.",
                "Iris tipis jeruk nipis.",
                "Masukkan mangga dan jeruk nipis ke dalam toples.",
                "Tambahkan 1 liter air dan dinginkan selama 2 jam."
            )
        ),
        Rekomendasi(
            id = 10,
            title = "Air Anggur Lemon",
            description = "Segarnya anggur dengan tambahan asam dari lemon.",
            imageRes = R.drawable.grape_lemon,
            ingredients = listOf("10 Anggur", "1 Lemon", "1 Liter Air"),
            benefits = "Kaya antioksidan dan membantu hidrasi.",
            preparationSteps = listOf(
                "Potong anggur menjadi dua bagian.",
                "Iris lemon menjadi potongan tipis.",
                "Masukkan anggur dan lemon ke dalam toples.",
                "Tambahkan 1 liter air dan dinginkan selama 2 jam."
            )
        ),
        Rekomendasi(
            id = 11,
            title = "Air Semangka Lemon",
            description = "Perpaduan segarnya semangka dengan asamnya lemon.",
            imageRes = R.drawable.watermelon_lemon,
            ingredients = listOf("5 Potongan Semangka", "1 Lemon", "1 Liter Air"),
            benefits = "Menghidrasi tubuh dan kaya vitamin C.",
            preparationSteps = listOf(
                "Potong semangka menjadi potongan kecil.",
                "Iris lemon tipis-tipis.",
                "Masukkan semangka dan lemon ke dalam toples.",
                "Tambahkan 1 liter air dan dinginkan selama 3 jam."
            )
        ),
        Rekomendasi(
            id = 12,
            title = "Air Delima Mint",
            description = "Manisnya delima dengan kesegaran daun mint.",
            imageRes = R.drawable.pomegranate_mint,
            ingredients = listOf("1/2 Cangkir Biji Delima", "10 Daun Mint", "1 Liter Air"),
            benefits = "Kaya antioksidan dan menyegarkan tubuh.",
            preparationSteps = listOf(
                "Masukkan biji delima dan daun mint ke dalam toples.",
                "Tambahkan 1 liter air.",
                "Dinginkan di kulkas selama 3–4 jam sebelum disajikan."
            )
        ),
        Rekomendasi(
            id = 13,
            title = "Air Lemon Blueberry",
            description = "Rasa asam lemon berpadu dengan manisnya blueberry.",
            imageRes = R.drawable.lemon_blueberry,
            ingredients = listOf("1 Lemon", "1/2 Cangkir Blueberry", "1 Liter Air"),
            benefits = "Kaya vitamin dan antioksidan.",
            preparationSteps = listOf(
                "Iris lemon menjadi potongan tipis.",
                "Masukkan lemon dan blueberry ke dalam toples.",
                "Tambahkan 1 liter air.",
                "Biarkan dingin selama 2–3 jam."
            )
        ),
        Rekomendasi(
            id = 14,
            title = "Air Jeruk Mentimun",
            description = "Perpaduan segar jeruk dan mentimun.",
                imageRes = R.drawable.orange_cucumber,
            ingredients = listOf("1 Jeruk", "1 Mentimun", "1 Liter Air"),
            benefits = "Menghidrasi tubuh dan menyegarkan kulit.",
            preparationSteps = listOf(
                "Iris jeruk dan mentimun tipis-tipis.",
                "Masukkan ke dalam toples.",
                "Tambahkan 1 liter air.",
                "Dinginkan selama 3–4 jam sebelum disajikan."
            )
        ),
        Rekomendasi(
            id = 15,
            title = "Air Kelapa Jeruk Nipis",
            description = "Kesegaran alami air kelapa dengan asamnya jeruk nipis.",
            imageRes = R.drawable.coconut_lime,
            ingredients = listOf("500 ml Air Kelapa", "1 Jeruk Nipis", "500 ml Air"),
            benefits = "Meningkatkan hidrasi dan kaya elektrolit.",
            preparationSteps = listOf(
                "Campurkan air kelapa dan air biasa di dalam toples.",
                "Iris jeruk nipis menjadi potongan tipis dan tambahkan.",
                "Biarkan dingin selama 1–2 jam."
            )
        )
    )

    val tanggalList = mutableListOf(
        Tanggal(
            id = 1,
            date = "1",
            day = "Senin",
            notes = "Mencapai target hidrasi hari ini.",
            waterConsumed = 2000,
            targetWater = 2000,
            activities = listOf("Lari pagi", "Rapat kantor", "Yoga sore")
        ),
        Tanggal(
            id = 2,
            date = "2",
            day = "Selasa",
            notes = "Minum air sedikit kurang dari target.",
            waterConsumed = 1500,
            targetWater = 2000,
            activities = listOf("Hiking", "Makan malam keluarga")
        ),
        Tanggal(
            id = 3,
            date = "3",
            day = "Rabu",
            notes = "Hidrasi cukup baik.",
            waterConsumed = 1800,
            targetWater = 2000,
            activities = listOf("Istirahat di rumah", "Berkebun")
        ),
        Tanggal(
            id = 4,
            date = "4",
            day = "Kamis",
            notes = "Hidrasi cukup meskipun sibuk.",
            waterConsumed = 1900,
            targetWater = 2000,
            activities = listOf("Belanja bulanan", "Makan malam bersama keluarga")
        ),
        Tanggal(
            id = 5,
            date = "5",
            day = "Jumat",
            notes = "Minum cukup air di sela-sela kesibukan.",
            waterConsumed = 2000,
            targetWater = 2000,
            activities = listOf("Kerja dari rumah", "Membersihkan rumah")
        ),
        Tanggal(
            id = 6,
            date = "6",
            day = "Sabtu",
            notes = "Hidrasi sangat baik, merasa segar sepanjang hari.",
            waterConsumed = 2500,
            targetWater = 2000,
            activities = listOf("Berenang pagi", "Makan siang di luar", "Menonton film")
        ),
        Tanggal(
            id = 7,
            date = "7",
            day = "Minggu",
            notes = "Hari santai dengan cukup hidrasi.",
            waterConsumed = 2000,
            targetWater = 2000,
            activities = listOf("Membaca buku", "Berjalan santai di taman")
        ),
        Tanggal(
            id = 8,
            date = "8",
            day = "Senin",
            notes = "Hidrasi sesuai target, merasa fokus.",
            waterConsumed = 2000,
            targetWater = 2000,
            activities = listOf("Kerja di kantor", "Rapat proyek besar")
        ),
        Tanggal(
            id = 9,
            date = "9",
            day = "Selasa",
            notes = "Minum air sedikit kurang, perlu memperhatikan jadwal minum.",
            waterConsumed = 1600,
            targetWater = 2000,
            activities = listOf("Hiking ringan", "Belanja mingguan")
        ),
        Tanggal(
            id = 10,
            date = "10",
            day = "Rabu",
            notes = "Hidrasi cukup baik dan membantu mengurangi stres.",
            waterConsumed = 2100,
            targetWater = 2000,
            activities = listOf("Meditasi pagi", "Makan siang bersama teman")
        ),
        Tanggal(
            id = 11,
            date = "11",
            day = "Kamis",
            notes = "Minum air lebih dari target setelah olahraga.",
            waterConsumed = 2300,
            targetWater = 2000,
            activities = listOf("Olahraga pagi", "Kerja di kantor", "Masak malam")
        ),
        Tanggal(
            id = 12,
            date = "12",
            day = "Jumat",
            notes = "Hari sibuk tapi hidrasi tetap tercapai.",
            waterConsumed = 2000,
            targetWater = 2000,
            activities = listOf("Meeting panjang", "Latihan tim olahraga")
        ),
        Tanggal(
            id = 13,
            date = "13",
            day = "Sabtu",
            notes = "Minum air lebih banyak karena aktivitas outdoor.",
            waterConsumed = 2400,
            targetWater = 2000,
            activities = listOf("Jalan-jalan ke pantai", "Makan siang piknik", "Berbelanja")
        ),
        Tanggal(
            id = 14,
            date = "14",
            day = "Minggu",
            notes = "Hari santai dengan fokus hidrasi.",
            waterConsumed = 2100,
            targetWater = 2000,
            activities = listOf("Berolahraga ringan", "Membaca buku di taman")
        )
    )

    val kategoriList = listOf(
        Kategori(
            id = 1,
            name = "Detoks",
            description = "Resep infused water untuk membersihkan tubuh.",
            imageRes = R.drawable.detox,
            recipeIds = listOf(1, 2, 7),
            tags = listOf("segar", "detoks", "bersih"),
            themeColor = Color(0xFF81C784)
        ),
        Kategori(
            id = 2,
            name = "Energi",
            description = "Infused water yang memberikan tambahan energi sepanjang hari.",
            imageRes = R.drawable.energy,
            recipeIds = listOf(4, 9, 15),
            tags = listOf("energi", "segar", "hangat"),
            themeColor = Color(0xFFFFA726)
        ),
        Kategori(
            id = 3,
            name = "Hidrasi",
            description = "Pilihan infused water yang menghidrasi tubuh dengan maksimal.",
            imageRes = R.drawable.hydration,
            recipeIds = listOf(5, 6, 11),
            tags = listOf("hidrasi", "segar", "lembab"),
            themeColor = Color(0xFF4FC3F7)
        ),
        Kategori(
            id = 4,
            name = "Antioksidan",
            description = "Infused water kaya akan antioksidan untuk kesehatan tubuh.",
            imageRes = R.drawable.antioxidant,
            recipeIds = listOf(3, 8, 10, 12),
            tags = listOf("antioksidan", "kesehatan", "alami"),
            themeColor = Color(0xFFD32F2F)
        ),
        Kategori(
            id = 5,
            name = "Vitamin C",
            description = "Pilihan infused water yang kaya akan vitamin C untuk meningkatkan daya tahan tubuh.",
            imageRes = R.drawable.vitamin_c,
            recipeIds = listOf(8, 13, 15),
            tags = listOf("vitamin", "segar", "daya tahan tubuh"),
            themeColor = Color(0xFFFFEB3B)
        ),
        Kategori(
            id = 6,
            name = "Relaksasi",
            description = "Infused water yang membantu tubuh untuk relaks dan tenang.",
            imageRes = R.drawable.relaxation,
            recipeIds = listOf(2, 12, 14),
            tags = listOf("relaksasi", "tenang", "hangat"),
            themeColor = Color(0xFFB39DDB)
        ),
        Kategori(
            id = 7,
            name = "Manis Alami",
            description = "Infused water dengan rasa manis alami tanpa tambahan gula.",
            imageRes = R.drawable.natural_sweetness,
            recipeIds = listOf(5, 6, 9),
            tags = listOf("manis", "alami", "segar"),
            themeColor = Color(0xFFFF8A65)
        ),
        Kategori(
            id = 8,
            name = "Segar Harian",
            description = "Infused water yang cocok diminum setiap hari untuk kesegaran.",
                imageRes = R.drawable.daily_fresh,
            recipeIds = listOf(1, 3, 10),
            tags = listOf("harian", "segarkan tubuh", "segar"),
            themeColor = Color(0xFF4CAF50)
        ),
        Kategori(
            id = 9,
            name = "Kesehatan Kulit",
            description = "Infused water yang membantu menjaga kesehatan kulit.",
            imageRes = R.drawable.skin_health,
            recipeIds = listOf(3, 8, 13),
            tags = listOf("kulit sehat", "hidrasi", "segar"),
            themeColor = Color(0xFFCE93D8)
        ),
        Kategori(
            id = 10,
            name = "Campuran Tropis",
            description = "Rasa tropis dari kombinasi buah-buahan segar.",
            imageRes = R.drawable.tropical_mix,
            recipeIds = listOf(6, 11, 15),
            tags = listOf("tropis", "buah", "eksotis"),
            themeColor = Color(0xFFFFC107)
        )
    )
}
