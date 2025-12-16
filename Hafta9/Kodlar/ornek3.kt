@Composable
fun ana_sayfa()
{
    var soru by remember { mutableStateOf("") }
    var cevap by remember { mutableStateOf("Henuz soru sormadiniz...") }


    val scope = rememberCoroutineScope()

    val gemini_model = remember {
        GenerativeModel(
            modelName = "gemini-2.5-flash",
            apiKey = ""
        )
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(
                rememberScrollState()
            )
    )
    {
        TextField(
            value = soru,
            label = {
                Text(text = "Sorgu")
            },
            onValueChange = {
                soru = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                scope.launch {
                    var cevap_gemini = gemini_model.generateContent(soru)
                    cevap = cevap_gemini.text ?: "Cevap yok"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Test")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Cevap:", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text(
                text = "${cevap}",
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}