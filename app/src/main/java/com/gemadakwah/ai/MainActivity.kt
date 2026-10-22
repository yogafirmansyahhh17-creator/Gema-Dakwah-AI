
package com.gemadakwah.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Emerald = Color(0xFF064E3B)
private val Gold = Color(0xFFFFD166)
private val PageBg = Color(0xFFF2F7F4)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                GemaDakwahApp()
            }
        }
    }
}

@Composable
fun GemaDakwahApp() {
    var judul by remember { mutableStateOf("Renungan Islami") }
    var naskah by remember {
        mutableStateOf(
            "Assalamu'alaikum warahmatullahi wabarakatuh.\\n\\n" +
            "Sahabat Muslim, jangan pernah berhenti berdoa dan berusaha. " +
            "Tetaplah berbuat baik, bersabar, dan bertawakal kepada Allah.\\n\\n" +
            "Semoga Allah memberikan keberkahan dalam setiap langkah kita. Aamiin."
        )
    }
    var suara by remember { mutableStateOf("Orus — Pria berwibawa") }
    var pesan by remember {
        mutableStateOf("Silakan siapkan naskah dakwah Anda.")
    }

    val pilihanSuara = listOf(
        "Orus — Pria berwibawa",
        "Zephyr — Pria lembut",
        "Fenrir — Pria bersemangat",
        "Puck — Pria santai",
        "Kore — Wanita santun",
        "Aoede — Wanita lembut"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PageBg)
            .verticalScroll(rememberScrollState())
            .padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        Text("☪", fontSize = 48.sp, color = Gold)

        Text(
            "GemaDakwah AI",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Emerald
        )

        Text(
            "Teman Membuat Audio Dakwah Islami",
            fontSize = 14.sp,
            color = Emerald
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Text(
                    "Buat Naskah Dakwah",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Emerald
                )

                Text("Judul naskah")

                OutlinedTextField(
                    value = judul,
                    onValueChange = { judul = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    placeholder = { Text("Masukkan judul") }
                )

                Text("Pilih tema")

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("Renungan", "Motivasi").forEach { tema ->
                        Button(
                            onClick = {
                                judul = tema + " Islami"
                                pesan = "Tema dipilih: $tema"
                            },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Emerald
                            )
                        ) {
                            Text(tema)
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("Doa", "Ceramah").forEach { tema ->
                        Button(
                            onClick = {
                                judul = tema + " Islami"
                                pesan = "Tema dipilih: $tema"
                            },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Emerald
                            )
                        ) {
                            Text(tema)
                        }
                    }
                }

                Text("Isi naskah")

                OutlinedTextField(
                    value = naskah,
                    onValueChange = {
                        naskah = it
                        pesan = "Naskah berhasil diperbarui."
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp),
                    placeholder = { Text("Tulis naskah dakwah di sini") }
                )

                Text(
                    "Jumlah karakter: ${naskah.length}",
                    color = Emerald,
                    fontSize = 12.sp
                )

                HorizontalDivider()

                Text(
                    "Pilihan Suara",
                    fontWeight = FontWeight.Bold,
                    color = Emerald
                )

                pilihanSuara.forEach { pilihan ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = suara == pilihan,
                            onClick = { suara = pilihan }
                        )
                        Text(pilihan, fontSize = 14.sp)
                    }
                }

                Button(
                    onClick = {
                        pesan = "Naskah siap diproses. Fitur audio AI akan dihubungkan pada tahap berikutnya."
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Emerald
                    )
                ) {
                    Text(
                        "Buat Audio Dakwah",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Text(
                    pesan,
                    color = Emerald,
                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "GemaDakwah AI • Semoga Bermanfaat",
            color = Emerald,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}
