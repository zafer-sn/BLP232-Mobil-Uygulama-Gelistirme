@Composable
fun ana_sayfa()
{
    var renkler by remember { mutableStateOf(mutableListOf(Color.Red, Color.Green, Color.Blue)) }
    var arkaplan_rengi by remember { mutableStateOf(renkler[0]) }
    var sayac by remember { mutableStateOf(1) }
    var deger: String? by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(arkaplan_rengi),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                try {
                    arkaplan_rengi = renkler[sayac]
                } catch (e: Exception)
                {
                    deger = e.localizedMessage
                }
                sayac++
            }
        ) {
            Text(
                text = "Mavi Yap",
                fontSize = 36.sp
            )
        }
        Text(
            text = "${deger}",
            color = Color.White,
            fontSize = 16.sp
        )
    }
}