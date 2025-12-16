fun ana_sayfa()
{
    var sayac by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                println(sayac)
                sayac++
            },
            //modifier = Modifier.size(50.dp)
        ) {
            Text(
                text = "+",
                fontSize = 54.sp
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = "Deger: ${sayac}",
            fontSize = 36.sp,
            color = Color.White,
            textDecoration = TextDecoration.Underline
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = {
                println(sayac)
                sayac--
            },
            //modifier = Modifier.size(50.dp)
        ) {
            Text(
                text = "-",
                fontSize = 54.sp
            )
        }
    }
}